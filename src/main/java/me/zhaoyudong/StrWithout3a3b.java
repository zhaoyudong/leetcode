package me.zhaoyudong;

public class StrWithout3a3b {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        char a = 'a';
        char b = 'b';

        if (A < B) {
            int tmp = B;
            B = A;
            A = tmp;

            char t = b;
            b = a;
            a = t;
        }

        while (A > 0 || B > 0) {
            if (A > 0) {
                sb.append(a);
                A--;
            }

            if (A > B) {
                sb.append(a);
                A--;
            }

            if (B > 0) {
                sb.append(b);
                B--;
            }
        }

        return sb.toString();
    }

}
