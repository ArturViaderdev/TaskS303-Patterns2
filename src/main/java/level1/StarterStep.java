package level1;

public interface StarterStep {
    MainStep withMainCourse(String mainCourse);
    StarterStep isVegan();
    StarterStep isGlutenFree();


}
