package org.learning.rpc.tinyrpc.opration;

public class RemoteEcho implements Echo {

    @Override
    public String echo(String msg) {

        return "from remote:" + msg;
    }

}
