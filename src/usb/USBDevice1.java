package usb;

public class USBDevice1 implements USB {
    @Override
    public void open() {
        System.out.println("USBDevice1 已打开。");
    }

    @Override
    public void read() {
        System.out.println("USBDevice1 正在读取。");
    }

    @Override
    public void close() {
        System.out.println("USBDevice1 已关闭。");
    }
}
