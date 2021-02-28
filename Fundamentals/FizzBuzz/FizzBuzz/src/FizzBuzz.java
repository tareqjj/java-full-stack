public class FizzBuzz {
    public static String fizzBuzz(int number){
        if (number % 3 == 0 && number % 5 ==0){
            return "FizzBuzz";
        }
        if (number % 3 == 0){
            return "fizz";
        }
        if (number % 5 == 0){
            return "buzz";
        }
        else{
            int num =  fizzNum(number);
            return String.valueOf(num);
        }

    }

    public static int fizzNum(int number){
        return number;
    }

    public static void main(String[] args){
        System.out.println(fizzBuzz(1));

    }
}
