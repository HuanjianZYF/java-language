package com.zyf.java.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author zyf
 * @CreateAt 2018/5/5 下午5:26
 *
 * 解析xml
 */
public class DocumentBuilderCase {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream in = new FileInputStream("/Users/zyf/IdeaProjects/javalanguage/src/main/java/com/zyf/java/xml/test.xml");
        Document document = builder.parse(in);
        Element root = document.getDocumentElement();
        System.out.println(root.getTagName());
    }
}
