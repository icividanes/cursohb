package com.example;

//import java.util.Set;
//import java.util.UUID;
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
import com.example.segregation.CustomerRepository;
//import com.example.pizza.Ingredient;
//import com.example.pizza.Pizza;
import com.example.segregation.ServiceCustomerUpdate;

//import jakarta.persistence.Entity;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
            
        CustomerRepository repositoy = new CustomerRepository();
        ServiceCustomerUpdate service = new ServiceCustomerUpdate(repositoy);
        service.update();        

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
