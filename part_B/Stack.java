public class Stack implements StackInterface {

	DequeInterface myDeque = new ArrayDeque();

	public void push(Object o){ //O(n)
		myDeque.insertLast(o);
	}

	public Object pop() throws EmptyStackException{ //O(1)
		if(myDeque.isEmpty()) throw new EmptyStackException("No element present in Stack");
		try {
			return myDeque.removeLast();
		} catch (EmptyDequeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object top() throws EmptyStackException{ //O(1)
		if(myDeque.isEmpty()) throw new EmptyStackException("No element present in Stack");
		try {
			return myDeque.last();
		} catch (EmptyDequeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isEmpty(){ //O(1)
		return myDeque.isEmpty();
	}

	public int size(){ //O(1)
		return myDeque.size();
	}
}