package cz.fku.effectiveJava.generalProgramming;

import java.lang.reflect.Array;
import java.util.*;

public class Loop2 {
    public static void main(String[] args) {
        explicitTraversing();
        conditionalRemoving();
    }

    private static void explicitTraversing() {
        List<String> col = new LinkedList<>(Arrays.asList("a", "b", "c"));

        for(Iterator<String> it = col.iterator(); it.hasNext();) {
            if(it.next().equals("b")) {
                it.remove();
            }
        }
    }

    public static void conditionalRemoving() {
        List<String> col = new LinkedList<>(Arrays.asList("a", "b", "c"));
        col.removeIf(s -> s.equals("b"));
        col.contains("b");
    }
}
