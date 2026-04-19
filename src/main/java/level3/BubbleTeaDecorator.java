package level3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BubbleTeaDecorator implements BubbleTea {
    protected BubbleTea decoratedBubbleTea;
    public BubbleTeaDecorator(BubbleTea decoratedBubbleTea)
    {
        this.decoratedBubbleTea = decoratedBubbleTea;
    }

    @Override
    public String getDescription() {
        return decoratedBubbleTea.getDescription();
    }

    @Override
    public double getCost() {
        return new BigDecimal(Double.toString(decoratedBubbleTea.getCost())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
