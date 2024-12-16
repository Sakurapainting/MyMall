import java.util.Date;
import java.util.List;

public class Order {
    private List<Commodity> commodities;
    private Date orderDate;
    private String address;

    public Order(List<Commodity> commodities, String address) {
        this.commodities = commodities;
        this.orderDate = new Date();
        this.address = address;
    }

    public void showOrder() {
        System.out.println("订单日期：" + orderDate);
        System.out.println("收货地址：" + address);
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }
}
