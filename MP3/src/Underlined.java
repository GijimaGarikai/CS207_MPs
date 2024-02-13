/**
 * Underlines a given textblock
 * 
 * @author Samuel A. Rebelsky
 * @author Garikai | Alexander
 */
public class Underlined implements TextBlock {
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
  public Underlined(TextBlock block) {
    this.contents = block;
  } // Underlined(TextBlock block)
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
    if(i == this.height() -1) {
      int length = this.width();
      char[] underline = new char[length];
      for (int j = 0; j < length; j++) {
        underline[j] = '_';
      }
      return new String(underline);
    }
    else {
    return this.contents.row(i);
    }
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height() + 1;
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
           (other instanceof Underlined) &&
           (this.contents.eqv(((Underlined) other).contents));
  } // eqv(TextBlock)

}