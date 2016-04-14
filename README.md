# Robot-Simulator

Simulation of toy robot moving on a square tabletop

A robot is placed on a 5x5 tabletop. Instructions are issued to the robot via user input or via a text input file

## Environments

Initially developed on

* Windows 10
* JRE 8 U73

## System dependencies and configuration

* JRE => 8U73

## Usage Instructions

Load command prompt and change to working directory of robotsim class files

To run application in interactive mode:

java robotsim

To run application from an input file:

java robotsim <path to input file>

## Valid commands

Note: Commands for interactive and input file are identical

#####PLACE X,Y,DIRECTION

**Purpose:** Places robot on tabletop. Only valid if robot is not on board alread, will be discard otherwise.

X = X coordinate on tabletop to place robot. Valid inputs: 1-5
Y = Y coordinate on tabletop to place robot. Valid inputs: 1-5
DIRECTION = Direction for robot to face. Valid inputs are NORTH, SOUTH, EAST, WEST

#####MOVE

**Purpose:** Move robot one unit forward in the direction it is currently facing.

Only valid if movement does not take robot off the tabletop edge.

Valid moves are within the following X and Y coordinate ranges

1 => X <= 5, 1 => Y <= 5

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

## Running tests

## Overview

## Design Choices

## License

## Conclusion


