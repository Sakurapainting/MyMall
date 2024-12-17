package model;

public class Food extends Commodity {
    public Food(int id, String name, double price, int quantity, String model, boolean isWithBluetooth) {
        super(id, name, price, quantity, model, isWithBluetooth);
    }

    public Food() {
        super();
    }
}
