package level3;

import java.math.BigDecimal;

public class MatchaBase implements BubbleTea{
    @Override
    public String getDescription() {
        return "Matcha bubble tea";
    }

    @Override
    public double getCost() {
        return 3.2;
    }
}
