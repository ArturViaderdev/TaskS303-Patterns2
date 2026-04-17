package level1;

public class MenuState {
    Dish starter;
    Dish mainCourse;
    String mainCourseSupplement;
    String dessert;
    String coffee;
    String drink;
    public MenuState()
    {
        starter = null;
        mainCourse = null;
        mainCourseSupplement = null;
        dessert = null;
        coffee = null;
        drink = null;
    }

   public void setStarter(Dish starter)
   {
       this.starter = starter;
   }

   public void setMainCourse(Dish mainCourse,String supplement)
   {
       this.mainCourse = mainCourse;
       this.mainCourseSupplement = supplement;
   }

   public void setDessert(String dessert)
   {
       this.dessert = dessert;
   }

   public void setCoffe(String coffe)
   {
       this.coffee = coffe;
   }

   public void setDrink(String drink)
   {
       this.drink = drink;
   }

    public Dish getStarter() {
        return starter;
    }

    public Dish getMainCourse() {
        return mainCourse;
    }

    public String getMainCourseSupplement() {
        return mainCourseSupplement;
    }

    public String getDessert() {
        return dessert;
    }

    public String getCoffee() {
        return coffee;
    }

    public String getDrink() {
        return drink;
    }
}
