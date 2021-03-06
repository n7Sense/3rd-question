/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.Hex;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

/**
 *
 * @author nSense
 */
public class SHA256Hashing {

    /**
     * @param args the command line arguments
     */
    
    public static String HashWithJavaMessageDigest(final String originalString) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    public static String HashWithGuava(final String originalString) {
        final String sha256hex = Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
        return sha256hex;
    }

    public static String HashWithApacheCommons(final String originalString) {
        final String sha256hex = DigestUtils.sha256Hex(originalString);
        return sha256hex;
    }

    public static String HashWithBouncyCastle(final String originalString) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        final String sha256hex = new String(Hex.encode(hash));
        return sha256hex;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        String message = "hi this is my sharable unique key for decryption 4456789";
        System.out.println("HashWithJavaMessageDigest:\n"+HashWithJavaMessageDigest(message));
    }
    
}
