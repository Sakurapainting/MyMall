public class Commodity {
    private int id;
    private String name;
    private String type;
    private double price;
    private int quantity;
    private String model;
    private boolean isWithBluetooth;

    public Commodity(int id, String name, String type, double price, int quantity, String model, boolean isWithBluetooth) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.model = model;
        this.isWithBluetooth = isWithBluetooth;
    }

    // Getter和Setter方法
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getModel() { return model; }
    public boolean getIsWithBluetooth() { return isWithBluetooth; }

    public boolean hasBluetooth() {
        return isWithBluetooth;
    }

    @Override
    public String toString() {
        return "商品编号：" + id + ", 名称：" + name + ", 类型：" + type + ", 价格：" + price + ", 数量：" + quantity + ", 型号/分类：" + model + ", 是否带蓝牙：" + isWithBluetooth;
    }
}
