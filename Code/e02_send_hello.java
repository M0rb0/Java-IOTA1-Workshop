/*
This example creates a simple transaction with a custom message/tag.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;
import org.iota.jota.model.Transfer;
import org.iota.jota.utils.TrytesConverter;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class e02_send_hello {
    public static String SENDER_SEED = "BESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEED9";
    public static String RECIPIENT_ADDRESS = "BESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESS99";

    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(RECIPIENT_ADDRESS, 0, TrytesConverter.asciiToTrytes("HELLO WORLD!"), "HELLOWORLD"));
        iotaAPI.sendTransfer(SENDER_SEED, 2, 2, 14, transfers, null, null, false, false, null);

        System.out.println("Transaction sent!\nhttps://devnet.thetangle.org/address/" + RECIPIENT_ADDRESS);
    }
}