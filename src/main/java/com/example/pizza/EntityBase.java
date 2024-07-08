package com.example.pizza;

import java.util.UUID;

public abstract class EntityBase {
    private UUID id; //atributos
    protected EntityBase(UUID id){ //constructor
        this.id = id;
    }
    public UUID getId(){   //getter
        return id;
    }
}
