package model;

import com.google.gson.annotations.SerializedName;

public abstract class Commodity {
    public Commodity() {
        // 默认无参构造函数
    }

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private double price;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("model")
    private String model;

    @SerializedName("isWithBluetooth")
    private boolean isWithBluetooth;

    public Commodity(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.model = model;
        this.isWithBluetooth = isWithBluetooth;
    }

    // Getter和Setter方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public boolean getIsWithBluetooth() { return isWithBluetooth; }
    public void setIsWithBluetooth(boolean isWithBluetooth) { this.isWithBluetooth = isWithBluetooth; }

    public boolean hasBluetooth() {
        return isWithBluetooth;
    }

    @Override
    public String toString() {
        return "商品编号：" + id + ", 名称：" + name + ", 类型：" + getClass().getSimpleName() +
               ", 价格：" + price + ", 数量：" + quantity + ", 型号/分类：" + model +
               ", 是否带蓝牙：" + isWithBluetooth;
    }
}
