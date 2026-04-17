package level2;

public class StockMarketVariation {
    private boolean up;
    private double amount;

    public StockMarketVariation(double amount, boolean up)
    {
        this.amount = amount;
        this.up = up;
    }

    public boolean isUp() {
        return up;
    }

    public double getAmount() {
        return amount;
    }
}
