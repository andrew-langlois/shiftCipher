import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitShiftCipherTests {

  @Test
  public void testEncodeAndDecode() {
    ShiftCipherPlus3 shiftCipher = new ShiftCipherPlus3();
    String sStartingValue = "HELLO";
    String sCurrentValue  = new String(sStartingValue);

    long startTime = System.currentTimeMillis();
    System.out.println("Start with: " + sCurrentValue + "\n");
    sCurrentValue = shiftCipher.encode(sCurrentValue);
    System.out.println("");
    System.out.println("Encoded to: " + sCurrentValue + "\n");
    sCurrentValue = shiftCipher.decode(sCurrentValue);
    System.out.println("");
    System.out.println("Decoded to: " + sCurrentValue);
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Array Cipher Run time: " + totalTime + "ms" + "\n");

    assertEquals(sStartingValue, sCurrentValue);
  }

  @Test
  public void testEncodeASCIIAndDecodeASCII() {
    ShiftCipherPlus3 shiftCipher = new ShiftCipherPlus3();
    String sStartingValue = "HELLO";
    String sCurrentValue  = new String(sStartingValue);

    long startTime = System.currentTimeMillis();
    System.out.println("Start with: " + sCurrentValue + "\n");
    sCurrentValue = shiftCipher.encodeASCII(sCurrentValue);
    System.out.println("");
    System.out.println("Encoded to: " + sCurrentValue + "\n");
    sCurrentValue = shiftCipher.decodeASCII(sCurrentValue);
    System.out.println("");
    System.out.println("Decoded to: " + sCurrentValue);
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Array Cipher Run time: " + totalTime + "ms" + "\n");

    assertEquals(sStartingValue, sCurrentValue);
  }
}
