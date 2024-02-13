//package csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the sample methods.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class TBTests {
  /**
   * A test that should succeed.
   * @throws Exception 
   */

  // TextBlock t1 = new TextLine("Hello World");
  // TextBlock t2 = new TextLine("Hello World");
  // TextBlock t3 = new TextLine("");

  // TextBlock bb = new BoxedBlock(t1);
  // TextBlock c = new Centered(bb, 10);
  // TextBlock hc = new HComposition(c, t1);
  // TextBlock hf = new HorizontallyFlipped(hc);
  // TextBlock rj = new RightJustified(hf, 20);
  // TextBlock tr = new Truncated(rj, 3);
  // TextBlock u = new Underlined(tr);
  // TextBlock vc = new VComposition(u, t1);
  // TextBlock vf = new VerticallyFlipped(vc);
  // TextBlock bb2 = new BoxedBlock(vf);

  // TextBlock block = new TextLine("Hello");
  // TextBlock block2 = new TextLine("Hello");
  // HorizontallyFlipped testH = new HorizontallyFlipped(block);
  // HorizontallyFlipped testtestH = new HorizontallyFlipped(testH);
  // HorizontallyFlipped testH2 = new HorizontallyFlipped(block2);
  // BoxedBlock boxedLine = new BoxedBlock(block);

  @Test
  void sampleSuccesfulTest() throws Exception {
    TextBlock t1 = new TextLine("Hello World");
    TextBlock t2 = new TextLine("Hello Worl");
    assertEquals(false, TBUtils.equal(t1, t2));
  } // sampleSuccessfulTest()

  /**
   * A test that should fail.
   */
  @Test
  void sampleFailingTest() {
    fail(2, 3);
  } // sampleFailingTest()
} // class TestSampleMethods