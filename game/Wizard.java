public class Wizard extends Adventurer {
    private int mana; 
    private String chant;  

    // Constructors
    public Wizard() {
        this("_"); 
    } 

    public Wizard(String name) {
        this(name, 10);
    } 

    public Wizard(String name, int mana) {
       this(name, mana, "a"); 
    }  

    public Wizard(String name, int mana, String chant) {
        this.setName(name);
        this.setMana(mana);
        this.chant = chant; 

    }

    //Accessor - Mutators
    public int getMana() {
        return mana; 
    } 

    public void setMana(int value) {
        this.mana = value; 
    }   

    public void setChant(String chant) {
        this.chant = chant; 
    }

    public String getChant() {
        return chant; 
    }

    //Damage Stuff
    public void attack(Damageable other) {} 
    public void specialAttack(Damageable other) {}

}
