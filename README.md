# Project 0
Application for Athletes to search available workout data to see if there is someone to run with on a certain day

## User Features
- [x] Reads in workout data from each athlete in a .csv file and stores in java collection
- [x] Can take input from the user and searches workout data to see if there is a match for the desired workout
- [x] Allows user to store workout data in the database after search
- [x] Connected successfully to database
- [x] Program can return and store data successfully from the database

## Application Features
- [x] README included
- [x] Junit testing complete
- [x] Integration(database) testing complete
- [x] Log 4j Logging incorporated
- [x] Pushed to GitHub

## Instructions for Use 
- Initial welcome message followed by asking user to enter the day they would like to find a workout on.
  Valid days are: Monday - Friday only  
- User prompted to choose what type of workout he or she would like to search for:
  - By Distance, in miles (press 1)
  - By Vertical gain, in feet (press 2)
  - By time, in hours (press 3)
- Application will search available workout data and will return a suitable message if a match is found.
  - For example "We foudn a workout: You should run with Maurice on Wednesday"
  - If no match, app will return the message "Sorry, no one to run with this week"
- Finally the app will prompt the user if he/she wants to save into the database.
  - If "y", then the data saves into database and returns the values ot the console as a check
  - If "n", then the program exits without persisting data to database