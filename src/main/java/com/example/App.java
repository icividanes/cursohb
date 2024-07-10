package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;



//import org.reflections.Reflections;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;*/

import com.example.liskov.Aguila;
import com.example.liskov.Pinguino;
import com.example.liskov.Writer;
import com.example.pizza.Ingredient;
import com.example.segregation.CustomerRepository;
import com.example.segregation.ServiceCustomerUpdate;
import com.example.verticalslice.features.ingredients.AddIngredient;
import com.example.verticalslice.features.pizza.AddPizza;
import com.example.verticalslice.features.pizza.AddPizza.Request;



/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        addPizza();
        addIngredient();

        CustomerRepository repositoy = new CustomerRepository();
        ServiceCustomerUpdate service = new ServiceCustomerUpdate(repositoy);
        service.update(1);        

        Consumer<Object> mock = (obj)->{};

        Pinguino pinguino = new Pinguino(5);
        Aguila aguila = new Aguila(20, 100);
        Writer.printAve(aguila, mock);
        Writer.printAve(pinguino,(obj)->{});
        //error de compilacion
        //Writer.printAvVoladora(pinguino);
        //Writer.printAvNoVoladora(aguila);
       Writer.printAvNoVoladora(pinguino,System.out::println);
       Writer.printAvVoladora(aguila,System.out::println);
    }
    public static void addPizza(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient.create(UUID.randomUUID(), "tomate", 1D));
        ingredients.add(Ingredient.create(UUID.randomUUID(), "queso", 1.5D));

        Request req = new Request(
            "carbonara", 
            "pizza buenisima", 
            "url", 
            ingredients);

        var response = AddPizza.build().add(req);
        System.out.println(response);
    }
    public static void addIngredient(){
        var request = new AddIngredient.Request("tomate", 1D);
        var response = AddIngredient.build().add(request);
        System.err.println(response);
    }
    public static void setup() {
        /* 
          //java.util.Set<Class<?>> set = new HashSet<>();
          //Class<?>[] array = new Class<?>[set.size()];
          

          final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
          .build();
          
          SessionFactory sessionFactory = new MetadataSources(registry)
          //.addAnnotatedClasses(set.toArray(array))
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
          
          session.close();
        */         
    }
}
