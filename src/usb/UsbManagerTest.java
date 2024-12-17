package usb;

public class UsbManagerTest {
    public static void main(String[] args) {
        UsbManager usbManager = new UsbManager();
        usbManager.useUsbDevice("usb.USBDevice1");
    }
}
