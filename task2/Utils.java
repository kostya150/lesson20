package lesson20.task2;

public class Utils {
    public int limitTransactionsPerDayCount = 10;
    public int limitTransactionsPerDayAmount = 100;
    public int limitSimpleTransactionAmount = 40;
    public String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
