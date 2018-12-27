/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static javafx.application.Platform.exit;

/**
 *
 * @author PC
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static String meeting(String s) {
        // your code
        String ans = "";
        s = s.toUpperCase();
        String[] names = s.split(";");

        ArrayList<String> newList = new ArrayList<String>();

        for (String name : names) {
            String[] surName = name.split(":");
            String fname = surName[0];
            String lname = surName[1];

            newList.add(lname + ";" + fname);
        }

        List<String> subList = newList.subList(0, newList.size());
        Collections.sort(subList);

        for (String name : newList) {
            String[] surName = name.split(";");
            String fname = surName[0];
            String lname = surName[1];

            ans += "(" + fname + ", " + lname + ")";
        }

        return ans;
    }

    public static int persistence(long n) {
        int steps = 0;

        String numbers = String.valueOf(n);
        char[] nums = numbers.toCharArray();

        int newResult = 1;
        while (nums.length > 1) {
            for (char l : nums) {

                newResult *= Integer.valueOf(String.valueOf(l));
            }
            numbers = String.valueOf(newResult);
            nums = numbers.toCharArray();
            newResult = 1;
            steps += 1;
        }

        return steps;
    }

    public static boolean getXO(String str) {

        boolean x = false;
        int xs = 0;
        int os = 0;
        str=str.toLowerCase();
        char[] stringArray = str.toCharArray();
        for (char s : stringArray) {
            if (s == 'x') {
                xs++;
            }

            if (s == 'o') {
                os++;
            }

        }
        
        System.out.println(os+" "+xs);
        if (xs == os) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(getXO("ooxx"));
        System.out.println(getXO("ooddfxddfxx"));
        System.out.println(getXO("ooxxkjkjkjo"));
        System.out.println(getXO("ooxsdfsdfsafoxsdfsdfdx"));

        String result = meeting("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell");
        String expected = "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)";

        if (result.equals(expected)) {
            System.out.println("amazing");
        } else {
            System.out.println("Sorry...");
        }

        System.out.println(result);
        System.out.println(expected);
        //"(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)");
    }

}
