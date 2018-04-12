package me.afua.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Device implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String model;
    private String brand;

    public Device()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    @Override
//    public String toString() {
//        return "Device{" +
//                "id=" + id +
//                ", model='" + model + '\'' +
//                ", brand='" + brand + '\'' +
//                '}';
//    }
}
