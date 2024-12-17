package model;

import usb.USB;

public class Computer extends Commodity implements USB {

    public Computer(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public Computer() {
        // 默认无参构造函数
    }

    @Override
    public void open() {
        System.out.println(getName() + " open");
    }

    @Override
    public void read() {
        System.out.println(getName() + " read");
    }

    @Override
    public void close() {
        System.out.println(getName() + " close");
    }
}
