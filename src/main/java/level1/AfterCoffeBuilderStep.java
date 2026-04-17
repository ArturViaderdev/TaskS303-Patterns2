package level1;

public class AfterCoffeBuilderStep implements AfterCoffeStep{
    MenuState state;
    String coffee;
    public AfterCoffeBuilderStep(String coffee,MenuState state)
    {
        this.coffee = coffee;
        this.state = state;
    }

    @Override
    public BuildStep withDrink(String drink) {
        if(drink.isEmpty())
        {
            throw new EmptyFieldException();

        }
        else
        {
            state.setCoffe(coffee);
            return new FinalBuilderStep(drink,state);
        }
    }

    @Override
    public Menu build() {
        state.setCoffe(coffee);
        return new Menu(state);
    }
}
