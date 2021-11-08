public class SuperArray {
    private int size;
    private String[] data;

    public SuperArray() {
      data = new String[10];
      size = 0;
    }

    public SuperArray(int initialCapacity) {
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

    public void add(int index, String newstr) {
        for(int i = size(); i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = newstr;
    }

    public boolean add(String a) {
        data[size] = a;
        size++;
        return true;
    }

    public String remove(int index) {
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
          System.out.println("Error: index out of range");
          return null;
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

    public String set(int index, String element) {
      if (index >= 0) {
        String temp = data[index];
        data[index] = element;
        return temp;
      }
      else {
        System.out.println("Error: index out of bounds");
        return null;
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
