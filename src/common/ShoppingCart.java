package common;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class ShoppingCart {
    private List<Commodity> commodities;

    public ShoppingCart() {
        commodities = new ArrayList<>();
    }

    public void addCommodity(Commodity commodity) {
        commodities.add(commodity);
    }

    public void removeCommodity(int id) {
        Commodity toRemove = null;
        for (Commodity commodity : commodities) {
            if (commodity.getId() == id) {
                toRemove = commodity;
                break;
            }
        }
        if (toRemove != null) {
            commodities.remove(toRemove);
            System.out.println("商品已移除：" + toRemove.getName());
        } else {
            System.out.println("未找到商品编号：" + id);
        }
    }

    public void clearCart() {
        commodities.clear();
        System.out.println("购物车已清空。");
    }

    public void showCart() {
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }
}
