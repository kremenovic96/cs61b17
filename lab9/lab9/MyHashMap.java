package lab9;

import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by ranko on 17.4.17..
 */
public class MyHashMap<K,V> implements Map61B<K, V> {

    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }
    private SequentialSearchST<K,V>[]table;
    private int m; //table size
    private int n; //num of elements
    private float loadFactor;
    public MyHashMap(){}
    public MyHashMap(int initialSize){
        MyHashMap(initialSize, 1);
    }
    public MyHashMap(int initialSize, double loadFactor){
        table = new int[initialSize];
        m = initialSize;
        this.loadFactor = loadFactor;
        for (int i = 0; i < initialSize;i++){
            table[i] = new SequentialSearchST<K,V>();
        }
    }
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public int size(){
        return this.n;
    }
    @Override
    public V get(K key){
        int index = hash(key);
        return table[index].get(key);
    }
    @Override
    public boolean containsKey(K key){
        return get(key) != null;
    }
    @Override
    public void put(K key, V value){
        if (n > loadFactor){
            resize(2*m);
        }
        int index = hash(key);
        if (!table[index].contains(key)){
            n++;
        }
        table[index].put(key, value);
    }
    private void resize(int newSize){
    MyHashMap<K,V> temp = new MyHashMap<>(newSize);
    for (int i =0; i <m;i++){
        for(K key : table[i].keys()){
            temp.put(key, table[i].get(key));
        }
    }
    this.m = temp.m;
    this.n = temp.n;
    this.table = temp.table;
    }
    @Override
    public Set<K> keySet(){
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < m;i++){
            keys.add(table[i].keys());
        }
        return keys;
    }
    @Override
    public void clear(){
        for (int i = 0; i < m; i ++){
            table[i]=new SequentialSearchST<>();
        }
        this.n = 0;
        this.m = 0;
    }
}
