package model;

public class HardDrive extends Commodity {
    public HardDrive(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public HardDrive() {
        // 默认无参构造函数
    } 
}
