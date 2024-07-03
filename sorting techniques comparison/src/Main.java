import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;



public class Main {
    static public void count_sort(int[] arr) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        int max = arr[0];
        int counter=0;
        // Find the max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Initialize freq array
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // Count occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
            counter++;
        }
        System.out.println("Array before sort: " + Arrays.toString(arr));
        System.out.println("Frequency array: " + Arrays.toString(count));

        // store cumulative sum in freq array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            counter++;
        }
        // output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
            counter++;
        }
        // Copy sorted elements to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);

        System.out.println("Array after sort: " + Arrays.toString(arr));
        System.out.println();
        System.out.println("counter : "+counter);
    }

    static void BubbleSorting  (int []arr){
        int n =arr.length;
        int temp=0;
        int count=0;
        boolean flag;
        for(int i =0;i<n-1;i++) {
             flag=true;
            for(int j=0 ;j<n-i-1;j++){
                if(arr[j]>arr[j+1])  {
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=false;
                    count++;
                    System.out.println(Arrays.toString(arr));
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println();
        System.out.println("counter : "+count);

    }

    static int counter;
    static public int partition1(int arr[],int l,int h){
        int i=l;
        int j=h;
        int pivot_location =l;

        while (true) {
            while (arr[pivot_location] <=arr[j] && pivot_location!=j){
                j--;
            }
            if (pivot_location==j) {
                break;
            } else if (arr[pivot_location]>arr[j]) {
                int temp=arr[j];
                arr[j]=arr[pivot_location];
                arr[pivot_location]=temp;
                pivot_location=j;
                System.out.println(Arrays.toString(arr));
                counter++;
            }

            while (arr[pivot_location] >= arr[i] && pivot_location!=i){
                i++;
            }
            if (pivot_location==i) {
                break;
            } else if (arr[pivot_location]<arr[i]) {
                int temp=arr[i];
                arr[i]=arr[pivot_location];
                arr[pivot_location]=temp;
                pivot_location=i;
                System.out.println(Arrays.toString(arr));
                counter++;
            }

        }
        return pivot_location;
    }


    static public void quick_sort1(int arr[],int l,int h){
         if (l<h) {
            int piv= partition1(arr, l, h);
            quick_sort1(arr,l,piv-1);
            quick_sort1(arr,piv+1,h);
        }

    }

    public static void main(String[] args) {
        Random random=new Random();
        DecimalFormat numberFormat = new DecimalFormat("#0.000000000");
        Scanner sc=new Scanner(System.in);
        int[] a_sorted =new int[10];
        int[] x_sorted =new int[10];
        int[] y_sorted =new int[10];
        int[] b_reversed =new int[10];
        int[] d_reversed =new int[10];
        int[] e_reversed =new int[10];
        int[] c_random =new int[10];
        int[] m_random =new int[10];
        int[] n_random =new int[10];

        for (int i=0;i<a_sorted.length;i++) {
            a_sorted[i]=i;
        }

        for (int i=0;i<b_reversed.length;i++) {
            b_reversed[i]=b_reversed.length-i-1;
        }

        for (int i=0;i<c_random.length;i++) {
            c_random[i]=  random.nextInt(10);
        }

        System.out.println("choose 1 for specific operation");
        System.out.println("choose 2 for Full comparison");
        int num0= sc.nextInt();

        if (num0==1) {
            System.out.println("choose array type :");
            System.out.println("choose 1 for sorted array ");
            System.out.println("choose 2 for reversed array ");
            System.out.println("choose 3 for random array ");
            int arraynum= sc.nextInt();

            System.out.println( );

            System.out.println("choose sort type :");
            System.out.println("choose 1 for linear sort (counting-sort) ");
            System.out.println("choose 2 for bubble sort ");
            System.out.println("choose 3 for quick sort ");
            int sortnum= sc.nextInt();

            if(arraynum==1){
                if (sortnum==1) {
                    System.out.println();
                    long startTime1 = System.nanoTime();
                    count_sort(a_sorted);
                    long stopTime1 = System.nanoTime();
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime1 - startTime1)*Math.pow(10,-9))+" second");
                } else if (sortnum==2) {
                    System.out.println("array before sort"+Arrays.toString(a_sorted));
                    System.out.println();
                    long startTime2 = System.nanoTime();
                    BubbleSorting(a_sorted);
                    long stopTime2 = System.nanoTime();
                    System.out.println( );
                    System.out.println("array after sort"+Arrays.toString(a_sorted));
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime2 - startTime2)*Math.pow(10,-9))+"second");
                } else if (sortnum==3) {
                    System.out.println("array before sort"+Arrays.toString(a_sorted));
                    System.out.println();
                    long startTime9 = System.nanoTime();
                    quick_sort1(a_sorted,0, a_sorted.length-1);
                    long stopTime9 = System.nanoTime();
                    System.out.println( );
                    System.out.println("array after sort"+Arrays.toString(a_sorted));
                    System.out.println();
                    System.out.println("counter to make pivots in right places : "+counter);
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime9 - startTime9)*Math.pow(10,-9))+"second");
                }
            } else if (arraynum==2) {
                if (sortnum==1) {
                    System.out.println();
                    long startTime1 = System.nanoTime();
                    count_sort(b_reversed);
                    long stopTime1 = System.nanoTime();
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime1 - startTime1)*Math.pow(10,-9))+" second");
                } else if (sortnum==2) {
                    System.out.println("array before sort"+Arrays.toString(b_reversed));
                    System.out.println();
                    long startTime2 = System.nanoTime();
                    BubbleSorting(b_reversed);
                    long stopTime2 = System.nanoTime();
                    System.out.println( );
                    System.out.println("array after sort"+Arrays.toString(b_reversed));
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime2 - startTime2)*Math.pow(10,-9))+"second");
                } else if (sortnum==3) {
                    System.out.println("array before sort"+Arrays.toString(b_reversed));
                    System.out.println();
                    long startTime9 = System.nanoTime();
                    quick_sort1(b_reversed,0, b_reversed.length-1);
                    long stopTime9 = System.nanoTime();
                    System.out.println( );
                    System.out.println("array after sort"+Arrays.toString(b_reversed));
                    System.out.println();
                    System.out.println("counter to make pivots in right places : "+counter);
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime9 - startTime9)*Math.pow(10,-9))+"second");
                }
            } else if (arraynum == 3) {
                if (sortnum == 1) {
                    System.out.println();
                    long startTime1 = System.nanoTime();
                    count_sort(c_random);
                    long stopTime1 = System.nanoTime();
                    System.out.println();
                    System.out.println("time: " + numberFormat.format((stopTime1 - startTime1) * Math.pow(10, -9)) + " second");
                } else if (sortnum == 2) {
                    System.out.println("array before sort"+Arrays.toString(c_random));
                    System.out.println();
                    long startTime2 = System.nanoTime();
                    BubbleSorting(c_random);
                    long stopTime2 = System.nanoTime();
                    System.out.println( );
                    System.out.println("array after sort"+Arrays.toString(c_random));
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime2 - startTime2)*Math.pow(10,-9))+"second");
                } else if (sortnum == 3) {
                    System.out.println("array before sort"+Arrays.toString(c_random));
                    System.out.println();
                    long startTime9 = System.nanoTime();
                    quick_sort1(c_random,0, c_random.length-1);
                    long stopTime9 = System.nanoTime();
                    System.out.println( );
                    System.out.println("array after sort"+Arrays.toString(c_random));
                    System.out.println();
                    System.out.println("counter to make pivots in right places : "+counter);
                    System.out.println();
                    System.out.println("time: "+numberFormat.format((stopTime9 - startTime9)*Math.pow(10,-9))+"second");
                } else {
                    System.out.println("try again and choose right operation ");
                    System.exit(0);
                }
            } else {
                System.out.println("try again and choose right operation ");
                System.exit(0);
            }
        } else if (num0==2) {
            System.arraycopy(a_sorted, 0, x_sorted, 0, x_sorted.length);
            System.arraycopy(a_sorted, 0, y_sorted, 0, y_sorted.length);
            System.arraycopy(b_reversed, 0, d_reversed, 0, d_reversed.length);
            System.arraycopy(b_reversed, 0, e_reversed, 0, e_reversed.length);
            System.arraycopy(c_random, 0, m_random, 0, m_random.length);
            System.arraycopy(c_random, 0, n_random, 0, n_random.length);

            cmparison(a_sorted,x_sorted,y_sorted,b_reversed,d_reversed,e_reversed,c_random,m_random,n_random);
        }else {
            System.out.println("try again and choose right operation ");
            System.exit(0);
        }







    }

    static public void cmparison(int[]a_sorted,int[]x_sorted,int[]y_sorted,int [] b_reversed,int [] d_reversed,int [] e_reversed,int []c_random,int []m_random,int []n_random){
        DecimalFormat numberFormat = new DecimalFormat("#0.000000000");

        System.out.println("sorted array :");

        System.out.println("counting sort (linear sort) :");
        System.out.println();
        long startTime1 = System.nanoTime();
        count_sort(a_sorted);
        long stopTime1 = System.nanoTime();
        System.out.println( );
        System.out.println("time: "+numberFormat.format((stopTime1 - startTime1)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("bubble sort:");
        System.out.println("array before sort"+Arrays.toString(x_sorted));
        System.out.println();
        long startTime2 = System.nanoTime();
        BubbleSorting(x_sorted);
        long stopTime2 = System.nanoTime();
        System.out.println( );
        System.out.println("array after sort"+Arrays.toString(x_sorted));
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime2 - startTime2)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("quick sort:");
        System.out.println("array before sort"+Arrays.toString(y_sorted));
        System.out.println();
        long startTime3 = System.nanoTime();
        quick_sort1(y_sorted,0, y_sorted.length-1);
        long stopTime3 = System.nanoTime();
        System.out.println( );
        System.out.println("array after sort"+Arrays.toString(y_sorted));
        System.out.println();
        System.out.println("counter to make pivots in right places : "+counter);
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime3 - startTime3)*Math.pow(10,-9))+"second");
        System.out.println( );

        System.out.println("reversed array:");

        System.out.println("counting sort (linear sort) :");

        long startTime4 = System.nanoTime();
        count_sort(b_reversed);
        long stopTime4 = System.nanoTime();
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime4 - startTime4)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("bubble sort:");
        System.out.println("array before sort"+Arrays.toString(d_reversed));
        System.out.println();
        long startTime5 = System.nanoTime();
        BubbleSorting(d_reversed);
        long stopTime5 = System.nanoTime();
        System.out.println( );
        System.out.println("array after sort"+Arrays.toString(d_reversed));
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime5 - startTime5)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("quick sort:");
        System.out.println("array before sort"+Arrays.toString(e_reversed));
        System.out.println();
        long startTime6 = System.nanoTime();
        quick_sort1(e_reversed,0, e_reversed.length-1);
        long stopTime6 = System.nanoTime();
        System.out.println( );
        System.out.println("array after sort"+Arrays.toString(e_reversed));
        System.out.println();
        System.out.println("counter to make pivots in right places : "+counter);
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime6 - startTime6)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("random array:");

        System.out.println("counting sort (linear sort) :");
        System.out.println();
        long startTime7 = System.nanoTime();
        count_sort(c_random);
        long stopTime7 = System.nanoTime();
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime7 - startTime7)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("bubble sort:");
        System.out.println("array before sort"+Arrays.toString(m_random));
        System.out.println();
        long startTime8 = System.nanoTime();
        BubbleSorting(m_random);
        long stopTime8 = System.nanoTime();
        System.out.println( );
        System.out.println("array after sort"+Arrays.toString(m_random));
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime8 - startTime8)*Math.pow(10,-9))+"second");

        System.out.println();
        System.out.println();

        System.out.println("quick sort:");

        System.out.println("array before sort"+Arrays.toString(n_random));
        System.out.println();
        long startTime9 = System.nanoTime();
        quick_sort1(n_random,0, n_random.length-1);
        long stopTime9 = System.nanoTime();
        System.out.println( );
        System.out.println("array after sort"+Arrays.toString(n_random));
        System.out.println();
        System.out.println("counter to make pivots in right places : "+counter);
        System.out.println();
        System.out.println("time: "+numberFormat.format((stopTime9 - startTime9)*Math.pow(10,-9))+"second");
    }

}