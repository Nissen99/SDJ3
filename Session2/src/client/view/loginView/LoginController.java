package client.view.loginView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.IController;
import client.view.bankView.BankController;
import client.view.registerView.RegisterController;
import client.view.viewModel.ViewModelLogin;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController implements IController {

    @FXML public TextField usernameTextfeild;
    @FXML public TextField passwordTextfeild;
    private String path = "loginView/login";
    private String viewTitle = "Login View";
    private ViewModelLogin viewModelLogin = ViewModelFactory.getInstance().getlogin();


    @Override
    public void init() {
    usernameTextfeild.textProperty().bindBidirectional(viewModelLogin.usernamePropertyProperty());
    passwordTextfeild.textProperty().bindBidirectional(viewModelLogin.passwordPropertyProperty());
    viewModelLogin.resetTextFields();
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getTitle() {
        return viewTitle;
    }

    public void login(){
        if (viewModelLogin.login()){
        ViewHandler.getInstance().changeView(new BankController());
        }

    }

    public void register(){
        ViewHandler.getInstance().changeView(new RegisterController());

    }


}
