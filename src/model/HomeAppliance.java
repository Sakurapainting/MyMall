package model;

public class HomeAppliance extends Commodity {
    public HomeAppliance(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public HomeAppliance() {
        // 默认无参构造函数
    }
}
