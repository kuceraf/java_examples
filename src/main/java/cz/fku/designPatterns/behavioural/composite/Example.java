package cz.fku.designPatterns.behavioural.composite;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {
    default int sum() {
        int result = 0;
        for (Integer v: this) {
            result = result + v;
        }
        return result;
    }
}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
    public static ManyValues create(List<Integer> from) {
        ManyValues manyValues = new ManyValues();
        manyValues.addAll(from);
        return manyValues;
    }
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        // todo
        int result = 0;
        for (ValueContainer v : this ) {
            result = result + v.sum();
        }
        return result;
    }
}


class Demo {
    public static void main(String[] args) {
        List<ValueContainer> values = Arrays.asList(
                new SingleValue(1),
                new SingleValue(1),
                ManyValues.create(
                        Arrays.asList(1, 1)
                )
        );
        MyList myList = new MyList(values);
        myList.sum();
    }
}
