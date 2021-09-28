package cz.fku.designPatterns.behavioural.bridge;

interface Renderer {
    String whatToRenderAs();
}

class VectorRendered implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}
class RasterRendered implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}
abstract class Shape
{
    protected Renderer renderer;
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract String getName();

    @Override
    public String toString()
    {
        return String.format("Drawing %s as %s", getName(), this.renderer.whatToRenderAs());
    }
}

class Triangle extends Shape
{
    public Triangle(Renderer renderer) {
        super(renderer);
    }
    @Override
    public String getName()
    {
        return "Triangle";
    }
}

class Square extends Shape
{
    public Square(Renderer renderer) {
        super(renderer);
    }
    @Override
    public String getName()
    {
        return "Square";
    }
}

//class VectorSquare extends Square
//{
//    public VectorSquare(Renderer renderer) {
//        super(renderer);
//    }
//    @Override
//    public String toString()
//    {
//        return String.format("Drawing %s as %s", getName(), this.renderer.whatToRenderAs());
//    }
//}
//
//class RasterSquare extends Square
//{
//    public RasterSquare(Renderer renderer) {
//        super(renderer);
//    }
//    @Override
//    public String toString()
//    {
//        return String.format("Drawing %s as %s", getName(), this.renderer.whatToRenderAs());
//    }
//}


class Demo {
    public static void main(String[] args) {
        new Triangle(new RasterRendered()).toString();
    }
}

// imagine VectorTriangle and RasterTriangle are here too
