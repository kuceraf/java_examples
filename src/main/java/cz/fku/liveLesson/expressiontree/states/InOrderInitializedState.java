package cz.fku.liveLesson.expressiontree.states;

import cz.fku.liveLesson.expressiontree.tree.TreeOps;

/**
 * A state formatted in-order and containing an expression
 * tree.
 */
class InOrderInitializedState 
      extends InOrderUninitializedState {
    /** 
     * Print the current expression tree in the @a context
     * using the designed @a format.
     */
    public void print(TreeOps context, String format) {
        context.tree().print(format);
    }

    /** 
     * Evaluate the yield of the current expression tree in
     * the @a context using the designed @a format.
     */
    public void evaluate(TreeOps context, String format) {
        context.tree().evaluate(format);
    }
}

