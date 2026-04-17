package level1;

public interface MainStep {
    MainStep isVegan();
    MainStep isGlutenFree();
    MainStep withSuplement(String supplement);
    AfterDessertStep withDessert(String dessert);
    AfterCoffeStep withCoffee(String coffe);
    BuildStep withDrink(String drink);
    Menu build();
}
