import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988.025f},
                {"Краторная булка N-200i", 1255},
                {"Plain Bun", 1.0f},
                {"Sweet Bun", 2.5f},
                {"123", 5.0f},
                {null, 6.0f},
                {"", 7.0f},
                {"Bun with cheesе, chicken, bacon, beef and cucumber", 8.0f},
                {"Special Bun with symbols #$%", 9.0f},
                {"Cheap bun", Float.MIN_VALUE},
                {"Expensive bun", Float.MAX_VALUE}
        };
    }

    @Test
    public void getNameBun(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBun(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
