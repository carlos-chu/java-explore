package org.learning.rpc.tinyrpc.support;

import org.learning.rpc.tinyrpc.protocol.Invocation;

/**
 * @ClassName: Server
 * @Description: 服务提供的接口
 * @author carlos.chu
 * @date 2016年3月16日 下午3:01:44
 *
 */
public interface Server {

    void start();

    void stop();

    void register(Class interfaceDefiner, Class impl);

    void call(Invocation invoker);

    boolean isRunning();

    int getPort();
}
