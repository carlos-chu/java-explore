package org.learning.jvm.keywords;

/**
 * @ClassName: KeyWord
 * @Description: 映射java的修饰关键字，如static, final, public, volatile, synchronized, class, interface, public等
 * @author carlos.chu
 * @date 2016年5月11日 上午11:26:56
 */
public class KeyWord {

    void public_() {

    }

    private class Print {
        private StringBuffer sb = new StringBuffer();

        void print(String keyword) {
            sb.append(keyword);
        }
    }
}
