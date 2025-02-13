package Day4;

import Day3.Path;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventCoinTest {

    AdventCoin adventCoin1 = new AdventCoin("abcdef");
    AdventCoin adventCoin2 = new AdventCoin("pqrstuv");

    public AdventCoinTest() throws NoSuchAlgorithmException {
    }

    @Test
    public void getAnswer() {

        assertEquals(609043, adventCoin1.getIncrementAnswer());
        assertEquals(1048970, adventCoin2.getIncrementAnswer());

    }

}
