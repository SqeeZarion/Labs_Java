package org.example.Command;

public class Invoker {
    private Command command;

    public Invoker(Command command){
        this.command=command;
    }

    public void doSmth(){
        try {
            command.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
