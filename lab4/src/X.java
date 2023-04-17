class XDriver {
    public static void main(String[] args) {
        String str = "congratulations";
        X x = new X(new char[]{'h', 'e', 'y'}, str, 5);

        System.out.printf("x.chars: %s\n", (Object) x.getChars());
        System.out.printf("x.str: %s\n", x.getStr());
        System.out.printf("x.num: %d\n", x.getNum());

        String str2 = "rocks";
        X y = new X(new char[]{'j', 'a', 'v', 'a'}, str2, 10);

        System.out.printf("y.chars: %s\n", (Object) y.getChars());
        System.out.printf("y.str: %s\n", y.getStr());
        System.out.printf("y.num: %d\n", y.getNum());
    }
}

public class X {
    public char[] getChars() {
        return chars;
    }

    public String getStr() {
        return str;
    }

    public int getNum() {
        return num;
    }

    private char[] chars;
    protected String str = "";
    int num;

    public X(char[] chars, String str, int n) {
        this.chars = chars;
        this.str = str;
        num = n;
    }

    @Override
    protected void finalize() {
        System.err.println("X: finalize() called");
    }
}
