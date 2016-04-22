# Robot-Simulator

Simulation of toy robot moving on a square tabletop

A robot is placed on a 5x5 tabletop. Instructions are issued to the robot via user input or via a text input file

## Demo

![DEMO](https://raw.githubusercontent.com/densikat/Robot-Simulator/develop/image/output.gif)

## Environments

Initially developed on

* Windows 10
* JRE 8 U73
* Maven 3.3.9

## System dependencies and configuration

* JDK => 8U60

## Successfully tested on following platforms

* Windows 10
* OS X El Capitan (10.11.4)
* Ubuntu 15.10
* Ubuntu 16.04

## Usage Instructions

Load command prompt and change to working directory of robotsim class files

To run application in interactive mode:

java -jar jarfile

_example._ 

	$ java -jar robotsim-0.0.1-SNAPSHOT.jar

To run application from an input file:

java -jar jarfile pathtoinputfile

_example._ 

	$ java -jar robotsim-0.0.1-SNAPSHOT.jar c:\temp\instructions.txt
	
## Valid commands

Note: Commands for interactive and input file are identical

#####PLACE X,Y,DIRECTION

**Purpose:** Places robot on tabletop. Only valid if robot is not on board already, will be discard otherwise.

X = X coordinate on tabletop to place robot. Valid inputs: 0-4
Y = Y coordinate on tabletop to place robot. Valid inputs: 0-4
DIRECTION = Direction for robot to face. Valid inputs are NORTH, SOUTH, EAST, WEST

#####MOVE

**Purpose:** Move robot one unit forward in the direction it is currently facing.

Only valid if movement does not take robot off the tabletop edge.

#####LEFT

**Purpose:** Rotate the robot 90 degrees to the left

_example_ Robot is facing north, LEFT is issued, robot is now facing WEST

#####RIGHT

**Purpose:** Rotate the robot 90 degrees to the right

_example_ Robot is facing north, RIGHT is issued, robot is now facing EAST

#####REPORT

**Purpose:** Reports the location of the robot and direction the robot is facing

_example_

REPORT
3,3,NORTH

## Compiling from source

Maven needs to be installed and working.

1. Download source (via zip or clone repository)
2. Browse to source root
3. Run the following to compile from source

    ```console
	$ mvn compile
	```

## Creating executable jar

1. Download source (via zip or clone repository)
2. Browse to source root
3. Run the following to compile and package from source

    ```console
	$ mvn package
	```

## Running tests

1. Browse to source root
2. Run the following to execute tests

    ```console
	$ mvn test
	```

## Structure

Code is comprised of four main source files

**Simulator.java**

_Contains main method, runs the simulator_

Class does the following:

    Takes and checks command line arguments passed to the program
    Runs in either interactive mode or batch (file) mode depending on command line arguments passed
    Initializes robot and table
    Takes each command sequentially and processes them
    
**Robot.java**

_Class representation of a robot_

Does the following:
    
    Takes a command and validates it against a given table
    Executes a command against a given table
    
**Command.java**

_Class representation of a command_

Does the following:

    Takes a command string, parses string, if valid populates command instance fields

**TabletTop.java**

_Class representation of Table Top_

Does the following:

    Initializes a table top with specific X and Y upper bounds

**Direction.java**

_Direction class, uses hashtable internally to represent directions_

_This class was implemented to provide a way to arithmetically (via hashtable index) achieve rotation instructions_

Does the following:

    Returns string representation of direction based on hashtable index.

**Instruction.java**

_Interface used to spawn instruction objects_

_Move, Place, Report, Left, Right, Report instruction classes all spawn off this interface and provide these methods_

Does the following:

    Provides validation and execution methods for instruction

**InstructionFactory.java**

_Factory class used to dynamically generate instruction objects based on command text_

Does the following:

    Returns instruction object instances

## License

This project is licensed under the [MIT License](http://www.opensource.org/licenses/MIT)
