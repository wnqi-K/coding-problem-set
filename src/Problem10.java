/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-17
 */

/**
 * Realize the power method in math library. the exponent can be pos or neg int.
 */
public class Problem10 {
    public static double power(int base, int exp){
        if(base == 0 &&  exp == 0){
            throw new RuntimeException("invalid New.Input. ");
        }

        if(base == 0){
            return 0;
        }

        if(exp == 0){
            return 1;
        }

        int absoluteExp;
        if(exp < 0){
            absoluteExp = -exp;
        }else{
            absoluteExp = exp;
        }

        double result = calculatePowerRec(base, absoluteExp);
        if(exp < 0){
            result = 1/result;
        }

        return result;
    }

    private static long calculatePower(int base, int absoluteExp) {
        if(absoluteExp == 1){
            return base;
        }

        long result = 1;
        for(int i = 0; i < absoluteExp; i++){
            result *= base;
        }
        return result;
    }

    // calculatePower using recursive method.
    private static long calculatePowerRec(int base, int absoluteExp){
        if(absoluteExp == 1){
            return base;
        }

        long result = calculatePowerRec(base, absoluteExp >> 1);
        result *= result;
        if(absoluteExp % 2 == 1){
            result *= base;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(power(2, 5));
        System.out.println(power(2, -5));
    }
}
