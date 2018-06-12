package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        //TODO если город оплаты (совершения транзакции) не разрешен bad request exception +
        //TODO не хватило места internal server exception
        validate(transaction);


        return transaction;
    }

    public static void validate(Transaction transaction) throws BadRequestException, InternalServerException {
        if(transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed" + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for(Transaction tr: getTransactionsPerDay(transaction.getDateCreated())){
            sum += tr.getAmount();
            count++;
        }
        if(sum > utils.getLimitTransactionsPerDayAmount()){
            throw new LimitExceeded("Transaction limit per day amount exceeded" + transaction.getId() + ". Can't be saved");
        }
        if(count > utils. getLimitTransactionsPerDayCount()){
            throw new LimitExceeded("Transaction limit per day count exceed" + transaction.getId() + ". Can't be saved");
        }
        if(transaction.getCity().equals(utils.getCities())){

        }else
            throw new BadRequestException("Bad request of transaction" + transaction.getId() + ". Can't be saved");
        //TODO не хватило места internal server exception

        for (int i = 0; i <= transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
            }else
                throw new InternalServerException("There is no place to save" + transaction.getId() + ". Can't be saved");

        }
    }
     public static Transaction[] transactionList(){
         //Transaction[] transactions = new Transaction[10];
        //TODO
        return transactions;

    }
    public static Transaction[] transactionList(String city) throws BadRequestException {

        if (transactions != null) {
            int count = 0;

            for (int i = 0; i < transactions.length; i++) {
                if(city.equals(Transaction.getCity())){// если имя введенного города совпадает с транзакциями этого города.
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

    public static Transaction[] transactionList(int amount) throws BadRequestException {

        if (transactions != null) {
            int count = 0;

            for (int i = 0; i < transactions.length; i++) {
                if (amount == Transaction.getAmount()) {
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

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction){
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
