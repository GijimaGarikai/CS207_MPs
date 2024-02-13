public class VerticallyFlipped implements TextBlock {
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
  public VerticallyFlipped(TextBlock block) {
    this.contents = block;
  } // VerticallyFlipped(TextBlock block)
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
    return this.contents.row(this.height() - i - 1);
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
  * Return the contents of the text block.
  */
  public TextBlock getContents() {
    return this.contents;
  }

}