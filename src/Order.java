import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Order {
    private List<Commodity> commodities;
    private Date orderDate;
    private String address;
    private int orderNumber;

    public Order(List<Commodity> commodities, String address) {
        this.orderNumber = OrderNumberGenerator.getInstance().getNextOrderNumber();
        this.commodities = commodities;
        this.orderDate = new Date();
        this.address = address;
    }

    public void showOrder() {
        System.out.println("订单号：" + orderNumber);
        System.out.println("订单日期：" + orderDate);
        System.out.println("收货地址：" + address);
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
}
