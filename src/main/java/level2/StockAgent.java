package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class StockAgent extends Observable {
    private double value;
    public StockAgent()
    {

    }

    public void addObserver(StockBrokerAgency observer)
    {
        super.addObserver(observer);
    }

    public void removeObserver(StockBrokerAgency observer)
    {
        super.deleteObserver(observer);
    }

    public void stockMarketUp(double amount)
    {
        value+=amount;
        setChanged();
        notifyObservers(new StockMarketVariation(amount,true));
    }

    public void stockMarketDown(double amount)
    {
        value-=amount;
        setChanged();
        notifyObservers(new StockMarketVariation(amount,false));
    }
}
