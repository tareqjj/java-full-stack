import java.util.ArrayList;
import java.util.Arrays;
public class HelloWorld {
    public static void main(String[] args) {
        int[] myArray = {1,3,5,7,9,13};
        ArrayList<Integer> y = new ArrayList<Integer>();
        int[] arr4 = {1, 5, 10};
        int[] arr3 = {1, 5, 10};
        int[] arr2 = {1, 5, 10, -2};
        int[] arr = {1,3,5,7,9,13};
        int[] arr1 = {1,3,5,7,9,13};
        allNumbers();
        oddNumbers();
        sum();
        iterate(myArray);
        max(myArray);
        avg(myArray);
        oddNumbersArr(y);
        greaterThanY(arr4, 2);
        square(arr3);
        noNegatives(arr2);
        minMaxAvg(arr);
        shift(arr1);
    }
    public static void allNumbers(){
        for(int i = 1; i<=255; i++){
            System.out.println(i);
        }
    }
    public static void oddNumbers(){
        for(int i = 1; i<=255; i+=2){
            System.out.println(i);
        }
    }
    public static void sum(){
        int sum = 0;
        for(int i = 0; i<=255; i++){
            System.out.println("New number: "+i+" Sum: "+sum);
            sum += i;
        }
    }
    public static void iterate(int[] myArray){
        for(int i = 0; i<myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
    public static void max(int[] myArray){
        int max = myArray[0];
        for(int i = 0; i<myArray.length; i++){
            if (myArray[i] > max){
                max = myArray[i];
            }
        }
        System.out.println(max);
    }
    public static void avg(int[] myArray){
        double avg = 0;
        int sumArr = 0;
        for(int i = 0; i<myArray.length; i++){
            sumArr += myArray[i];
        }
        avg = sumArr/myArray.length;
        System.out.println(avg);
    }
    public static void oddNumbersArr(ArrayList<Integer> y){
        for(int i = 1; i<=255; i+=2){
            y.add(i);
        }
        System.out.println(y);
    }
    public static void greaterThanY(int[] arr4, int y){
        int counter = 0;
        for(int i = 0; i<arr4.length; i++){
            if (arr4[i] > y){
                counter ++;
            }
        }
        System.out.println(counter);
    }
    public static void square(int[] arr3){
        for(int i = 0; i<arr3.length; i++){
            arr3[i] = arr3[i]*arr3[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
    public static void noNegatives(int[] arr2){
        for(int i = 0; i<arr2.length; i++){
            if (arr2[i] < 0){
                arr2[i] = 0;
            }
            System.out.println(Arrays.toString(arr2));
        }
    }
    public static void minMaxAvg(int[] arr){
            int max = arr[0];
            int min = arr[0];
            int sum = 0;
            float avg = 0;
            for(int i = 0; i<arr.length;i++){
                if(arr[i]>max){
                    max=arr[i];
                }
                if(arr[i]<min){
                    min=arr[i];
                }
                sum += arr[i];
            }
            avg = sum/arr.length;
            System.out.println(max +" " + min+" "+ avg);
        }
    public static void shift(int [] arr1){
        for(int i=1;i<arr1.length;i++){
            arr1[i-1] = arr1[i];
        }
        arr1[arr1.length-1] = 0;
        System.out.println(Arrays.toString(arr1));
    }
}