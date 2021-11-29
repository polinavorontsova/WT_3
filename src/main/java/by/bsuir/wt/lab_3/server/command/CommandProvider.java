package by.bsuir.wt.lab_3.server.command;

import by.bsuir.wt.lab_3.server.command.exception.CommandException;
import by.bsuir.wt.lab_3.server.command.impl.AuthCommand;
import by.bsuir.wt.lab_3.server.command.impl.CreateCommand;
import by.bsuir.wt.lab_3.server.command.impl.DisconnectCommand;
import by.bsuir.wt.lab_3.server.command.impl.EditCommand;
import by.bsuir.wt.lab_3.server.command.impl.ViewCommand;

public class CommandProvider {
    private static final CommandProvider INSTANCE = new CommandProvider();

    private CommandProvider() {
    }

    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    public Command getCommand(String request) throws CommandException {
        if (request == null){
            throw new CommandException("Command cannot be null");
        }
        var arguments = request.split(" ");

        if (arguments.length < 1) {
            throw new CommandException("No command arguments found");
        }

        return switch (arguments[0]) {
            case "AUTH" -> new AuthCommand();
            case "DISCONNECT" -> new DisconnectCommand();
            case "EDIT" -> new EditCommand();
            case "VIEW" -> new ViewCommand();
            case "CREATE" -> new CreateCommand();
            default -> throw new CommandException("No such command");
        };
    }
}
