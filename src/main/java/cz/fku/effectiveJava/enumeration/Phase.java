package cz.fku.effectiveJava.enumeration;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map
        // key: source phase, value: (destination phase, transition)
        private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(Phase.Transition.values())
                .collect(
                        groupingBy(
                                t -> t.from, // grouping elements according to a classification function
                                () -> new EnumMap<>(Phase.class), // a supplier providing a new empty Map into which the results will be inserted
                                toMap( // downstream reduction
                                        t -> t.to, // keyMapper
                                        t -> t, // valueMapper
                                        (x, y) -> y, // mergeFunction (unused)
                                        () -> new EnumMap<>(Phase.class) // mapFactory
                                )
                        )
                );

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}
