public class Kitty {
    private int age;
    private String name;

    public Kitty(String newName, int newAge) {
      age = newAge;
      name = newName;
    }

    public Kitty() {
      name = "Mittens";
      age = 2;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public void changeName(String newName) {
      name = newName;
    }

    public void makeOlder() {
      age++;
    }

    public String toString() {
      return "The amazing " + name + "."; 
    }
}
