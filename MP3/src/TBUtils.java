import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Garikai, Alexander
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)
  // tests whether a textblock looks the same
  public static boolean equal(TextBlock t1, TextBlock t2) throws Exception {
    int height, width;
    height = t1.height();
    width = t1.width();
    if (height != t2.height() || width != t2.width()) {
      return false;
    }
    for (int j = 0; j < height; j++) {
      String str1 = t1.row(j);
      String str2 = t2.row(j);
      if (!str1.equals(str2)) {
        return false;
      }
    }
    return true;
  }
  // tests whether a textblock was built with the same building blocks and input
  public static boolean eqv(TextBlock t1, TextBlock t2) throws Exception {
    return t1.eqv(t2);
  }
  // tetst whether a textblock is stored in the same place in memory
  public static boolean eq(TextBlock t1, TextBlock t2) throws Exception {
    return t1.toString().equals(t2.toString());
  }
} // class TBUtils
