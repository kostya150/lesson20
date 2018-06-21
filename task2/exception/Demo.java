package lesson20.task2.exception;


import lesson20.task2.Controller;
import lesson20.task2.Transaction;
import lesson20.task2.TransactionType;

public class Demo {
    public static void main(String[] args) throws BadRequestException, InternalServerException {
        Transaction[] transactions = new Transaction[10];
        Transaction tr1 = new Transaction(123, "Kiev", 321, "abc", TransactionType.INCOME, );
        Transaction tr2 = new Transaction(213, "Odessa", 432, "bac", TransactionType.OUTCOME, );
        Controller controller = new Controller();
        System.out.println(controller.save(tr1));
        System.out.println(controller.transactionList());
        System.out.println(controller.transactionList("Kiev"));
        System.out.println(controller.transactionList(123));




    }
}
