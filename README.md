# TestExample
It is a project in which you will learn android Testing using JUnit4, Espresso, mockito testing library.



# Why do I even need to “test” my code? 🤔

Let’s assume we are making some “Shopping App”. In some X feature, we need to get the final product price. 
In order to show the user the final product price we need to make some calculations based on some inputs 
like the base product price & some discount that comes from somewhere (it doesn’t matter, the point is the situation).

Now that we’ve got the feature requirements, it’s time to do what we know.

Start coding, get into coding flow state with your hacker sweater and your lofi music.
Code finished, time to build the app and launch it in your phone.
Time for manual human testing.
Ops! We found a bug.
Close the app, go to your price calculator class
Research your code, till you finally find and “fix” the bug.
Do the “fixes” and repeat the steps 2, 3… till your app is “stable”.
Repeating the same process again and again and again doesn’t seem very practical, and we could have prevent this since the beginning! Saving time that we could use doing something else like read a blog, play some game, do exercise, etc. Time is the most valuable thing we have on life, so don’t waste it.

# What is unit test? 
-> In simple terms is the test you make to small portions of your code. 

-> By creating and running unit tests against your code, you can easily verify that the logic of individual units is correct.

-> Unit testing is done to ensure that developers write high-quality and errorless code.

-> It is advised to write Unit tests before writing the actual app, you will write tests beforehand and 
   the actual code will have to adhere to the design guidelines laid out by the test. 

-> Unit tests run on your local machine only. These tests are compiled to run locally on the Java Virtual Machine (JVM) to minimize execution time.

There are some framework are available for testing : 

1. JUnit 
2. Espresso 
3. Mockito

# JUnit : Unit testing

   It is a “Unit Testing” framework for Java Applications which is already included by default in android studio.
It is an automation framework for Unit as well as UI Testing. It contains annotations such as @Test, @Before, @After, etc. 

   In this branch you will learn how to test functions which are not depends on context or any phone related things.
For example you will test armstrong number, string validation, password validation, etc.

# Espresso : UI testing 

   It is very important to test the UI in all aspects so that the user will not get any trouble in using the application.
The application should be easy to use. If the UI is tested properly it makes the usability of the application easier.

Using Espresso Frameworks
-> It is Google’s framework for UI testing.
-> It is a good and fast test automation framework that allows you to test many things inside your application in a simple way.
-> It is part of the Android Support Repository.
-> Highly test cycle.
-> Suitable for writing black-box tests
-> Easy to set up.

# Mockito : Unit testing

   Mockito is my favorite library for testing with mock objects. Its fluent API separates pre-test preparation from post-test validation.
Should the test fail, Mockito makes it clear to see where our expectations differ from reality! The library has everything you need to write complete tests.
 
If you found it helpful please share on 
 
LinkedIn : 
https://www.linkedin.com/in/kaushal-vasava
 
Twitter : 
https://twitter.com/KaushalVasavaIn
 
Thank you,
Kaushal Vasava.
 
