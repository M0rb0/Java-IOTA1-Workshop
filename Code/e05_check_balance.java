/*
This example retreives the balance of the given address.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;

import java.net.MalformedURLException;

public class e05_check_balance {
    public static String TEST_ADDRESS = "BWBBBJSZJXCEKOWULBHQRTCFVCCTRNGNGBZD9AGOD9CIKMUXNEWKZZC9YXGAGGQMUFGEIHQPFEBMWAXDCBFZKMOCAD";

    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        System.out.println("Balance: " + iotaAPI.getBalance(100, TEST_ADDRESS));
    }
}