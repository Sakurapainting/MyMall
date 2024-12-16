import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
		Scanner pause = new Scanner(System.in);

        // 初始化商城
        Mall mall = new Mall();
        mall.loadCommodities("src/commodities.json");

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
                case 10:// 退出
                    Menu.endMenu();
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
                }
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
