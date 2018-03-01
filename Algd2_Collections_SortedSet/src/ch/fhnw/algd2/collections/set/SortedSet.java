//******************************************************************************
//  ALGD-2  :  Excercise 1a : SortedSet                                        *
// --------------------------------------------------------------------------- *
//  version 1  :  2014-02-25                                              vtg  *
//******************************************************************************

package ch.fhnw.algd2.collections.set;

import java.util.Arrays;
import java.util.Set;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class SortedSet<E extends Comparable<E>> extends MyAbstractCollection<E>
		implements Set<E> {

	public static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Object[] data;

	public SortedSet() {
		this(DEFAULT_CAPACITY);
	}

	public SortedSet(int capacity) {
		this.size = 0;
		data = new Object[capacity];
	}

	@Override
	public boolean add(E e) {
	  if (size == data.length) throw new IllegalStateException();
	  if (e==null) throw new NullPointerException();
	  int pos = Arrays.binarySearch(data,0,size,e);
	  if (pos>=0){
	    return false;
	  }else{
	    pos = -(pos + 1);
	    for (int i=size; i>pos; --i){
	      data[i] = data[i-1];
	    }
	    data[pos] = e;
	    ++size;
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
		SortedSet<Integer> set = new SortedSet<Integer>();
		
		int[] values = {1,2,3,4,5,6,7,8,9,10,11};
		
		System.out.println(set.contains(3));
    System.out.println("-------------------------");
		
		for (int i : values){
		  System.out.println("vorher:" + Arrays.toString(set.toArray()));
		  set.add(i);
		  System.out.println("nachher:" + Arrays.toString(set.toArray()));
		  System.out.println(set.contains(3));
		  System.out.println("-------------------------");
		}
	}

}
