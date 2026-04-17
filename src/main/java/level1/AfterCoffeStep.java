package level1;

public interface AfterCoffeStep {
    BuildStep withDrink(String drink);
    Menu build();
}
