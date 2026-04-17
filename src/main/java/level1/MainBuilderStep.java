package level1;

public class MainBuilderStep implements MainStep{
    private String mainCourse;
    private MenuState state;
    private boolean vegan;
    private boolean glutenFree;
    private String supplement;

    public MainBuilderStep(String mainCourse, MenuState state)
    {
        this.mainCourse = mainCourse;
        this.state = state;
        this.supplement = null;
    }

    @Override
    public MainStep isVegan() {
        vegan = true;
        return this;
    }

    @Override
    public MainStep isGlutenFree() {
        glutenFree = true;
        return this;
    }

    @Override
    public MainStep withSuplement(String supplement) {
        if(supplement.isEmpty())
        {
            throw new EmptyFieldException();
        }
        else
        {
            this.supplement = supplement;
            return this;
        }
    }

    private void updateState()
    {
        state.setMainCourse(new Dish(mainCourse,vegan,glutenFree),supplement);
    }

    @Override
    public AfterDessertStep withDessert(String dessert) {
        if(dessert.isEmpty())
        {
            throw new EmptyFieldException();
        }
        else
        {
            updateState();
            return new AfterDessertBuilderStep(dessert, state);
        }
    }

    @Override
    public AfterCoffeStep withCoffee(String coffe) {
        if(coffe.isEmpty())
        {
            throw new EmptyFieldException();
        }
        else
        {
            updateState();
            return new AfterCoffeBuilderStep(coffe,state);
        }
    }

    @Override
    public BuildStep withDrink(String drink) {
        if(drink.isEmpty())
        {
            throw new EmptyFieldException();
        }
        else
        {
            updateState();
            return new FinalBuilderStep(drink,state);
        }
    }

    @Override
    public Menu build() {
        updateState();
        return new Menu(state);
    }
}
