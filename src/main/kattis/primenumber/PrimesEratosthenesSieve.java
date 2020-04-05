package kattis.primenumber;

import java.util.Vector;

class PrimesEratosthenesSieve
{
    static final int MAXN = 100001;

    // stores smallest prime factor for every number
    static int spf[] = new int[MAXN];

    // Calculating SPF (Smallest Prime Factor) for every
    static void sieve()
    {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)
              spf[i] = i;
          for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;
        for (int i=3; i*i<MAXN; i++)
        {
             if (spf[i] == i)
            {
                 for (int j=i*i; j<MAXN; j+=i)
                       if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }

    // A O(log n) function returning primefactorization
    // by dividing by smallest prime factor at every step
    static Vector<Integer> getFactorization(int x)
    {
        Vector<Integer> ret = new Vector<>();
        while (x != 1)
        {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }

}
