public class ArrayDeque implements DequeInterface{
  public static final int LENGTH = 1;

  private Object[] array = new Object[LENGTH];;

  private int N = array.length;
  public int size = 0;
  private int f = 0;
  private int r = 0;

  public void insertFirst(Object o){
    if (size()==N){
      Object[] newArray = new Object[2*N];
      newArray[0] = o;
      int k=1;
      int i=f%N;
      do{
        newArray[k] = array[i];
        k++;
        f++;
        i=f%N;

      }while(i!=r);
      f=0;
      size++;
      array=newArray;
      N=array.length;
      r=k%N;

    }else{
      if(f==0){
        array[N-1] = o;
        f=N-1;
        size++;
      }else{
        f--;
        array[f]=o;
        size++;
      }

    }
  }

  public void insertLast(Object o){
    if (size()==N){
      Object[] newArray = new Object[2*N];
      int k=0;
      int i=f%N;
      do{
        newArray[k] = array[i];
        k++;
        f++;
        i=f%N;

      }while(i!=r);

      f=0;
      size++;
      array = newArray;
      N = array.length;
      r=k%N;
      array[r] = o;
      r=(r+1)%N;

    }else{
      array[r] = o;
      r = (r+1)%N;
      size++;
    }
  }

  public Object removeFirst() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("No element present");
    Object temp = first();
    array[f] = null;
    f= (++f)%N;
    size--;
    return temp;
  }

  public Object removeLast() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("No element present");
    Object temp = last();

    if(r==0){
      array[N-1] = null;
      r=N-1;
    }
    else{
      array[r-1] = null;
      r--;
    }

    size--;
    return temp;
  }

  public Object first() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("No element present");
    return array[f];
  }

  public Object last() throws EmptyDequeException{
    if(isEmpty()) throw new EmptyDequeException("No element present");
    if(r==0)
      return array[N-1];
    else
      return array[r-1];
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size()==0;
  }

  public String toString(){
    String s = "[";
    int temp = f;
    int i = temp%N;

    do {
      if(array[i]!=null)
        s = s + array[i] + ",";
      temp++;
      i = temp%N;
    }while(i!=r);

    s= s.substring(0,s.length()-1) + "]";
    return s;
  }
}