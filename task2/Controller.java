package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

public class Controller {
    private static TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);

    }
    public static Transaction[] transactionList(){
        return transactionDAO.transactionList();

    }
    public static Transaction[] transactionList(String city) throws BadRequestException {
        return transactionDAO.transactionList(Transaction.getCity());

    }
    public static Transaction[] transactionList(int amount) throws BadRequestException {
        return transactionDAO.transactionList(Transaction.getAmount());
    }
}
