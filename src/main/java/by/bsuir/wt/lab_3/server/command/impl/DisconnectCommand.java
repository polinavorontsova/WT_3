package by.bsuir.wt.lab_3.server.command.impl;


import by.bsuir.wt.lab_3.server.command.Command;
import by.bsuir.wt.lab_3.server.model.AuthType;
import by.bsuir.wt.lab_3.server.service.ServiceFactory;

public class DisconnectCommand implements Command {
    @Override
    public String execute(Object caller, String request) {
        ServiceFactory.getInstance().getAuthService().setAuthType(caller, AuthType.UNAUTH);
        return "Bye!";
    }
}
