package lesson20.task2.exception;


import lesson20.task2.Controller;
import lesson20.task2.Transaction;

public class Demo {
    public static void main(String[] args) throws BadRequestException {
        Transaction[] transactions = new Transaction[10];
       // System.out.println(Controller.save());
        System.out.println(Controller.transactionList());
        System.out.println(Controller.transactionList(Transaction.getCity()));
        System.out.println(Controller.transactionList(Transaction.getAmount()));


    }
}
