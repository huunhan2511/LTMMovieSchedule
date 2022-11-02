/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author huunh
 */
public class RSA {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    //hàm khởi tạo server
    public RSA(PrivateKey privateKey, PublicKey publicKey){
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }
    public RSA(PublicKey publicKey){
        this.publicKey = publicKey;
    }
    //Hàm khởi tạo client 
    public RSA(){
        
    }
    // trả về String tham số key dạng byte[]
    public String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    // trả về byte[] tham số key dạng String
    public byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }
    
    //Mã hóa chuỗi key cần (vd: key AES) // trả về kiểu String
    public String encrypt(String message) throws Exception{
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }
    //Giải mã chuỗi key cần (vd: key AES) // trả về kiểu String
    public String decrypt(String encryptedMessage) throws Exception{
        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage,"UTF8");
    }
}
