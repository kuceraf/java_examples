package cz.fku.designPatterns.structural.bridge;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class ShapeTest {
    @Test
    public void draw() {
        Shape square = new Square(new RedColor());
        assertThat(square.draw()).isEqualTo("Square drawn.  Red");
    }
}