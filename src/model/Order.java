import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import discount.DiscountFactory;
import discount.DiscountStrategy;

public class Order {
    private List<Commodity> commodities;
    private Date orderDate;
    private String address;

    @SerializedName("contactPerson")
    private String contactPerson;

    @SerializedName("contactPhone")
    private String contactPhone;

    private int orderNumber;

    private double totalPrice;
    private String discountType;

    public Order(List<Commodity> commodities, String address, String contactPerson, String contactPhone) {
        this.orderNumber = OrderNumberGenerator.getInstance().getNextOrderNumber();
        this.commodities = commodities;
        this.orderDate = new Date();
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;

        // 计算折扣总价
        DiscountStrategy discountStrategy = DiscountFactory.getDiscountStrategy();
        this.totalPrice = discountStrategy.applyDiscount(commodities);
        this.discountType = discountStrategy.getHolidayName();
    }

    // Getter和Setter方法
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public void showOrder() {
        System.out.println("订单号：" + orderNumber);
        System.out.println("订单日期：" + orderDate);
        System.out.println("收货地址：" + address);
        System.out.println("折扣类型：" + discountType);
        System.out.println("折扣后的总价：" + totalPrice);
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }

    public String toJson() {
        return GsonProvider.getGson().toJson(this);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getAddress() {
        return address;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDiscountType() {
        return discountType;
    }
}
