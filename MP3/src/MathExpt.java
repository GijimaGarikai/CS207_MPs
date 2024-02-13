import java.io.PrintWriter;
import java.math.*;
// import java.math.BigInteger;
// import java.math.Integer;
// import java.math.Double;
// import java.math.BigDecimal;
// import java.math.Float;

/**
 * A few simple experiments with our utilities.
 *
 * @author Samuel A. Rebelsky
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    // for (BigInteger i = BigInteger.valueOf(2); i < 10; i++) {
    //   double root = MathUtils.squareRoot(i);
    //   pen.println("The square root of " + i + " seems to be " + root);
    //   pen.println(root + "^2 = " + (root * root));
    // } // for i
    BigInteger testBI = BigInteger.valueOf(2);
    double root = MathUtils.squareRoot(testBI);
    pen.println("The square root of BigInt" + testBI + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));

    Integer testInt = Integer.valueOf(2);
    root = MathUtils.squareRoot(testInt);
    pen.println("The square root of Integer" + 2 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));

    Float testFl = Float.valueOf(2);
    root = MathUtils.squareRoot(testFl);
    pen.println("The square root of Float" + testFl + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));

    Double testD = Double.valueOf(2);
    root = MathUtils.squareRoot(testD);
    pen.println("The square root of Double" + testD + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));

    BigDecimal testBD = BigDecimal.valueOf(2);
    root = MathUtils.squareRoot(testBD);
    pen.println("The square root of BigInt" + testBD + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));

    double testdd = 2;
    root = MathUtils.squareRoot(testdd);
    pen.println("The square root of BigInt" + testdd + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));


    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
