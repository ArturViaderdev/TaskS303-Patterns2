package level1;

public class Main {
    public static void main(String[] args)
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
        System.out.println(executiveMenu.toString());
        Menu kidsMenu = new MenuBuilder()
                .withMainCourse("Macarrons amb tomàquet")
                .withDessert("Gelat de Vainilla")
                .withDrink("Suc de taronja")
                .build();
        System.out.println(kidsMenu.toString());
        Menu halfMenu = new MenuBuilder()
                .withMainCourse("Risotto de bolets")
                .isVegan()
                .withCoffee("Espresso")
                .withDrink("Aigua")
                .build();
        System.out.println(halfMenu.toString());
    }
}
