package com.codeup.models;

import javax.persistence.*;


@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String make;

    @Column(nullable = false, length = 50)
    private String model;

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car(){}
//    constructor
    public Car(long id, String make, String model) {
        this.id = id;
        this.make = make;
        this.model = model;
    }
}
