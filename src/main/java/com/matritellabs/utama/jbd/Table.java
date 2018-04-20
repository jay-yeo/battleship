package com.matritellabs.utama.jbd;

public class Table {
    public int tableSize;
    public String[][] tableArray;

    // Constructor
    public Table(int sizeOfTable) {
        tableSize = sizeOfTable;
        tableArray = new String[tableSize][tableSize];
    }

    // tableSize Getter
    public int getTableSize() {
        return tableSize;
    }

    // tableSize Setter
    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    // Print Table Method
    public void printTable(Table inputTable) {
        for (int i = 0; i < inputTable.tableArray.length ; i++) {
            System.out.println(inputTable.tableArray[i]);
        }
    }

}
