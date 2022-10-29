package easy;

public class Palindrome {
    public static void main(String[] args) {
        String str = "ABC ECBA";

        Palindrome obj = new Palindrome();
        if(obj.checkPalindrome(str)) {
            System.out.println("String is Palindrome!");
        } else
            System.out.println("String is not Palindrome!");
    }

    boolean checkPalindrome(String str) {

        if(str.length() == 1 || str.length() == 0) {
            return true;
        }

        char start = str.charAt(0);
        char end = str.charAt(str.length() - 1);

        if(start == end) {
            return checkPalindrome(str.substring(1, str.length() - 1));
        } else
            return false;
    }
}
