package org.learning.datastructure.list;

import org.learning.datastructure.KIList;

/**
 * @ClassName: MyArrayList
 * @Description: 自实现arrayList
 * @author carlos.chu
 * @date 2016年4月6日 下午1:35:50
 *
 */
public class KArrayList<T> implements KIList<T> {

    private final static int INIT_CAPACITY = 12;
    private Object[] mList = null;

    /** 当前的容量 */
    private int mCurrentCapacity = 0;
    private int mSize = 0;

    public KArrayList() {
        mList = new Object[INIT_CAPACITY];
        mCurrentCapacity = INIT_CAPACITY;
    }

    @Override
    public void add(T item) {
        if (mSize == mCurrentCapacity) {
            expansion();
        }
        mList[mSize] = item;
        mSize++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        if (mSize == mCurrentCapacity) {
            expansion();
        }
        Object[] newList = new Object[mCurrentCapacity];
        System.arraycopy(mList, 0, newList, 0, index);
        System.arraycopy(newList, index, newList, index + 1, mSize - index);
        newList[index] = item;
        mList = newList;
        mSize++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        mList[index] = item;
    }

    @Override
    public void remove(T item) {
        for (int i = 0; i < mSize; i++) {
            if (mList[i].equals(item)) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[mCurrentCapacity];
        System.arraycopy(mList, 0, newList, 0, index);
        System.arraycopy(mList, index + 1, newList, index, mSize - index);
        mList = newList;
        mSize--;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < mSize; i++) {
            if (mList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (mSize == 0) ? true : false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        return (T) mList[index];
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < mSize; i++) {
            if (mList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return mSize;
    }

    private void expansion() {
        Object[] oldList = mList;
        Object[] newList = new Object[getNewCapacity()];
        System.arraycopy(oldList, 0, newList, 0, oldList.length);
        mList = newList;
    }

    /**
     * 容量增加原先的50%
     * 
     * @return
     */
    private int getNewCapacity() {
        return mCurrentCapacity = mCurrentCapacity + (mCurrentCapacity >> 1);
    }

    public static void main(String[] args) {
        KArrayList<Integer> arr = new KArrayList<Integer>();

        for (int i = 1; i <= 50; i++) {
            arr.add(i);
        }

        arr.add(10, 99);
        arr.add(0, 99);

        System.out.println(arr.get(0));

        // arr.clear();

        // System.out.println(arr.contains(99));
        // System.out.println(arr.indexOf(59));

        arr.remove(11);

        arr = null;
    }

}
