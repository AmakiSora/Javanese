package algorithm.string;
/**
 * 无重复字符的最长子串
 * 例:
 * "abcabcbb" 结果为 "abc"
 * "bbbbb"    结果为 "b"
 * "pwwkew"   结果为 "wke"
 */
public class LongestStringWithoutDuplicateCharacters {
    private void countDuplicateCharacters(String str){
        int[] last = new int[128];//只适合字母等ascii码较小的字符
        int position = 0;//子串开始位置
        int res = 0;//子串长度
        int start = 0;//窗口开始位置
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            start = Math.max(start, last[index]);
            if ((i - start + 1)>res){
                res = i - start + 1;
                position = start;
            }
            last[index] = i+1;
        }
        System.out.println("无重复字符的最长子串为:"+str.substring(position,position+res));
    }
    public void test(){
        String str = "pwwkew";
        countDuplicateCharacters(str);
    }
}
