package org.example.Command;

public interface Command {

    public CommandResult<String> execute() throws Exception;
}
