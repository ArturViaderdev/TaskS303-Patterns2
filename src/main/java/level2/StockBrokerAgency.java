package level2;

import java.util.Observable;
import java.util.Observer;

public class StockBrokerAgency implements Observer {
    private String name;

    public StockBrokerAgency(String name)
    {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object o) {
        StockMarketVariation variation = (StockMarketVariation) o;
        String output = name + " received notification: Stock market went ";
        if(variation.isUp())
        {
            output = output + "UP";
        }
        else
        {
            output = output + "DOWN";
        }
        output = output + " to " + Double.toString(variation.getAmount());
        System.out.println(output);
    }
}
