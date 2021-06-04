package Ciphers;

public class ShiftCipherPlus3 {
/* This uses the 26 characters of the alphabet and maps A-Z to the numbers 0-25.

   The +3 cipher encodes A-Z to the numbers 0-25 respectively then adds 3, i.e. 3-28. N.B. 26-28 => 0-2
   The +3 cipher decodes A-Z to the numbers 0-25 respectively by taking 3 away. N.B. -3 to -1 => 23-25
*/
  private char cipher[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; // cipher values A-Z => 0-25 based on Index position(0-25)
  private int  iCharacterAOffset = 65;   // A is char 65, so -65 aligns to cipher values 0-25
  private int  iPlus3Offset      = 3;    // cipher +3 offset values

  // Convert string to UPPERCASE and ONLY characters A-Z. All other characters are ignored
  private String convertToAtoZOnly(String strAtoZ) {
    if (strAtoZ != null) {
      char[]       ch       = strAtoZ.toUpperCase().toCharArray();
      StringBuffer sbResult = new StringBuffer("");

      for (int i = 0; i < ch.length; i++) {
        for (int j = 0; j < cipher.length; j++) {
          if (ch[i] == cipher[j]) {
            sbResult.append(""+ch[i]);
            break;
          }
        }
      }
      return sbResult.toString();
    } else {
      return ""; // Value was Null
    }
  }

  // The +3 cipher encodes A-Z to the numbers 0-25 respectively then adds 3, i.e. 3-28. N.B. 26-28 => 0-2
  public String encode(String strToEncode) {
    // UPPERCASE and clean the Input String ready for encoding using A-Z only
    String sNewStrToEncode = convertToAtoZOnly(strToEncode);
    char[] ch              = sNewStrToEncode.toCharArray(); // Create a char array of the string to be encode using toCharArray()
    int[]  cipherValue     = new int[ch.length];            // Build a companion array to store the encode number values
    int    iCastAscii      = 0;
    String sEncodedNumbers = "[ ";
    String sEncodedPlus3   = "[ ";

    // Step 1. Loop through the Character Array to encode using the Cipher values
    for (int i = 0; i < ch.length; i++) {
      // Parse the cipher array to convert individual Character A-Z to 0-25.
      for (int j = 0; j < cipher.length; j++) {
        // Check Character is in the cipher list
        if (ch[i] == cipher[j]) {
          // A-Z char found, convert to cipher value 0-25 based on the Index of the Array.
          cipherValue[i] = j;
          sEncodedNumbers = sEncodedNumbers + cipherValue[i] + " ";
          break; // Stop parsing the cipher array
        }
      }
    }
    sEncodedNumbers = sEncodedNumbers + "]";
    System.out.println("Encode Message to numbers: " + sNewStrToEncode + " => " + sEncodedNumbers);

    // Step 2. Loop through the Cipher Values Array to +3 to the values
    for (int i = 0; i < cipherValue.length; i++) {
      //System.out.print("Character = " + ch[i]  + " Cipher Value=" + cipherValue[i] + " +3 Value=" + cipherValue[i] + iPlus3Offset);
      int iPlus3Value = cipherValue[i] + iPlus3Offset;     // Add 3 to the character value 0-25 => 3-28
      if (iPlus3Value >= cipher.length) {                  // If character value >= 26 then map to 0-2, therefore 3-28 => 0-25
          iPlus3Value = iPlus3Value - cipher.length;       // Map chars 26-28 to 0-2 to allow characters X,Y and Z to work.
      }
      //System.out.println(" iPlus3Value = " + iPlus3Value);
      cipherValue[i] = iPlus3Value;                        // Store the new encoded value from 0-25
      ch[i] = cipher[iPlus3Value];                         // Convert character value +3, 0-25 to ASCII character value from cipher array

      sEncodedPlus3  = sEncodedPlus3 + cipherValue[i] + " ";
      //System.out.println(ch[i] + " Cipher Value=" + cipherValue[i]);
    }
    sEncodedPlus3 = sEncodedPlus3 + "]";
    System.out.println("Increment the value by 3:  " + sEncodedNumbers + " => " + sEncodedPlus3);

    // Step 3. Return the +3 encoded string
    String sEncodeStr = new String(ch);                    // Recreate a new String from the chracter array with new +3 encoded values
    System.out.println("Numbers back into letters: " + sEncodedPlus3 + " => " + sEncodeStr);
    return sEncodeStr;
  }

  public String decode(String strToDecode) {
    // UPPERCASE and clean the Input String ready for decoding using A-Z only
    String sNewStrToDecode = convertToAtoZOnly(strToDecode);
    char[] ch              = sNewStrToDecode.toCharArray(); // Create a char array of the string to be decode using toCharArray()
    int[]  cipherValue     = new int[ch.length];            // Build a companion array to store the decode number values
    String sDecodedNumbers = "[ ";
    String sDecodedMinus3  = "[ ";

    // Step 1. Loop through the Character Array to decode using the Cipher values
    for (int i = 0; i < ch.length; i++) {
      // Parse the cipher array to convert individual Character A-Z to 0-25.
      for (int j = 0; j < cipher.length; j++) {
        // Check Character is in the cipher list
        if (ch[i] == cipher[j]) {
          // A-Z char found, convert to cipher value 0-25 based on the Index of the Array.
          cipherValue[i] = j;
          sDecodedNumbers = sDecodedNumbers + cipherValue[i] + " ";
          break; // Stop parsing the cipher array
        }
      }
    }
    sDecodedNumbers = sDecodedNumbers + "]";
    System.out.println("Decode Message to numbers: " + sNewStrToDecode + " => " + sDecodedNumbers);

    // Step 2. Loop through the Cipher Values Array to -3 from the values
    for (int i = 0; i < cipherValue.length; i++) {
      //System.out.print("Character = " + ch[i]  + " Cipher Value=" + cipherValue[i] + " -3 Value=" + (cipherValue[i] - iPlus3Offset));
      int iMinus3Value = cipherValue[i] - iPlus3Offset;     // Minus 3 to the character value 0-25 => -3 to 22
      if (iMinus3Value < 0) {                               // If character value < 0 then remap -3 to -1, therefore -3 to -1 => 23-25
          iMinus3Value = iMinus3Value + cipher.length;       // Map chars -3 to -1 to 23-25 to allow characters X,Y and Z to work.
      }
      //System.out.println(" iMinus3Value = " + iMinus3Value);
      cipherValue[i] = iMinus3Value;                        // Store the new decoded value from 0-25
      ch[i] = cipher[iMinus3Value];                         // Convert character value +3, 0-25 to ASCII character value from cipher array

      sDecodedMinus3 = sDecodedMinus3 + cipherValue[i] + " ";
      //System.out.println(ch[i] + " ASCII Value=" + iCastAscii + " Cipher Value=" + cipherValue[i]);
    }
    sDecodedMinus3 = sDecodedMinus3 + "]";
    System.out.println("Decrement the value by 3:  " + sDecodedNumbers + " => " + sDecodedMinus3);

    // Step 3. Return the -3 decoded string
    String sDecodeStr = new String(ch);                    // Recreate a new String with the chracter array with new -3 decoded values
    System.out.println("Numbers back into letters: " + sDecodedMinus3 + " => " + sDecodeStr);
    return sDecodeStr;
  }

  public String encodeASCII(String strToEncode) {
    // UPPERCASE and clean the Input String ready for encoding using A-Z only
    String sNewStrToEncode = convertToAtoZOnly(strToEncode);
    char[] ch              = sNewStrToEncode.toCharArray(); // Create a char array of the string to be encode using toCharArray()
    int[]  cipherValue     = new int[ch.length];            // Build a companion array to store the encode number values
    int    iCastAscii      = 0;
    String sEncodedNumbers = "[ ";
    String sEncodedPlus3   = "[ ";

    // Step 1. Convert characters to Cipher values using the ASCII Character map to assit
    for (int i = 0; i < ch.length; i++) {
      cipherValue[i] = ch[i] - iCharacterAOffset;           // A is ASCII char 65, so -65 aligns to cipher values 0-25
      sEncodedNumbers = sEncodedNumbers + cipherValue[i] + " ";
    }
    sEncodedNumbers = sEncodedNumbers + "]";
    System.out.println("Message to numbers:           " + sNewStrToEncode + " => " + sEncodedNumbers);

    // Step 2. Loop through the Cipher Values Array to +3 to the values
    for (int i = 0; i < ch.length; i++) {
      int iPlus3Value = cipherValue[i] + iPlus3Offset;    // Add 3 to the character value 0-25 => 3-28
      if (iPlus3Value >= 26) {                            // If character value >= 26 then map to 0-2, therefore 3-28 => 0-25
          iPlus3Value = iPlus3Value - 26;                 // Map chars 26-28 to 0-2 to allow characters X,Y and Z to work.
      }
      int iAsciiChar  = iPlus3Value  + iCharacterAOffset; // Convert character value 0-25 to ASCII character value
      ch[i]           = (char) iAsciiChar;                // Convert ASCII value to char
      sEncodedPlus3   = sEncodedPlus3 + iPlus3Value  + " ";
      //System.out.println(ch[i] + " ASCII Value=" + iCastAscii + " Cipher Value=" + cipherValue[i]);
    }
    sEncodedPlus3 = sEncodedPlus3 + "]";
    System.out.println("Increment the value by 3: " + sEncodedNumbers + " => " + sEncodedPlus3);

    // Step 3. Return the +3 encoded string
    String encodeStr = new String(ch);                    // Recreate a new String from the chracter array with new +3 encoded values
    System.out.println("Numbers back into letters:    " + sEncodedPlus3 + " => " + encodeStr);
    return encodeStr ;
  }

  public String decodeASCII(String strToDecode) {
    // UPPERCASE and clean the Input String ready for decoding using A-Z only
    String sNewStrToDecode = convertToAtoZOnly(strToDecode);

    char[] ch              = sNewStrToDecode.toCharArray(); // Create a char array of the string to be decode using toCharArray()
    int[]  cipherValue     = new int[ch.length];            // Build a companion array to store the decode number values
    String sDecodedNumbers = "[ ";
    String sDecodedMinus3  = "[ ";

    // Step 1. Convert characters to Cipher values using the ASCII Character map to assit
    for (int i = 0; i < ch.length; i++) {
      cipherValue[i] = ch[i] - iCharacterAOffset;           // A is ASCII char 65, so -65 aligns to cipher values 0-25
      sDecodedNumbers = sDecodedNumbers + cipherValue[i] + " ";
    }
    sDecodedNumbers = sDecodedNumbers + "]";
    System.out.println("Message to numbers:           " + sNewStrToDecode + " => " + sDecodedNumbers);

    // Step 2. Loop through the character Array to -3 from the values
    for (int i = 0; i < ch.length; i++) {
      int iMinus3Value = cipherValue[i] - iPlus3Offset;    // Minus 3 from the character value 0-25 => -3 to 22
      if (iMinus3Value < 0) {                              // If character value < 0 then remap to -3 to -1, therefore -3 to 22 => 0-25
          iMinus3Value = iMinus3Value + 26;                // Map chars -3 to -1 to 23-25 to allow characters X,Y and Z to work.
      }
      int iAsciiChar   = iMinus3Value  + iCharacterAOffset; // Convert character value 0-25 to ASCII character value
      ch[i]            = (char) iAsciiChar;                 // Convert ASCII value to char
      sDecodedMinus3   = sDecodedMinus3 + iMinus3Value + " ";
      //System.out.println(ch[i] + " Cipher Value=" + cipherValue[i] + " ASCII Value=" + iAsciiChar);
    }
    sDecodedMinus3 = sDecodedMinus3 + "]";
    System.out.println("Decrement the value by 3:  " + sDecodedNumbers + " => " + sDecodedMinus3);

    // Step 3. Return the -3 decoded string
    String decodeStr = new String(ch); // Recreate a new String with the chracter array with new -3 decoded values
    System.out.println("Numbers back into letters:    " + sDecodedMinus3 + " => " + decodeStr);
    return decodeStr;
  }

  public static void main(String[] args) {
    long   startTime  = 0;
    long   endTime    = 0;
    long   totalTime1 = 0;
    long   totalTime2 = 0;
    String str       = "!HELlO1#4/abc WXYZ";

    ShiftCipherPlus3 cipher = new ShiftCipherPlus3();  // Create instance of cipher

    System.out.println("ONLY A-Z and a-z can work and everything is UPPERCASED for simplicity.");

    startTime = System.currentTimeMillis();
    System.out.println("Start with: " + str + "\n");
    str = cipher.encode(str);
    System.out.println("");
    System.out.println("Encoded to: " + str + "\n");
    str = cipher.decode(str);
    System.out.println("");
    System.out.println("Decoded to: " + str);
    endTime   = System.currentTimeMillis();
    totalTime1 = endTime - startTime;
    System.out.println("Array Cipher Run time: " + totalTime1 + "ms" + "\n");

    startTime = System.currentTimeMillis();
    System.out.println("Start with: " + str + "\n");
    str = cipher.encodeASCII(str);
    System.out.println("");
    System.out.println("Encoded to: " + str + "\n");
    str = cipher.decodeASCII(str);
    System.out.println("");
    System.out.println("Decoded to: " + str);
    endTime    = System.currentTimeMillis();
    totalTime2 = endTime - startTime;
    System.out.println("ASCII Cipher Run time: " + totalTime2 + "ms");
  }
}
