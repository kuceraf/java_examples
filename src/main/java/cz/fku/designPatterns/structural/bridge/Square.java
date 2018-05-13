package cz.fku.designPatterns.structural.bridge;

public class Square extends Shape {
    public Square(Color color){
        super(color);
    }
    @Override
    String draw() {
        return "Square drawn. " + color.fill();
    }
}
