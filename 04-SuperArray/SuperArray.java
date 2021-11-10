public class SuperArray {
    private int size;
    private String[] data;

    public SuperArray() {
      data = new String[10];
      size = 0;
    }

    public SuperArray(int initialCapacity) throws Exception {
      if (initialCapacity < 0) {
          throw new IllegalArgumentException("Error: Size must be a non-negative integer value")
      }
      data = new String[initialCapacity];
      size = 0;
    }

    private void resize() {
        String[] newarr = new String[2 * size() + 1];
        for (int i = 0; i < size(); i++) {
            newarr[i] = data[i];
        }
        data = newarr;
    }

    public int size() {
        return size;
    }

    public boolean add(String a) {
      if (size() + 1 >= data.length) {
          resize();
      }
        data[size] = a;
        size++;
        return true;
    }

    public void add(int index, String newstr) {
        if (size() + 1 >= data.length) {
            resize();
        }
        for(int i = size(); i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = newstr;
    }

    public String remove(int index) throws IllegalArgumentException{
      if (index > 0 && index <= size()){
         String removed = data[index];
        data[index] = null;
        for (int i = index; i < size; i++) {
          data[i] = data[i + 1];
        }
        data[size] = null;
        return removed;
      }
      else {
          throw new IllegalArgumentException("Error: Index must be a non-negative integer value");
      }
    }

    public boolean remove(String target) {
        final int index = indexOf(target);
        if (index != -1) {
            remove(index);
            return true;
        }
        else {
          return false;
        }
    }

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

    public String get(int index) {
        return data[index];
    }

    public String set(int index, String element) throws IllegalArgumentException {
      if (index >= 0) {
        String temp = data[index];
        data[index] = element;
        return temp;
      }
      else {
        throw new IllegalArgumentException("Error: Index must be a non-negative integer value");
      }
    }

    public int indexOf(String str) {
        for (int i = 0; i < size(); i++) {
          if (str.equals(data[i])) {
            return i;
          }
        }
        return -1;
    }

    public int LastIndexOf(String str) {
        for (int i = size(); i > 0; i--) {
          if (str.equals(data[i])) {
            return i;
          }
        }
        return -1;
    }


}
