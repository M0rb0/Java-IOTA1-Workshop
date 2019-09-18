/*
This example fetches and prints transactions for a given address.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;
import org.iota.jota.model.Transaction;
import org.iota.jota.utils.TrytesConverter;

import java.net.MalformedURLException;
import java.util.List;

public class e03_fetch_hello {
    public static String RECIPIENT_ADDRESS = "BESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESSTESTADDRESS99";

    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        List<Transaction> transactionList = iotaAPI.findTransactionObjectsByAddresses(new String[] {RECIPIENT_ADDRESS});

        for(int i = 0; i < transactionList.size(); i++) {
            if(transactionList.get(i).getSignatureFragments().length() % 2 == 1) System.out.println("Message " + (i + 1) + ": " + TrytesConverter.trytesToAscii(transactionList.get(i).getSignatureFragments() + "9"));
            else System.out.println("Message " + (i + 1) + ": " + TrytesConverter.trytesToAscii(transactionList.get(i).getSignatureFragments()));
        }
    }
}