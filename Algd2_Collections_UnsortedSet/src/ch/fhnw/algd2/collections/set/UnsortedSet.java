//******************************************************************************
//  ALGD-2  :  Excercise 1a : UnortedSet                                        *
// --------------------------------------------------------------------------- *
//  version 1  :  2014-02-25                                              vtg  *
//******************************************************************************


package ch.fhnw.algd2.collections.set;

import java.util.Arrays;
import java.util.Set;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class UnsortedSet<E extends Comparable<E>> extends
		MyAbstractCollection<E> implements Set<E> {

	public static final int DEFAULT_CAPACITY = 100;
	private int size;

	private Object[] data;

	public UnsortedSet() {
		this(DEFAULT_CAPACITY);
	}

	public UnsortedSet(int capacity) {
		this.size = 0;
		data = new Object[capacity];
	}

	@Override
	public boolean add(E e) {
	  if (size == data.length) throw new IllegalStateException();
    if (e==null) throw new NullPointerException();
    int pos = find(e);
    if (pos>=0){
      return false;
    }else{
      data[size++] = e;
      return true;
    }
	}

	@Override
	public boolean remove(Object o) {
	  int pos = Arrays.binarySearch(data,0,size,o);
    if (pos < 0){
      return false;
    }else{
      for (int i=pos; i<size-1; ++i){
        data[i] = data[i+1];
      }
      --size;
      return true;
    }
	}


	@Override
	public boolean contains(Object o) {
	  return find(o) >= 0;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size());
	}

	@Override
	public int size() {
	  return size;
	}
	
	private int find(Object o) {
    try{
      for (int i=0; i<size; ++i){
        if (((E)data[i]).compareTo((E)o) == 0){
          return i;
        }
      }
    }
    catch (ClassCastException e){
      return -1;
    }
    return -1;
  }

	public static void main(String[] args) {
		UnsortedSet<Integer> set = new UnsortedSet<Integer>();
		set.add(2);
		set.add(2);
		set.add(1);
		System.out.println(Arrays.toString(set.toArray()));
		System.out.println(set.contains("aaa"));
	}

}
