package baitap;

public class Bai5{
    private int numerator; // Tử số
    private int denominator; // Mẫu số

    // Constructor
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Tối giản phân số khi tạo đối tượng
    }

    // Tối giản phân số bằng cách tìm GCD (Greatest Common Divisor)
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        // Đảm bảo mẫu số luôn dương
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Hàm tìm GCD
    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    // Nghịch đảo phân số
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    // Cộng hai phân số
    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Trừ hai phân số
    public Rational subtract(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDen


