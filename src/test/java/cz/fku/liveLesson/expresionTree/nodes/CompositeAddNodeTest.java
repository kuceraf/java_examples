package cz.fku.liveLesson.expresionTree.nodes;

import junit.framework.TestCase;
import org.junit.Test;

public class CompositeAddNodeTest {
    @Test
    public void test() {
        ComponentNode node = new CompositeAddNode(
                new LeafNode(3),
                new LeafNode(4)
                );
    }
}