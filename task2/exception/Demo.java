package lesson20.task2.exception;


import lesson20.task2.Controller;
import lesson20.task2.Transaction;
import lesson20.task2.TransactionType;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Transaction[] transactions = new Transaction[10];
        Transaction tr1 = new Transaction(123, "Lvov", 3, "abc", TransactionType.INCOME,new Date());
        Transaction tr2 = new Transaction(213, "Odessa", 432, "bac", TransactionType.OUTCOME,new Date() );
        Controller controller = new Controller();
        System.out.println(controller.save(tr1));
        System.out.println(controller.transactionList());
        System.out.println(controller.transactionList("Lvov"));
        System.out.println(controller.transactionList(123));




    }
}
