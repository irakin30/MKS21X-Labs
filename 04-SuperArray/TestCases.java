public class TestCases {
  public static void main(String args[]){
    SuperArray alist = new SuperArray();
    alist.add("Mario");
    //displaying elements
    System.out.println(alist);
    System.out.println(alist.toStringDebug());

    alist.add("Samus");
    //displaying elements
    System.out.println(alist);
    System.out.println(alist.toStringDebug());

    alist.add("Ash");
    alist.add("Link");
    alist.add("Kirby");
    //displaying elements
    System.out.println(alist);
    System.out.println(alist.toStringDebug());

    //testing get
    System.out.println(alist.get(1));
    System.out.println(alist.get(3));

    //testing set
    System.out.println(alist.set(1, "Sepharoth") + " to " + "Sepharoth");
    display(alist);
    System.out.println(alist.set(4, "Luigi") + " to " + "Luigi");
    display(alist);
    }

    public static void display(SuperArray alist) {
      System.out.println(alist);
      System.out.println(alist.toStringDebug());
    }
}
