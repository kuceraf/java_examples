package cz.fku.liveLesson.expressiontree.tree;

import cz.fku.liveLesson.expressiontree.iterators.IteratorFactory;
import cz.fku.liveLesson.expressiontree.nodes.ComponentNode;
import cz.fku.liveLesson.expressiontree.platspecs.Platform;
import cz.fku.liveLesson.expressiontree.utils.StreamsUtils;
import cz.fku.liveLesson.expressiontree.visitors.EvaluationVisitor;
import cz.fku.liveLesson.expressiontree.visitors.Visitor;
import cz.fku.liveLesson.expressiontree.visitors.VisitorFactory;

import java.util.Iterator;

/**
 * Interface for the Composite pattern that is used to contain all the
 * operator and operand nodes in the expression tree.  Plays the role
 * of the "Abstraction" in the Bridge pattern and delegates to the
 * appropriate "Implementor" that performs the expression tree
 * operations.
 */
public class ExpressionTree
       implements Iterable<ExpressionTree> {
    /**
     * A factory that creates the appropriate visitors.
     */
    private static VisitorFactory sVisitorFactory =
        new VisitorFactory();

    /** 
     * Base implementor. 
     */
    ComponentNode mRoot = null;

    /** 
     * A factory class capable of creating iterators dynamically. 
     */
    private IteratorFactory mTreeIteratorFactory
        = new IteratorFactory();

    /**
     * Constructor that takes a {@code Node} that contains all the
     * nodes in the expression tree.
     */
    public ExpressionTree(ComponentNode root) {
        mRoot = root;
    }

    /** 
     * Returns whether a the tree is null. 
     */
    public boolean isNull() {
        return mRoot == null;
    }

    /** 
     * Returns root. 
     */
    public ComponentNode getRoot() {
        return mRoot;
    }

    /** 
     * Returns the root item. 
     */
    public int item() throws Exception {
        return mRoot.item();
    }

    /** 
     * Returns the tree's mLeft node.
     */
    public ExpressionTree left() {
        return new ExpressionTree(mRoot.left());
    }

    /** 
     * Returns the tree's mRight node.
     */
    public ExpressionTree right() {
        return new ExpressionTree(mRoot.right());
    }

    /**
     * Accepts a {@code visitor}.
     */
    public void accept(Visitor visitor) {
        mRoot.accept(visitor);
    }

    /** 
     * Returns an {@code Iterator} that supports the requested
     * traveralOrder.
     */
    public Iterator<ExpressionTree> makeIterator(String traversalOrderRequest) {
        // Use the TreeIteratorFactory to create the requested
        // iterator.
        return mTreeIteratorFactory.makeIterator(this,
                                                 traversalOrderRequest);
    }

    /**
     * Returns an {@code Iterator} that supports pre-order traversal.
     */
    @Override
    public Iterator<ExpressionTree> iterator() {
        return makeIterator(IteratorFactory.PRE_ORDER);
    }

    /** 
     * Print the operators and operands of the @a tree using the
     * designated @a traversalOrder.
     */
    public void print(String traversalOrder) {
        if (traversalOrder.equals(""))
            // Default to in-order if user doesn't explicitly request
            // a print order.
            traversalOrder = "in-order";

        // Note the high pattern density in the code below, which uses
        // of the Factory Method, Iterator, Bridge, Strategy, and
        // Visitor patterns.

        // Create the PrintVisitor using a factory. 
        Visitor printVisitor = sVisitorFactory
                .makeVisitor("print");

        // Create a stream that traverses all nodes in the expression tree and
        // accepts the printVisitor to evaluate each type of node.
        StreamsUtils
            .iteratorToStream(makeIterator(traversalOrder), false)
            .forEach(expressionTree -> expressionTree.accept(printVisitor));

        /*
        for (ExpressionTree node : this)
            node.accept(printVisitor);

        this.forEach(node -> node.accept(printVisitor));
        */

        /*
        // Iterate through all nodes in the expression tree and accept
        // the printVisitor to evaluate each type of node.
        for(Iterator<ExpressionTree> it = makeIterator(traversalOrder);
            it.hasNext();
            )
            it.next().accept(printVisitor);
        */
    }
	  	
    /** 
     * Evaluate and print the yield of the @a tree using the
     * designated @a traversalOrder.
     */
    public void evaluate(String traversalOrder) {
        if (traversalOrder.equals(""))
            // Default to post-order if user doesn't explicitly
            // request an eval order.
            traversalOrder = "post-order";
        else if (!traversalOrder.equals("post-order"))
            throw new IllegalArgumentException(traversalOrder + " evaluation is not supported yet");

        // Note the high pattern density in the code below, which uses
        // of the Factory Method, Iterator, Bridge, Strategy, and
        // Visitor patterns.

        // Create the EvaluationVisitor using a factory. 
        Visitor evalVisitor = sVisitorFactory
                .makeVisitor("eval");

        // Create a stream that traverses all nodes in the expression tree and
        // accepts the evalVisitor to evaluate each type of node.
        StreamsUtils
            .iteratorToStream(makeIterator(traversalOrder), false)
            .forEach(expressionTree -> expressionTree.accept(evalVisitor));

        /*
        // Iterate through all nodes in the expression tree and accept
        // the evalVisitor to evaluate each type of node.
        for(Iterator<ExpressionTree> it = makeIterator(traversalOrder);
            it.hasNext();
            )
            it.next().accept(evalVisitor);
        */

        Integer total = ((EvaluationVisitor) evalVisitor).total();

        // Use the platform strategy to printout the result.
        Platform.instance().outputLine(total.toString());
    }
}
