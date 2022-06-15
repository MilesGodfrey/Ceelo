#! /usr/bin/env python3
# Ceelo - Miles Godfrey
import random
import time
#getHand Method
def getHand():
        a = random.randrange(1,7)
        b = random.randrange(1,7)
        c = random.randrange(1,7)
        hand = [a,b,c]
        
        
        return sorted(hand)

def checkHand(hand):
    handValue = 0
    if hand == [1,2,3]:
        handValue = 0
    elif hand == [4,5,6]:
        handValue = 13
    elif hand[0] == hand[1] and hand[1] == hand[2]:
        handValue = hand[0] + 6
    elif hand[0] == hand[1]:
        handValue = hand[2]
    elif hand[1] == hand[2]:
        handValue = hand[0]
    else:
        handValue = -2

    return handValue
    

def opponent(players):
    opponentScores = [players]
    for i in range (int(players)):
        handValue = -2
        while handValue < -1:
            hand = getHand()
            handValue = checkHand(hand)
        time.sleep(1.5)
        print("opponent "+str(i)+" hand: " + str(hand))
        print("opponent "+str(i)+" score: " + str(handValue))
        opponentScores.append(handValue)
    return opponentScores
   


print("Welcome to my Ceelo game.")
print("Ceelo is a Chinese dice rolling game. ")
print("The rules are very simple.")
print("You roll 3 dice and if you get a match")
print("the third dice is your score. For example,")
print("a 1,1,5 would be a score of 5.")
print("Highest score wins the game. 1,2,3 is an instant lose,")
print("and 4,5,6 is an instant win unless someone else can roll it too")
print("triples are better than any double so a 1,1,1 will beat a 5,5,6")
print("")
choice = input("Enter 1 to play.")
players = input("how many opponents? (at least 1 opponent must be chosen)")
if int(players) < 1:
    choice = 2
    print("must have at least one opponent")
while choice == "1":
    bet = input("How much money do you bet? (opponent(s) will match)")
    handValue = -2
    while handValue < -1:
        hand = getHand()
        handValue = checkHand(hand)
        print("rolling...")
        print(hand)
        time.sleep(1)
    
    print("Current Score: "+str(handValue))

    opponentScores = opponent(players)
    lose = False;
        
    for i in range (int(players)):
        if handValue < opponentScores[i+1]:
            lose = True;
        elif handValue == opponentScores[i+1]:
            lose = True;
        
            
            
    if lose == False: #The logic isnt perfect here but it will work just fine
        print("You Win!")
        bet = int(bet) * int(players)
        print("amount:" + str(bet) + "$")
    elif lose == True:
        print("You lose")
        bet = 0
        print("amount:" + str(bet) + "$")
            

        
            
    
    
    


    choice = input("Enter 1 to play again, and enter 2 to exit")
print("thanks for playing!")

