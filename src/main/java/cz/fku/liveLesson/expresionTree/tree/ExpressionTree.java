package cz.fku.liveLesson.expresionTree.tree;

import cz.fku.liveLesson.expresionTree.nodes.ComponentNode;

/**
 * Interface for the Composite pattern that is used to contain all the
 * operator and operand nodes in the expression tree.  Plays the role
 * of the "Abstraction" in the Bridge pattern and delegates to the
 * appropriate "Implementor" that performs the expression tree
 * operations.
 */
public class ExpressionTree {
    /**
     * Base implementor.
     */
    ComponentNode mRoot;

    public ExpressionTree(ComponentNode root) {
        mRoot = root;
    }
}
