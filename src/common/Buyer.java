import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Buyer {
    private String name;
    private String address;

    private ShoppingCart cart;
    private Order currentOrder;
    private List<Order> orderHistory;

    public Buyer(String name) {
        this.name = name;
        this.address = " ";
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public void browseMall(Mall mall) {
        mall.showAllCommodities();
    }

    // 根据商品编号展示某个商品详细信息
    public void viewCommodity(Mall mall, int id) {
        Commodity commodity = mall.getCommodityById(id);
        if (commodity != null) {
            System.out.println(commodity);
        } else {
            System.out.println("未找到商品编号：" + id);
        }
    }

    public void addToCart(Commodity commodity) {
        cart.addCommodity(commodity);
        System.out.println("已添加商品：" + commodity.getName());
    }

    public void removeFromCart(int id) {
        cart.removeCommodity(id);
    }

    public void clearCart() {
        cart.clearCart();
    }

    public void submitOrder() {
        if (!cart.getCommodities().isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入送货地址：");
            address = sc.nextLine(); // 输入地址
    
            System.out.println("请输入联系人：");
            String contactPerson = sc.nextLine(); // 输入联系人
    
            System.out.println("请输入联系电话：");
            String contactPhone = sc.nextLine(); // 输入联系电话
    
            currentOrder = new Order(cart.getCommodities(), address, contactPerson, contactPhone);
            orderHistory.add(currentOrder); // 添加到历史订单
            cart = new ShoppingCart(); // 清空购物车
            System.out.println("订单提交成功！");
            
            // 显示折扣信息和总价
            System.out.println("折扣类型：" + currentOrder.getDiscountType());
            System.out.println("折扣后的总价：" + currentOrder.getTotalPrice());

            // 将订单发送给物流公司
            LogisticsCompany logisticsCompany = new LogisticsCompany();
            logisticsCompany.processOrder(currentOrder.toJson());

            try (FileWriter writer = new FileWriter("orders.json", true)) {
                writer.write(currentOrder.toJson());
                writer.write("\n"); // 每个订单占一行
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("保存订单到文件时出错。");
            }

        } else {
            System.out.println("购物车为空，无法提交订单。");
        }
    }

    public void viewOrder() {
        if (currentOrder != null) {
            currentOrder.showOrder();
        } else {
            System.out.println("您还没有订单。");
        }
    }

    public void viewCart() {
        cart.showCart();
    }

    // 查看历史订单
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("您还没有历史订单。");
        } else {
            for (Order order : orderHistory) {
                order.showOrder();
            }
        }
    }
    
    // 查找具有蓝牙功能的商品
    public void findBlueTooth(Mall mall) {
        List<Commodity> bluetoothCommodities = mall.findBlueTooth();
        if (bluetoothCommodities.isEmpty()) {
            System.out.println("没有找到具有蓝牙功能的商品。");
        } else {
            System.out.println("具有蓝牙功能的商品：");
            for (Commodity commodity : bluetoothCommodities) {
                System.out.println(commodity);
            }
        }
    }
}
