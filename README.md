Below, you can find the description of your fourth assignment, which also
includes its output in the Application Walkthrough section.
In this assignment, you are expected to improve your existing Hotel
Reservation System by incorporating inheritance hierarchy and enumerations.
You should add six new classes for different room types called Single, Double,
Club, Family, FamilyView and Suite, which all should be inherited from the
Room class and should all be its subclass. Thus, you need to initialize each
subclass with its relevant room specifications, as provided below, using its
constructor and set the instance variables.
Room Type dailyCost roomSize hasBath
Single $100 15 False
Double $180 30 False
Club $250 45 True
Family $400 50 False
Family with View $450 50 True
Suite $650 80 True
Additionally, you are required to add a static int variable named
totalNumOfReservations in your Reservation class, which will hold the total
number of reservations. In the main method, this variable must be utilized to
keep track of the total number of reservations and should be incremented
using the dot operator (Class.variable) every time a new reservation instance is
created. Then, this variable should be used to print the total number of
reservations.
You need to use Enumerations to specify the menu options by creating a new
enum class called MenuOptions. You should print the menu in the main
method using the enum constants’ textual representations. Furthermore, you
are required to check the user input for the menu by comparing the
MenuOptions constants.
When the application is started, it should prompt the user with the following
menu:
1. Create new Reservation
2. Create new Reservation with Room Type
3. Display all Reservations
4. Display the total number of reservations
5. Exit
When the user selects the 1st option, s/he should be prompted to enter the
relevant information (values corresponding to instance variables) for a new
Room. The default room type will be a Single.
When the user selects the 2nd option, the system will expect the user to input
the generic information about the reservation and lastly the type of the room.
The roomType provided by the user then should be compared using equals()
method and a relevant type of subclass instance should be created. Then, the
created object, which will be a subclass of Room, should be added to the
Reservation object via its constructor. Then fully constructed Reservation
objects should be stored in an array for later use.
When the user selects the 3rd option, the information about all reservations
should be printed with the help of the existing displayInfo() method.
When the user selects the 4th option, the total number of reservations should
be printed by calling the static class variable totalNumOfReservations.
When the user selects the 5th option, the application should be terminated.
Application Walkthrough
1. Create new Reservation
2. Create new Reservation with Room Type
3. Display all Reservations
4. Display the total number of reservations
5. Exit
1
Hotel Name: Hilton
Reservation Month: April
Reservation Start: 10
Reservation End: 16
Reservation created!
1. Create new Reservation
2. Create new Reservation with Room Type
3. Display all Reservations
4. Display the total number of reservations
5. Exit
2
ROOM INFOS:
Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false
Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false
Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true
Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false
Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true
Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true
Hotel Name: Ramada
Room Type: Suite
Reservation Month: July
Reservation Start: 20
Reservation End: 24
Reservation created!
1. Create new Reservation
2. Create new Reservation with Room Type
3. Display all Reservations
4. Display the total number of reservations
5. Exit
3
Reservation for a Single room in Hilton starts on April 10 and ends on April
16. Reservation has a total cost of $600.
Reservation for a Suite room in Ramada starts on July 20 and ends on July 24.
Reservation has a total cost of $5200.
1. Create new Reservation
2. Create new Reservation with Room Type
3. Display all Reservations
4. Display the total number of reservations
5. Exit
4
2 reservations created so far.
1. Create new Reservation
2. Create new Reservation with Room Type
3. Display all Reservations
4. Display the total number of reservations
5. Exit
5


