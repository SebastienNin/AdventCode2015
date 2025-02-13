package Day4;

import lombok.Getter;
import lombok.Setter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdventCoin  {

    @Getter
    @Setter
    private String secretKey;
    @Getter
    @Setter
    private String hashCode;
    @Getter
    @Setter
    private Integer incrementAnswer;

    public AdventCoin(String secretKey) throws NoSuchAlgorithmException {
        this.secretKey = secretKey;
        this.getCode();
    }

    public void getCode() throws NoSuchAlgorithmException {

        Integer increment = 0;
        boolean hashStartsWithFiveZeros = false;
        String hash = "";

        while (! hashStartsWithFiveZeros) {
            hash = computeHashWithIncrement(increment);


            if(hash.substring(0,6).equals("000000")){

                hashStartsWithFiveZeros = true;

            }else {

                increment++;

            }



        }

        this.incrementAnswer = increment;
        this.hashCode = hash;

    }

    public String computeHashWithIncrement(Integer increment) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        String input = this.getSecretKey() + increment;
        byte[] inputBytes = input.getBytes();
        byte[] hashBytes = md.digest(inputBytes);

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        String hashHex = sb.toString();

        return hashHex.substring(0, 6);

    }

}
