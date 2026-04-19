package level3;

public class Flavor extends BubbleTeaDecorator{
    private String flavor;
    public Flavor(BubbleTea decoratedBubbleTea, String flavor) {
        this.flavor = flavor;
        super(decoratedBubbleTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Flavor:" + flavor;
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.60;
    }
}
