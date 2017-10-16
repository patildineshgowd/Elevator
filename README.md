# Elevator
Elevator Assignment

## Assumption
Assuming the floor numbers passed are valid (eg: if the building has 12 floors, floor numbers should be less than or equal to 12)
It is a generic algorithm which is cable of calculating distance for any floor numbers.

## Pre-requisites to run this module
Java to be installed on machine which is running this module
Maven should be installed if program is tested using Java class instead of jar file

## How to run the project
Testing using Java main class: com.bofa.interview.ElevatorMain
	pass the program arguments : <FILE PATH> <MODE A or B) -> eg: C:/test/testfile.txt A

Testing using jar file: 
java -jar <JarFileName>.jar <FILENAME> <MODE>
	FILENAME : Has to be contain complete path to the file
	MODE : Use only char 'A' or 'B' (without quotes)
java -jar bofa-elevator-algo-jar-with-dependencies.jar C:/test/testfile.txt A

## Solution
Read the input file and Break each line into a separate use case .Now pick each use case read all the requests for that usecase and push into the queue.Now once queue is loaded, traverse it based on the lift mode (A or B).

