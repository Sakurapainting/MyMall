package model;

public class BluetoothWatch extends BluetoothDevice {
    public BluetoothWatch(int id, String name, double price, int quantity, String model) {
        super(id, name, price, quantity, model);
    }

    public BluetoothWatch() {
        // 默认无参构造函数
    }
}
