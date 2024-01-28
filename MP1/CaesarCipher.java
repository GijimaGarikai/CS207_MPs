
  /***********************************************************************
     * Name(s) Garikai Gijima           *
     * Assignment name (Mini project 1)                                    *
     *                                                                     *
     * Due Date 1/29                                                       *
     ***********************************************************************/

    /* *********************************************************************
     * Academic honesty certification:                                     *
     *   Written/online sources used: 
     * https://www.devdungeon.com/content/standard-input-output-and-error-java#writing_to_stderr.         *
     *   Help obtained: None                                          *
     *   My/our typed name(s) below confirms that the above list of sources *
     *   is complete AND that I/we have not talked to anyone else          *
     *   (e.g., CSC 207 students, tutors) about the solutions              *
     *                                                                     *
     *   Signature: Garikai Gijima      *
     ***********************************************************************/


public class CaesarCipher {
    public static void main (String[] args) throws Exception {
        if (args.length != 2) { // error checking to ensure appropriate input
            System.err.println("Invalid number of parameters");
            System.exit(2);
        }

        String instruction = args[0].toLowerCase();
        String inputString = args[1];

        if (!(instruction.equals("encode") || instruction.equals("decode"))) {
            System.err.println("Invalid instruction. Use 'encode' or 'decode'.");
            System.exit(1);
        }
        

        java.io.PrintWriter pen;
        pen = new java.io.PrintWriter(System.out, true);

        if (instruction.equals("encode")){
            // prints out all 26 encrypted versions of the input
            for (int i = 0; i < 26; i++){
                pen.println(encodeCaesar(inputString, i));
            }
        }
        else {
            for (int i = 0; i < 26; i++){
                // prints out all 26 decrypted versions of the input
                pen.println(decodeCaesar(inputString, i));
            }
        }
    } 

    /* char code(char input, int shift)
     * input: char input, int shift
     * output: char
     * usage: shifts 'input' based on the given 'shift' parameter
      */
    public static char code(char input, int shift) {
        int ascii;
        int a = (int) 'a';
        ascii = (((int) input + shift - a)+26) % 26;
        return (char) (ascii + a);
    }
    /* String encodeCaesar(String word, int val)
     * input: String word, int val
     * output: String
     * usage: shifts each character in 'word' by 'val' and returns new string
      */
    public static String encodeCaesar(String word, int val) {
        char[] result;
        char letter;
        int ascii;
        int a = (int) 'a';

        result = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            result[i] = code(letter, val);
        }
        return new String(result);
    }
    /* String decodeCaesar(String ciphertext, int val)
     * input: String ciphertext, int val
     * output: String
     * usage: reverses the operations of 'encodeCaesar'
      */
    public static String decodeCaesar(String ciphertext, int val) {
        
        return encodeCaesar(ciphertext, -val);
    }
} // class NameOfClass
