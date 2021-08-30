package algorithm.string;

/**
 * 克努特—莫里斯—普拉特操作(KMP算法)
 * 字符串匹配算法
 * KMP算法的核心是利用匹配失败后的信息,尽量减少模式串与主串的匹配次数以达到快速匹配的目的
 */
public class KnuthMorrisPratt {
    private int kmp(String string, String pattern) {
        char[] str = string.toCharArray();
        char[] pat = pattern.toCharArray();
        int[] next = new int[pattern.length()];
        getNext(next, pat);
        int i = 0;
        int j = 0;
        while (i < str.length && j < pat.length) {
            if (j == -1 || str[i] == pat[j]) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if (j == pat.length)
            return i - j;
        else
            return -1;
    }

    private void getNext(int[] next, char[] pattern) {
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < pattern.length - 1) {
            if (k == -1 || pattern[j] == pattern[k]) {
                j++;
                k++;
                if (pattern[j] == pattern[k])
                    next[j] = next[k];
                else
                    next[j] = k;
            } else
                k = next[k];

        }
    }

    public void test() {
        String str = "ABABABAABABAAABABAA";
        String pat =        "ABABAAABABAA";
        int position = kmp(str, pat);
        if (position != -1)
            System.out.println("子串的位置在:" + position);
        else
            System.out.println("子串在主串中不存在!");
    }
}
