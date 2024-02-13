//package csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;

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

  
  TextBlock t1 = new TextLine("Hello World");
  TextBlock t2 = new TextLine("Hello World");
  TextBlock t3 = new TextLine("");

  // TextBlock bb = new BoxedBlock(t1);
  // TextBlock c = new Centered(bb, 10);
  // TextBlock hc = new HComposition(c, t1);
  // TextBlock hf = new HorizontallyFlipped(hc);
  // TextBlock rj = new RightJustified(hf, 20);
  // TextBlock tr = new Truncated(rj, 3);
  // TextBlock u = new Underlined(tr);
  // TextBlock vc = new VComposition(u, t1);
  // TextBlock vf = new  // TextBlock bb2 = new BoxedBlock(vf); VerticallyFlipped(vc);


  TextBlock block = new TextLine("Hello");
  TextBlock block2 = new TextLine("Hello");
  HorizontallyFlipped testH = new HorizontallyFlipped(block);
  HorizontallyFlipped testtestH = new HorizontallyFlipped(testH);
  HorizontallyFlipped testH2 = new HorizontallyFlipped(block2);
  BoxedBlock boxedLine = new BoxedBlock(block);
  TextBlock empty = new TextLine("");
  Truncated trunc = new Truncated(block, 0);

  /*
   * Tests the equal method of TBUtils
   */
  //Case where the two blocks are the same block
  @Test
  void equalTest1() throws Exception {
    assertEquals(true, TBUtils.equal(block, block));
  }

  //Case where the two blocks were built the same
  @Test
  void equalTest2() throws Exception {
    assertEquals(true, TBUtils.equal(block, block2));
  }

  //Case where two blocks only look the same
  @Test
  void equalTest3() throws Exception {
    assertEquals(true, TBUtils.equal(block, testtestH));
  }

  //Case where two block look different
  @Test
  void equalTest4() throws Exception {
    assertEquals(false, TBUtils.equal(block, testH));
  }

  //Case where two empty strings are compared
  @Test
  void equalTest5() throws Exception {
    assertEquals(true, TBUtils.equal(empty, trunc));
  }





  /*
   * Tests the eqv method of TBUtils
   */
  TextBlock v = new VComposition(block, empty);
  TextBlock h = new HComposition(block, empty);

  //Case where the two blocks are the same block
  @Test
  void eqvTest1() throws Exception {
    assertEquals(true, TBUtils.eqv(block, block));
  }

  //Case where the two blocks were built the same
  @Test
  void eqvTest2() throws Exception {
    assertEquals(true, TBUtils.eqv(block, block2));
  }

  //Case where two blocks only look the same
  @Test
  void eqvTest3() throws Exception {
    assertEquals(false, TBUtils.eqv(block, testtestH));
  }

  //Case where two block look different
  @Test
  void eqvTest4() throws Exception {
    assertEquals(false, TBUtils.eqv(block, testH));
  }

  //Case where every step looks the same, but at least one of the building blocks is a different type
  @Test
  void eqvTest5() throws Exception {
    assertEquals(false, TBUtils.equal(v, h));
  }



  /*
   * Tests the equal method of TBUtils
   */
  //Case where the two blocks are the same block
  @Test
  void eqTest1() throws Exception {
    assertEquals(true, TBUtils.eq(block, block));
  }

  //Case where the two blocks were built the same (but aren't the same)
  @Test
  void eqTest2() throws Exception {
    assertEquals(false, TBUtils.eq(block, block2));
  }


} // class TestSampleMethods