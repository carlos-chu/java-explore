package org.learning.rpc.tinyrpc.support;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.learning.rpc.tinyrpc.protocol.Invocation;

/**
 * @ClassName: Client
 * @Description: 客户端
 * @author carlos.chu
 * @date 2016年3月16日 下午2:53:13
 *
 */
public class Client {

    private String host;
    private int port;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void init() throws UnknownHostException, IOException {
        socket = new Socket(host, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public void invoke(Invocation invoker) throws UnknownHostException, IOException, ClassNotFoundException {
        init();
        System.out.println("write data...");
        oos.writeObject(invoker);
        oos.flush();

        ois = new ObjectInputStream(socket.getInputStream());
        Invocation result = (Invocation) ois.readObject();
        invoker.setResult(result.getResult());
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
