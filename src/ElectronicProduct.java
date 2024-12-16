public class ElectronicProduct extends Commodity {
    public ElectronicProduct(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, "电子产品", price, quantity, model, isWithBluetooth);
    }

    public ElectronicProduct() {
        // 默认无参构造函数
    }
}
