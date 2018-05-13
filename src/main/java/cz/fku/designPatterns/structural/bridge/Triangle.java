package cz.fku.designPatterns.structural.bridge;

public class Triangle extends Shape {
    Triangle(Color color) {
        super(color);
    }

    @Override
    String draw() {
        return "Square drawn. " + color.fill();
    }
}
