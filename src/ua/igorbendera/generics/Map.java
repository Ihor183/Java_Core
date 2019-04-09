package ua.igorbendera.generics;

import java.util.*;

public class Map<K, V> extends MyEntry<K, V>{
    private HashMap<K, V> map;

    public Map(K k, V v) {
        super(k, v);
        map = new HashMap<>();
        map.put(k, v);
    }

    public void addToMap(K k, V v) {
        if(!map.containsKey(k)) {
            map.put(k, v);
            System.out.println("Success");
        } else {
            System.out.println("This key is already using");
        }
    }

    public void removeByKey(K key) {
        if(map.containsKey(key)) {
            map.remove(key);
            System.out.println("Success");
        } else {
            System.out.println("Wrong key!");
        }
    }

    public void removeValue(K key) {
        map.replace(key, null);
    }

    public void showMap() {
        System.out.println(map);
    }

    public void showKeys() {
        Set<K> keys = map.keySet();
        System.out.println(keys);
    }

    public void showValues() {
        ArrayList<V> values =  new ArrayList<>(map.values());
        System.out.println(values);
    }
}
