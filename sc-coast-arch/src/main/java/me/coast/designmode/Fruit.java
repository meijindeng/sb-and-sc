package me.coast.designmode;

/**
 * @author meiji 多态： 父类的引用指向子类的对象
 */
public class Fruit {
    int num;
    public void eat(){
        System.out.println("eat Fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void eat() {
        super.num = 10;
        System.out.println("eat " + num + " Apple");
    }
    public static void main(String[] args) {
        Fruit fruit = new Apple();
        fruit.eat();
    }
}
