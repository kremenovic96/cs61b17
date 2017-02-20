package synthesizer;

/**
 * Created by ranko on 2/20/17.
 */

public interface BoundedQueue<T> {
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();
    default boolean isEmpty(){return fillCount() == 0;}
    default boolean isFUll(){return fillCount() == capacity();}

}
