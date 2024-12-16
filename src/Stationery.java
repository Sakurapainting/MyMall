public class Stationery extends Commodity {
    public Stationery(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, "文具", price, quantity, model, isWithBluetooth);
    }

    public Stationery() {
        // 默认无参构造函数
    }
}
