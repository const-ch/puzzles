package kattis.primenumber;

import java.util.Scanner;

public class PrimesCacheOptimization {

    static int MAX_CACHE = 100000000;
    static int MAX_NUMBER = 1000000000;
    static int MIN_NUMBER = 2;

    static int[] cachedCalculations = initArrayOfCachedCalculations();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            int n = scan.nextInt();
            if (n == 4 || n < MIN_NUMBER || n > MAX_NUMBER)
                break;
            factorizeNumber(n , 0);
        }
        scan.close();
    }

    static void factorizeNumber(int numberToFactorize , int times) {

        times++;

        if (isPrime(numberToFactorize))
        {
            System.out.println(numberToFactorize + " " + times);
            return;
        }

        if(isCalculationCached(numberToFactorize)){ // checking if calculation already processed
            factorizeNumber(cachedCalculations[numberToFactorize] , times);
            return;
        }

        factorizeNumber(calculateSumOfFactorials(numberToFactorize) , times);
    }

    static int calculateSumOfFactorials(int numberToReduce){
        int n = numberToReduce;
        int sum = 0;
        int i = 2;
        while (true)
        {
            if (((i << 2)==0) && ((n&1) == 0))
            {
                n = n << 2;
                sum = sum + 2;
                if (isPrime(n))
                {
                    sum =sum + n;
                    recordResultToCache(numberToReduce,sum);
                    break;
                }
                i = 1;
            }
            else
                { if (n % i == 0)
                    {
                        n = n / i;
                        sum = sum + i;
                        if (isPrime(n))
                        {
                            sum =sum + n;
                            recordResultToCache(numberToReduce,sum);
                            break;
                        }
                        i = 1;
                    }
                }
            i++;
        }
        recordResultToCache(numberToReduce,sum);
        return sum;
    }



    static boolean isPrime(int n) {

        if( isInCacheRange(n) && isCachedAsPrime(n)){
            return true;
        }
        if ((n&1) == 0) { //fast binary operator
            return false;
        }
        int maximalMultiplier = (int)Math.sqrt(n);
        for (int i = 3; i <= maximalMultiplier; i += 2)
            if (n % i == 0)
                return false;

        recordResultToCache(n, n); //record as prime number
        return true;
    }

    private static int[] initArrayOfCachedCalculations() {
        int[] cachedArray = new int[MAX_CACHE];
        cachedArray[MIN_NUMBER] = MIN_NUMBER;
        return cachedArray;
    }

    private static boolean isCalculationCached(int numberToFactorize) {
        return isInCacheRange(numberToFactorize) && cachedCalculations[numberToFactorize]!=0;
    }

    private static void recordResultToCache(int numberToFactorize, int sumOfFactors) {
        if(isInCacheRange(numberToFactorize))
            cachedCalculations[numberToFactorize]=sumOfFactors;
    }

    static boolean isCachedAsPrime(int n) {
        return cachedCalculations[n] == n;
    }

    static boolean isInCacheRange(int n) {
        return n<MAX_CACHE;
    }

}
