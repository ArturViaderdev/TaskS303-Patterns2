package level3;

import java.math.BigDecimal;

public class LatteBase implements BubbleTea{
    @Override
    public String getDescription() {
        return "Latte bubble tea";
    }

    @Override
    public double getCost() {
        return 3.5;
    }
}
