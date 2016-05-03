package org.learning.grammar;

/**
 * @ClassName: StaticPai
 * @Description: 静态分派
 * @author carlos.chu
 * @date 2016年4月27日 下午5:10:12
 *
 */
public class StaticPai {
    public void say(Human hum) {
        System.out.println("I am human");
    }

    public void say(Man hum) {
        System.out.println("I am man");
    }

    public void say(Woman hum) {
        System.out.println("I am woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticPai sp = new StaticPai();
        sp.say(man);
        sp.say(woman);
    }
}

class Human {
}

class Man extends Human {
}

class Woman extends Human {
}