package common;

public class OrderNumberGenerator {
    // 单例模式
    private static OrderNumberGenerator instance = new OrderNumberGenerator();
    private int currentOrderNumber = 1000;

    private OrderNumberGenerator() {
        // 私有构造函数，防止外部实例化
    }

    public static OrderNumberGenerator getInstance() {
        return instance;
    }

    public synchronized int getNextOrderNumber() {
        return currentOrderNumber++;
    }
}
