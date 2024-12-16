public class Headphone extends Commodity {
    public Headphone(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, "耳机", price, quantity, model, isWithBluetooth);
    }

    public Headphone() {
        // 默认无参构造函数
    }
}
