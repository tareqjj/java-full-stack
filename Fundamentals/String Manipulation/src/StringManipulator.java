import java.lang.Integer;
public class StringManipulator {

    public String trimAndConcat(String str1, String str2){
        str1 = str1.trim();
        str2 = str2.trim();
         return str1.concat(str2);
    }

    public Integer getIndexOrNull(String str, char character) {
        int index = str.indexOf(character);
        if (index < 0) {
            return null;
        }
        return index;
    }

    public Integer getIndexOrNullofSubstring(String str, String subString) {
        int index = str.indexOf(subString);
        if(index < 0){
            return null;
        }
        return index;
    }

    public String concatSubstring(String str1, int start, int end, String str2){
        String subStr = str1.substring(start, end);
        return subStr.concat(str2);
    }

    public static void StringManipulatorTest(){
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str);
        System.out.println(manipulator.getIndexOrNull(str,'x'));
        System.out.println(manipulator.getIndexOrNullofSubstring(str,"World"));
        String word = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word);
    }

    public static void main(String[] args){
        StringManipulatorTest();
    }
}
