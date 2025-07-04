

class CheckArmstrong {
    public static boolean armstrongCheck(int num){

        int n= num;
        int digits = 0;
        while (n>0) {
            digits++;
            n /=10;
        }

        int original = num;
        int sum =0;
        while(original>0){
            int singleDigit = original % 10;
            sum += power(singleDigit, digits);
            original /= 10;
        }

        if (num == sum) {
            return true;
        }
        else{
            return false;
        }



    }

    static int power (int base, int exponent){
        int result = 1;
        while (exponent >0){
            result *= base;
            exponent--;
        }
        return result;
    }
}

public class P1 {
    public static void main(String[] args) {
        System.out.println(CheckArmstrong.armstrongCheck(153));;
    }
}
