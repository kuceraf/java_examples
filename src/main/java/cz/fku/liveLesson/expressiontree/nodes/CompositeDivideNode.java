package cz.fku.liveLesson.expressiontree.nodes;

import cz.fku.liveLesson.expressiontree.visitors.Visitor;

/**
 * A node containing mLeft and mRight children.  The meaning of this
 * node is mLeft / mRight.  It plays the role of a "Composite" in the
 * Composite pattern.
 */
public class CompositeDivideNode 
       extends CompositeBinaryNode {
    /**
     * Constructor.
     */
    public CompositeDivideNode(ComponentNode left,
                               ComponentNode right) {
        super(left, right);
    }

    /** 
     * Return the printable character stored in the node. 
     */
    public int item() {
	return '/';
    }

    /**
     * Define the @a accept() operation used for the Visitor pattern
     * to accept the @a visitor.
     */
    public void accept(Visitor visitor) {
	visitor.visit(this);
    }
}
