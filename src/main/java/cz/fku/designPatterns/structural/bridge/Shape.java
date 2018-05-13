package cz.fku.designPatterns.structural.bridge;

public abstract class Shape {
    Color color;
    Shape(Color color) {
        this.color = color;
    }
    abstract String draw();
}
