import random

numSpaces = 40;

def dieSum(a, b):
    return a + b;

def dieRoll(location):

   
    
    print("Currently on: " + str(board[location]))
    print("Rolling...");
    die_one = random.randint(1,6);
    die_two = random.randint(1,6);

    roll_total = dieSum(die_one, die_two);

    print("You rolled a " + str(roll_total) + "!");

    if (location + roll_total) < numSpaces:
        location += roll_total
    elif (location + roll_total) >= numSpaces:
        print("You passed GO! You get $200!");
        location = (location + roll_total - numSpaces)
        
   
    print("You advanced to: " + str(board[location]))

    if die_one == die_two:
        print("Doubles! Rolling again...")
        dieRoll(location)

    return location;


board = ["GO", "Mediterranean Ave", "Community Chest", "Baltic Ave", "Income tax", "Reading Railroad", "Oriental Ave", "Chance", "Vermont Ave", "Connecticut Ave", "Jail",
         "St. Charles Place", "Electric Company", "States Ave", "Virginia Ave", "Pennsylvania Railroad", "St. James Place", "Community Chest", "Tennessee Ave", "New York Ave", "Free Parking",
         "Kentucky Ave", "Chance", "Indiana Ave", "Illinois Ave", "B & O Railroad", "Atlantic Ave", "Ventnor Ave", "Water Works", "Marvin Gardens", "Go to Jail!",
         "Pacific Ave", "North Carolina Ave", "Community Chest", "Pacific Ave", "Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk"]

locationPos = 0;

boardLocation = board[0];

temp = 'a'
while temp != 'q':
    locationPos = dieRoll(locationPos);
    temp = input("q to quit");
