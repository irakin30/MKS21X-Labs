public class SuperArray {
    private int size;
    private String[] data;

    public SuperArray() {
      data = new String[10];
      size = 0;
    }

    public int size() {
        return size;
    }

    public void add(String a) {
        data[size] = a;
        size++;
    }

    public void remove(int index) {
        data[index] = null;
        for (int i = index; i < size; i++) {
          data[i] = data[i + 1];
          //reminder to add the edge case
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
}