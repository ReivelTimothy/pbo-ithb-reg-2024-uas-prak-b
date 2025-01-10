package controller;

import models.classes.Customer;

public class RegisterControl {
    private static RegisterControl registerControl;
    public RegisterControl(){

    }
    public RegisterControl getRegisterControl(){
        if (registerControl == null) {
            registerControl = new RegisterControl();
        }
        return registerControl;
    }

    public void register(Customer customer){
        
    }

}
