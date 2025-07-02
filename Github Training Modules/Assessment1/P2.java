package GithubTrainingModules.Java.Assignment1;
import java.util.ArrayList;
class CheckArmstronginRange {

    public int[] armRange(int min, int max){
        ArrayList<Integer> armList = new ArrayList<>();

        for (int i=min; i<=max; i++){
            if (armstrongCheck(i)) {
                armList.add(i);
            }
        }

        int [] armArray = new int[armList];

        int i=0;
        for(Integer e:armList){
            armArray[i] = e;
            i++;
        }

        return armArray;
    }


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

public class P2 {
    public static void main(String[] args) {
        
    }
}
