package com.warfield.google.problems;

/*
def solution(x, y):
    x, y = int(x), int(y)
    # 'x' is for Mach Bombs
    # 'y' is for Facula Bombs
    cycles = 0
    # Counts the number of replication cycles
    while (x != 1 and y != 1):
        # If number of Mach bombs and Facula bombs are same
        # Then, It is impossible to replicate to the desired
        # Total number of bombs
        if x % y == 0:
            return "impossible"
        else:
            # cycles = cycles + 1
            # ABOVE ASSIGNMENT, CAUSES TWO TEST CASES TO FAIL
            # FOR EXAMPLE FOR 7/3 : 2 CYCLES ARE CONSUMED
            cycles = cycles+int(max(x, y)/min(x, y))
            x, y = max(x, y) % min(x, y), min(x, y)
    return str(cycles+max(x, y)-1)
 */

import java.math.BigInteger;

public class Bomb {
    public static void main(String[] args) {
        String result = solution("4","7");
        System.out.println(result);
    }

    private static String solution(String x, String y) {
        BigInteger m = new BigInteger(x);
        BigInteger f = new BigInteger(y);

        BigInteger cycles= new BigInteger(String.valueOf(0));
        while (!m.equals(BigInteger.ONE) && !f.equals(BigInteger.ONE)){
            if (m.mod(f).equals(BigInteger.ZERO)){
                return "impossible";
            }else{
                cycles=cycles.add(m.max(f).divide(m.min(f)));
                BigInteger x1=m.max(f).mod(m.min(f));
                BigInteger y1=m.min(f);
                m=x1;
                f=y1;
            }
        }
        return String.valueOf(cycles.add(m.max(f).subtract(BigInteger.ONE)));
    }
}
