/*
This example creates a data transaction split over multiple messages.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;
import org.iota.jota.model.Transfer;
import org.iota.jota.utils.TrytesConverter;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class e07_send_data {
    public static String SENDER_SEED = "BESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEED9";
    public static String RECIPIENT_ADDRESS = "DLFRZGLWXZISBBJTLFCXVBCQBQKZZ9QKIYVPABXOIPUR9LB9CVGEGQSC9RQSJCMTTFHXSNHPKZXABGVGYAETJYRDPC";

    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        String message = "HIPPITY HOP, JAVA WORKSHOP. ";
        for(int i = 0; i < 70; i++) message += "HIPPITY HOP, JAVA WORKSHOP. ";

        List<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(RECIPIENT_ADDRESS, 0, TrytesConverter.asciiToTrytes(message), "IOTAWORKSHOP"));
        iotaAPI.sendTransfer(SENDER_SEED, 2, 2, 14, transfers, null, null, false, false, null);

        System.out.println("Data sent!\nhttps://devnet.thetangle.org/address/" + RECIPIENT_ADDRESS);
    }
}