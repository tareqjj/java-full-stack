import java.util.*;

public class PuzzleJava {

    public static ArrayList greaterThanten(){
        ArrayList list = new ArrayList();
        int[] arr = {3, 5, 1, 2, 7, 9, 8, 13, 25, 32};
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (arr[i] > 10 ){
                list.add(arr[i]);
            }
        }
        System.out.println(sum);
        return list;
    }

    public static ArrayList<String> stringsLongerThanFive() {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Nancy");
        arr.add("Jinichi");
        arr.add("Fujibayashi");
        arr.add("Momochi");
        arr.add("Ishikawa");
        Collections.shuffle(arr);
        System.out.println((arr));

        ArrayList<String> arr2 = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i).length() > 5){
                arr2.add(arr.get(i));
            }
        }
        return arr2;
    }

    public static void alphabet(){
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (char i = 'A'; i <= 'Z'; i++)
            charArray.add(i);

        Collections.shuffle(charArray);
        System.out.println(charArray.get(charArray.size()-1));
        System.out.println(charArray.get(0));

        List<Character> list = Arrays.asList('A', 'E', 'I', 'O', 'U');

        if (list.contains(charArray.get(charArray.size()-1))){
            System.out.println("Last element is a vowel");
        } else{
            System.out.println("Last element is not a vowel");
        }
    }

    public static int[] randArray(){
        Random rand = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(46) + 55;
        }
        return arr;
    }

    public static void randMinMax(){
        Random rand = new Random();
        ArrayList<Integer> randArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            randArray.add(rand.nextInt(46) + 55);
        }
        Collections.sort(randArray);
        System.out.println(randArray);
        System.out.println(randArray.get(0));
        System.out.println(randArray.get(randArray.size()-1));
    }

    public static void randString(){
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (char i = 'A'; i <= 'Z'; i++)
            charArray.add(i);

        Random rand = new Random();
        String str = "";
        for (int i = 0; i < 5; i++) {
            int randChar = rand.nextInt(26);
            str = str.concat(String.valueOf(charArray.get(randChar)));
        }
        System.out.println(str);
    }

    public static void fiveStrings(){
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (char i = 'A'; i <= 'Z'; i++)
            charArray.add(i);

        Random rand = new Random();
        String[] stringArray = new String[10];
        for (int i = 0; i < stringArray.length ; i++) {
            String str = "";
            for (int j = 0; j < 5; j++) {
                int randChar = rand.nextInt(26);
                str = str.concat(String.valueOf(charArray.get(randChar)));
            }
            stringArray[i] = str;
        }
        System.out.println(Arrays.toString(stringArray));
    }

    public static void main(String[] args){
        System.out.println(greaterThanten());
        System.out.println(stringsLongerThanFive());
        alphabet();
        System.out.println(Arrays.toString(randArray()));
        randMinMax();
        randString();
        fiveStrings();
    }
}
