package model;

public class WaterHeater extends ElectricalAppliance {
    public WaterHeater() {
        super();
    }

    public WaterHeater(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }
}
