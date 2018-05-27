## Introduction

The Tiny Island Radio Company have a number of radio transmitter and receiver towers on a series of tiny islands. Some of the receivers are currently unable to receive a signal, and so they need you to write an application to calculate how the transmitters should be modified to ensure full coverage.

We estimate that this problem will take 2-3 hours of your time.

## Problem

* Each island scenario consists of a collection of transmitter towers and receiver towers.
* Each tower has an integer-only (X, Y) location denoting its position on the island.
* Each transmitter tower also has an integer transmit power denoting the range of its transmissions.
* If the [Chebyshev distance](https://en.wikipedia.org/wiki/Chebyshev_distance) separating a receiver and a transmitter is equal to or less than that transmitter's power, then the receiver is within that transmitter's range and can pick up a good signal.
* All transmitters emit the same signal, so if a receiver is within range of one or more transmitters then it is defined to be 'within coverage'.
* Some receiver towers in a scenario will be out of coverage.
* The locations of all towers are fixed.
* The power of a transmitter can be increased or left unchanged, but cannot be decreased.
* The specific dimensions of the island are not relevant.
* Your application must increase the power of one or more towers so that all receivers on the island are in coverage, while minimising the total power of the transmitters on the island.  

## Provided Materials

* You will have been provided with a small codebase providing a basic maven build, some basic model objects, some test scenarios, and the correct answers to most of the test scenarios.
* The purpose of this codebase is to provide a starting-point for your implementation so as to reduce the amount of time you need to spend on it.
* You may replace or refactor any of the provided code if you choose, it is not intended to be a perfect implementation (nor is it well-commented).
* A very poor sample solution *AddTenOptimiser* is provided, along with a sample test class *AddTenOptimiserTest* (which will not pass and so is annotated @Ignore).
* Note there is no main function, the provided codebase is intended to run only within unit tests.
* In the img directory are some ASCII maps showing the trickier scenarios.

## Your Solution

* Write a class which implements the *PowerOptimiser* interface.
* Add as many other classes as you see fit. 
* Write a test class for your optimiser which runs each of the island scenarios in *TestScenarios*.
* The last two test scenarios do not have the correct answer provided; you must add this yourself.
* You may write any additional tests for any classes as you see fit, including the provided classes.
* Your solution should pass all the given test scenarios, but you can still receive credit if not.
* You may assume that there are no tight performance constraints.
* You may use the provided starting materials, or you may start from scratch if you wish; your solution must be a Java 8 application which is built and invoked using maven.
* You may use existing open-source libraries which don't directly address the problem.
* Your code should be well-formatted and easily-readable, with appropriate comments.
* Send us your full solution, either in a zip or via link to Github/Bitbucket etc.
