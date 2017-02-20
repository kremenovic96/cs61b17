package synthesizer;

/**
 * Created by ranko on 2/20/17.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
    protected int fillCount;
    protected int capacity;
    public int capacity(){return capacity;}
    public int fillCount(){return fillCount;}
//    public boolean isEmpty()
 //   public abstract T peek();
 //   public abstract T dequeue();
 //   public abstract void enqueue(T x);







}
