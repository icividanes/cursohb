package com.example.verticalslice.features.pizza;

import com.example.pizza.Pizza;
import com.example.segregation.Add;

public class AddPizza {
    //Request
    public record Request() {
    }
    //Response
    public record Response() {
    }
    private final AddHandler useCase;
    
    protected AddPizza(final AddHandler useCase){
        this.useCase = useCase;
    }
    Response add(Request req){
        return useCase.add(req);
    }

    //UseCase
    private interface AddHandler {
    
        Response add(Request req);
    }
    private static class AddHanlderImpl implements AddHandler{

        private final Add<Pizza> repository;
        public AddHanlderImpl(final Add<Pizza> repository){
            this.repository = repository;
        }
        @Override
        public Response add(Request req) {
            return null;
        }

    }
    //Repository
    private static class PizzaRepositoryAdd implements Add<Pizza> {

        @Override
        public void add(Pizza entity) {
            //persistir la pizza
        }   
        
    }
    public static AddPizza build(){
        PizzaRepositoryAdd repository = new PizzaRepositoryAdd();        
        var useCase = new AddHanlderImpl(repository);
        return new AddPizza(useCase);
    }
}
