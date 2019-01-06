import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Assercje_KalkulatorTest {
    Assercje_Kalkulator calc = new Assercje_Kalkulator();

    @Test
    public void testCase1() {
        int result = calc.add(3, 5);
        assertTrue(result == 8);
    }

    @Test
    public void testCase2() {
        int result = calc.add(4, 4);
        assertFalse(7 == result);
    }

    @Test
    public void testCase3() {
        int result = calc.add(3, 9);
        assertEquals(result, (12));
    }

}