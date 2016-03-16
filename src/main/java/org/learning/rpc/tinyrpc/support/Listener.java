package org.learning.rpc.tinyrpc.support;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.learning.rpc.tinyrpc.protocol.Invocation;

/**
 * @ClassName: Listener
 * @Description: 端口监听器
 * @author carlos.chu
 * @date 2016年3月16日 下午3:04:29
 *
 */
public class Listener extends Thread {

    private ServerSocket socket;
    private Server server;

    public Listener(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println("server starting...port:" + server.getPort());

        try {
            socket = new ServerSocket(server.getPort());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (server.isRunning()) {
            try {
                System.out.println("wait...");
                Socket client = socket.accept();
                System.out.println("request coming...");
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                Invocation invo = (Invocation) ois.readObject();
                System.out.println("remote invoke:" + invo);
                server.call(invo);

                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
                oos.writeObject(invo);
                oos.flush();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
