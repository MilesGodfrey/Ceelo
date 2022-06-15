# Cee-lo is a Chinese dice game that has slowly transitioned to a worldwide street gambling game. Cee-lo is played by placing a bet and rolling 3 dice. If you get a double then the third dice is your score (Ex: 1,1,6 = 6 and 4,4,4 = 4). If you roll a 1,2,3 you lose and if you roll 4,5,6 you win. If no value is rolled (Ex: 1,3,4) then a reroll is given. Winner takes the pot, and the loser loses his bet.
# I uploaded two versions and it should be known that the Java version is the street version (no triples) while the Python version is the ancient chinese version with triples so the score heirarchy would be as follows:
1,2,3 (insant lose)
#,#,1
#,#,2
#,#,3
#,#,4
#,#,5
#,#,6
1,1,1
2,2,2
3,3,3
4,4,4
5,5,5
6,6,6
4,5,6 (insant win)
