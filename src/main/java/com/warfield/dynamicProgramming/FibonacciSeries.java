package com.warfield.dynamicProgramming;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciSeries {

    /*
    [KOJAYAKU-M-J0M4:/Users/kojayaku/Documents/Koushik/intelij/warfield/target/classes]$ java -Xmx2g -Xss1g com.warfield.dynamicProgramming.FibonacciSeries
Find fibonacci for :
12121
1564207954060
1564207954040
12,121th Fibonacci series is :6,161,727,215,149,637,877,536,484,678,776,810,269,358,790,084,711,623,556,384,579,549,085,471,834,154,377,023,515,165,652,325,105,466,836,083,845,212,361,621,269,069,963,547,557,890,288,367,885,204,994,842,824,408,821,336,704,727,103,545,752,899,944,217,500,781,336,871,885,530,449,105,591,592,094,814,218,838,154,588,001,603,319,386,789,235,445,485,314,214,818,027,956,154,294,366,165,723,740,839,584,322,217,287,419,784,546,915,586,436,588,862,245,043,334,889,596,324,243,373,117,974,973,004,894,421,122,489,171,585,234,217,991,935,259,380,910,314,264,743,780,293,534,787,390,619,407,572,423,367,511,430,708,720,548,276,601,551,458,436,220,145,713,734,052,216,195,352,179,290,386,210,234,041,294,482,849,243,950,450,853,369,318,816,119,845,257,642,494,534,033,787,760,161,797,813,666,331,661,718,281,431,096,829,710,442,461,755,607,559,005,383,199,343,339,674,019,550,789,402,291,416,869,339,824,889,730,870,463,869,545,402,306,729,075,689,781,249,859,219,840,168,885,089,931,348,920,637,930,077,691,880,750,062,091,992,368,931,679,704,557,679,636,185,049,528,918,141,641,256,795,035,766,860,804,012,211,431,612,042,200,642,183,465,999,426,106,039,970,861,366,470,981,551,093,531,912,086,050,265,528,393,258,250,707,810,409,674,212,395,599,044,626,200,682,159,691,011,793,743,949,032,559,537,040,473,388,521,855,826,588,126,632,100,506,651,702,860,778,904,330,071,798,864,936,866,656,702,114,208,867,315,163,852,061,889,976,159,760,025,336,589,080,325,900,459,933,841,758,538,757,457,662,601,084,730,038,354,928,330,144,076,570,337,013,196,423,983,616,090,371,569,288,382,643,308,425,982,135,067,675,912,782,492,381,540,196,087,280,903,623,756,791,005,070,911,544,904,225,463,312,101,879,773,573,091,825,075,121,696,626,392,684,017,088,925,416,958,109,268,919,826,046,877,981,802,900,404,099,172,683,052,750,229,001,210,940,824,632,067,167,356,602,813,962,361,639,367,216,996,332,796,737,816,957,298,558,644,466,833,359,277,601,943,453,279,850,572,700,517,210,003,337,140,251,605,837,589,496,361,594,200,313,725,853,442,801,315,749,180,021,019,251,573,446,435,938,931,143,680,753,104,157,686,846,237,834,584,188,618,654,352,018,831,738,052,488,983,927,712,634,185,253,553,712,039,472,323,642,734,801,229,498,046,758,948,084,247,229,731,354,987,389,043,613,349,591,904,839,627,976,791,189,371,049,859,236,263,235,263,853,685,255,304,073,426,275,529,218,547,767,165,305,443,594,504,160,976,126,119,083,792,549,984,265,992,029,104,495,889,932,880,227,396,254,721,725,951,685,443,920,493,719,734,586,527,417,226,909,203,150,938,771,267,941,977,322,736,806,545,375,369,653,681,901,226,611,718,741,246,860,168,614,292,019,153,640,634,969,106,741,395,131,218,328,821,981,772,820,787,701,566,721,576,795,578,483,648,689,661,824,627,415,791,470,862,451,680,553,829,663,392,768,632,911,417,813,814,997,510,242,902,372,598,683,547,009,114,270,273,934,349,449,767,789,403,255,178,554,788,163,219,433,102,793,104,191,892,828,214,893,986,308,136,170,323,599,189,087,370,792,534,776,002,111,914,939,178,343,542,178,346,471,305,031,510,335,090,484,306,559,695,944,334,702,824,457,631,794,061,926,898,796,184,152,772,397,674,368,364,080,551,130,898,367,517,702,321,210,568,345,087,710,245,693,345,990,626,709,474,499,858,252,479,654,825,219,493,456,033,194,621,020,508,997,715,975,987,942,696,008,241,746,153,217,334,169,468,496,751,129,589,009,408,397,391,706,136,138,567,055,020,832,843,921
Total time taken using dynamic programming :20ms
[KOJAYAKU-M-J0M4:/Users/kojayaku/Documents/Koushik/intelij/warfield/target/classes]$ java -Xmx2g -Xss1g com.warfield.dynamicProgramming.FibonacciSeries
Find fibonacci for :
500
1564207978435
1564207978433
500th Fibonacci series is :139,423,224,561,697,880,139,724,382,870,407,283,950,070,256,587,697,307,264,108,962,948,325,571,622,863,290,691,557,658,876,222,521,294,125
Total time taken using dynamic programming :2ms
[KOJAYAKU-M-J0M4:/Users/kojayaku/Documents/Koushik/intelij/warfield/target/classes]$
     */
    public static void main(String[] args) {
        Map<BigInteger,BigInteger> memoize = new HashMap<BigInteger, BigInteger>();
        memoize.put(BigInteger.ZERO,BigInteger.ZERO);
        memoize.put(BigInteger.ONE,BigInteger.ONE);
        memoize.put(BigInteger.valueOf(2),BigInteger.ONE);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Find fibonacci for :");
        BigInteger input = scanner.nextBigInteger();
        long startTime=System.currentTimeMillis();
        System.out.print("1\t1\t");
        BigInteger result=findFibonacci(input,memoize);
        long endTime=System.currentTimeMillis();
        System.out.println(MessageFormat.format("\n{0}th Fibonacci series is :{1}",input,result));
        //System.out.println(memoize.values().toString());
        System.out.println(MessageFormat.format("Total time taken using dynamic programming :{0}ms",endTime-startTime));

        System.out.println("input for bottom up :");
        System.out.println("\nResult ::"+botttomUpApproach(scanner.nextInt()));
    }

    private static BigInteger findFibonacci(BigInteger input, Map<BigInteger, BigInteger> memoize) {
        if(memoize.get(input)!=null){
            return memoize.get(input);
        }
        BigInteger res = findFibonacci(input.subtract(BigInteger.ONE),memoize).add(findFibonacci(input.subtract(BigInteger.valueOf(2)),memoize));
        System.out.print(res+"\t");
        memoize.put(input,res);
        return res;
    }

    private static long botttomUpApproach(int input){
        long[] fibSeries = new long[input+1];
        fibSeries[0] = 0L;
        fibSeries[1] = 1L;
        fibSeries[2] = 1L;
        System.out.print(fibSeries[0]+"\t"+fibSeries[1]+"\t");
        for (int i=3;i<input+1;i++){
            fibSeries[i] = fibSeries[i-1]+fibSeries[i-2];
            System.out.print(fibSeries[i]+"\t");
        }
        return fibSeries[input];

    }
}
