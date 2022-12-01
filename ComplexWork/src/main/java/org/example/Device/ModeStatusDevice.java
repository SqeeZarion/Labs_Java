package org.example.Device;

public class ModeStatusDevice extends Device {

    ModeStatus regime;

    public ModeStatusDevice() {
        super();
        this.regime = ModeStatus.Mid;
    }

    public ModeStatusDevice(String name, Integer power) {
        super(name, power);
        state = false;
        regime = ModeStatus.Mid;
    }

    public void setModeStatus(Integer ModeStatusCode) {
        if (ModeStatusCode == 1) {
            this.regime = ModeStatus.ECO;
        } else if (ModeStatusCode == 2) {
            this.regime = ModeStatus.Mid;
        } else if (ModeStatusCode == 3) {
            this.regime = ModeStatus.MAX;
        }
        calculateRegimePower(this);
    }

    public static void calculateRegimePower(ModeStatusDevice obj) {

        switch (obj.regime.getRegimeCode()) {
            case (1):
                obj.power = (int) (obj.power * 0.5);
                break;
            case (3):
                obj.power = (int) (obj.power * 1.3);
                break;
            default:
        }
    }

    @Override
    public String toString() {
        return
                "\nName='" + name + '\'' +
                        ", power=" + power +
                        ", state=" + state +
                        ", Mode Status=" + regime;
    }


    public ModeStatus getModeStatus() {
        return regime;
    }
}
