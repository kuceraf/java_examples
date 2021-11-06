package cz.fku.designPatterns.behavioural.chain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

//class Event<Args> {
//    private int index = 0;
//    private final Map<Integer, Consumer<Args>> handlers = new HashMap<>();
//
//    public int subscribe(Consumer<Args> handler) {
//        int i = index;
//        handlers.put(index++, handler);
//        return i;
//    }
//    public void unsubscribe(int key) {
//        handlers.remove(key);
//    }
//    public void fire(Args args) {
//        for (Consumer<Args> handler : handlers.values()) {
//            handler.accept(args);
//        }
//    }
//}
//
//class Query {
//    public String creatureName;
//    enum Argument {
//        ATTACK, DEFENSE
//    }
//    public Argument argument;
//    public int result;
//
//    public Query(String creatureName,
//                 Argument argument,
//                 int result) {
//        this.creatureName = creatureName;
//        this.argument = argument;
//        this.result = result;
//    }
//}
//
//// mediator
//class Game {
//    public Event<Query> queries = new Event<>();
//}
//
//class Creature {
//    private Game game;
//    public String name;
//    public int baseAttack, baseDefense;
//
//    public Creature(Game game, String name,
//                    int baseAttack, int baseDefense) {
//        this.game = game;
//        this.name = name;
//        this.baseAttack = baseAttack;
//        this.baseDefense = baseDefense;
//    }
//
//    int getAttack() {
//        Query query = new Query(name, Query.Argument.ATTACK, baseAttack);
//        game.queries.fire(query);
//        return query.result;
//    }
//
//    int getDefense() {
//        Query query = new Query(name, Query.Argument.DEFENSE, baseDefense);
//        game.queries.fire(query);
//        return query.result;
//    }
//
//    @Override
//    public String toString() {
//        return "Creature{" +
//                "game=" + game +
//                ", name='" + name + '\'' +
//                ", attack=" + getAttack() +
//                ", defense=" + getDefense() +
//                '}';
//    }
//}
//
//
//class CreatureModifier {
//    protected Game game;
//    protected Creature creature;
//
//    public CreatureModifier(Game game, Creature creature) {
//        this.game = game;
//        this.creature = creature;
//    }
//}
//
//
//class DoubleAttackModifier
//        extends CreatureModifier
//        implements AutoCloseable
//{
//    private final int token;
//    public DoubleAttackModifier(Game game, Creature creature) {
//        super(game, creature);
//        token = game.queries.subscribe(q -> {
//            if (q.creatureName.equals(creature.name)
//                    && q.argument == Query.Argument.ATTACK
//            ) {
//                q.result *= 2;
//            }
//        });
//    }
//
//    @Override
//    public void close()  {
//        game.queries.unsubscribe(token);
//    }
//}
//
//class Demo {
//    public static void main(String[] args) {
//        Game game = new Game();
//        Creature goblin = new Creature(game, "Strong Goblin", 2, 2);
//        System.out.println(goblin);
//
//        new DoubleAttackModifier(game, goblin);
//        System.out.println(goblin);
//
//    }
//}
//------------------------------------------------------

class Event<Args> {
    private int index = 0;
    private final Map<Integer, Consumer<Args>> handlers = new HashMap<>();

    public int subscribe(Consumer<Args> handler) {
        int i = index;
        handlers.put(index++, handler);
        return i;
    }

    public void unsubscribe(int key) {
        handlers.remove(key);
    }

    public void fire(Args args) {
        for (Consumer<Args> handler : handlers.values()) {
            handler.accept(args);
        }
    }
}

class Query {
    public Creature creature;

    public Statistic argument;
    public int result;

    public Query(Creature creature,
                 Statistic argument,
                 int result) {
        this.creature = creature;
        this.argument = argument;
        this.result = result;
    }
}

abstract class Creature {
    protected int baseAttack, baseDefense;
    protected Game game;

    public abstract int getAttack();

    public abstract int getDefense();

    public Creature(int baseAttack, int baseDefense, Game game) {
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.game = game;
    }
}

class CreatureModifier {
    protected Game game;
//    protected CreatureModifier next;

    public CreatureModifier(Game game) {
        this.game = game;
    }
}

class IncreaseAttackCreatureModifier extends CreatureModifier {

    public IncreaseAttackCreatureModifier(Game game) {
        super(game);
        game.queries.subscribe(query -> {
            if (Statistic.ATTACK.equals(query.argument)) {
                long goblinKingCount = game.creatures.stream()
                        .filter(c -> c instanceof GoblinKing)
                        .count();
                query.result = query.creature.baseAttack + (int) goblinKingCount;
            }
        });
    }
}

class IncreaseDefenseCreatureModifier extends CreatureModifier {

    public IncreaseDefenseCreatureModifier(Game game) {
        super(game);
        int token = game.queries.subscribe(query -> {
            if (Statistic.DEFENSE.equals(query.argument)) {
                long goblinsCount = game.creatures.size();
                query.result = query.creature.baseDefense + (int) goblinsCount - 1;
            }
        });
    }
}

class Goblin extends Creature {
    public Goblin(int baseAttack, int baseDefense, Game game) {
        super(baseAttack, baseDefense, game);
    }

    public Goblin(Game game) {
        super(1, 1, game);
    }

    @Override
    public int getAttack() {
        Query query = new Query(this, Statistic.ATTACK, baseAttack);
        game.queries.fire(query);
        return query.result;
    }

    @Override
    public int getDefense() {
        Query query = new Query(this, Statistic.DEFENSE, baseDefense);
        game.queries.fire(query);
        return query.result;
    }
}

class GoblinKing extends Goblin {
    public GoblinKing(Game game) {
        super(3, 3, game);
    }
}

enum Statistic {
    ATTACK, DEFENSE
}

class Game {
    private IncreaseDefenseCreatureModifier increaseDefenseCreatureModifier;
    private IncreaseAttackCreatureModifier increaseAttackCreatureModifier;
    public Game() {
        increaseDefenseCreatureModifier = new IncreaseDefenseCreatureModifier(this);
        increaseAttackCreatureModifier = new IncreaseAttackCreatureModifier(this);
    }
    public Event<Query> queries = new Event<>();
    public List<Creature> creatures = new ArrayList<>();
}

class Demo {
    public static void main(String[] args) {
        Game game = new Game();
        Goblin goblin1 = new Goblin(game);
        Goblin goblin2 = new Goblin(game);
        Goblin goblin3 = new Goblin(game);
        game.creatures.add(goblin1);
        game.creatures.add(goblin2);
        game.creatures.add(goblin3);

        goblin1.getDefense();
//        GoblinKing goblinKing = new GoblinKing(game);
//        game.creatures.add(goblin);
//        game.creatures.add(goblinKing);
//        //System.out.println(goblin.getAttack());
//        System.out.println(goblin.getDefense());
//        System.out.println(goblinKing.getDefense());
    }
}
