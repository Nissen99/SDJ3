package client.view.viewModel;

import client.core.ModelFactory;
import client.model.IClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModelRegister {


    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private IClientModel clientModel = ModelFactory.getInstance().getModel();

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void registerUser(){
        clientModel.registeruser(getUsername(), getPassword());
    }

    public void resetTextFields() {
        username.setValue("");
        password.setValue("");
    }

}
