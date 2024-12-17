package model;

public class BluetoothDevice extends Commodity{
    public BluetoothDevice(int id, String name, double price, int quantity, String model) {
        super(id, name, price, quantity, model, true);
    }

    public BluetoothDevice() {
        // 默认无参构造函数
    }
}
