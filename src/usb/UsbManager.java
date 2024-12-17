package usb;

/*
 *     通过这种方式，UsbManager 能够动态地处理任何实现了 USB 接口的类，
 * 而不需要在代码中事先知道具体的实现类。
 *     这提高了代码的灵活性和可扩展性，因为可以通过传入不同的类名来操作不同的 USB 设备，
 * 只要这些类实现了 USB 接口。
 */

public class UsbManager {
    public void useUsbDevice(String className) {
        try {
            Class<?> cls = Class.forName(className);//Class<?>是泛型，表示这是一个Class类型的对象，forName返回的是一个Class对象
            Object obj = cls.getDeclaredConstructor().newInstance();//newInstance()方法创建一个新的实例

            // 判断是否实现了 USB 接口，如果实现了，则调用 USB 接口的方法
            if (obj instanceof USB) { //instanceof是Java的一个二元操作符，用来测试一个对象是否为一个类的实例
                USB usbDevice = (USB) obj;  //实现了接口，才会进行强制类型转换
                usbDevice.open();
                usbDevice.read();
                usbDevice.close();
            } else {
                System.out.println(className + " 未实现 USB 接口");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无法创建对象：" + className);
        }
    }
}
