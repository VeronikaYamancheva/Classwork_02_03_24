package ru.yamancheva.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ItHashMap<K, V> implements ItMap<K, V>{

    private int size = 0;
    private int capacity = 20;
    private List<List<Node<K, V>>> buckets = new LinkedList<>();

    public ItHashMap(){
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % capacity);
        List<Node<K, V>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return bucket.get(i).value;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = Math.abs(hash % capacity);
        List<Node<K, V>> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                bucket.get(i).value = value;
                return;
            }
        }
        bucket.add(new Node<>(key, value));
        size++;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return null;
    }
}
