package org.example.Command;

public enum CommandEnum {

    OFF(0),
    ON(1),
    SetRegime(2),
    PrintAll(3),
    PrintOnDevices(4),
    SearchByParameters(5);

    private final int commandCode;

    CommandEnum(int commandCode) {
        this.commandCode = commandCode;
    }


    public int getCommandCode() {
        return commandCode;
    }
}
