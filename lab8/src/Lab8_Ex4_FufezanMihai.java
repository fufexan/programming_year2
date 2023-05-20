/*
 * 4. You are given a binary file which contains a sequence of characters
 * representing a private Bitcoin key (256 characters). From the keyboard read
 * a sequence of characters which represents the public key for a Bitcoin.
 * Generate the transaction id for this information by using the XOR bitwise
 * operator applied upon the private and public keys. Write the result in
 * another binary file.
 */

import java.io.*;

public class Lab8_Ex4_FufezanMihai {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/bitcoin.key");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            char[] privateKey = bufferedReader.readLine().toCharArray();
            if (privateKey.length != 256) {
                System.err.println("Private key length must be 256 characters, but it is " + privateKey.length + " long!");
                bufferedReader.close();
                System.exit(1);
            }
            bufferedReader.close();

            InputStreamReader keyboardStreamReader = new InputStreamReader(System.in);
            BufferedReader keyboardBufferedReader = new BufferedReader(keyboardStreamReader);

            System.out.println("Enter the public key of your Bitcoin key pair:");
            char[] publicKey = keyboardBufferedReader.readLine().toCharArray();
            if (publicKey.length != 256) {
                System.err.println("Public key length must be 256 characters, but it is " + publicKey.length + " long!");
                keyboardBufferedReader.close();
                System.exit(1);
            }
            keyboardBufferedReader.close();

            char[] transactionID = new char[256];

            // perform XOR on the keys
            for (int i = 0; i < privateKey.length; i++) {
                transactionID[i] = (char) (privateKey[i] ^ publicKey[i]);
            }

            FileOutputStream fileOutputStream = new FileOutputStream("src/bitcoinTransaction.id");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(transactionID);
            System.out.println("The transaction id was written.");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
