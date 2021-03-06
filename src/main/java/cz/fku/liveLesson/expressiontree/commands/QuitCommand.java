package cz.fku.liveLesson.expressiontree.commands;

import cz.fku.liveLesson.expressiontree.input.InputDispatcher;
import cz.fku.liveLesson.expressiontree.tree.TreeOps;

/**
 * Instructs the mInput dispatching loop to shut down.  This plays the
 * role of the "ConcreteCommand" in the Command pattern.
 */
public class QuitCommand 
       extends UserCommand {
    /** 
     * Constructor that provides the appropriate @a TreeOps.
     */
    QuitCommand(TreeOps context) {
        super(context);
    }

    /** 
     * Quit the mInput dispatching loop.
     */
    public void execute() {
        InputDispatcher.instance().endInputDispatching();
    }

    /** 
     * Print the valid commands available to users. 
     */
    public void printValidCommands(boolean verboseField) {
    }
}
