/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.admissions;

import java.text.DecimalFormat; //for formatting the GPA to two decimal places

/**
 *
 * @author jskuschner
 */
class idealStudent {
     
        String schoolName;
    double idealGPA;
    int idealACTscore;
    int idealSATscore;
    
     idealStudent(){
        schoolName = "UCLA"; //Go Bruins! Data based on 25th percentile of UCLA freshman admits in Fall 2019
        idealGPA = 4.18; // https://admission.universityofcalifornia.edu/campuses-majors/ucla/freshman-admission-profile.html
        idealSATscore = 1360;
        idealACTscore = 29;
    }
    
}

class testStudent extends idealStudent {

    
    static String name;
    static  double gpa;
     static int SATscore;
    static int ACTscore;
    
   testStudent (String label, double grades, int sScore, int aScore){
       name = label;
       gpa = grades;
       SATscore = sScore;
       ACTscore = aScore;
   }
    
    void showData(){
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
        
        System.out.println("ACT Test Score: " + ACTscore);
         
            System.out.println("SAT Test Score: " + SATscore);

    }
    
    int ACTCompare (){
        int temp = 0;
        temp = this.ACTscore - idealACTscore;
        return temp;
    }
    
    int SATCompare (){
        int temp = 0;
        temp = this.SATscore - idealSATscore;
        return temp;
    }
    
     double gpaCompare (){
        double temp;
        temp = this.gpa - idealGPA; //taking difference of user GPA against ideal
        return temp;
    }
     
     int evaluate(double gpaGap, int ACTgap, int SATgap){
         System.out.println("Evaluating " + this.name + "'s chances to be admitted to " + schoolName + "...");
         int points = 0; //point system to compare student to ideal
         
         if (gpaGap >= 1.00){ //compares GPA to ideal
             System.out.println("Your GPA is much higher than the ideal GPA.");
             System.out.println("+2 points towards admission");
             points = points + 2;
         }else if(gpaGap > 0.0 && gpaGap < 1.00){
             System.out.println("Your GPA is higher than the ideal GPA.");
             System.out.println("+1 point towards admission");
             points++;
         }else if(gpaGap < -1.00){
             System.out.println("Your GPA is much lower than the ideal GPA.");
             System.out.println("-2 points towards admission");
             points = points - 2;
         }else if(gpaGap < 0.00 && gpaGap >= -1.00){
             System.out.println("Your GPA is lower than the ideal GPA.");
             System.out.println("-1 point towards admission");
             points--;
         }
         
         if (ACTgap >= 5){
             System.out.println("Your ACT score is much higher than the ideal ACT score.");
             System.out.println("+2 points towards admission");
             points = points + 2;
         }else if (ACTgap >= 0 && ACTgap < 5){
             System.out.println("Your ACT score is higher than the ideal ACT score.");
             System.out.println("+1 point towards admission");
             points++;  
            }else if (ACTgap <= -4){
             System.out.println("Your ACT score is much lower than the ideal ACT score.");
             System.out.println("-2 point towards admission");
             points = points - 2;
            }else if (ACTgap < 0 && ACTgap > -4){
                System.out.println("Your ACT score is lower than the ideal ACT score");
                System.out.println("-1 point towards admission");
            }
         
           if (SATgap >= 200){
             System.out.println("Your SAT score is much higher than the ideal SAT score.");
             System.out.println("+2 points towards admission");
             points = points + 2;
         }else if (SATgap >= 0 && SATgap < 200){
             System.out.println("Your SAT score is higher than the ideal SAT score.");
             System.out.println("+1 point towards admission");
             points++;  
            }else if (SATgap <= -200){
             System.out.println("Your SAT score is much lower than the ideal SAT score.");
             System.out.println("-2 point towards admission");
             points = points - 2;
            }else if (SATgap < 0 && SATgap > -4){
                System.out.println("Your SAT score is lower than the ideal SAT score");
                System.out.println("-1 point towards admission");
            }
         return points;
     }
    void compareTo(){
        
        System.out.println("Comparing " + this.name + " to the ideal student at " + schoolName + "...");
       
        double gpaDiff = gpaCompare(); 
        
           DecimalFormat df = new DecimalFormat("#.##"); //formatting display
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        if (gpaDiff >= 0){
            System.out.println("Your GPA is " + df.format(gpaDiff) + " points higher than the ideal student's.");
        }else if (gpaDiff <= 0){
            System.out.println("Your GPA is " + df.format(gpaDiff * -1) + " points lower than the ideal student's");
        }
        
        
        int ACTDiff = ACTCompare();

         if (ACTDiff >= 0){
            System.out.println("Your ACT score is " + ACTDiff + " points higher than the ideal student's.");
        }else if (ACTDiff <= 0){
            System.out.println("Your ACT score is " + (ACTDiff * -1) + " points lower than the ideal student's");
        }
         
         int SATDiff = SATCompare();
         if (SATDiff >= 0){
            System.out.println("Your SAT score is " + SATDiff + " points higher than the ideal student's.");
        }else if (SATDiff <= 0){
            System.out.println("Your SAT score is " + (SATDiff * -1) + " points lower than the ideal student's");
        }
         
         int evaluation = evaluate(gpaDiff, ACTDiff, SATDiff);
         
         if (evaluation >=0){
             System.out.println("You were " + evaluation + " points above the ideal.");
            System.out.println("You deserve to be admitted to " + schoolName);
         } else if (evaluation <=0){
             System.out.println("You were " + (evaluation * -1) + " points below the ideal.");
            System.out.println("You most likely won't be admitted to " + schoolName);
            System.out.println("Maybe next year!");
         }
        
    }
}
