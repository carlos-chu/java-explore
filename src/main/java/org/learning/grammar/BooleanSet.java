package org.learning.grammar;

import java.util.HashSet;

public class BooleanSet {

    public static void main(String[] args) {
        HashSet<Boolean> set = new HashSet<Boolean>();
        set.add(new Boolean(true));
        set.add(new Boolean(true));
        set.add(new Boolean(false));
        set.add(new Boolean(true));
        set.add(new Boolean(true));
        for (Boolean b : set) {
            System.out.println(b);
            String s = "a";
        }
    }
}
