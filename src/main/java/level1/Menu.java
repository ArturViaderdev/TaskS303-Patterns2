package level1;

public class Menu {
    private String starter;
    private boolean starterIsVegan;
    private boolean starterIsGlutenFree;
    private String mainCourse;
    private boolean mainCourseIsVegan;
    private boolean mainCourseIsGlutenFree;
    private String supplement;
    private String dessert;
    private String coffe;
    private String drink;

    public Menu(MenuState state)
    {
        if(state.getStarter() == null)
        {
            starter = null;
            starterIsVegan = false;
            starterIsGlutenFree = false;
        }
        else {
            starter = state.getStarter().getFood();
            starterIsVegan = state.getStarter().isVegan();
            starterIsGlutenFree = state.getStarter().isGlutenFree();
        }
        mainCourse = state.getMainCourse().getFood();
        mainCourseIsVegan = state.getMainCourse().isVegan();
        mainCourseIsGlutenFree = state.getMainCourse().isGlutenFree();
        supplement = state.getMainCourseSupplement();
        dessert = state.getDessert();
        coffe = state.getCoffee();
        drink = state.getDrink();
    }

    @Override
    public String toString()
    {
        String menu = "Menú:\n";
        if (starter != null)
        {
            menu = menu + " - Entrant: " + starter;
            if (starterIsVegan) {
                menu = menu + " (Vegan)";
            }
            if (starterIsGlutenFree) {
                menu = menu + " (Gluten Free)";
            }
            menu = menu + "\n";
        }
        menu = menu + " - Plat Principal: " + mainCourse;
        if (mainCourseIsVegan) {
            menu = menu + " (Vegan";
        }
        if (mainCourseIsGlutenFree) {
            menu = menu + " (Gluten Free)";
        }
        if (supplement != null) {
            menu = menu + ", Suplement: " + supplement;
        }
        menu = menu + "\n";
        if (dessert != null) {
            menu = menu + " - Postres: " + dessert + "\n";
        }
        if (coffe != null) {
            menu = menu + " - Café: " + coffe + "\n";
        }
        if (drink != null) {
            menu = menu + " - Beguda: " + drink;
        }
        return menu;
        /*return "Menu{" +
                "starter='" + starter + '\'' +
                ", starterIsVegan=" + starterIsVegan +
                ", starterIsGlutenFree=" + starterIsGlutenFree +
                ", mainCourse='" + mainCourse + '\'' +
                ", mainCourseIsVegan=" + mainCourseIsVegan +
                ", mainCourseIsGlutenFree=" + mainCourseIsGlutenFree +
                ", supplement='" + supplement + '\'' +
                ", dessert='" + dessert + '\'' +
                ", coffe='" + coffe + '\'' +
                ", drink='" + drink + '\'' +
                '}';*/

    }
}
