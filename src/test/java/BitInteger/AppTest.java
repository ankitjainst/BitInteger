/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package BitInteger;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        int val = 19;
        BitInteger b1 = new BitInteger();
        b1.valueToBitInteger(val);

        BitInteger b2 = new BitInteger();
        b2.byteArrToBitInteger(b1.toByteArray(), 0);
        assertEquals(b2.getValue(), val);
    }
}
