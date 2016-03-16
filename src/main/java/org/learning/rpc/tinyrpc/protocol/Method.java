package org.learning.rpc.tinyrpc.protocol;

import java.io.Serializable;

/**
 * @ClassName: Method
 * @Description: 调用方法定义协议
 * @author carlos.chu
 * @date 2016年3月16日 下午2:49:10
 *
 */
public class Method implements Serializable {

    private static final long serialVersionUID = 8119657865833513444L;

    private String methodName;
    private Class[] params;

    public Method(String name, Class<?>[] parameterTypes) {
        this.methodName = name;
        this.params = parameterTypes;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParams() {
        return params;
    }

    public void setParams(Class[] params) {
        this.params = params;
    }

}
