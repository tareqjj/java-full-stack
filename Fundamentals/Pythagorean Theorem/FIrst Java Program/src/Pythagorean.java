import java.lang.Math;
public class Pythagorean {
    public static double calculateHypotenuse(int legA, int legB) {
        double sum = Math.pow(legA, 2) + Math.pow(legB, 2);
        return Math.sqrt(sum);

    }
    public static void main(String[] args) {
        System.out.println(calculateHypotenuse(2,2));
    }
}
