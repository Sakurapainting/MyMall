package common;

public class OrderNumberGenerator {
    // 单例模式
    private static OrderNumberGenerator instance = new OrderNumberGenerator();
    private int currentOrderNumber = 1000;

    private OrderNumberGenerator() {

    }

    public static OrderNumberGenerator getInstance() {
        return instance;
    }

    public synchronized int getNextOrderNumber() {
        return currentOrderNumber++;
    }
}
