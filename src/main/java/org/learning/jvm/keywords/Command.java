package org.learning.jvm.keywords;

/**
 * @ClassName: Command
 * @Description: 映射java的基本命令，例如new，instansof,
 * @author carlos.chu
 * @date 2016年5月11日 上午11:18:31
 */
public interface Command {

    /**
     * 映射new关键字
     * 
     * @param t
     * @return
     */
    <T> T newT(T t);

    /**
     * 映射static关键字
     * 
     * @param t
     * @return
     */
    <T> T staticT(T t);
    
    
}
