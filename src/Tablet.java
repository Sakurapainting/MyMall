public class Tablet extends Computer {
    public Tablet(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }    

    public Tablet() {
        // 默认无参构造函数
    }
}
