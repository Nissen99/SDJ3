package client.view.bankView;

import client.core.ViewModelFactory;
import client.view.IController;
import client.view.viewModel.ViewModelBank;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BankController implements IController {

    @FXML public Label usernameLabel;
    @FXML public Label balanceLabel;
    @FXML public TextField withdrawTextField;
    @FXML public TextField depositTextField;
    @FXML public TextField receiverTextField;
    @FXML public TextField amountTextField;
    private String path = "bankView/bank";
    private String viewTitle = "Bank";
    private ViewModelBank viewModel = ViewModelFactory.getInstance().getBank();



    @Override
    public void init() {
        usernameLabel.textProperty().bindBidirectional(viewModel.usernameProperty());
        balanceLabel.textProperty().bindBidirectional(viewModel.balanceProperty());
        withdrawTextField.textProperty().bindBidirectional(viewModel.withdrawAmountProperty());
        depositTextField.textProperty().bindBidirectional(viewModel.depositAmountProperty());
        receiverTextField.textProperty().bindBidirectional(viewModel.receiverNumberProperty());
        amountTextField.textProperty().bindBidirectional(viewModel.receiverAmountProperty());


    }

    public void withdraw(){
    viewModel.withdraw();
    }

    public void deposit(){
    viewModel.deposit();
    }

    public void updateBalance(){
    viewModel.checkBalance();
    }

    public void sendMoney(){
    viewModel.sendMoney();
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getTitle() {
        return viewTitle;
    }
}
