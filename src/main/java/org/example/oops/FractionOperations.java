package org.example.oops;

public class FractionOperations {
    private static Fraction addFractions(Fraction f1, Fraction f2){
        int f1n = f1.getNumerator();
        int f1d = f1.getDenominator();
        int f2n = f2.getNumerator();
        int f2d = f2.getDenominator();
        int lcm = f1d * f2d;
        Fraction sum = new Fraction();
        sum.setNumerator((lcm/f1d * f1n) + (lcm/f2d * f2n));
        sum.setDenominator(lcm);
        return sum;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        f1.setNumerator(3);
        f1.setDenominator(4);
        Fraction f2 = new Fraction();
        f2.setNumerator(2);
        f2.setDenominator(5);

        Fraction sum = new Fraction();
        sum = addFractions(f1, f2);

        System.out.println("fraction sum numerator: " + sum.getNumerator() + " and denominator is: " + sum.getDenominator());

    }
}
