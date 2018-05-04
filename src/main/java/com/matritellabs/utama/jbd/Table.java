package com.matritellabs.utama.jbd;

public class Table {
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
    public void setTableField(int horzCoordinate, int vertCoordinate) {
        tableArray[horzCoordinate][vertCoordinate] = 1;
    }

    // Print Table Method
    public void printTable() {
        System.out.println("    A B C D E F G H I J");
        System.out.println("    -------------------");
        for (int row = 0; row < tableArray.length ; row++) {
            for (int column = 0; column < tableArray[row].length ; column++) {

                if (column == 0 && row != 9){
                    System.out.print(""+ (row + 1) + " | ");

                }else if (column == 0) {
                    System.out.print(""+ (row + 1) + "| ");
                }

                System.out.print(tableArray[row][column] + " ");


            }

            System.out.println();
        }
    }

}
