package com.string;


public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
    public static String addBinary(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;
        byte[] aa = a.getBytes();
        byte[] bb = b.getBytes();
        byte flag = 0;
        while (al >= 0 || bl >= 0) {
            int i;
            if (al >= 0 && bl >= 0) {
                i = aa[al] - 48 + bb[bl]  + flag;
            } else if (al >= 0) {
                i = aa[al] + flag;
            } else {
                i = bb[bl] + flag;
            }
            flag = 0;
            if (i >= 50) {
                flag = 1;
                i -= 2;
            }
            if (al > bl) aa[al] =(byte)i;
            else bb[bl]=(byte)i;
            al--;
            bl--;
        }
        if (al > bl) {
            return flag == 0 ? new String(aa) : 1 + new String(aa);
        }
        return flag == 0 ? new String(bb) : 1 + new String(bb);
    }
}
