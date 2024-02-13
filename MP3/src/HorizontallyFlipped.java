/**
 * The horizontal flip of a text block.
 * 
 * @author Samuel A. Rebelsky
 * @author Garikai | Alexander
 */
public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
   /**
   * The stuff in the box and its width
   */
  TextBlock contents;
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public HorizontallyFlipped(TextBlock block) {
    this.contents = block;
  } // HorizontallyFlipped(TextBlock block)
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
    int length = this.contents.width();
    char[] reverse = new char[length];
    for (int j = 0; j < length; j++) {
        reverse[length-1-j] = this.contents.row(i).charAt(j);
    }
    return new String(reverse);
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
    return this.contents.width();
  }

  /**
   * Determine if we are structurally equivalent to another block.
   */
  public boolean eqv(TextBlock other) throws Exception {
    return TBUtils.equal(this, other) && 
           (other instanceof HorizontallyFlipped) &&
           (this.contents.eqv(((HorizontallyFlipped) other).contents));
  } // eqv(TextBlock)


}