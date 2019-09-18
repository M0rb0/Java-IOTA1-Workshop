/*
This example generates an address with a default security level of 2
for a given seed. This is the first available, unused address for this seed.
*/
import org.iota.jota.IotaAPI;
import org.iota.jota.builder.AddressRequest;
import org.iota.jota.connection.Connection;
import org.iota.jota.connection.HttpConnector;
import org.iota.jota.dto.response.GetNewAddressResponse;

import java.net.MalformedURLException;

public class e04_generate_address {
    public static String TEST_SEED = "BESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEEDTESTSEED9";

    public static void main(String[] args) throws MalformedURLException {
        Connection node = new HttpConnector("https", "nodes.devnet.iota.org", 443);
        IotaAPI iotaAPI = new IotaAPI.Builder().addNode(node).build();

        AddressRequest addressRequest = new AddressRequest.Builder(TEST_SEED, 2).checksum(true).addSpendAddresses(false).build();
        GetNewAddressResponse response = iotaAPI.generateNewAddresses(addressRequest);

        System.out.println("Generated address: " + response.getAddresses().get(0) + "\nGo to https://faucet.devnet.iota.org and paste this address here to receive devnet tokens.");
    }
}