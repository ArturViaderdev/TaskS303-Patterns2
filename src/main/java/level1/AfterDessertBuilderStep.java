package level1;

public class AfterDessertBuilderStep implements AfterDessertStep{
    private String dessert;
    private MenuState state;
    public AfterDessertBuilderStep(String dessert,MenuState state)
    {
        this.dessert = dessert;
        this.state = state;
    }

    @Override
    public BuildStep withDrink(String drink) {
        state.setDessert(dessert);
        return new FinalBuilderStep(drink,state);
    }

    @Override
    public Menu build() {
        state.setDessert(dessert);
        return new Menu(state);
    }
}
