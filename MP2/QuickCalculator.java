import java.io.PrintWriter;
/* 
 * Purpose: Quick Calculator. Handles multiple basic math expressions on the CLI
 * @author Garikai Gijima 
 * @author Samuel A. Rebelsky (ideas were taken from the instructions)
*/
public class QuickCalculator {
  public static void main (String[] args) throws Exception {
    if (args.length < 1) { // error checking to ensure appropriate input
      System.err.println("No expressions entered");
      System.exit(2);
    }
    // Instantiate the PrintWriter
    PrintWriter pen = new PrintWriter(System.out, true);
    // Instantiate register
    Registers register = new Registers();
    // Instantiate Calculator
    BFCalculator calc = new BFCalculator();
    String[] expressions = args;
    for (int i = 0; i < expressions.length; i++) {
      try {
        String[] expr = BFCalculator.tokenize(expressions[i]);
        String start = expr[0];
        BigFraction result = InteractiveCalculator.eval(start, expr, register, calc);
        if (!start.equals("STORE")) {
          printStringArr(expr, pen);
          pen.print(" = ");
          pen.println(result);
        } else {
          pen.print(expr[1]);
          pen.print(" = ");
          pen.println(result);
        }
      } catch(Exception ex) {
        System.err.println("'" + expressions[i] + "'" + " is invalid. Unable to compute.");  
      }
    }
  }
  // prints the strings in a String array
  public static void printStringArr(String[] arr, PrintWriter pen) {
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length-1) {
        pen.print(arr[i]);
      } else {
        pen.print(arr[i]);
        pen.print(" ");
      }
    }
    
  }
}