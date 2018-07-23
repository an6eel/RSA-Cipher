
package crypto;

import java.math.BigInteger;
import java.security.SecureRandom;


/**
 *
 * @author Angel Garcia Malagon
 */
public class Rsa {
    private final static BigInteger one=new BigInteger("1");
    private final static SecureRandom random=new SecureRandom();
    
    private RSAKey publickey;
    private RSAKey privatekey;
    
    public Rsa(){
        BigInteger p=BigInteger.probablePrime(256, random);
        BigInteger q=BigInteger.probablePrime(256, random);
        
        while(p==q)
            q=BigInteger.probablePrime(256, random);
        
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        BigInteger mod=p.multiply(q);
        BigInteger pub=new BigInteger("65537");
        BigInteger priv=pub.modInverse(phi);
        
        publickey=new RSAKey(pub,mod);
        privatekey=new RSAKey(priv,mod);
    }
    
    public RSAKey getPublicKey(){
        return publickey;
    }
    
    RSAKey getPrivateKey(){
        return privatekey;
    }
    
    public BigInteger encrypt(String msg) {
        byte[] bytes=msg.getBytes();
        BigInteger message=new BigInteger(bytes);
        return message.modPow(publickey.getExponent(), publickey.getModulus());
        
    }
    
    public String decrypt(BigInteger decr) {
        BigInteger mess=decr.modPow(privatekey.getExponent(), privatekey.getModulus());
        return new String(mess.toByteArray());
    }
    
}
