package Test.com.lsf;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        a = Arrays.copyOf(a,4);
        System.out.println(a.length);
        for (int b:a){
            System.out.println(b);
        }
    }
}
