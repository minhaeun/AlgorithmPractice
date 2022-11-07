package cs.ArrayList;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayList implements List{
    private Object[] list;
    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(indexOf(o) >= 0) return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {

        if(size == list.length)  throw new IndexOutOfBoundsException();
        list[size] = o;
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] tmpList = new Object[size];
        size += c.size();
        list = new Object[size];
        for(int i = 0; i < tmpList.length; i++){
            list[i] = tmpList[i];
        }
        for(int i = tmpList.length; i < size; i++){
            list[i] = c.stream().toArray()[i- tmpList.length];
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] tmpList = new Object[size];
        size += c.size();
        list = new Object[size];
        for(int i = 0; i < index; i++){
            list[i] = tmpList[i];
        }
        for(int i = index; i < c.size(); i++){
            list[i] = c.stream().toArray()[i-index];
        }
        for(int i = c.size(); i < size; i++){
            list[i] = tmpList[index + i - c.size()];
        }
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        return list[index];
    }

    @Override
    public Object set(int index, Object element) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        list[index] = element;
        return element;
    }

    @Override
    public void add(int index, Object element) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        if(index == size)   add(element);
        else{
            for(int i = size; i > index; i--){
                list[i] = list[i - 1];
            }
            list[index] = element;
            size++;
        }
    }

    @Override
    public Object remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        Object tmp = list[index];
        list[index] = null;

        for(int i = index; i < size - 1; i++){
            list[i] = list[i+1];
            list[i+1] = null;
        }
        size--;
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(list[i].equals(o))    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(list[i].equals(o))    return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        int subSize = toIndex - fromIndex + 1;
        Object[] sub = new Object[subSize];
        for(int i = fromIndex; i <= toIndex; i++){
            sub[i] = list[i];
        }
        return Arrays.stream(sub).collect(Collectors.toList());
    }

    @Override
    public boolean retainAll(Collection c) {
        if(containsAll(c))  return true;
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o : c) {
            if(!remove(o)) return false;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if(!contains(o))    return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] arr = new Object[a.length];
        for(int i = 0; i < a.length; i++){
            arr[i] = list[i];
        }
        return arr;
    }
}
