import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUnpacker {

    private boolean test(String test, String answer) {
        return answer.equals(Unpacker.unpackingString(test));
    }

    @Test
    void test1() {
        assertTrue(test("xyz", "xyz"));
    }

    @Test
    void test2() {
        assertTrue(test("3[xyz]4[xy]z","xyzxyzxyzxyxyxyxyz"));
    }

    @Test
    void test3() {
        assertTrue(test("2[3[x]y]","xxxyxxxy"));
    }

    @Test
    void test4() {
        assertTrue(test("2[a3[bcd3[a4[d]]xaz]a]abd","abcdaddddaddddaddddxazbcdaddddaddddaddddxazbcdaddddaddddaddddxazaabcdaddddaddddaddddxazbcdaddddaddddaddddxazbcdaddddaddddaddddxazaabd"));
    }

    @Test
    void test5() {
        String test = "33ab4";
        assertThrows(IllegalArgumentException.class, () -> {
            Unpacker.unpackingString(test);
        });
    }
    @Test
    void test6() {
        String test = "2[33[x]y]";
        assertThrows(IllegalArgumentException.class, () -> {
            Unpacker.unpackingString(test);
        });
    }


}
