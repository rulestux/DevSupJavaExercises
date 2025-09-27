package entities;

import entities.enums.Color;

public abstract class Shape {

    private Color color;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

     public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // métodos abstratos só podem ser criados em
    // classes abstratas:
    public abstract double area();

}
