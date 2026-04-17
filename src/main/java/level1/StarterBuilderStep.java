package level1;

public class StarterBuilderStep implements StarterStep {
    private String starter;
    private boolean vegan;
    private boolean glutenFree;
    private MenuState state;

    public StarterBuilderStep(String starter, MenuState state)
    {
        this.starter = starter;
        vegan = false;
        glutenFree = false;
        this.state = state;
    }

    @Override
    public MainStep withMainCourse(String mainCourse) {
        state.setStarter(new Dish(starter,vegan,glutenFree));
        return new MainBuilderStep(mainCourse,state);
    }

    @Override
    public StarterStep isVegan() {
        vegan = true;
        return this;
    }

    @Override
    public StarterStep isGlutenFree() {
        glutenFree = true;
        return this;
    }
}
