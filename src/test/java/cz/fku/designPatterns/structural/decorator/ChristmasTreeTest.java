package cz.fku.designPatterns.structural.decorator;

import cz.fku.designPatterns.structural.decorator.example1.ChristmasTree;
import cz.fku.designPatterns.structural.decorator.example1.ChristmasTreeImpl;
import cz.fku.designPatterns.structural.decorator.example1.decorators.BubbleLights;
import cz.fku.designPatterns.structural.decorator.example1.decorators.Garland;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ChristmasTreeTest {

    @Test
    public void decorate_simple() {
       ChristmasTree christmasTree = new ChristmasTreeImpl();
       assertThat(christmasTree.decorate()).isEqualTo("Christmas tree");
    }

    @Test
    public void decorate_withBubbleLights() {
        ChristmasTree christmasTree = new BubbleLights(new ChristmasTreeImpl());
        assertThat(christmasTree.decorate()).isEqualTo("Christmas tree with Bubble Lights");
    }

    @Test
    public void decorate_withBubbleLightsAndGarland() {
        ChristmasTree christmasTree = new Garland(new BubbleLights(new ChristmasTreeImpl()));
        assertThat(christmasTree.decorate()).isEqualTo("Christmas tree with Bubble Lights with Garland");
    }
}