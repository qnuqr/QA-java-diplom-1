import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void enumIngredientTypeSauceTest() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void enumIngredientTypeFillingTest() {
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
