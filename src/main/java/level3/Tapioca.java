package level3;

import java.math.BigDecimal;

public class Tapioca extends BubbleTeaDecorator{
    public Tapioca(BubbleTea decoratedBubbleTea) {
        super(decoratedBubbleTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Tapioca";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}
