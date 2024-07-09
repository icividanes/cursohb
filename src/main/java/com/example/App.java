package com.example;

//import java.util.Set;
import java.util.UUID;

//import org.reflections.Reflections;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;*/

import com.example.pizza.Ingredient;
import com.example.pizza.Pizza;

import jakarta.persistence.Entity;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        /*Reflections reflections = new Reflections("com.example");
        Set<Class<?>> importantClasses = reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> clazz : importantClasses) {
            
        }*/
        UUID id = UUID.randomUUID();

        Pizza pizza = Pizza
                .builder()
                .setId(UUID.randomUUID())
                .setName("carbonara")
                .setDescription("pizza excelente")
                .setUrl("url")
                .build();

        /*
         * Pizza pizza = Pizza.create(UUID.randomUUID(),
         * "carbonara",
         * "la mejor del mundo",
         * "url");
         */
        pizza.addIngredient(Ingredient.create(id, "tomate", 1.0D));
        pizza.addIngredient(Ingredient.create(id, "tomate", 1.0D));
        // esto no se debería permitir
        // pizza.getIngredients().add(ingredient);
        System.err.println(pizza.getPrice());

        // EntityBase entiy = new EntityBase(UUID.randomUUID());
        System.out.println("Hello World!");
        // setup();
    }

    public static void setup() {
        /*
         * final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
         * .build();
         * 
         * SessionFactory sessionFactory = new MetadataSources(registry)
         * .addAnnotatedClass(Events.class)
         * .buildMetadata()
         * .buildSessionFactory();
         * 
         * Session session = sessionFactory.openSession();
         * 
         * var tr = session.beginTransaction();
         * 
         * Events events = new Events();
         * events.id = 1;
         * 
         * session.persist(events);
         * // var result = session.get(Events.class, 1);
         * // session.remove(events);
         * 
         * tr.commit();
         * 
         * // var result = session.get(Events.class, 1);
         * 
         * session.close();
         */
    }
}
