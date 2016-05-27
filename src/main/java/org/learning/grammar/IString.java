package org.learning.grammar;

public class IString {

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "abc";
        System.out.println(s == s1);

        String ss = new String("abc");
        String ss1 = new String("abc");
        System.out.println(ss == ss1);
        System.out.println(ss.equals(ss1));

        String sss = new String("ab") + new String("c");
        sss.intern();
        String sss1 = "abc";
        System.out.println(sss == sss1);
    }
}
