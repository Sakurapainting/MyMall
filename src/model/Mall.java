package model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import common.*;

public class Mall {
    private List<Commodity> commodities;
    private Gson gson;
    private String commoditiesFilePath = "src/commodities.json";

    public Mall() {
        commodities = new ArrayList<>();
        gson = GsonProvider.getGson(); // 使用统一的 Gson 实例
    }

    public void loadCommodities(String filePath) {
        try {
            Type listType = new TypeToken<List<Commodity>>(){}.getType();
            commodities = gson.fromJson(new FileReader(filePath), listType); 
            System.out.println("商品已成功加载。");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("反序列化商品信息时出错，需要检查 JSON 数据和类的定义。");
        }
    }
    public void showAllCommodities() {
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
    }

    public Commodity getCommodityById(int id) {
        for (Commodity commodity : commodities) {
            if (commodity.getId() == id) {
                return commodity;
            }
        }
        return null;
    }

    public List<Commodity> findBlueTooth() {
        List<Commodity> bluetoothCommodities = new ArrayList<>();
        for (Commodity commodity : commodities) {
            if (commodity.hasBluetooth()) {
                bluetoothCommodities.add(commodity);
            }
        }
        return bluetoothCommodities;
    }

    // 保存商品到 JSON 文件
    public void saveCommodities() {
        try (FileWriter writer = new FileWriter(commoditiesFilePath)) {
            gson.toJson(commodities, writer);
            System.out.println("商品已成功保存。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("保存商品信息时出错。");
        }
    }

    public void addCommodity(Commodity commodity) {
        commodities.add(commodity);
        saveCommodities();
    }

    // 从 JSON 数据中加载商品
    public void addCommodityFromJson(String jsonData) {
        try {
            Commodity commodity = gson.fromJson(jsonData, Commodity.class);
            if (commodity != null) {
                commodities.add(commodity);
                System.out.println("商品已从 JSON 数据中添加到商城。");
            } else {
                System.out.println("反序列化后的商品为 null。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("从 JSON 数据添加商品时出错。");
        }
    }

}
