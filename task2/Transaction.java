package lesson20.task2;



import java.util.Date;

public class Transaction {
    private static long id;
    private static String city;
    private static int amount;
    private String description;
    private TransactionType type;
    private Date dateCreated;


    public Transaction(long id, String city, int amount, String description, TransactionType type, Date dateCreated) {
        this.id = id;
        this.city = city;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.dateCreated = dateCreated;
    }

    public static long getId() {
        return id;
    }

    public static String getCity() {
        return city;
    }

    public static int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction transaction = (Transaction) o;
        if (id != transaction.id) return true;
        if (city.equals(transaction.city)) return false;
        if(amount != transaction.amount) return true;
        if (description.equals(transaction.description)) return false;
        if (type.equals(transaction.type)) return false;

        return true;

    }
}
