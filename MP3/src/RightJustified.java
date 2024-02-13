public class RightJustified implements TextBlock {
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
    public RightJustified(TextBlock block, int totWidth) {
    if (block.width() > totWidth) {
      System.err.println("Width too small");
      System.exit(2);
    }
    this.contents = block;
    this.totWidth = totWidth;
  } // RightJustified(TextBlock block, int maxWidth)
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
    int left = this.totWidth - this.contents.width();
    String leftSpace = "";
    for(int j = 0; j < left; j++) {
      leftSpace += " ";
    }
    return leftSpace + this.contents.row(i);
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
  * Return the contents of the text block.
  */
  public TextBlock getContents() {
    return this.contents;
  }

}