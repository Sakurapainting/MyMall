package model;

public class MobilePhone extends Commodity {
    public MobilePhone(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public MobilePhone() {
        // 默认无参构造函数
    }
}
