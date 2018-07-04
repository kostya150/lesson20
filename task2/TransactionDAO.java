package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {

        if (validate(transaction)) {
            for (int i = 0; i <= transactions.length; i++) {
                if (transactions[i] == null) {
                    transactions[i] = transaction;
                    return transactions[i];
                }
            }

        }
        throw new LimitExceeded("There is no place to save" + transaction.getId() + ". Can't be saved");
    }

    public boolean validate(Transaction transaction) throws BadRequestException, InternalServerException {
        if(transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed" + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for(Transaction tr: getTransactionsPerDay(transaction.getDateCreated())){
            sum += tr.getAmount();
            count++;
        }
        if(sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount() && transaction.getAmount() > utils.getLimitSimpleTransactionAmount()){//TODO

            throw new LimitExceeded("Transaction limit per day amount exceeded" + transaction.getId() + ". Can't be saved");
        }
        if(count + 1 > utils. getLimitTransactionsPerDayCount()){//TODO
            throw new LimitExceeded("Transaction limit per day count exceed" + transaction.getId() + ". Can't be saved");
        }
        checkTransactionCity(transaction);
        return true;
    }

    private void checkTransactionCity(Transaction transaction) throws BadRequestException{
        for(String c: utils.getCities()){
            if(c.equals(transaction.getCity())){
                return;
            }
            throw new BadRequestException("Bad request of transaction" + transaction.getId() + ". Can't be saved");
        }

    }
     public Transaction[] transactionList() throws InternalServerException {

         for (int i = 0; i <= transactions.length; i++) {
             if (transactions[i] != null)
                 return transactions;
         }
         throw new InternalServerException("There are no transactions");
    }
    public Transaction[] transactionList(String city) throws BadRequestException {

        if (transactions != null) {
            int count = 0;

            for (int i = 0; i < transactions.length; i++) {
                if(transactions[i] != null){
                if(city.equals(transactions[i].getCity())){// если имя введенного города совпадает с транзакциями этого города.
                    count++;
                }
                }
            }
            Transaction[] transactions = new Transaction[count];

            count = 0;
            for (int i = 0; i < transactions.length; i++) {
                if (transactions[i] != null) {
                    transactions[count] = transactions[i];
                    count++;
                }
            }
        }else
            throw new  BadRequestException("There are no transactions");
        return transactions;
        }

    public Transaction[] transactionList(int amount) throws BadRequestException {

        if (transactions != null) {
            int count = 0;

            for (int i = 0; i < transactions.length; i++) {
                if (amount == transactions[i].getAmount()) {
                    count++;
                }
            }
            Transaction[] transactions = new Transaction[count];

            count = 0;
            for (int i = 0; i < transactions.length; i++) {
                if (transactions[i] != null) {
                    transactions[count] = transactions[i];
                    count++;
                }
            }
        }else
            throw new  BadRequestException("There are no transactions");
        return transactions;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int count = 0;
        for(Transaction transaction: transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(trMonth == month && trDay == day)
                    count ++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for(Transaction transaction: transactions){
            if(transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(trMonth == month && trDay == day){
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }


}
