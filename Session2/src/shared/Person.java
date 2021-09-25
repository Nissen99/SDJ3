package shared;

import java.io.Serializable;

public class Person implements Serializable {



    private  String password;
    private int balance;
    private String username;
    private int accountNumber;



    public Person(int balance, String username, String password, int accountNumber) {
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
