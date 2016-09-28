package ch.heigvd.amt.model;

/**
 * Created by Henrik on 28.09.2016.
 */
//Model
public class Fruit {
    private String name;
    private String color;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
