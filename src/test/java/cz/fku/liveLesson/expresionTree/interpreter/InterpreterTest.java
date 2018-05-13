package cz.fku.liveLesson.expresionTree.interpreter;

import cz.fku.liveLesson.expresionTree.tree.ExpressionTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterpreterTest {
    Interpreter interpreter = new Interpreter();

    @Test
    public void interpret() {
        ExpressionTree interpret = interpreter
                .interpret("1+2");
    }
}