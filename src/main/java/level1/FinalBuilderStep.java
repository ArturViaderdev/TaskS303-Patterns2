package level1;

public class FinalBuilderStep implements BuildStep{
    private MenuState state;
    private String drink;
    @Override
    public Menu build() {
        state.setDrink(drink);
        return new Menu(state);
    }

    public FinalBuilderStep(String drink, MenuState state)
    {
        this.drink = drink;
        this.state = state;
    }
}
