package com.github.binodnme.hashing;

import com.lambdaworks.crypto.SCryptUtil;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Binod Shrestha <binodshrestha@lftechnology.com> on 4/26/17.
 */
public class Main {
    public static void main(String[] args) {
        scryptTest();
        bcryptTest();
    }

    private static void scryptTest() {
        System.out.println("--------------------scrypt---------------------------");
        String password = SCryptUtil.scrypt("password", 16384, 20, 10);
        System.out.println("hashed password: " + password );

        if (SCryptUtil.check("password", password)) {
            System.out.println("password matched");
        } else {
            System.out.println("password not matched");
        }
    }

    private static void bcryptTest() {
        System.out.println("--------------------bcrypt---------------------------");
        String salt = BCrypt.gensalt(10);
        System.out.println("salt => " + salt);

        String hash = BCrypt.hashpw("password", salt);
        System.out.println("hashed password => " + hash);

        if (BCrypt.checkpw("password", hash)) {
            System.out.println("password matched");
        } else {
            System.out.println("password not matched");
        }
    }
}
