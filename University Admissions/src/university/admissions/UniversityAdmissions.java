/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.admissions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jskuschner
 */
public class UniversityAdmissions {

    static String getName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = s.nextLine();
        return name;
    }

    static double getGPA() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your weighted GPA: ");
        double gpa = s.nextDouble();
        return gpa;
    }

    static int getACTScore() {
        Scanner s = new Scanner(System.in);
        int tempScore = 0;
        System.out.println("Please enter ACT test score: ");
        tempScore = s.nextInt();
        while (tempScore < 0 && tempScore > 36) { //checks to see if a valid score was entered
            System.out.println("Invalid test score.");
            System.out.println("Please enter 0-36 for ACT");
            System.out.println();
            System.out.println("Please enter ACT test score: ");
            tempScore = s.nextInt();
        }
        return tempScore;

    }

    static int getSATScore() {
        Scanner s = new Scanner(System.in);
        int tempScore = 0;
        System.out.println("Please enter SAT test score: ");
        tempScore = s.nextInt();
        while (tempScore < 0 && tempScore > 1600) { //checks to see if a valid score was entered
            System.out.println("Invalid test score.");
            System.out.println("Please enter 0-1600 for SAT");
            System.out.println();
            System.out.println("Please enter SAT test score: ");
            tempScore = s.nextInt();
        }
        return tempScore;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final int MANUAL = 1;
        final int FILE = 2;

        String name = "";
        double gpa = 0.0;
        int ACTscore = 0;
        int SATscore = 0;

        Scanner option = new Scanner(System.in);
        System.out.println("Would you like to enter your information manually or from a text file?");
        System.out.println("Enter 1 for manual or 2 for text file");

        int op = option.nextInt();

        if (op == MANUAL) {

            name = getName();
            gpa = getGPA();

            ACTscore = getACTScore();
            SATscore = getSATScore();
        } else if (op == FILE) { //use constants
            try {
                File student = new File("/Users/jskuschner/Desktop/student.txt");
                Scanner input = new Scanner(student);

                while (input.hasNext()) {

                    name = input.nextLine();
                    gpa = input.nextDouble();
                    ACTscore = input.nextInt();
                    SATscore = input.nextInt();
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Testing purposes");
            }

        }

        idealStudent j = new idealStudent();
        testStudent test = new testStudent(name, gpa, SATscore, ACTscore);
        test.showData();

        test.compareTo();
    }

}
