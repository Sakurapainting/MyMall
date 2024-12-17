package model;

public class ElectronicProduct extends Commodity {
    public ElectronicProduct(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public ElectronicProduct() {
        // 默认无参构造函数
    }
}    
