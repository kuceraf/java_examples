package cz.fku.liveLesson.expressiontree.states;

import cz.fku.liveLesson.expressiontree.tree.TreeOps;

/**
 * A state formated pre-order without an expression tree.
 */
class PreOrderUninitializedState
      extends UninitializedState {
    /**
     * Process the @a expression using a pre-order interpreter
     * and update the state of the @a context to the @a
     * PreOrderUninitializedState.
     */
    public void makeTree(TreeOps context, String format) {
        throw new IllegalStateException("PreOrderUninitializedState.makeTree() not yet implemented");
    }
}
	  	  
