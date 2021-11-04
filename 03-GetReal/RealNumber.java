public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  /*
  *Return the sum of this and the other
  */
  public double add(RealNumber other){

     //other can be ANY RealNumber, including a RationalNumber

     //or other subclasses of RealNumber (that aren't written yet)

     return value + other.value;
  }

  /*
  *Return the product of this and the other
  */
  public double multiply(RealNumber other){
    return value * other.value;
  }

  /*
  *Return the this divided by the other
  */
  public double divide(RealNumber other){
    return value / other.value;
  }

  /*
  *Return the this minus the other
  */
  public double subtract(RealNumber other){
    return value - other.value;
  }


  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+value;
  }

  public int compareTo(RealNumber other) {
    final value = getValue() - other.getValue();
    if (value < 0) {
      return -1;
    }
    else if (value > 0) {
      return 1;
    }
    else {
      return 0;
    }
  }

  public int equals(RealNumber other) {
      return getValue() == other.getValue(); 
  }
}
