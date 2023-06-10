package org.yeonfish.engin;

import java.util.ArrayList;
import java.util.List;

public class Keygenerator {

    private int sampleNum = 1000;

    public Keygenerator() {}

    public int getPubkey() {
        int q = getPrime(this.sampleNum);
        int p = getPrime(q-1);
        int n = p*q;
        int On = (p-1)*(q-1);

        int e = 2;

        while ((e < On) && (gcd(e, On) != 1)) {
            e++;
        }

        return e;
    }

    private static int getPrime(int max) {
        ArrayList<Integer> avoidList = new ArrayList<Integer>();
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        primeList.add(1);
        for (int i=1;i<max;i++) {
            if (!avoidList.contains(i+1)) {
                primeList.add(i + 1);
                for (int j = 1; (i + 1) * j <= max; j++)
                    avoidList.add((i + 1) * j);
            }
        }
        return primeList.get(primeList.toArray().length-1);
    }

    private static int gcd(int n1, int n2) {
        while (n2 != 0) {
            n1 = n2;
            n2 = n1%n2;
        }

        return n1;
    }
}
