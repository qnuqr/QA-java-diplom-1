import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class BurgerTest {
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Создаем бургер с моками булки и ингредиентов
        burger = new Burger();
        // Настраиваем поведение моков
        when(bun.getName()).thenReturn("BunName");
        when(bun.getPrice()).thenReturn(50f);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("TestSauce");
        when(ingredient1.getPrice()).thenReturn(30f);

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("TestFilling");
        when(ingredient2.getPrice()).thenReturn(70f);
    }

    @Test
    public void testAddIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> expectedIngredients = Arrays.asList(ingredient1, ingredient2);
        Assert.assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1); // Удаляем второй ингредиент
        List<Ingredient> expectedIngredients = Arrays.asList(ingredient1);
        Assert.assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0); // Перемещаем второй ингредиент на первую позицию
        List<Ingredient> expectedIngredients = Arrays.asList(ingredient2, ingredient1);
        Assert.assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        // Ожидаемая цена: цена булки * 2 + сумма цен ингредиентов
        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce",80));
        String expectedReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

}
