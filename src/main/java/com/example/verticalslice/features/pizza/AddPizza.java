package com.example.verticalslice.features.pizza;

import java.util.List;
import java.util.UUID;

import com.example.pizza.Ingredient;
import com.example.pizza.Pizza;
import com.example.segregation.Add;

public class AddPizza {
    // Request
    public record Request(
            String name,
            String description,
            String url,
            List<Ingredient> ingredients) {
    }

    // Response
    public record Response(
            UUID id,
            String name,
            String description,
            String url,
            Double price,
            List<Ingredient> ingredients) {
    }

    private final UseCase useCase;

    protected AddPizza(final UseCase useCase) {
        this.useCase = useCase;
    }

    Response add(Request req) {
        return useCase.add(req);
    }

    // UseCase
    private interface UseCase {

        Response add(Request req);
    }

    private static class UseCaseImpl implements UseCase {

        private final Add<Pizza> repository;

        public UseCaseImpl(final Add<Pizza> repository) {
            this.repository = repository;
        }

        @Override
        public Response add(Request req) {

            //Request->Entidad
            var pizza = Pizza.create(
                    UUID.randomUUID(), req.name(),
                    req.description(), req.url());
            for (var ingedient : req.ingredients()) {
                pizza.addIngredient(ingedient);
            }

            repository.add(pizza);
            //Entidad->Response
            return new Response(
                    pizza.getId(),
                    pizza.getName(),
                    pizza.getDescription(),
                    pizza.getUrl(),
                    pizza.getPrice(),
                    pizza.getIngredients());
        }

    }

    // Repository
    private static class Repository implements Add<Pizza> {

        @Override
        public void add(Pizza entity) {
            // persistir la pizza
        }

    }

    public static AddPizza build() {
        var repository = new Repository();
        var useCase = new UseCaseImpl(repository);
        return new AddPizza(useCase);
    }
}

// Feature->AddPizza->UseCase->Repository