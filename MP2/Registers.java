/* 
 * Purpose: Registers. Stores past result values of the QUICK or INTERACTIVE calculators
 * @author Garikai Gijima 
 * @author Samuel A. Rebelsky (ideas were taken from the instructions)
*/
public class Registers {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  // Register of 26 BigFraction values
  BigFraction[] register;
  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  public Registers() {
    this.register= new BigFraction[26];
  }
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  public void store(char register, BigFraction val) {
    int a = (int) 'a';
    int position = (int) Character.toLowerCase(register) - a;
    this.register[position] = val;
  }

  public BigFraction get(char register) {
    int a = (int) 'a';
    int position = (int) Character.toLowerCase(register) - a;
    return this.register[position];
  }
}