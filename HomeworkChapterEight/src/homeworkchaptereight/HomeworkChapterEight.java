/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homeworkchaptereight;

import java.util.*;
import java.text.NumberFormat;
import java.io.*;

/**
 *
 * @author dfcol
 */
public class HomeworkChapterEight 
{   

    /**
     * @param args the command line arguments
     */
    
    //static postion array list since positions don't need to change
    static ArrayList<Integer>playerPositions = new ArrayList<>();
    static ArrayList<Integer>npcPositions = new ArrayList<>();
    
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        String answer = "y";
        
        //Heading
        Console.displayLine("Welcome to the Batting Avrage Calculator");
        
        while (answer.equalsIgnoreCase("y"))            
        {            
            //Enter number of at bats
            int atBats = Console.getInt("\nEnter number of times at bat: ", 1, 30);
            //Create menu for 0 = out 1 = single 2 = double 3 = triple 4 = home run
            Console.displayLine("\n0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
            //User input bases taken for each at bat, store in int array
            int results[] = new int[atBats];
            double baseHits = 0.0;
            double totalBases = 0.0;
            
            //go through each index and ask for at bat results using a for loop
            for(int i = 0; i < atBats; i++)
            {
                int resultInput = Console.getInt("Result for at-bat " + (i+1) + ": ", 0, 4);
                results[i] = resultInput;
            }
            
            //interate through each element in results array
            for(int result : results)
            {
                if(result > 0)
                {
                    baseHits++;
                }
                totalBases += result;
            }
            //calculate batting average
            //calculate Slugging percent
            double battingAvg = (baseHits / atBats);
            double slugPercent = (totalBases / atBats);
            //Instantiate instance of a number to be formated
            NumberFormat number = NumberFormat.getNumberInstance();
            //Format number to display only 3 digits after the decimal
            number.setMinimumFractionDigits(3);
            
            //Create string to represent formated battingAverage
            String battingAverageString = number.format(battingAvg);
            
            //Create string to represent formated slugPercent
            String slugPercentString = number.format(slugPercent);
            
            //pring batting average and slugging percent
            Console.displayLine("\nBatting average: " + battingAverageString);
            Console.displayLine("Slugging percent: " + slugPercentString);
            
            //Another player option y/n
            answer = Console.getString("\nAnother player? (y/n): ", "y", "n");
        }//End While
        
        //Create 2 dimensional array to store sales data
        double sales[][] = {{1540.0,2010.0,2450.0, 1845.0},{1130.0,1168.0, 1847.0,1491.0},
        {1580.0,2305.0,2710.0,1284.0}, {1105.0,4102.0,2391.0,1576.0}};
        
        //Number format class object in dollars
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(java.util.Locale.US);
        
        Console.displayLine("The sales report application");
        
        Console.displayLine("Sales by quarter: ");
        Console.displayLine("Region\tQ1\t\tQ2\t\tQ3\t\tQ4");
        
        //j element in i row in 2D array stores sales values for j quarter
        for(int i = 0; i < sales.length; i++)
        {
            System.out.println(i + 1 + "\t");
            
            for (int j = 0; j < sales[i].length; j++)
            {
                System.out.println(defaultFormat.format(sales[i][j]) + "\t");
            }
            Console.displayLine();
        }
        
        //i row stores sales for i region
        Console.displayLine("Sales by region: \n");
        for (int i = 0; i <sales.length; i++)
        {
            System.out.println("Region " + (i+1) + ": ");
            double regionSales = 0;
            for(int j = 0; j <sales[i].length; j++)
            {
                regionSales += sales[i][j];
            }
            System.out.println(defaultFormat.format(regionSales));
            
        }//End for
        
        Console.displayLine("\nSales by Quarter: \n");
        
        //4 variables to represent quarters
        double quarterOne = 0;
        double quarterTwo = 0;
        double quarterThree = 0;
        double quarterFour = 0;
        
        for (int i = 0; i <sales.length; i++)
        {
            for (int j = 0; j < sales[i].length; j++)
            {
                if (j == 0)
                {
                    quarterOne += sales[i][j];
                }
                if (j == 1)
                {
                    quarterTwo += sales[i][j];
                }
                if (j == 2)
                {
                    quarterThree += sales[i][j];
                }
                if (j == 3)
                {
                    quarterFour += sales[i][j];
                }
            }//End for
        }//End for
        
        System.out.println("Q1: "+defaultFormat.format(quarterOne));
        System.out.println("Q2: "+defaultFormat.format(quarterTwo));
        System.out.println("Q3: "+defaultFormat.format(quarterThree));
        System.out.println("Q4: "+defaultFormat.format(quarterFour));
        
        double total = 0;
        
        for (double[] sale : sales) {
            for (int j = 0; j < sale.length; j++) {
                total += sale[j];
            }
        } //End for
        
        System.out.println("\nTotal Sales: "+defaultFormat.format(total));
        System.out.println("\n*****Next section in 5 seconds*****");
        
        try
        {
            java.util.concurrent.TimeUnit.SECONDS.sleep(5);
        }
        catch(InterruptedException e)
        {
                    
        }
        
        
        //Tic Tac Toe
        System.out.println("\nWelcome to Tic Tac Toe");
        
        //GameBoard design
        String board[][] = {{" ", "|", " ", "|", " "}, {"+", "+", "+", "+", "+"}, {" ", "|", " ", "|", " "},
                            {"+", "+", "+", "+", "+"}, {" ", "|", " ", "|", " "}};
        
        //Print gameboard from a seperate method
        gameBoard(board);         
        
        
        while(true)
        {
            //Player input block
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Enter your block (1-9): ");
            int position = scan.nextInt();
            
            //make sure that player and npc don't overwrite one another check player choice against player and npc position lists
            while(playerPositions.contains(position) || npcPositions.contains(position))
            {
                System.out.println("Position taken! Try again (1-9): ");
                position = scan.nextInt();
            }            
        
            //System.out.println(position);
        
            //place mark on board
            placeMark(board, position, "player");
        
            //crappy npc AI
            Random roll = new Random();
            int npcPosition = roll.nextInt(9) + 1;
            
            while(playerPositions.contains(npcPosition) || npcPositions.contains(npcPosition))
            {
                npcPosition = roll.nextInt(9) + 1;
            }
            
            placeMark(board, npcPosition, "npc");
        
            //call method to print game board
            gameBoard(board);
            
            //check winning condition and print win message
            String winMessage = checkWinner();
            if (winMessage.length() > 0)
            {
                 System.out.println(winMessage);
                 break;
            }
           
            
        }//End tic tac toe while loop
        
        eightFour();
        
        
    }//End main
    
