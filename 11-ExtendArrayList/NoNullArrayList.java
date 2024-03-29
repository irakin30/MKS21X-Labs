import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T> {
    public NoNullArrayList() {
        super();
    }

    public NoNullArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public boolean add(T t) throws IllegalArgumentException {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        return super.add(t);
    }

    @Override
    public void add(int index, T t) throws IllegalArgumentException{
        if (t == null) {
            throw new IllegalArgumentException();
        }
        super.add(index,t);
    }

    @Override
    public T set(int index, T t) throws IllegalArgumentException{
        if (t == null) {
            throw new IllegalArgumentException();
        }
        return set(index, t);
    }
}
