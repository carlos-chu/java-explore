package org.learning.datastructure.map;


/**
 * @ClassName: MyHashMap
 * @Description: 自定义hashmap，数据结构是链表加数组
 * @author carlos.chu
 * @date 2016年3月21日 下午3:19:01
 *
 */
public class MyHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;// 默认容量
    private int size;
    private Entry<K, V>[] table; // array buffer 链表的数组

    public MyHashMap(int size) {
        this.size = size;
        table = new Entry[size];
    }

    public MyHashMap() {
        this.size = INITIAL_CAPACITY;
        table = new Entry[size];
    }

    public int indexOf(int hashCode) {
        return hashCode % (size - 1);
    }

    public V put(K key, V value) {
        if (key == null || value == null) {
            return null;
        }
        int hashCode = key.hashCode();
        int index = indexOf(hashCode);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            V oldValue;
            K k = e.key;
            if (k.hashCode() == hashCode && (k == key || k.equals(key))) {
                oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        Entry<K, V> newEntry = new Entry<K, V>(key, value, table[index]);
        table[index] = newEntry;
        return null;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hashCode = key.hashCode();
        int index = indexOf(hashCode);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            K k = e.key;
            if (k.hashCode() == hashCode && (k == key || k.equals(key))) {
                return e.value;
            }
        }
        return null;
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next; // 指向下个元素的指针，该地址有是数组的地址，这样就兼顾了数组的查询效率和链表的插入效率

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        MyHashMap<String, String> mh = new MyHashMap<String, String>();
        mh.put("a", "a");
        mh.put("a", "a2");
        mh.put("b", "b");
        System.out.println(mh.get("a") + mh.get("b"));
    }
}
