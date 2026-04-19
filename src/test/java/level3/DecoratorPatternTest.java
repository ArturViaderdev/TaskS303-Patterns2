package level3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {
    @Test
    public void TeaBaseTest()
    {
        BubbleTea tea3 = new TeaBase();
        tea3 = new Tapioca(tea3);
        tea3 = new Flavor(tea3,"Poma");
        Assertions.assertEquals(tea3.getDescription(),"Tea bubble tea + Tapioca + Flavor:Poma");
        Assertions.assertEquals(tea3.getCost(),4.1);
    }

    @Test
    public void MatchaBaseTest()
    {
        BubbleTea tea2 = new MatchaBase();
        tea2 = new Sugar(tea2);
        tea2 = new Ice(tea2);
        tea2 = new Flavor(tea2,"Kiwi");
        Assertions.assertEquals(tea2.getDescription(),"Matcha bubble tea + Sugar + Ice + Flavor:Kiwi");
        Assertions.assertEquals(tea2.getCost(),4.35);
    }

    @Test
    public void LatteBaseTest()
    {
        BubbleTea tea = new LatteBase(); // base Latte
        tea = new Tapioca(tea);
        tea = new Sugar(tea);
        tea = new Flavor(tea, "Maduixa");
        tea = new Flavor(tea, "Mango");

        Assertions.assertEquals(tea.getDescription(),"Latte bubble tea + Tapioca + Sugar + Flavor:Maduixa + Flavor:Mango");
        Assertions.assertEquals(tea.getCost(),5.5);
    }
}
