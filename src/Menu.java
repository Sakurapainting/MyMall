public class Menu {
    public static void showMenu() {
		System.out.println("  ******************************");
		System.out.println("         MyMall System          ");
		System.out.println("  ******************************");
		System.out.println("输入序号以继续：");
		System.out.println("1）商品展示");
		System.out.println("2）按编号查询商品");
        System.out.println("3）查询有蓝牙功能的商品");
		System.out.println("4）添加商品至购物车");
		System.out.println("5）删除购物车中的商品");
		System.out.println("6）查看购物车");
		System.out.println("7）清空购物车");
		System.out.println("8）结账");
        System.out.println("9）查看历史订单");
        System.out.println("10）退出");
	}

	public static void endMenu() {
		System.out.println("  *******************************");
		System.out.println("       Thanks for Shopping！    ");
		System.out.println("  *******************************");
	}
}
