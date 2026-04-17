package level1;

public class MenuBuilder implements StartStep {
    private String entrant;
    private String mainCourse;
    private String dessert;
    private String drink;
    private MenuState state;

    public MenuBuilder()
    {
        state = new MenuState();
    }

    @Override
    public StarterStep withEntrant(String entrant) {

        return new StarterBuilderStep(entrant,state);
    }

    @Override
    public MainStep withMainCourse(String mainCourse) {
        return new MainBuilderStep(mainCourse,state);
    }
}
