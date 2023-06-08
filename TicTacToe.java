package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean checkWinner(int array[][], char player) {

        for (int i = 0; i < array.length; i++) {                                                    //check lines
            if (array[i][0] == player && array[i][1] == player && array[i][2] == player) {
                return true;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if(array[0][j] == player && array[1][j] == player && array[2][j] == player) {        //check columns
                return true;
            }
        }
        if(array[0][0] == player && array[1][1] == player && array[2][2] == player) {       //check diagonals
            return true;
        }
        if(array[0][2] == player && array[1][1] == player && array[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        int grid[][] = new int[3][3];                        // 2D array to simplify program

        System.out.println("---------");                      //this loop  fills grid with empty cells
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
                System.out.print((char) grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

            boolean validInput = false;

            int playerRow = 0;

            while (!validInput) {     // condition ,if is not valid input , print exception and take another input from user

                try {
                    String[] usersCoordinates = scanner.nextLine().split(" ");  //entry user coordinates converted to String array
                    int lines = Integer.parseInt(usersCoordinates[0]);               //first coordinate is line and second is column
                    int columns = Integer.parseInt(usersCoordinates[1]);

                    boolean coordinatesRange = (lines <= 3 && lines > 0) && (columns <= 3 && columns > 0);

                    if (!coordinatesRange) {

                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                    else if (grid[lines - 1][columns - 1] != ' ') {

                        System.out.println("The cell is already occupied!");
                    }
                    else if (playerRow % 2 == 0) {
                        grid[lines - 1][columns - 1] = 'X';
                        System.out.println("---------");                             //this is the player X
                        for (int i = 0; i < grid.length; i++) {
                            System.out.print("| ");
                            for (int j = 0; j < grid[i].length; j++) {
                                System.out.print((char) grid[i][j] + " ");
                            }
                            System.out.println("|");
                        }
                        playerRow++;
                        System.out.println("---------");
                          if (checkWinner(grid,'X')){
                            System.out.println("X wins");
                            validInput = true;
                        }
                    }
                    else if (playerRow % 2 != 0) {
                        grid[lines - 1][columns - 1] = 'O';
                        System.out.println("---------");                                //this is the player O
                        for (int i = 0; i < grid.length; i++) {
                            System.out.print("| ");
                            for (int j = 0; j < grid[i].length; j++) {
                                System.out.print((char) grid[i][j] + " ");
                            }
                            System.out.println("|");
                        }
                        playerRow++;
                        System.out.println("---------");
                        if (checkWinner(grid,'O')){
                            System.out.println("O wins");
                            validInput = true;
                        }
                      }
                   if( !checkWinner(grid,'X') && !checkWinner(grid, 'O') && playerRow == 9){    //Draw option
                        System.out.println("Draw");
                        validInput = true;
                    }
                  }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("You should enter two valid numbers!");
                }
              }
            }
          }




