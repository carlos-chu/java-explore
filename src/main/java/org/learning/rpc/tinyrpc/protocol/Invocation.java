package org.learning.rpc.tinyrpc.protocol;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ClassName: Invocation
 * @Description: 调用协议定义
 * @author carlos.chu
 * @date 2016年3月16日 下午2:46:27
 *
 */
public class Invocation implements Serializable {

    private static final long serialVersionUID = -9210720005574838048L;

    private Class interfaces;
    private Method method;
    private Object[] params;
    private Object result;

    public Class getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class interfaces) {
        this.interfaces = interfaces;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Invocation [interfaces=" + interfaces + ", method=" + method + ", params=" + Arrays.toString(params)
                + ", result=" + result + "]";
    }

}
