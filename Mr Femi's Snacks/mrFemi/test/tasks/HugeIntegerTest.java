package mrFemi.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HugeIntegerTest {

    @Test
    public void testHugeInteger() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("56748");
        String expected = "56748";
        assertEquals(expected, hugeInteger.toString());
    }

    @Test
    public void testHugeInteger2() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("-2");
        String expected = "-2";
        assertEquals(expected, hugeInteger.toString());
    }

    @Test
    public void testHugeInteger_negativeNumber() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("-56748");
        String expected = "-56748";
        System.out.println(hugeInteger);
        assertEquals(expected, hugeInteger.toString());
    }


    @Test
    public void parsesNullOrBlankString_throwsIllegalArgumentException() {
        HugeInteger hugeInteger = new HugeInteger();
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse(""));
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse("09"));
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse("  "));
        assertThrows(IllegalArgumentException.class, () -> hugeInteger.parse(null));

    }


    @Test
    public void addTwoHugeIntegerObjects() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("7234");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("4321");

        String expected = "11555";
        String actual = hugeInteger.add(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addTwoHugeIntegerObjects2() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("7234");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("432");

        String expected = "7666";
        String actual = hugeInteger.add(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addTwoHugeIntegerObjects3() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("637");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("5432");

        String expected = "6069";
        String actual = hugeInteger.add(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addTwoHugeIntegerObjects4() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("-1053");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("952");

        String expected = "-101";
        String actual = hugeInteger.add(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addTwoHugeIntegerObjects5() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("1053");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("-952");

        String expected = "101";
        String actual = hugeInteger.add(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("9674");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");

        String expected = "6341";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects2() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("943");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("937");

        String expected = "6";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects3() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("8543");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("9539");

        String expected = "-996";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects4() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("-1053");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("952");

        String expected = "-2005";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects5() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("1053");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("-952");

        String expected = "2005";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects6() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("871");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("65");

        String expected = "806";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTwoHugeIntegerObjects7() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("65");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("871");

        String expected = "-806";
        String actual = hugeInteger.subtract(hugeInteger2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void compareTwoHugeIntegerObjects_isEqual() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");

        assertTrue(hugeInteger.isEqualTo(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isNotEqual() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("9674");
        assertTrue(hugeInteger.isNotEqualTo(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isGreaterThan() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3330");
        assertTrue(hugeInteger.isGreaterThan(hugeInteger2));
    }
    @Test
    public void compareTwoHugeIntegerObjects_isLessThan() {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("4567");
        assertTrue(hugeInteger.isLessThan(hugeInteger2));
    }
    @Test
    public void compareTwoHugeIntegerObjects_isGreaterThanOrEqualsTo()  {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3333");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");
        assertTrue(hugeInteger.isGreaterThanOrEqualTo(hugeInteger2));
    }

    @Test
    public void compareTwoHugeIntegerObjects_isGreaterThanOrEqualsTo2()  {
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.parse("3334");
        HugeInteger hugeInteger2 = new HugeInteger();
        hugeInteger2.parse("3333");
        assertTrue(hugeInteger.isGreaterThanOrEqualTo(hugeInteger2));
    }
}