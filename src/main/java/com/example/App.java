package com.example;

import java.util.UUID;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;*/

import com.example.pizza.Ingredient;
import com.example.pizza.Pizza;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        Ingredient ingredient = Ingredient.create(UUID.randomUUID(), "tomate", 1D);
        Pizza pizza = Pizza.create(UUID.randomUUID(),
                "carbonara",
                "la mejor del mundo",
                "url");
        pizza.addIngredient(ingredient);
        pizza.addIngredient(ingredient);
        //esto no se debería permitir
        //pizza.getIngredients().add(ingredient);
        System.err.println(pizza.getPrice());

        // EntityBase entiy = new EntityBase(UUID.randomUUID());
        System.out.println("Hello World!");
        //setup();
    }

    public static void setup() {
        /*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Events.class)
                .buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        var tr = session.beginTransaction();

        Events events = new Events();
        events.id = 1;

        session.persist(events);
        // var result = session.get(Events.class, 1);
        // session.remove(events);

        tr.commit();

        // var result = session.get(Events.class, 1);

        session.close();*/
    }
}
