# Sudoku

##Validate
To validate a sudoku run the compiled application with the following command:

java -jar .\sudoku-1.0.jar <sudoku.csv> validate

###Example output for a valid sudoku
<pre>This sudoku is valid :)</pre>

###Example output for an invalid sudoku
<pre>This sudoku is not valid :(</pre>

##Solve
To solve a sudoku run the compiled application with the following command:

java -jar .\sudoku-1.0.jar <sudoku.csv> solve

###Example input for an incomplete sudoku
Please note that the zeroes represent empty fields.
<pre>4,3,5,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0</pre>

###Example output for a solved sudoku
<pre>I solved the sudoku for you :)
4,3,5,2,6,9,7,8,1
6,8,2,5,7,1,4,9,3
1,9,7,8,3,4,5,6,2
8,2,6,1,9,5,3,4,7
3,7,4,6,8,2,9,1,5
9,5,1,7,4,3,6,2,8
5,1,9,3,2,6,8,7,4
2,4,8,9,5,7,1,3,6
7,6,3,4,1,8,2,5,9</pre>
