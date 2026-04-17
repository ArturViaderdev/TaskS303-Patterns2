package level1;

public interface AfterDessertStep {
    BuildStep withDrink(String drink);
    Menu build();
}
