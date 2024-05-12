package ru.gumenuk.task2;

public class LinkedList<T> implements List<T> {
    LinkedList<String> states = new LinkedList<String>();
    @Override
    public void add(T elem) {
        states.add("Germany");
        states.add("Russia");
        states.add("USA");
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException("Не найдена такая тема!");
        }
        states.indexOf("Germany");
        return null;
    }

    @Override
    public int size() {
       states.size();

        return 0;
    }

    @Override
    public boolean remove(T elem) {
        states.remove("Germany");
        return false;
    }

    @Override
    public void remove(int index) {
        states.remove(2);

    }

    @Override
    public boolean contains(T elem) {

        if(states != null && !states.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(states == null && states.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        states.clear();

    }

    @Override
    public int indexOf(T elem) {
        int index = -1;
        if (states != null) {
            for (int i = 0; i < states.size(); i++) {
                if (states.get(i).equals(elem)) {
                    index = i;
                    break;
                }
            }
        }
        return 0;
    }
}
