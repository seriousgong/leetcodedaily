package leetcode.exam;

public class question1 {

    public static void main(String[] args) {
        question1 q = new question1();
        System.out.println(q.calculate("AB"));
    }

    /*"A" 运算：使 x = 2 * x + y；
"B" 运算：使 y = 2 * y + x。*/
    public int calculate(String s) {

        int x = 1;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    x = 2 * x + y;
                    break;
                case 'B':
                    y = 2 * y + x;

            }
        }
        return x + y;
    }


}
