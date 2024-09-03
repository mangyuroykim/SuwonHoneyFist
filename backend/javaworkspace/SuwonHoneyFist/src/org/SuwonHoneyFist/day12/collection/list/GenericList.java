package org.SuwonHoneyFist.day12.collection.list;

public class GenericList<T> {
    Object[] objects;
    int size;

    public GenericList() {
        objects = new Object[3];
        size = 0;
    }

    public void add(T object) {
        if (size == objects.length) {
            // 배열 크기를 늘림
            Object[] newObjects = new Object[objects.length * 2];
            for (int i = 0; i < objects.length; i++) {
                newObjects[i] = objects[i];
            }
            objects = newObjects;
        }
        objects[size] = object;
        size++;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) objects[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        objects = new Object[3];
        size = 0;
    }
}
