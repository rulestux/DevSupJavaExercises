package entities;

import enums.Color;

public class Circle extends AbstractShape {

    private Double radius;

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        // pi vezes o raio ao quadrado; pi retirado
        // da propria biblioteca nativa Java:
        return Math.PI * radius * radius;
    }
}
