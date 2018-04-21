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
        for (int i = 0; i < tableArray.length ; i++) {
            for (int j = 0; j < tableArray[i].length ; j++) {
                System.out.print(tableArray[i][j] + " ");
            }
            System.out.println();
        }
    }

}
