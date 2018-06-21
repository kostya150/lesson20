package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);

    }
    public Transaction[] transactionList() throws InternalServerException {
        return transactionDAO.transactionList();

    }
    public Transaction[] transactionList(String city) throws BadRequestException {
        return transactionDAO.transactionList(Transaction.getCity());

    }
    public Transaction[] transactionList(int amount) throws BadRequestException {
        return transactionDAO.transactionList(Transaction.getAmount());
    }
}
