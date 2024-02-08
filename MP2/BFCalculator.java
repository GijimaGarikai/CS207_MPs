import java.lang.Character;

/* 
 * Purpose: BigFraction Calculator. Handles basic math operations between BigFractions
 * @author Garikai Gijima 
 * @author Samuel A. Rebelsky (ideas were taken from the instructions)
*/

public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  // Stores the last computed result
  BigFraction lastResult;
  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  public BFCalculator(){
    this.lastResult = new BigFraction(0, 1);
  }
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  // gets the last calculated value
  public BigFraction get() {
    return this.lastResult;
  } 
  // adds `val` the last calculated value 
  public void add(BigFraction val) {
    this.lastResult = this.get().add(val);
  }
  // subtracts `val` from the last calculated value
  public void subtract(BigFraction val) {
    this.lastResult = this.get().sub(val);
  }

  // multiplies `val` to the last calculated value
  public void multiply(BigFraction val) {
    this.lastResult = this.get().multiply(val);
  }

  // divides `this.lastResult` by `val`
  public void divide(BigFraction val) {
    this.lastResult = this.get().divide(val);
  }

  // resets `this.lastResult to 0
  public void clear() {
    this.lastResult = new BigFraction(0, 1);
  }
  // splits the expression by the space character
  public static String[] tokenize(String expr) {
    String[] tokens = expr.split(" ");
    return tokens;
  }
  // checks if a String is a letter
  public static boolean isLetter(String str) {
    if (str.length() == 1 && Character.isLetter(str.charAt(0))) {
      return true;
    } else {
      return false;
    }
  }
  // checks if an expression is a register or a number
  public static BigFraction decide(String str, Registers register) {
    BigFraction result;
    if (BFCalculator.isLetter(str)) {
      result = register.get(str.charAt(0));
    } else {
      result = new BigFraction(str);
    }
    return result;
  }

  // evaluates an expression
  public void evaluate(String[] tokens, Registers register) {
    //PrintWriter pen = new PrintWriter(System.out, true);
    this.clear();
    String first = tokens[0];
    BigFraction curTotal = decide(first, register);
    this.add(curTotal);
    for (int i = 1; i < tokens.length; i++) {
      String next = tokens[i+1];
      BigFraction curVal = decide(next, register);
      if (tokens[i].equals("+")) { // we put it inside the loop in case the input is off
        this.add(curVal);
      } else if (tokens[i].equals("-")) {
        this.subtract(curVal);
      } else if (tokens[i].equals("*")) {
        this.multiply(curVal);
      } else if (tokens[i].equals("/")) {
        this.divide(curVal);
      }
      i++;
    }
  }
  
}