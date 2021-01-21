/*
This example creates a transaction with a custom message/tag.
The amount of iota specified in the "AMOUNT" variable will be transferred to the given address.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;
import org.iota.jota.dto.response.GetBalancesAndFormatResponse;
import org.iota.jota.model.Input;
import org.iota.jota.model.Transfer;
import org.iota.jota.utils.TrytesConverter;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class e06_send_tokens {
    public static String TEST_SEED = "BESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEED9";
    public static String RECIPIENT_ADDRESS = "RYQZZGLWXZISBBJTLFCXVBCQBQKZZ9QKIYVPABXOIPUR9LB9CVGEGQSC9RQSJCMTTFHXSNHPKZXABGVGYAETJYRDPC";
    public static long AMOUNT = 1;

    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        List<Input> inputList;
        List<Transfer> transfers = new ArrayList<>();

        GetBalancesAndFormatResponse response = iotaAPI.getInputs(TEST_SEED, 2, 0, 10, 100);
        inputList = new ArrayList<>(response.getInputs());

        transfers.add(new Transfer(RECIPIENT_ADDRESS, AMOUNT, TrytesConverter.asciiToTrytes("HERE IS YOUR " + AMOUNT + " IOTA!"), "JAVA9WORKSHOP"));
        iotaAPI.sendTransfer(TEST_SEED, 2, 2, 9, transfers, inputList, null, true, false, null);
        System.out.println("Transaction sent!\nhttps://devnet.thetangle.org/address/" + RECIPIENT_ADDRESS);
    }
}