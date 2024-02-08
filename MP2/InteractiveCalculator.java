import java.io.PrintWriter;
import java.util.Scanner;
/* 
 * Purpose: Interactive Calculator. Basic calculator on CLI
 * @author Garikai Gijima 
 * @author Samuel A. Rebelsky (ideas were taken from the instructions)
*/
public class InteractiveCalculator {
  public static void main (String[] args) throws Exception {
    // if (args.length < 2) { // error checking to ensure appropriate input
    //   System.err.println("Invalid number of parameters");
    //   System.exit(2);
    // }
    // Instantiate the PrintWriter
    PrintWriter pen = new PrintWriter(System.out, true);
    // Instantiate register
    Registers register = new Registers();
    // Instantiate Calculator
    BFCalculator calc = new BFCalculator();
    // Instantiate scanner and get input
    Scanner scanner = new Scanner(System.in);
    printInstructions(pen);
    String[] input = getInput(scanner, pen);
    String start = input[0];
    while (!start.equals("QUIT")) {
      try {
        BigFraction result = eval(start, input, register, calc);
        if (!start.equals("STORE")) {
          pen.println(result);
        }
      } catch (Exception ex) {
        System.err.println("Invalid expression. Note initial instructions");
      }

      input = getInput(scanner, pen);
      start = input[0];
    }
    
    scanner.close();
    //pen.println(calc.get());
  }
  // get's input from the command line
  public static String[] getInput(Scanner scanner, PrintWriter pen) {
    pen.println("Enter space separated expression to continue or 'QUIT' to exit");
    String input = scanner.nextLine();
    String[] betterInput = BFCalculator.tokenize(input);
    return betterInput;
  }
  // intermediary evaluation function
  public static BigFraction eval(String start, String[] input, Registers register, BFCalculator calc) {
    if (start.equals("STORE")) {
      char place = input[1].charAt(0);
      register.store(place, calc.get()); 
    } else {
      calc.evaluate(input, register);
      //pen.println(calc.get());
    } 
    return calc.get();
  }

  public static void printInstructions(PrintWriter pen) {
    pen.println("*****INSTRUCTIONS START*****");
    pen.println("Ensure all operands and operators are space separated");
    pen.println("Valid operators: '+'' | '-'' | '/'' | '*'");
    pen.println("Valid operands: Whole numbers | Fractions | Letters (only if value was stored there prior)");
    pen.println("Expressions must start with a number|fraction|register and end with any of the same type. Single value expressions are allowed");
    pen.println("Expressions must alternate between operands and operators");
    pen.println("STORE operations must be followed by a single letter character as the register");
    pen.println("*****INSTRUCTIONS END*****");

  }
  
}