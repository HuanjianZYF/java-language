package com.zyf.java.syntaxsuger.innerclass;

/**
 * @Author zyf
 * @CreateAt 2018/4/9 下午3:54
 * 直接在方法里面返回一个匿名的内部类对象
 * 所以经常用new Thread(new Runnable() {})这种写法，就是在Thread的构造函数里传了一个匿名类对象
 * 如果要传递一个变量到内部类里面,那么这个变量必须是final的
 */
public class InnerClassCase3 {

    public IDestination to(final String a) {
        final String b = "c";

        return new IDestination() {
            private String label = "a";

            @Override public String getLabel() {
                return label + a + b;
            }

            public void setLabel(String label) {
                this.label = label;
            }
        };
    }

    public static void main(String[] args) {
        InnerClassCase3 innerClassCase3 = new InnerClassCase3();
        IDestination iDestination = innerClassCase3.to("b");
        System.out.println(iDestination.getLabel());
    }
}
