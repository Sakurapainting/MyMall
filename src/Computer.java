public class Computer extends Commodity {
    public Computer(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, "电脑", price, quantity, model, isWithBluetooth); 
    }

    public Computer() {
        // 默认无参构造函数
    }
}
