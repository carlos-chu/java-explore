package org.learning.rpc.tinyrpc;

import org.learning.rpc.tinyrpc.opration.Echo;
import org.learning.rpc.tinyrpc.opration.RemoteEcho;
import org.learning.rpc.tinyrpc.support.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new RPC.RPCServer();
        server.register(Echo.class, RemoteEcho.class);
        server.start();
    }

}
