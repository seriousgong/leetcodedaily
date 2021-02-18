package leetcode.oct;

public class day21 {
    public static void main(String[] args) {
        day21 d = new day21();
        System.out.println(d.isLongPressedName("alex", "aaleex"));
        System.out.println(d.isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(d.isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));

    }

    public boolean isLongPressedName(String name, String typed) {

        byte[] nb = name.getBytes();
        byte[] tb = typed.getBytes();
        int a = 0;
        int b = 0;
        while (a < nb.length && b < tb.length) {
            if (nb[a] != tb[b]) {
                if (a != 0 && tb[b] == tb[b - 1]) {
                    while (b < tb.length && tb[b] == tb[b - 1]) {
                        b++;
                    }
                    if (b >= tb.length||nb[a] != tb[b]) return false;
                    else {
                        a++;
                        b++;
                    }
                } else {
                    return false;
                }
            } else {
                a++;
                b++;
            }
        }
        if (b >= tb.length && a < nb.length) return false;
        else {
            for (int i = b; i < tb.length; i++) {
                if (tb[i] != tb[i - 1]) return false;
            }
        }
        return true;
    }
}
