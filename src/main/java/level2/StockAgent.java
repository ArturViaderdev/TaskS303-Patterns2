package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class StockAgent extends Observable {
    private double value;
    private List<Observer> observers;
    public StockAgent()
    {
        observers = new ArrayList<>();
    }

    public void addObserver(StockBrokerAgency observer)
    {
        observers.add(observer);
    }

    public void removeObserver(StockBrokerAgency observer)
    {
        observers.remove(observer);
    }

    public void stockMarketUp(double amount)
    {
        value+=amount;
        for(Observer observer:observers)
        {
            observer.update(this,new StockMarketVariation(amount,true));
        }
    }

    public void stockMarketDown(double amount)
    {
        value-=amount;
        for(Observer observer:observers)
        {
            observer.update(this,new StockMarketVariation(amount,false));
        }
    }
}
