package com.example.segregation;

public class ServiceCustomerUpdate {
    private final Update<Customer,Integer> repository;
    public ServiceCustomerUpdate(Update<Customer,Integer> repository){
        this.repository = repository;
        

    }
    public void update(){
        Customer customer = new Customer();
        this.repository.get(null);
        this.repository.update(customer);
    }

}
