package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();
    private Transaction[] transactions = new Transaction[10];


    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);

    }
    public Transaction[] transactionList() throws InternalServerException {
        return transactionDAO.transactionList();

    }
    public Transaction[] transactionList(String city) throws InternalServerException, BadRequestException {
        for (int i = 0; i < transactions.length; i++){
        return transactionDAO.transactionList(transactions[i].getCity());
        }
        throw new InternalServerException("Error");

    }
    public Transaction[] transactionList(int amount) throws BadRequestException, InternalServerException {
        for (int i = 0; i < transactions.length; i++){
        return transactionDAO.transactionList(transactions[i].getAmount());
        }
        throw new InternalServerException("Error");
    }
}
