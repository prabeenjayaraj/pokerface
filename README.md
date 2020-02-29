# pokerface

This program is used the find the Poker Hand based on the given input file

* The Program should validate for invalid cards
* I have generated Random Card Hands which is in the test/resources pokerCardHand.txt for testing random scenarios

Poker Face

In The program

The name of the hand will be one of:

High card

One pair

Two pair

Three of a kind

Straight

Flush

Full house

Four of a kind

Straight flush

Royal Flush


Each line of the input file will contain 5 valid card descriptions.
Each description is in the form CS, where C is the name of the card (2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A)
and S is the suit (H, D, S, C for Hearts, Diamonds, Spades and Clubs respectively).

Below is the Sample input line

Example input:

3H JS 3C 7C 5D

JH 2C JD 2H 4C

9H 9D 3S 9S 9C

9C 3H 9S 9H 3S

Example output:

3H JS 3C 7C 5D => One pair

JH 2C JD 2H 4C => Two pair

9H 9D 3S 9S 9C => Four of a kind

9C 3H 9S 9H 3S => Full house

I have added the below notes for understanding the Poker Hands. Below is the Also the Order in which the
Poker Hands will be prioritised


1. A Royal flush is an ace-high straight flush
2. A straight flush is a hand that contains five cards of sequential rank, all of the same suit
3. Four of a kind is a hand that contains four cards of one rank and one card of another rank.
4. Full House is a hand that contains three cards of one rank and two cards of another rank.
5. A flush is a hand that contains five cards all of the same suit, not all of sequential rank
6. A straight is a hand that contains five cards of sequential rank, not all of the same suit
7. Three of a kind is a hand that contains three cards of one rank and two cards of two other ranks.
8. Two pair is a hand that contains two cards of one rank, two cards of another rank and one card of a third rank.
9. One pair is a hand that contains two cards of one rank and three cards of three other ranks.
10. High card is a hand that does not fall into any other category



Executing the Program
Gradlew is bundled in the project
Execute the below to build and create the jar
./gradlew clean build jacocoTestReport pokerJar

Once the build is complete you can see the code coverage ,code style and  code analysis report below in the project directory
./build/jacocoHtml/index.html
./build/reports/checkstyle/main.html
./build/reports/checkstyle/test.html
./build/reports/findbugs/main.html
./build/reports/tests/test/index.html

To Execute the Program as a executable , you can run this from the project dir
java -jar build/libs/poker-all-1.0-SNAPSHOT.jar ./src/test/resources/pokerCardHand.txt

You should be able to see the output printed in the console

Prabeen Jayaraj