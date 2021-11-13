package client.view.registerView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.IController;
import client.view.loginView.LoginController;
import client.view.viewModel.ViewModelRegister;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterController implements IController {


    @FXML public TextField usernameField;
    @FXML public TextField passwordField;
    private String path = "registerView/register";
    private String viewTitle = "Register";
    private ViewModelRegister viewModel = ViewModelFactory.getInstance().getRegister();



    @Override
    public void init() {
        usernameField.textProperty().bindBidirectional(viewModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(viewModel.passwordProperty());
        viewModel.resetTextFields();
    }

    public void registerUser(){
    viewModel.registerUser();
    ViewHandler.getInstance().changeView(new LoginController());
    }

    public void backToLogin(){
        ViewHandler.getInstance().changeView(new LoginController());
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
