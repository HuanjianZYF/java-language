package com.zyf.java.syntaxsuger.innerclass;

/**
 * @Author zyf
 * @CreateAt 2018/4/9 下午3:44
 *
 * 真会玩，这个内部类写在了一个方法里面了，结果这个类的作用域就是方法里面了
 * 类似的，内部类可以定义在任意的某个作用域内
 */
public class InnerClassCase2 {

    public IDestination to(String s) {

        class Destination implements IDestination {
            private String label;

            @Override public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public Destination(String label) {
                this.label = label;
            }
        }

        return new Destination(s);
    }

}

