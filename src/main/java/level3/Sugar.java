package level3;

import java.math.BigDecimal;

public class Sugar extends BubbleTeaDecorator{
    public Sugar(BubbleTea decoratedBubbleTea) {
        super(decoratedBubbleTea);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.3;
    }
}
