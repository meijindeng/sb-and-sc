package me.coast.designmode;

/**
 * 简单工厂模式如下：一个工厂类根据传入的参量决定创建出那一种产品类的实例。
 *
 * 在 MobileFactory的createPhone函数中需要传递一个参数，通过该参数来创建不同的手机对象，例如魅族、三星、小米。
 * 可以看到，MobileFactory中只有一个静态函数，通过该函数可以创建多种对象类型，这也就是它的核心定义。
 */
public class SimpleFactory {
    public static MobilePhone createPhone(String brand) {
        MobilePhone phone = null;
        if (brand.equalsIgnoreCase("samsung")) {
            phone = new Samsung();
        } else if (brand.equalsIgnoreCase("xiaomi")) {
            phone = new XiaoMi();
        } else if (brand.equalsIgnoreCase("meizu")) {
            phone = new Meizu();
        }
        return phone;
    }
}


/**
 * 魅族、三星、小米手机都继承自 MobilePhone，为了便于管理对象的创建，通过一个简单的工厂模式来创建这些类型的对象。
 * 简单工厂模式如上
 */
//电话基类
abstract class MobilePhone {
    public void makeCall() {
        System.out.println("打电话");
    }

    public void surfInterner() {
        System.out.println("上网");
    }
}

//魅族手机
class Meizu extends MobilePhone{
}

//三星手机
class Samsung extends MobilePhone{
}

//小米手机
class XiaoMi extends MobilePhone {
}


