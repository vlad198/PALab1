package pa.lab1.compulsory;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {

        // Display on the screen the message "Hello World!"
        System.out.println("Hello World!");

        // Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        // Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
        int n = (int) (Math.random() * 1_000_000);

        // Compute the result obtained after performing the following calculations:
        n *= 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n *= 6;

        // Compute the sum of the digits in the result obtained in the previous step.
        // This is the new result. While the new result has more than one digit, continue to sum the digits of the result.

        // var 1
        while (n > 9) {
            int s = 0;
            while (n > 0) { // calculate the sum of the digits
                s += n % 10;
                n /= 10;
            }
            n = s; // the new result
        }

//        var 2
//        if (n % 9 == 0)
//            n = 9;
//        else n = n % 9;

        // Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result]

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}