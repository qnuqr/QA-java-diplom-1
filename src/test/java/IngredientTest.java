import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Филе Люминесцентного тетраодонтимформа", 988},
                {IngredientType.FILLING, "Соус традиционный галактический", 15},
                {IngredientType.SAUCE, "", 1.0f},
                {IngredientType.FILLING, "111", 5.0f},
                {null, null, 6.0f},
                {null, "", 7.0f},
                {IngredientType.FILLING, "#$%!", 9.0f},
                {IngredientType.SAUCE, "Cheap bun", Float.MIN_VALUE},
                {IngredientType.FILLING, "Expensive bun", Float.MAX_VALUE}
        });
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(),0);
    }

}
