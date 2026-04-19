package level3;

public class Main {
    public static void main(String[] args)
    {
        BubbleTea tea = new LatteBase();
        tea = new Tapioca(tea);
        tea = new Sugar(tea);
        tea = new Flavor(tea, "Maduixa");
        tea = new Flavor(tea, "Mango");

        System.out.println(tea.getDescription());
        System.out.println(tea.getCost());

        BubbleTea tea2 = new MatchaBase();
        tea2 = new Sugar(tea2);
        tea2 = new Ice(tea2);
        tea2 = new Flavor(tea2,"Kiwi");

        System.out.println(tea2.getDescription());
        System.out.println(tea2.getCost());

        BubbleTea tea3 = new TeaBase();
        tea3 = new Tapioca(tea3);
        tea3 = new Flavor(tea3,"Poma");

        System.out.println(tea3.getDescription());
        System.out.println(tea3.getCost());

    }
}
