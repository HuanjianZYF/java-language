package com.zyf.java.innerclass;

/**
 * @Author zyf
 * @CreateAt 2018/4/9 下午3:09
 *
 * 1.内部类的类型为OuterClass.InnerClass
 * 2.可以把内部类写成private并继承某个抽象类或者实现某个接口，然后在public方法中返回那个接口类型
 *   这样据说就很有用。但是，在外部看来，根本就不存在内部类这种东西了。用户可以调用这个接口的方法，
 *   且我觉得动态绑定的是那个内部类型的对象，只是它的别的一些方法，没有办法来访问到。
 */
public class InnerClassCase1 {

    private class Contents implements IContents {
        private int i = 11;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    private class Destination implements IDestination {
        private String label;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Destination(String label) {
            this.label = label;
        }

        public void f() {
            System.out.println("a");
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents con() {
        return new Contents();
    }

    public void ship(String destination) {
        Contents contents = con();
        Destination destination1 = to(destination);
    }

    public static void main(String[] args) {
        InnerClassCase1 innerClassCase1 = new InnerClassCase1();
        innerClassCase1.ship("a");

        InnerClassCase1.Contents contents = innerClassCase1.con();
        InnerClassCase1.Destination destination = innerClassCase1.to("zzz");
        destination.f();
    }

}

interface IContents {
    int getI();
}

interface IDestination {
    String getLabel();
}
