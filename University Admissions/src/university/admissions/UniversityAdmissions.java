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

    //prompts user to enter name
    static String getName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = s.nextLine();
        return name;
    }
    //prompts user to enter weighted (5.00 scale) GPA
    static double getGPA() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your weighted GPA: ");
        double gpa = s.nextDouble();
        return gpa;
    }
    //prompts user to enter their ACT score
    static int getACTScore() {
        Scanner s = new Scanner(System.in);
        int tempScore = 0;
        System.out.println("Please enter ACT test score: ");
        tempScore = s.nextInt();
        while (tempScore < 0 && tempScore > 36) { //checks to see if a valid score was entered. Scores cannot be > 36 or < 0.
            System.out.println("Invalid test score.");
            System.out.println("Please enter 0-36 for ACT");
            System.out.println();
            System.out.println("Please enter ACT test score: ");
            tempScore = s.nextInt();
        }
        return tempScore;

    }
    //prompts user to enter their SAT Score
    static int getSATScore() {
        Scanner s = new Scanner(System.in);
        int tempScore = 0;
        System.out.println("Please enter SAT test score: ");
        tempScore = s.nextInt();
        while (tempScore < 0 && tempScore > 1600) { //checks to see if a valid score was entered. Scores cannot be > 1600 or < 0.
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

        final int MANUAL = 1; //for selecting to submit data manually
        final int FILE = 2; //for selecting to submit data via a .txt file

        String name = ""; 
        double gpa = 0.0;
        int ACTscore = 0;
        int SATscore = 0;

        Scanner option = new Scanner(System.in);
        System.out.println("Would you like to enter your information manually or from a text file?");
        System.out.println("Enter 1 for manual or 2 for text file");

        int op = option.nextInt();

        if (op == MANUAL) { //allows user to enter information manually, invoking methods from above

            name = getName();
            gpa = getGPA();

            ACTscore = getACTScore();
            SATscore = getSATScore();
        } else if (op == FILE) { //allows user to enter information via a text file 
            try {
                File student = new File("/Users/jskuschner/Desktop/student.txt"); //my personal file path. Probably needs to be changed for others who want to use.
                Scanner input = new Scanner(student); //Scanner for reading file.

                while (input.hasNext()) { //checks if their is more info in the file

                    name = input.nextLine(); //first line of file becomes name as a String
                    gpa = input.nextDouble(); //second line of file becomes gpa as a double
                    ACTscore = input.nextInt(); //third line of file becomes ACTScore as an int
                    SATscore = input.nextInt(); //fourth line of file becomes SATscore as an int
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Testing purposes"); //for seeing if the file was found. Can be changed to "File not found."
            }

        }

        idealStudent j = new idealStudent(); //constructs the ideal UCLA student with preprogrammed GPA and test scores
        testStudent test = new testStudent(name, gpa, SATscore, ACTscore); //builds a student to test against the ideal using the information taken either manually or from the .txt file
        test.showData(); //displays the user's information

        test.compareTo(); //compares the user's information to the ideal student and determines the user's qualifications to be admitted to UCLA
    }

}
