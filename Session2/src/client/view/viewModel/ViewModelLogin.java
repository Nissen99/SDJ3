package client.view.viewModel;

import client.core.ModelFactory;
import client.model.IClientModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModelLogin {


    private StringProperty usernameProperty = new SimpleStringProperty();
    private StringProperty passwordProperty = new SimpleStringProperty();
    private IClientModel clientModel = ModelFactory.getInstance().getModel();

    public String getUsernameProperty() {
        return usernameProperty.get();
    }

    public StringProperty usernamePropertyProperty() {
        return usernameProperty;
    }

    public String getPasswordProperty() {
        return passwordProperty.get();
    }

    public StringProperty passwordPropertyProperty() {
        return passwordProperty;
    }

    public boolean login(){

        try {
            clientModel.login(getUsernameProperty(), getPasswordProperty());
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void resetTextFields() {
        usernameProperty.setValue("");
        passwordProperty.setValue("");
    }
}
