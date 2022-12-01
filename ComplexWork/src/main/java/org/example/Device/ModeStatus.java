package org.example.Device;

public enum ModeStatus {

    ECO(1),
    Mid(2),
    MAX(3);

    private int regimeCode;

    ModeStatus(int regimeCode) {
        this.regimeCode = regimeCode;
    }

    public int getRegimeCode() {
        return regimeCode;
    }
}
