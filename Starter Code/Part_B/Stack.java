public class Stack implements StackInterface {

	DequeInterface myDeque = new ArrayDeque();

	public void push(Object o){
		myDeque.insertLast(o);
	}

	public Object pop() throws EmptyStackException{
		if(myDeque.isEmpty()) throw new EmptyStackException("No element present in Stack");
		try {
			return myDeque.removeLast();
		} catch (EmptyDequeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object top() throws EmptyStackException{
		if(myDeque.isEmpty()) throw new EmptyStackException("No element present in Stack");
		try {
			return myDeque.last();
		} catch (EmptyDequeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isEmpty(){
		return myDeque.isEmpty();
	}

	public int size(){
		return myDeque.size();
	}
}