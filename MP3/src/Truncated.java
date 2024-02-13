/**
 * Textblock shortened to a given width
 * 
 * @author Samuel A. Rebelsky
 * @author Garikai | Alexander
 */
public class Truncated implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
   /**
   * The stuff in the box and its width
   */
  TextBlock contents;
  int maxWidth;
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
    public Truncated(TextBlock block, int maxWidth) {
    if (block.width() < maxWidth) {
      System.err.println("Width too great");
      System.exit(2);
    }
    this.contents = block;
    this.maxWidth = maxWidth;

  } // Truncated(TextBlock block, int maxWidth)
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
    if (this.contents.width() < this.maxWidth) {
        return this.contents.row(i);
    }
    String substring;
    substring = this.contents.row(i).substring(0, this.maxWidth);
    return substring;
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
    if (this.contents.width() < this.maxWidth) {
        return this.contents.width();
    }
    return this.maxWidth;
  }

  /**
   * Determine if we are structurally equivalent to another block.
   */
  public boolean eqv(TextBlock other) throws Exception {
    return TBUtils.equal(this, other) && 
           (other instanceof Truncated) &&
           (this.contents.eqv(((Truncated) other).contents));
  } // eqv(TextBlock)
}

