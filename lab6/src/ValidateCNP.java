/*
 * Write a program that validates a Romanian Personal Numerical Code (CNP) and
 * throws appropriate exceptions in case of errors.
 */

import java.util.Scanner;

public class ValidateCNP {
    private String CNP = "";
    public boolean isValid() {
        final String regex = "^[1-9]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)(00[1-9]|0[1-9]\\d|[1-9]\\d\\d)\\d$";
        return CNP.matches(regex);
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}

class CNPDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a CNP to validate: ");
        ValidateCNP CNP = new ValidateCNP();
        CNP.setCNP(in.next());
    }
}

class CNPError extends Throwable {

}
