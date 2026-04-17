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
    public String toString() {
        return "Menu{" +
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
                '}';
    }
}
