//@author Daniel Hart
//This program finds how many attempts on average it takes to roll a six on a 
//six-sided die. The user may choose how many tests they would like to run
//(i.e. how many sixes they want rolled before calculating their final average).
//
//Possible improvements: Ask the user how many sides their die has. Add this as
//a parameter in the testAverage method.
//Consider asking the user what number they want to roll for (i.e. instead of
//six).
//It could be nice to customize the dialogue boxes and to round the final
//average to two digits.

package rollsix;

import java.util.*;
import javax.swing.*;

public class RollSix {
    public static void main(String[] args) {
	JOptionPane.showMessageDialog(null,"Welcome to RollSix!");
        JOptionPane.showMessageDialog(null,"Let's find out how many times on "
                + "average it takes you to roll a six on a six-sided die.");
        String sTimes;
        int times = 0;
        for (;;) {
            try {
                sTimes = JOptionPane.showInputDialog(null, "How many tests "
                        + "would you like to run to find your average over? "
                        + "Please enter an integer.");
                times = Integer.parseInt(sTimes.trim());
                break;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Please enter an integer.");
            } 
        }
        double result = testAverage(times);
        JOptionPane.showMessageDialog(null,"Average number of rolls to get"
                + " six after " + times + " tests: " + result);
    }

    //returns average number of times it takes to roll a six over a given number
    //of tests
    public static double testAverage(int test) {
        Random r = new Random();
        int tcount = 0;
        for (int i = 1; i<=test; i++) {
            int roll = 0;
            int count = 0;
            while (roll != 6) {
                count++;
                roll = r.nextInt(6) + 1;
            }
            System.out.println("You got a six in " + count + " turns!");
            tcount = tcount + count;
        }
        return (double) tcount/test;
    }
    
}
