package model;

public class Laptop extends Computer {
    private boolean isWireless;

    public Laptop(int id, String name, double price, int quantity, String model, boolean isWithBluetooth, boolean isWireless) {
        super(id, name, price, quantity, model, isWithBluetooth);
        this.isWireless = isWireless;
    }

    public Laptop() {
        // 默认无参构造函数
    }

    public boolean isWireless() {
        return isWireless;
    }

    @Override
    public String toString() {
        return super.toString() + ", 是否带无线：" + isWireless;
    }
}
