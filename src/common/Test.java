package common;

import java.util.Scanner;

import model.*;

public class Test {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
		Scanner pause = new Scanner(System.in);

        // 初始化商城
        Mall mall = new Mall();
        mall.loadCommodities("src/common/commodities.json");

        // 初始化买家
        Buyer buyer = new Buyer("张三");

        while(true){
            Menu.showMenu();
            System.out.println("请输入序号:");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:// 浏览商品
                    mall.showAllCommodities();

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 2:// 查询商品
                    System.out.println("请输入商品编号:");
                    int id = sc.nextInt();
                    buyer.viewCommodity(mall, id);

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 3:// 查询有蓝牙功能的商品 
                    System.out.println("有蓝牙功能的商品：");
                    buyer.findBlueTooth(mall);

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 4:// 添加商品
                    System.out.println("请输入商品编号:");
                    int id1 = sc.nextInt();
                    Commodity commodity = mall.getCommodityById(id1);
                    if (commodity != null) {
                        buyer.addToCart(commodity);
                    } else {
                        System.out.println("未找到商品编号：" + id1);
                    }

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 5:// 删除商品
                    System.out.println("请输入商品编号:");  
                    int id2 = sc.nextInt();
                    buyer.removeFromCart(id2);

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 6:// 查看购物车
                    buyer.viewCart();

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 7:// 清空购物车
                    buyer.clearCart();

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 8:// 结账
                    buyer.submitOrder();

                    // 查看订单
                    System.out.println("订单信息：");
                    System.out.println("");
                    buyer.viewOrder();

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 9:// 查看历史订单
                    buyer.viewOrderHistory();

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 10:// 添加新商品
                    addCommodityToMall(mall);

                    System.out.println("按回车键继续...");
                    pause.nextLine();
                    break;
                case 11:// 退出
                    Menu.endMenu();
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    // 添加新商品到商城
    public static void addCommodityToMall(Mall mall) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品类型（电子产品、日用品、食品、文具、家电、电脑、手机、笔记本电脑、台式机、一体机、平板电脑、耳机、移动硬盘、蓝牙设备、蓝牙耳机、蓝牙笔记本、蓝牙手表）:");
        String type = sc.nextLine();

        System.out.println("请输入商品编号:");
        int id = sc.nextInt();
        sc.nextLine(); // 清除缓冲区（nextInt()读取整数后，回车留在缓冲区）

        System.out.println("请输入商品名称:");
        String name = sc.nextLine();

        System.out.println("请输入商品价格:");
        double price = sc.nextDouble();

        System.out.println("请输入商品数量:");
        int quantity = sc.nextInt();
        sc.nextLine(); // 清除缓冲区（nextInt()读取整数后，回车留在缓冲区）

        System.out.println("请输入商品型号/分类:");
        String model = sc.nextLine();

        System.out.println("该商品是否具有蓝牙功能？（true/false）:");
        boolean isWithBluetooth = sc.nextBoolean();

        Commodity newCommodity = CommodityFactory.createCommodity(type, id, name, price, quantity, model, isWithBluetooth);
        if (newCommodity != null) {
            mall.addCommodity(newCommodity); // 添加并保存
            System.out.println("新商品已添加到商城！");
        } else {
            System.out.println("商品添加失败。");
        }
    }

        // // 浏览商品
        // buyer.browseMall(mall);

        // // 查询并查看商品
        // buyer.viewCommodity(mall, 101); // 蓝牙耳机
        // buyer.viewCommodity(mall, 102); // 笔记本电脑

        // // 加入购物车
        // Commodity earphone = mall.getCommodityById(101);
        // Commodity laptop = mall.getCommodityById(102);
        // if (earphone != null) {
        //     buyer.addToCart(earphone);
        // }
        // if (laptop != null) {
        //     buyer.addToCart(laptop);
        // }

        // // 查看购物车
        // System.out.println("购物车内容：");
        // buyer.viewCart();

        // // 提交订单
        // buyer.submitOrder();

        // // 查看订单
        // System.out.println("订单信息：");
        // System.out.println("");
        // buyer.viewOrder();

        // // 输出购物车所有物品（应为空）
        // System.out.println("购物车内容（提交订单后）：");
        // buyer.viewCart();
    // }
}
