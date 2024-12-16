public class Food extends Commodity {
    public Food(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, "食品", price, quantity, model, isWithBluetooth);
    }

    public Food() {
        // 默认无参构造函数
    }
}
