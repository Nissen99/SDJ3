package shared;

import java.io.Serializable;

public class Person implements Serializable {
    private int balance;
    private String username;
    private int accountNumber;



    public Person(int balance, String username, int accountNumber) {
        this.balance = balance;
        this.username = username;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
