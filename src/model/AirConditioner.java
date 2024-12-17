package model;

public class AirConditioner extends ElectricalAppliance {
    public AirConditioner() {
        super();
    }

    public AirConditioner(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }
}
