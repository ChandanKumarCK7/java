package DataStructures;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class CustomHashMap<K, V>{
    private LinkedList<Entry<K, V>>[] buckets;

    static final int default_capacity = 5;

    int capacity;

    public CustomHashMap(){
        this(default_capacity);
    }
    public CustomHashMap(int capacity){
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];

        for(int i =0; i < capacity; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K k, V v){
        int hash = getHash(k);
        LinkedList<Entry<K, V>> bucket = buckets[hash];
        for(Entry<K,V> e : bucket){
            if(e.key.equals(k)){
                e.value = v;
                return;
            }

        }
        bucket.add(new Entry<>(k, v));

    }

    public int getHash(K k){
        return k.hashCode() % capacity;
    }

    class Entry<K, V>{
        K key;
        V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    public LinkedList<Entry<K, V>>[] getBuckets() {
        return buckets;
    }

    public void setBuckets(LinkedList<Entry<K, V>>[] buckets) {
        this.buckets = buckets;
    }

    public void print(){
        System.out.println("yo");
        for(LinkedList<Entry<K, V>> b: this.buckets){
            for(Entry<K, V> entry : b){
                System.out.println(entry.getKey() +" "+entry.getValue());
            }
        }
    }

}

public class HashMapWithOtherDataStructures {
    public static void main(String[] args){

        CustomHashMap<String, Integer> h = new CustomHashMap<>();
        h.put("here", 6);
        h.put("here", 0);

        h.put("here1", 1);
        h.put("here1", 7);

        h.print();


    }


}
