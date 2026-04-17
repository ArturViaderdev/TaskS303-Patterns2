package level1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderPatternTest {
    @Test
    public void MenuCreationToStringTest()
    {
        Menu executiveMenu = new MenuBuilder()
                .withEntrant("Amanida Mediterrània")
                .isVegan()
                .isGlutenFree()
                .withMainCourse("Filet de Vedella")
                .withSuplement("Guarnició extra")
                .withDessert("Mousse de xocolata")
                .withDrink("Vi Negre")
                .build();
        Assertions.assertEquals(executiveMenu.toString(),"Menú:\n" +
                " - Entrant: Amanida Mediterrània (Vegan) (Gluten Free)\n" +
                " - Plat Principal: Filet de Vedella, Suplement: Guarnició extra\n" +
                " - Postres: Mousse de xocolata\n" +
                " - Beguda: Vi Negre");
    }

    @Test
    public void EmptyFieldsTest()
    {
        Assertions.assertThrows(EmptyFieldException.class,() ->{
                Menu menu = new MenuBuilder()
                .withEntrant("")
                .withMainCourse("")
                .withDessert("")
                .build();
        });
    }
}
