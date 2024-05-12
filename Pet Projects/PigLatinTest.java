import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PigLatinTest {

    @Test
    public void translateTest() {
        assertThrows(IllegalArgumentException.class, () -> PigLatin.translate(""));
        assertThrows(IllegalArgumentException.class, () -> PigLatin.translate(null));
        assertThrows(IllegalArgumentException.class, () -> PigLatin.translate("     "));
    }

    @Test
    public void translateTestAnotherMethod() {
        assertEquals("aliforniacay", PigLatin.convert("california").toPigLatin());
    }

    @Test
    public void translateTest1() {
        assertEquals("aliforniacay", PigLatin.translate("california"));
    }

    @Test
    public void translateTest2() {
        assertEquals("aragraphspay", PigLatin.translate("paragraphs"));
    }

    @Test
    public void translateTest3() {
        assertEquals("oveglay", PigLatin.translate("glove"));
    }

    @Test
    public void translateTest4() {
        assertEquals("algorithmway", PigLatin.translate("algorithm"));
    }

    @Test
    public void translateTest5() {
        assertEquals("eightway", PigLatin.translate("eight"));
    }

    @Test
    public void translateTest6() {
        assertEquals("artzschway", PigLatin.translate("schwartz"));
    }

    @Test
    public void translateTest7() {
        assertEquals("rhythmay", PigLatin.translate("rhythm"));
    }
}