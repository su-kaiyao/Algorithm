
public class Solution {

    public static int sumDigits(int n) {
        int sum=0;
        while (n>0) {
            sum+=(n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        while (n >= 10) {
            n = sumDigits(n);
        }
        return n==1 || n==7;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}