public interface List<T> {
    void add(int index, T t);
    void addFirst(T t);
    void addLast(T t);
    T remove(int index);
    boolean remove(T t);
    int size();
    T cloneList();
    boolean contains(T t);
    int indexOf(T t);
    boolean add(T t);
    void ensureCapacity(int minCapacity);
    T get(int i);
    T getFirst();
    T getLast();
    void clear();
    T removeFirst();
    T removeLast();
}
