package com.matritellabs.utama.jbd;

public class Table {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLACK = "\u001B[30;1m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_WHITE = "\u001B[37m";

    final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    final String ANSI_RED_BACKGROUND = "\u001B[41;1m";
    final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static int tableSize = 10;
    public int[][] tableArray;

    // Constructor
    public Table() {
        tableArray = new int[tableSize][tableSize];
    }

    // tableSize Getter
    public int getTableSize() {
        return tableSize;
    }

    // tableSize Setter
    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    // Set table field value
    public void setTableField(int horzCoordinate, int vertCoordinate, Ship ship) {
        tableArray[horzCoordinate][vertCoordinate] = ship.shipSize;
    }

    // Print Table Method
    public void printTable2() {
        System.out.println("    A B C D E F G H I J");
        System.out.println("   --------------------");
        for (int row = 0; row < tableArray.length ; row++) {
            for (int column = 0; column < tableArray[row].length ; column++) {

                if (column == 0 && row != 9){
                    System.out.print(""+ (row + 1) + " | ");

                }else if (column == 0) {
                    System.out.print(""+ (row + 1) + "| ");
                }

                System.out.print(tableArray[row][column] + " ");


            }

            System.out.println("|");
        }
        System.out.println("   ====================");

    }
    public void coloring(int input) {
        if (input == 0) {
            System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "   " + ANSI_RESET + " ");
        }
        else if (input == 2) {
            System.out.print(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " " + input+ " " + ANSI_RESET + " ");
        }
        else if (input == 3) {
            System.out.print(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " " + input+ " " + ANSI_RESET + " ");
        }
        else if (input == 4) {
            System.out.print(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " " + input+ " " + ANSI_RESET + " ");
        }
        else if (input == 5) {
            System.out.print(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " " + input+ " " + ANSI_RESET + " ");
        }
        else  if (input == 8 || input == 7) {
            System.out.print(ANSI_GREEN_BACKGROUND + "   " + ANSI_RESET + " ");
        }
        else if (input == 9) {
            System.out.print(ANSI_RED_BACKGROUND  + "   " + ANSI_RESET + " ");
        }
    }

    public void printTable() {
        System.out.println("     A   B   C   D   E   F   G   H   I   J ");
        System.out.println("   ------------------------------------------");
        for (int row = 0; row < tableArray.length ; row++) {
            for (int column = 0; column < tableArray[row].length ; column++) {

                if (column == 0 && row != 9){
                    System.out.print(""+ (row + 1) + " | ");

                }else if (column == 0) {
                    System.out.print(""+ (row + 1) + "| ");
                }
                coloring(tableArray[row][column]);



            }
            System.out.println("|");
            if (row != 9) {
                System.out.println("  |                                         |");
            }

        }
        System.out.println("   =========================================");

    }

}
