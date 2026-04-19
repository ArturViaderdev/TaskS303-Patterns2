package level3;

import java.math.BigDecimal;

public class TeaBase implements BubbleTea{
    @Override
    public String getDescription() {
        return "Tea bubble tea";
    }

    @Override
    public double getCost() {
        return 3;
    }
}
