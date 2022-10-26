/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homeworkchaptereight;

import java.util.Scanner;
/**
 *
 * @author dfcol
 */
public class Console 
{
   private static Scanner sc = new Scanner(System.in);  

    public static void displayLine()
    {
        System.out.println();
    }

    public static void displayLine(String s)
    {
        System.out.println(s);
    }

    public static String getString(String prompt)
    {
       String s = "";
       System.out.print(prompt);

       boolean isValid = false;

       while (!isValid)
       {
           s = sc.nextLine();
           if (s.equals(""))
           {
               System.out.println("Error! This entry is required. Try again.");
           } 
           else
           {
               isValid = true;
           }
       }
       return s;
    }

  

   public static String getString(String prompt, String s1, String s2)
   {
       String s = "";
       System.out.print(prompt);      

       boolean isValid = false;

       while (!isValid)
       {
           s = sc.nextLine();
           if (s.equals(""))
           {
               System.out.println("Error! This entry is required. Try again.");
           } 
           else
           {
               if(s.equalsIgnoreCase(s1) || s.equalsIgnoreCase(s2))
               {
                   isValid = true;

               }
               else 
               {
                   System.out.println("Error! This entry is required. Try again.");
               }
           }
       }
       return s;
   }

    public static int getInt(String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }

            sc.nextLine(); // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(String prompt,int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (!isValid)
        {
            i = getInt(prompt);
            if (i < min)
            {
                System.out.println("Error! Number must be " + min + " or higher.");
            }
            else if (i > max)
            {
                System.out.println("Error! Number must be no greater than " + max + ".");
            }
            else
            {
                isValid = true;
            }
        }
        return i;
    }  

    public static double getDouble(String prompt)
    {
        double d = 0.0;
        boolean isValid = false;

        while (!isValid)
        {
            System.out.print(prompt);
            
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            } 
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }

            sc.nextLine(); // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(String prompt,double min, double max)
    {
        double d = 0.0;
        boolean isValid = false;

        while (!isValid)
        {
            d = getDouble(prompt);
            
            if (d <= min)
            {
                System.out.println("Error! Number must be greater than " + min + ".");

            } 
            else if (d >= max)
            {
                System.out.println("Error! Number must be less than " + max + ".");
            }
            else
            {
                isValid = true;
            }
        }
        return d;

    } 
}
