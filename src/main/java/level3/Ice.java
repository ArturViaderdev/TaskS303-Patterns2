package level3;

import java.math.BigDecimal;

public class Ice extends BubbleTeaDecorator{
    public Ice(BubbleTea decoratedBubbleTea) {
        super(decoratedBubbleTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Ice";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.25;
    }
}
