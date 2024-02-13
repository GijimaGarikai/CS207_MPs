import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // // Create a block to use
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("Hello");
    HorizontallyFlipped testH = new HorizontallyFlipped(block);
    HorizontallyFlipped testtestH = new HorizontallyFlipped(testH);
    HorizontallyFlipped testH2 = new HorizontallyFlipped(block2);
    BoxedBlock boxedLine = new BoxedBlock(block);
    pen.println(TBUtils.eqv(testH, testH2));
    pen.println(TBUtils.eqv(block, boxedLine));
    pen.println(TBUtils.eqv(block, testtestH));

    // // Print out the block
    // TBUtils.print(pen, block);

//    TBUtils.print(pen, boxedLine.getContents());

    // BoxedBlock boxedBoxedLine = new BoxedBlock(boxedLine);
    // TBUtils.print(pen, boxedBoxedLine);

    // TextBlock mt = new TextLine("");
    // BoxedBlock mtBoxedLine = new BoxedBlock(mt);
    // TBUtils.print(pen, mtBoxedLine);

    //TextBlock block2 = new TextLine("Goodbye");
    //VComposition v1 = new VComposition(block, block2);
    // BoxedBlock vBoxedLines = new BoxedBlock(v1);
    //TBUtils.print(pen, v1);

    //Underlined cent = new Underlined(block);

    //VerticallyFlipped hrz = new VerticallyFlipped(v1);
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
