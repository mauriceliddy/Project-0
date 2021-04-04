/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.mauriceliddy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static Scanner scanEntry = new Scanner(System.in);
  public static Scanner scanSql = new Scanner(System.in);

  public static void main(String[] args) {

    DataInput dataInput = new DataInput();
    UserDatabaseAccess userDatabaseAccess = new UserDatabaseAccess();
    List<Workout> masterList = dataInput.readInData();
    // masterList.forEach(wout -> System.out.println(wout));

    // User Input
    System.out.print("Hello! On what day would you like to run? ");
    String day = null;

    day = scanEntry.next();

    System.out.println("Hello! What type of workout are you looking for?");
    System.out.println("Select 1 for distance");
    System.out.println("Select 2 for vertical gain");
    System.out.println("Select 3 for time");
    int choice = scanEntry.nextInt();
    ProcessData processData = new ProcessData(masterList);
    processData.processChoice(day, choice);

    // Database entry section:
    System.out.println("Would you like to store data into the database? y or n?");
    String response;
    response = scanSql.nextLine();
    if (response.equals("y")) {
      userDatabaseAccess.sendCSVDataToDatabase(masterList);
    }

    
    System.out.println("This just in: database data...");
    List<Workout> woutFromDB = new ArrayList<>();
    woutFromDB= userDatabaseAccess.retrieveAllFromDb();
    woutFromDB.forEach(line -> System.out.println(line.printWorkoutDataFromDB()));
  
    System.out.println("Exiting Program");

  }
}
