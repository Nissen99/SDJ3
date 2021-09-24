package client.view.viewModel;

import client.core.ModelFactory;
import client.model.IClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModelBank {

    private IClientModel clientModel = ModelFactory.getInstance().getModel();

    private StringProperty username = new SimpleStringProperty();
    private StringProperty balance = new SimpleStringProperty();
    private StringProperty withdrawAmount = new SimpleStringProperty();
    private StringProperty depositAmount = new SimpleStringProperty();
    private StringProperty receiverNumber = new SimpleStringProperty();


    public ViewModelBank(){
        username.setValue(clientModel.getLoggedIn().getUsername());
        checkBalance();
    }

    public void withdraw() {
        clientModel.withdraw(Integer.parseInt(withdrawAmount.get()));
        withdrawAmount.setValue("");
        checkBalance();
    }

    public void deposit(){
        clientModel.deposit(Integer.parseInt(depositAmount.get()));
        depositAmount.setValue("");
        checkBalance();
    }

    public void sendMoney() {
        clientModel.sendMoney(Integer.parseInt(receiverAmount.get()), Integer.parseInt(receiverNumber.get()));
        receiverAmount.setValue("");
        receiverNumber.setValue("");
        checkBalance();
    }

    public void checkBalance(){
        balance.setValue(String.valueOf(clientModel.checkBalance()));
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getBalance() {
        return balance.get();
    }

    public StringProperty balanceProperty() {
        return balance;
    }

    public String getWithdrawAmount() {
        return withdrawAmount.get();
    }

    public StringProperty withdrawAmountProperty() {
        return withdrawAmount;
    }

    public String getDepositAmount() {
        return depositAmount.get();
    }

    public StringProperty depositAmountProperty() {
        return depositAmount;
    }

    public String getReceiverNumber() {
        return receiverNumber.get();
    }

    public StringProperty receiverNumberProperty() {
        return receiverNumber;
    }

    public String getReceiverAmount() {
        return receiverAmount.get();
    }

    public StringProperty receiverAmountProperty() {
        return receiverAmount;
    }

    private StringProperty receiverAmount = new SimpleStringProperty();


}
