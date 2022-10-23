import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        String[] chaves = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "À", "Á", "Â", "Ã", "Ç", "È", "É", "Ê", "Ì", "Í", "Ò", "Ó", "Ô", "Õ", "Ù", "Ú", "Û", "à", "á", "â", "ã", "ç", "è", "é", "ê", "ì", "í", "î", "ò", "ó", "ô", "õ", "ù", "ú", "û"};
        for (int i = 1000; i <= 9999; i++) {

            for (String countX : chaves) {
                for (String countY : chaves) {
                  String secretKey = countX + countY;
                   // System.out.println(secretKey + " ||||| " + i);
                    try {
                        byte[] hmacSha256 = HMAC.calcHmacSha256(secretKey.getBytes("UTF-8"), String.valueOf(i).getBytes("UTF-8"));
                        //System.out.println(String.format("%064x", new BigInteger(1, hmacSha256)));
                        String X = String.format("%064x", new BigInteger(1, hmacSha256));
                        String Y = "32a4bcb76783dd96af829e9d175f98f33ac1543233425bb901943f98042caa36";
                        //System.out.println(X + "\n" + Y + "\n" + "secretKey = " + secretKey + "\nnum = " + i);
                        if (X.equals(Y)) {
                          //  System.out.println(X.equals(Y));
                            System.out.println(X + "\n" + Y + "\n" + "secretKey = " + secretKey + "\nnum = " + i);
                            System.exit(0);
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
