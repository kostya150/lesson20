package lesson20.task2;

public class Utils {
    public int LimitTransactionsPerDayCount = 10;
    public int LimitTransactionsPerDayAmount = 100;
    public int LimitSimpleTransactionAmount = 40;
    public String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return LimitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return LimitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return LimitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
