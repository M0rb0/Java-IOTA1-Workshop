/*
This example checks the basic functioning of the API and prints out
the node information of the node you are connected to.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;

import java.net.MalformedURLException;

public class e01_hello_world {
    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();
        System.out.println(iotaAPI.getNodeInfo());
    }
}