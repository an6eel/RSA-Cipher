/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.math.BigInteger;

/**
 *
 * @author angel
 */
public class RSAKey {
    private BigInteger exponent;
    private BigInteger modulus;
    
    public RSAKey(BigInteger exp,BigInteger mod){
        exponent=exp;
        modulus=mod;
    }
    
    public BigInteger getModulus(){
        return modulus;
    }
    
    public BigInteger getExponent(){
        return exponent;
    }
    
}
