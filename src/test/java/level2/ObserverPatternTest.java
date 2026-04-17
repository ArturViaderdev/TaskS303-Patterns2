package level2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Observer;

public class ObserverPatternTest {
    @Test
    public void testStockAgentNotifications(){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(bos));

        StockAgent agent = new StockAgent();

        Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");
        Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");


        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);

        agent.stockMarketUp(150.75);

        Assertions.assertEquals("Zenith Investments received notification: Stock market went UP to 150.75\n"+
                "Alpha Brokers received notification: Stock market went UP to 150.75"
                ,bos.toString().trim());
    }

    @Test
    public void testStockAgentNotificationsDown(){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(bos));

        StockAgent agent = new StockAgent();

        Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");
        Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");


        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);

        agent.stockMarketDown(150.75);

        Assertions.assertEquals("Zenith Investments received notification: Stock market went DOWN to 150.75\n"+
                        "Alpha Brokers received notification: Stock market went DOWN to 150.75"
                ,bos.toString().trim());
    }

    @Test
    public void subscriptionTest()
    {
        StockAgent agent = new StockAgent();
        Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");
        Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");
        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        Assertions.assertEquals(2,agent.countObservers());
    }
}
