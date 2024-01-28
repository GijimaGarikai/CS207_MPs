
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

public class VigenereCipher {
    public static void main (String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Invalid number of parameters");
            System.exit(2);
        }

        String instruction = args[0].toLowerCase();
        String inputString = args[1];
        String key = args[2];

        java.io.PrintWriter pen;
        pen = new java.io.PrintWriter(System.out, true);

        if (!(instruction.equals("encode") || instruction.equals("decode"))) {
            System.err.println("Invalid instruction. Use 'encode' or 'decode'.");
            System.exit(1);
        }
        if (inputString.equals("") || (key.equals(""))) {
            // handling empty input
            pen.println(inputString);
        } 
        else if (instruction.equals("encode")){
            pen.println(encodeVig(inputString, key, 1));
            
        }
        else {
            pen.println(decodeVig(inputString, key));
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

    /* char encodeVig(string word, String key, int encrypt)
     * input: string word, String key, int encrypt
     * output: String
     * usage: shifts 'input' based on the corresponding character in "key"
     * if encrypt is 1 then it's a positive shift for encryption, otherwise its 
     * a negative shift for decryption
      */
    public static String encodeVig(String word, String key, int encrypt) {
        char[] result;
        char letter;
        int shift;
        int a = (int) 'a';
        int max = key.length();

        result = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            shift = (int) key.charAt(i%max) - a;
            if (encrypt == 1){
                result[i] = code(letter, shift);
            }
            else {
                result[i] = code(letter, -shift);
            }
        }
        return new String(result);
    }
    /* char decodeVig(string word, String key)
     * input: string word, String key
     * output: String
     * usage: reverses the effect of encodeVig
      */
    public static String decodeVig(String word, String key) {
        
        return encodeVig(word, key, 0);
    }
}

