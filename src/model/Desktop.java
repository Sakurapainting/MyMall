package model;

public class Desktop extends Computer {
    public Desktop(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public Desktop() {
        // 默认无参构造函数
    }
}
