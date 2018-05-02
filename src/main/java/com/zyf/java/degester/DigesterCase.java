package com.zyf.java.degester;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.Rule;

import java.io.File;

/**
 * @Author zyf
 * @CreateAt 2018/5/2 下午5:45
 *
 * tomcat中用xml配置来对应java对象，使用了digester
 */
public class DigesterCase {

    public static void main(String[] args) {
        Digester digester = new Digester();
//        digester.setValidating(true);

        digester.addObjectCreate("person", Person.class);
        digester.addSetProperties("person");
        digester.addCallMethod("person", "say");
        digester.addObjectCreate("person/toy", Toy.class);
        digester.addSetProperties("person/toy");
        digester.addSetNext("person/toy", "setToy");

        File file = new File("/Users/zyf/IdeaProjects/javalanguage/src/main/java/com/zyf/java/degester/person.xml");
        try {
            Person person = digester.parse(file);
            System.out.println(person);
        } catch (Exception e) {
        }

    }
}
