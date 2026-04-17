package level1;

public class MenuBuilder implements StartStep {
    private MenuState state;

    public MenuBuilder()
    {
        state = new MenuState();
    }

    @Override
    public StarterStep withEntrant(String starter) {
        if(starter.isEmpty())
        {
            throw new EmptyFieldException();
        }
        else
        {
            return new StarterBuilderStep(starter,state);
        }
    }

    @Override
    public MainStep withMainCourse(String mainCourse) {
        if(mainCourse.isEmpty())
        {
            throw new EmptyFieldException();
        }
        else
        {
            return new MainBuilderStep(mainCourse,state);
        }
    }
}
