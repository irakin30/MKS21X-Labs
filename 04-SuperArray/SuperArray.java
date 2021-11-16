public class SuperArray {

    // Fields
    private int size;
    private String[] data;

    // Constructors
    public SuperArray() {
      data = new String[10];
      size = 0;
    }

    public SuperArray(int initialCapacity) throws IllegalArgumentException {
      if (initialCapacity < 0) {
          throw new IllegalArgumentException("Error: Size must be a non-negative integer value");
      }
      data = new String[initialCapacity];
      size = 0;
    }

    // ToString methods
    public String toString() {
      String str = "[";
      for (int i = 0; i < size; i++) {
        str += data[i];
        if (i < size - 1) {
          str += ", ";
        }
      }
      return str + "]";
    }

    public String toStringDebug() {
      String str = "[";
      for (int i = 0; i < data.length; i++) {
        str += data[i];
        if (i < data.length - 1) {
          str += ", ";
        }
      }
      return str + "]";
    }

    // Accessor/Mutator Methods
    public String get(int index) throws IndexOutOfBoundsException {
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Error: Index must be a non-negative integer value");
      }
      return data[index];
    }

    public String set(int index, String element) throws IndexOutOfBoundsException {
      if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Error: Index must be a non-negative integer value");
      }
      String temp = data[index];
      data[index] = element;
      return temp;
    } 
    
    public int size() {
      return size;
    }

    // Index Methods
    public int indexOf(String str) {
      for (int i = 0; i < size; i++) {
        if (str.equals(data[i])) {
          return i;
        }
      }
      return -1;
    }

    public int lastIndexOf(String str) {
      for (int i = size; i > 0; i--) {
        if (str.equals(data[i])) {
          return i;
        }
      }
      return -1;
    } 

    // SuperArray Methods
    private void resize() {
        String[] newarr = new String[2 * size + 1];
        for (int i = 0; i < size(); i++) {
          newarr[i] = data[i];
        }
        data = newarr;
    }

    public boolean add(String a) {
      if (size + 1 >= data.length) {
        resize();
      }
        data[size] = a;
        size++;
        return true;
    }

    public void add(int index, String newstr) {
      if (size + 1 >= data.length) {
        resize();
      } 
      size++;
      for(int i = size(); i > index; i--) {
          data[i] = data[i-1];
      }
      data[index] = newstr;
    }

    public String remove(int index) throws IndexOutOfBoundsException{
      if (index < 0 || index >= size)
      {
          throw new IndexOutOfBoundsException("Error: Index must be a non-negative integer value");
      }
        String removed = data[index];
        size--; 
        for (int i = index; i < size; i++) {
          data[i] = data[i + 1];
        }
        data[size] = null;
        return removed;
    
    }

    public boolean remove(String target) {
      if (indexOf(target) == -1) { 
        return false;
      } 
      remove(indexOf(target)); 
      return true; 
  }
}
