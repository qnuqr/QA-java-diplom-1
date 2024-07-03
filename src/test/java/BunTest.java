import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class BunTest {


    private Database database;
    private Bun bun;

    @Before
    public void setUp() {
        database = new Database();
        bun = database.availableBuns().get(0);
    }


    @Test
    public void getNameTest() {
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(100, bun.getPrice(), 0);
    }

}
