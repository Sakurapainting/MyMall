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
        commodity.setAddedTime(System.currentTimeMillis()); // 设置加入时间
        commodities.add(commodity);
    }

    public void sortCommodities(int algorithmType, int sortType) {
        switch (algorithmType) {
            case 1:
                bubbleSort(sortType);
                break;
            case 2:
                quickSort(sortType, 0, commodities.size() - 1);
                break;
            default:
                System.out.println("无效的排序算法。");
                break;
        }
    }

    private void bubbleSort(int sortType) {
        int n = commodities.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(commodities.get(j), commodities.get(j + 1), sortType) > 0) {
                    Commodity temp = commodities.get(j);
                    commodities.set(j, commodities.get(j + 1));
                    commodities.set(j + 1, temp);
                }
            }
        }
    }

    private void quickSort(int sortType, int low, int high) {
        if (low < high) {
            int pi = partition(sortType, low, high);
            quickSort(sortType, low, pi - 1);
            quickSort(sortType, pi + 1, high);
        }
    }

    private int partition(int sortType, int low, int high) {
        Commodity pivot = commodities.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(commodities.get(j), pivot, sortType) < 0) {
                i++;
                Commodity temp = commodities.get(i);
                commodities.set(i, commodities.get(j));
                commodities.set(j, temp);
            }
        }
        Commodity temp = commodities.get(i + 1);
        commodities.set(i + 1, commodities.get(high));
        commodities.set(high, temp);
        return i + 1;
    }

    private int compare(Commodity c1, Commodity c2, int sortType) {
        switch (sortType) {
            case 1:
                return c1.getName().compareTo(c2.getName());
            case 2:
                // 按照商品编号排序 Unicode 编码排序
                return Integer.compare(c1.getId(), c2.getId());
            case 3:
                return Long.compare(c2.getAddedTime(), c1.getAddedTime()); // 倒序
            default:
                return 0;
        }
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
