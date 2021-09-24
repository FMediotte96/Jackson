package api.jackson.model;

import java.util.Date;

public class Coffee {
    private String name;
    private String brand;
    private Date date;

    public Coffee() {
    }

    public Coffee(String name, String brand, Date date) {
        this.name = name;
        this.brand = brand;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
