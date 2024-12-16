public class DailyNecessity extends Commodity {
    public DailyNecessity(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, "日用品", price, quantity, model, isWithBluetooth);
    }

    public DailyNecessity(){
        // 默认无参构造函数
    }
}
