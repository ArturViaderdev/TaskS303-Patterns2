package level1;

public class Dish {
    private String food;
    private boolean vegan;
    private boolean glutenFree;

    public Dish(String food, boolean vegan, boolean glutenFree)
    {
        this.food = food;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
    }

    public String getFood() {
        return food;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }
}