    //print the game board
    public static void gameBoard(String board[][])
    {
        for(String row[] : board)
        {
            for (String column : row)
            {
                System.out.print(column);
            }
            System.out.println("");
        }
    }//End gameBoard
    
    //method for placing markers
    public static void placeMark(String board[][], int position, String user)
    {
        String mark = " "; //For player symbol
        
        if (user.equals("player"))
        {
            mark = "X";
            playerPositions.add(position);
            
        }
        else if (user.equals("npc"))
        {
            mark = "O";
            npcPositions.add(position);
        }
        
        //assign player mark to chosen block
        switch(position)
        {
            case 1:
               board[0][0] = mark;
               break;
            case 2:
               board[0][2] = mark;
               break;
            case 3:
               board[0][4] = mark;
               break;
            case 4:
               board[2][0] = mark;
               break;
            case 5:
               board[2][2] = mark;
               break;
            case 6:
               board[2][4] = mark;
               break;
            case 7:
               board[4][0] = mark;
               break;
            case 8:
               board[4][2] = mark;
               break;
            case 9:
               board[4][4] = mark;
               break;
            default:
                break;
        }
        
        System.out.println("\n************************************");
    }//End placeMark
    
    //Method to determine winner
    public static String checkWinner()
    {
        //All win conditions
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        
        List leftDiag = Arrays.asList(1, 5, 9);
        List rightDiag = Arrays.asList(7, 5, 3);
        
        List<List>winConditions = new ArrayList<>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(leftDiag);
        winConditions.add(rightDiag);
        
        for(List l : winConditions)
        {
            if (playerPositions.containsAll(l))
            {
                return "You win!";
            }
            else if (npcPositions.containsAll(l))
            {
                return "Npc wins!  Git gud scrub.";
            }
            else if(playerPositions.size() + npcPositions.size() == 9)
            {
                return "A tie.  Well, at least you didn't lose.";
            }
        }
        
        return "";
    }//End checkWinner
    
    public static void eightFour() throws FileNotFoundException
    {
        //array list of countries
        ArrayList<String> countries;
        countries = new ArrayList<>();

        Scanner console = new Scanner(System.in);

        OUTER:
        do 
        {
            System.out.print("\n1 - List Countries\n2 - Add a country\n3 - Exit\n\nEnter menu number : ");
            int choice = console.nextInt();
            
            switch (choice) {
                case 1:
                    countries = getCountries();
                    for (int i = 0; i < countries.size(); i++)
                    {
                        System.out.println(countries.get(i));
                    }   break;
                case 2:
                    countries = getCountries();
                    System.out.print("Enter country : ");
                    console.nextLine(); // ignore enter
                    String country = console.nextLine();
                    //add country
                    countries.add(country);
                    if (saveCountries(countries))
                    {
                        System.out.println("This country has been saved.");
                    }
                    else
                    {
                        System.out.println("Error while saving the file.");
                    }   break;
                case 3:
                    break OUTER;
                default:
                    System.out.println("Invalid entry");
                    break;    
            }
        } 
        while (true);

        System.out.println("Bye!");

    }//End eightyFour

public static ArrayList<String> getCountries() throws FileNotFoundException 
{

    ArrayList<String> al = new ArrayList<>();

    try 
    {
        try (Scanner input = new Scanner(new File("countries.txt"))) {
            while (input.hasNextLine())
            {
                String infoLine = input.nextLine();
                al.add(infoLine);
            }
        }

    } 
    catch (FileNotFoundException e) 
    {
        try 
        {
            createFile();

        } 
        catch (IOException ex) 
        {
            System.out.println("Error");
        }
    }

    return al;
}

public static void createFile() throws IOException 
{
    try {
            File file = new File("countries.txt");

            if (file.createNewFile()) 
            {
                System.out.println("countries.txt File Created in Project root directory");
            }

        } 
        catch (IOException ioe) 
        {
            
        }

}

public static boolean saveCountries(ArrayList<String> line) throws FileNotFoundException 
{
    /*Prints formatted representations of objects to a text-output stream. 
      This class implements all of the print methods found in PrintStream. */
    try (PrintWriter output = new PrintWriter("countries.txt")) 
    {
        
    } 
    catch (FileNotFoundException ioe) 
    {
        try 
        {
            createFile();
        } 
        catch (IOException e) 
        {
            System.out.println("Error");
        }
    }

        try (PrintWriter output = new PrintWriter("countries.txt")) 
        {
            for (int i = 0; i < line.size(); i++)
            {
                output.write(line.get(i) + "\n");
            }   
        }

    return true;


}//End saveCountries  

}//End class
