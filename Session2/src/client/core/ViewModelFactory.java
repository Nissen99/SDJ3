package client.core;

import client.view.viewModel.ViewModelBank;
import client.view.viewModel.ViewModelLogin;
import client.view.viewModel.ViewModelRegister;

public class ViewModelFactory {

    private static ViewModelFactory viewModelFactory;

    private ViewModelLogin login= new ViewModelLogin();
    private ViewModelBank bank;
    private ViewModelRegister register = new ViewModelRegister();


    private ViewModelFactory() {}

    public static ViewModelFactory getInstance()
    {
        if (viewModelFactory == null)
        {
            viewModelFactory = new ViewModelFactory();
        }
        return viewModelFactory;
    }

    public ViewModelLogin getlogin()
    {

        return login;
    }

    public ViewModelBank getBank(){
        if (bank == null){
            bank = new ViewModelBank();
        }
        return bank;
    }

    public ViewModelRegister getRegister(){
        return register;
    }
}
