
public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double a2 = legA * legA;
        double b2 = legB * legB;
        double legC = Math.sqrt(a2 + b2);
        return legC;
    }
}