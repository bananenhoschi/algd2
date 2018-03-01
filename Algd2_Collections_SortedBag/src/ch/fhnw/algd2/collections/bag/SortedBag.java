//******************************************************************************
//  ALGD-2  :  Excercise 1a : SortedBag                                        *
// --------------------------------------------------------------------------- *
//  version 1  :  2014-02-25                                              vtg  *
//******************************************************************************

package ch.fhnw.algd2.collections.bag;

import java.util.Arrays;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class SortedBag<E extends Comparable<E>> extends MyAbstractCollection<E> {

	public static final int DEFAULT_CAPACITY = 100;
	private int size;
	private Object[] data;

	public SortedBag() {
		this(DEFAULT_CAPACITY);
	}

	public SortedBag(int capacity) {
		this.size = 0;
		data = new Object[capacity];
	}

	@Override
	public boolean add(E e) {
	  if (size == data.length) throw new IllegalStateException();
    if (e==null) throw new NullPointerException();
    int pos = Arrays.binarySearch(data,0,size,e);
    if (pos<0)
      pos = -(pos + 1);
    for (int i=size; i>pos; --i){
      data[i] = data[i-1];
    }
    data[pos] = e;
    ++size;
    return true;
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
	  E dummy = (E)o; // check class cast
    if (size>0){
      return Arrays.binarySearch(data,0,size,o) >= 0;
    }
    return false;
	}


	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size());
	}

	@Override
	public int size() {
	  return size;
	}

	public static void main(String[] args) {
		SortedBag<Integer> bag = new SortedBag<Integer>();
		bag.add(2);
		bag.add(1);
		System.out.println(Arrays.toString(bag.toArray()));
	}

}
