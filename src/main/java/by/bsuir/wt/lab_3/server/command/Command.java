package by.bsuir.wt.lab_3.server.command;


import by.bsuir.wt.lab_3.server.command.exception.CommandException;

public interface Command {
    String execute(Object caller, String request) throws CommandException;
}
