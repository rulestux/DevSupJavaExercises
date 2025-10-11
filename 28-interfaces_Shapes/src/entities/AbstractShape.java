package entities;

import enums.Color;

// para herdar a classe 'Shape', sem o método 'area',
// a classe 'AbstractShape' precisa explicitar no entrypoint
// que é uma 'abstract class' que 'implemens' a interface
// 'Shape':
public abstract class AbstractShape implements Shape {

    private Color color;

    public AbstractShape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
