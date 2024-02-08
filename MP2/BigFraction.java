import java.math.BigInteger;
import java.lang.Character;
/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Garikai Gijima
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions 
   * are represented with a negative numerator. Similarly, if a fraction 
   * has a negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To 
   * obtain a fraction in simplified form, one must call the `simplify` 
   * method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
    simplify(this);
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
    simplify(this);
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public BigFraction(String str) {
    if (isNegative(str)) {
      BigFraction temp = new BigFraction(str.substring(1));
      temp = temp.multiply(new BigFraction(-1, 1));
      this.num = temp.numerator();
      this.denom = temp.denominator();
      return;
    }
    if (isNumeric(str)) {
      this.num = new BigInteger(str);
      this.denom = BigInteger.valueOf(1);
      return;
    }
    int position = str.indexOf("/");
    String cnum = str.substring(0,position);
    String cdnom = str.substring(position+1);
    this.num = new BigInteger(cnum);
    this.denom = new BigInteger(cdnom);
    simplify(this);
  } // Fraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  public void simplify(BigFraction fraction) {
    BigInteger numer = fraction.numerator();
    BigInteger denom = fraction.denominator();
    BigInteger commonFactor = numer.gcd(denom);
    numer = numer.divide(commonFactor);
    denom = denom.divide(commonFactor);
    if (denom.signum() == -1) {
      BigInteger negative = new BigInteger("-1");
      denom = denom.multiply(negative);
      numer = numer.multiply(negative);
    }
    fraction.num = numer;
    fraction.denom = denom;
  }

  /**
   * @param strNum
   * checks if the given string contains only numeric characters
   * @return boolean
   */
  public static boolean isNumeric(String strNum) {
    for (int i = 0; i < strNum.length(); i++) {
      char cur = strNum.charAt(i);
      boolean digit = Character.isDigit(cur);
      if (!digit) {
        return false;
      }
    }
    return true;
  }

  public static boolean isNegative(String strNum) {
    char sign = strNum.charAt(0);
    if (sign == '-') {
      return true;
    }
    return false;
  }

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's 
    // denominator and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = 
      (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // add(Fraction)

  /**
   * Subtract the fraction `subMe` to this fraction.
   * Works by making `subMe` negative and adding it
   */
  public BigFraction sub(BigFraction subMe) {
    BigInteger newNumerator = subMe.numerator().multiply(BigInteger.valueOf(-1));
    BigInteger newDenominator = subMe.denominator();
    BigFraction newSubMe;
    newSubMe = new BigFraction(newNumerator, newDenominator);
    return this.add(newSubMe);
  } // sub(Fraction)

  /**
   * multiply the fraction `multMe` to this fraction.
   */
  public BigFraction multiply(BigFraction multMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's 
    // denominator and multMe's denominator
    resultDenominator = this.denom.multiply(multMe.denom);
    // The numerator is the same
    resultNumerator = this.num.multiply(multMe.num);
    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  } // multiply(Fraction)

  public BigFraction divide(BigFraction divMe) {
    BigInteger newNumerator = divMe.denominator();
    BigInteger newDenominator = divMe.numerator();
    BigFraction divider = new BigFraction(newNumerator, newDenominator);
    return this.multiply(divider);
  } // divide(Fraction)

  /**
   * get the fractional part of the mixed fraction.
   */
  public BigFraction fractional() {
    BigInteger curNumerator = this.numerator();
    BigInteger denominator = this.denominator();
    BigInteger resultNumerator = curNumerator.mod(denominator);
    return new BigFraction(resultNumerator, denominator);
    
  } // fractional(Fraction)

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero
    if (this.denom.equals(BigInteger.valueOf(1))) {
      return this.num.toString();
    }
    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class Fraction
