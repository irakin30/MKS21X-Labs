import java.util.ArrayList;

public class ArrayListPractice {
    public static ArrayList<String> replaceEmpty( ArrayList<String> data){
    //return an new ArrayList that has all of the values of the original ArrayList except
    //that all empty strings are replaced with the word "Empty".
      ArrayList<String> newData = data.subList(0, data.size());
      for (int i = 0; i < newdata.size(); i++) {
          if (newData.get(i).equals("")) {
              newData.set(i, "Empty");
          }
      }
      return newdata;
    }

    public static ArrayList<String> makeReversedList( ArrayList<String> data){
    //return a new ArrayList that is in the reversed order of the parameter.
      ArrayList<String> newData = new ArrayList(data.size());
      for(int i = 0; i < data.size() - 1; i++) {
          newData.set(i, data.get(data.size() - (i + 1)));
      }
      return newData;
    }

    public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
    //return a new ArrayList that has all values of a and b in alternating order that is:
    //a[0], b[0], a[1], b[1]...
    //when one list is longer than the other, just append the remaining values to the end.
    }
}
