package lab8;
import java.util.Iterator;
import java.util.Set;
/**
 * Created by ranko on 3/8/17.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int N;

        public Node(K key, V val, int N) {
            this.key = key;
            this.value = val;
            this.N = N;
        }

    }
    @Override
    public int size(){
                return size(root);
    }
    public int size(Node x){
        if (x == null) {
            return 0;
        }
        return x.N;

    }
    @Override
    public void clear(){
        root = null;
    }
    public boolean containsKey(K key){
        return get(key) != null;
    }
    @Override
    public V get(K key){
        return get(root, key);
    }
    private V get(Node x, K key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if  (cmp > 0)
            return get(x.right, key);
        else
            return x.value;
    }
    @Override
    public void put(K key, V value){
        root = put(root, key, value);
    }
    private Node put(Node x, K key, V value){
        if (x == null) return new Node (key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }
    @Override
    public Iterator<K> iterator(){
        throw new UnsupportedOperationException();
    }


}
