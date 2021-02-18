package leetcode.nov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class day30 {
    public static void main(String[] args) {
//        System.out.println("ehehehehehehehehehehehehehehehehehehehehehehehehehehehehcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvafafafafafafafafafafafafafafafafafafafafafafywywywywywywywywywywywywywywywywywywywywywykukukukukukukukukukukukukukukukukukukukuksrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpgogogogogogogogogogogogogogogogogotitititititititititititititititibdbdbdbdbdbdbdbdbdbdbdbdbdbdbdbzjzjzjzjzjzjzjzjzjzjzjzlzlzlqlqlqlqlqlqlqlqlqq".length());
//        System.out.println("eweweweweweweweweweweweweweueueueueueueueueueueueueueueuhuhuhuhuhuhshshshshshshshshshshshshshshshshshshshphphphpcpcpcpcpcpcpcpcpcpcpcpcpcpcpcrcrcrcrcrcrcrcrcrcrcrcrmrmrmrmrmrmrmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmgmgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvovovovovovovovovonononononononononbnbnbnbnbnbnbnbnbnbnbnbnbnbnbabaiaiaiaiaiaiaiaiaiaiaiaiaiaiaiaiatatatatatftftftftftftftftftftftfdfdfdfdfdfdfdfdfdfdfdydydydydyzyzyzyzyzyzyzyzyzyzyzyzyzyzyjyjyjyjkjkjkjkjkjkjkjklklklklklklklklklklklkqkqkqwqwqwqwqwqwqwqwq".length());
//        System.out.println('q' - 'a');
        day30 d = new day30();
        System.out.println(d.reorganizeString("asafasfasfzxv"));
        System.out.println(d.reorganizeString("aab"));
        System.out.println(d.reorganizeString("aaab"));
        System.out.println(d.reorganizeString("abbabbaaab"));
//        System.out.println(d.reorganizeString("snnnnbpngobwznvnnnlnwhvnnnnfjnnlnnnnnnbnknnqkndzefncknnnnnaiqrntnndnnnjninnnunnunqhndnnqnnsjqnnpiqshntnnncnvnnnncnnqenlnninyndnnnljongnnjwnnnngllnnngkbnllnnnnontlbpngjnnenqnsnnnnnjeqqghnfpngepnodnnnnnnvnsrnughbnipvnhqmnzonoonnnjotnnonoennnpnfnnkdnnbmnmnpnqninnxronnnnvnlanlnnnebnnnlnvnfknsnbincnttnmnguqenhnnxunnnntnnnnhnqnzehvunfnvnndvnjnnnbnnpxnqipwnmnonnndlnsnonnninnxnnnjnnnnnesennmyiednnnnnnnnnhimtnnnonjlicnwnwvnntaxmnrntnnnnsnbnanninnecbcfjxncnnkvnnqgnunensanpnngjnzxjnopnnyvnnxskniyytnsnnnnx"));
//        System.out.println(d.reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao"));
//        System.out.println(d.reorganizeString("ehehehehehehehehehehehehehehehehehehehehehehehehehehehehcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmcmvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvnvafafafafafafafafafafafafafafafafafafafafafafywywywywywywywywywywywywywywywywywywywywywykukukukukukukukukukukukukukukukukukukukuksrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsrsxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpxpgogogogogogogogogogogogogogogogogotitititititititititititititititibdbdbdbdbdbdbdbdbdbdbdbdbdbdbdbzjzjzjzjzjzjzjzjzjzjzjzlzlzlqlqlqlqlqlqlqlqlqq"));
    }

    public String reorganizeString(String S) {
        int[] alphet = new int[26];
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            alphet[aChar - 'a']++;
        }
        int[] sort = new int[26];

        for (int i = 0; i < alphet.length; i++) {
            if (alphet[i] > S.length() / 2 + 1 || (S.length() % 2 == 0 && alphet[i] > S.length() / 2)) return "";
            sort[i] = i;
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return alphet[letter2 - 'a'] - alphet[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (alphet[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (queue.size() > 1) {
            Character a = queue.poll();
            Character b = queue.poll();
            stringBuilder.append(a).append(b);
            alphet[a - 'a']--;
            alphet[b - 'a']--;
            if (alphet[a - 'a'] > 0) {
                queue.offer(a);
            }
            if (alphet[b - 'a'] > 0) {
                queue.offer(b);
            }
        }
        if (queue.size() != 0) stringBuilder.append(queue.poll());
        return stringBuilder.toString();
    }


}
