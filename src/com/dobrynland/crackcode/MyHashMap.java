package com.dobrynland.crackcode;

/**
 * Created by Alexandra on 19.02.2017.
 */
public class MyHashMap<K, V> {

    class Entry<K, V> {
        Entry next = null;
        V value;
        K key;
        int hash;

        public V getValue() {
            return value;
        }

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.value = value;
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    Entry<K,V>[] table;

    MyHashMap() {
        table = new Entry[8];
    }

    int indexFor(int h) {
        return h & (table.length - 1);
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        if (key == null) {
            table[0] = new Entry(hash, key, value);
        }

        int i = indexFor(hash);
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {

            if (e.hash == hash && (key.equals(e.getKey()))) {
                e.setValue(value);
                return;
            }
        }
        addEntry(hash, key, value, i);
    }

    public void addEntry(int hash, K key, V value, int i) {
        if (i >= table.length) {
            //double array?
        }
        Entry<K, V> newEntry = new Entry(hash, key, value);
        if (table[i] != null) {
            newEntry.next = table[i];
        }
        table[i] = newEntry;
    }

    public V get(K key) {
        if(key == null){
            return table[0].getValue();
        }
        int hash = key.hashCode();
        Entry<K, V> e = table[indexFor(hash)];
        while(e != null){
            if (e.hash == hash && (key.equals(e.getKey()))) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    public void printHMap(){
        for(int i=0; i < table.length; i++){
            if(table[i] != null){
                Entry<K, V> e = table[i];
                while(e != null){
                    System.out.print(e.getKey() + " " + e.getValue());
                    System.out.println();
                    e = e.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap();

        map.put("Alice", 3);
        map.put("Anna", 4);
        map.put("Bob", 5);
        map.put("Alice", 6);

        map.printHMap();

        System.out.println(map.get("Bob"));
    }
}
