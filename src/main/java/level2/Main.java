package level2;

public class Main {
    public static void main(String[] args)
    {
        StockAgent agent = new StockAgent();

        StockBrokerAgency alphaBrokers = new StockBrokerAgency("Alpha Brokers");
        StockBrokerAgency zenithInvestments = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);

        agent.stockMarketUp(150.75);
        // Expected console output:
        // Alpha Brokers received notification: Stock market went UP to 150.75
        // Zenith Investments received notification: Stock market went UP to 150.75

        agent.stockMarketDown(145.50);
        // Expected console output:
        // Alpha Brokers received notification: Stock market went DOWN to 145.50
        // Zenith Investments received notification: Stock market went DOWN to 145.50
    }
}
