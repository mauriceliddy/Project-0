/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.mauriceliddy;

import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    DataInput dataInput = new DataInput();
    // List<Athlete> masterList = dataInput.readInData();

    String filePath = "dataObject.csv";
    List<Athlete> masterList = dataInput.readDataByObject(filePath);

    // User Input
    System.out.print("Hello! On what day would you like to run? ");
    String day = null;
    Scanner scan = new Scanner(System.in);
    day = scan.next();

    System.out.println("Hello! What type of workout are you looking for?");
    System.out.println("Select 1 for distance");
    System.out.println("Select 2 for vertical gain");
    System.out.println("Select 3 for time");
    int choice = scan.nextInt();
    ProcessData processData = new ProcessData(masterList);
    processData.processChoice(day, choice);
    scan.close();
  }
}