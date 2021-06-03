package algorithm.others;

/**
 * 二进制中1的个数
 */
public class TheNumberOf1InBinarySystem {
    //n&(n-1) 位运算可以将 n 的位级表示中最低的那一位 1 设置为 0。不断将 1 设置为 0，直到 n 为 0。
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
    public void test(){
        System.out.println(NumberOf1(1111));
    }
}
