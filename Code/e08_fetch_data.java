/*
This example fetches and prints a multi-transaction message.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;
import org.iota.jota.model.Transaction;
import org.iota.jota.utils.TrytesConverter;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

public class e08_fetch_data {
    public static String RECIPIENT_ADDRESS = "DLFRZGLWXZISBBJTLFCXVBCQBQKZZ9QKIYVPABXOIPUR9LB9CVGEGQSC9RQSJCMTTFHXSNHPKZXABGVGYAETJYRDPC";

    public static void main(String[] args) throws MalformedURLException {
        String full_message = "";

        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        List<Transaction> transactionList = iotaAPI.findTransactionObjectsByAddresses(new String[] {RECIPIENT_ADDRESS});

        //Bubble sort by current index to get the trytes in the correct order.
        for(int i = 0; i < transactionList.size(); i++)
            for(int j = 1; j < transactionList.size() - i; j++)
                if(transactionList.get(j - 1).getCurrentIndex() > transactionList.get(j).getCurrentIndex()) Collections.swap(transactionList, j - 1, j);

        for(int i = 0; i < transactionList.size(); i++) full_message += transactionList.get(i).getSignatureFragments();

        System.out.println("Received message:");
        System.out.println(TrytesConverter.trytesToAscii(full_message));
    }
}