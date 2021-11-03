public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno != 0) {
      numerator = nume;
      denominator = deno;
    }
    else {
      numerator = 0;
      denominator = 1;
    }
  }

  public double getValue(){
    return numerator / denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }

  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator == other.numerator) && (denominator == other.denominator);
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */

  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a == 0) {
        return b;
    }
    return (b % a, a);
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
      int gcd = gcd(numerator, denominator);
      numerator /= gcd;
      denominator /= gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int newNum = numerator * other.numerator;
    int newDen = denominator * other.denominator;
    RationalNumber product = new RationalNumber(newNum, newDen);
    product.reduce();
    return product;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber quotient = new RationalNumber(numerator, denominator);
    quotient = multiply(reciprocal(other));
    if (quotient.denominator == 0) {
        quotient.numerator = 0;
        quotient.denominator = 1;
    }
    else {
        quotient.reduce();
    }
    return quotient;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int newNum = (numerator * other.denominator) + (other.numerator * denominator);
    int newDen = (denominator * other.denominator);
    RationalNumber sum = new RationalNumber(newNum, newDen);
    sum.reduce();
    return sum;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int newNum = (numerator * other.denominator) - (other.numerator * denominator);
    int newDen = (denominator * other.denominator);
    RationalNumber difference = new RationalNumber(newNum, newDen);
    difference.reduce();
    return difference;
  }
}
