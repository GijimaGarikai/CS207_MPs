/**
 * A text block centered in a given width.
 *
 * @author Samuel A. Rebelsky
 * @author Garikai | Alexander
 */
public class Centered implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
   /**
   * The stuff in the box and its width
   */
  TextBlock contents;
  int totWidth;
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
    public Centered(TextBlock block, int totWidth) {
    if (block.width() > totWidth) {
      System.err.println("Width too small");
      System.exit(2);
    }
    this.contents = block;
    this.totWidth = totWidth;
  } // Centered(TextBlock block, int maxWidth)
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception{
    int remaining = this.totWidth - this.contents.width();
    int left = remaining / 2;
    int right = remaining - left;
    String leftSpace = "";
    String rightSpace = "";
    for(int j = 0; j < left; j++) {
      leftSpace += " ";
    }
    for(int j = 0; j < right; j++) {
      rightSpace += " ";
    }
    return leftSpace + this.contents.row(i) + rightSpace;
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.totWidth;
  }

  /**
   * Determine if we are structurally equivalent to another block.
   */
  public boolean eqv(TextBlock other) throws Exception {
    return TBUtils.equal(this, other) && 
           (other instanceof Centered) &&
           (this.contents.eqv(((Centered) other).contents));
  } // eqv(TextBlock)
}