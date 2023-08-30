package org.example.custom.database;

import org.example.custom.database.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
It should be possible to create or delete tables in a database.
A table definition comprises columns which have types. They can also have constraints
The supported column types are string and int.
The string type can have a maximum length of 20 characters.
The int type can have a minimum value of -1024 and a maximum value of 1024.
Support for mandatory fields (tagging a column as required)
It should be possible to insert records in a table.
It should be possible to print all records in a table.
It should be possible to filter and display records whose column values match a given value.
It should be possible to alter table to add/drop columns
It should be possible to creating index on a column
It should be possible to drop index of a column

create table <tablename><col_name datatype(size)>
insert values() into <tablename>

Table -> Rows -> Cells
*/
public class DatabaseOperator {

    private static Map<String, Table> dbMap = new HashMap<>();

    private static List<Row> rows = new ArrayList<>();

    //create table
    private static void createTable(String tableName, List<String> columns){

        //check if the table already exists
        if(dbMap.containsKey(tableName)){
            System.out.println("Table already exists!");
            System.exit(0);
        }

        Table t = new Table();
        List<Column> cols = new ArrayList<>();

        //else parse the input and create the table
        for(int i = 0; i < columns.size(); i++){
            String[] colMetaData = columns.get(i).split(" ");
            String colName = colMetaData[0];
            String dataType = colMetaData[1];
            boolean isNullable =  Boolean.parseBoolean(colMetaData[2]);
            Column col = new Column();
            col.setColumnName(colName);
            col.setNullable(isNullable);
            Datatype dt = new Datatype();
            dt.setTypeName(dataType);
            col.setDatatype(dt);
            cols.add(col);
        }

        t.setColumns(cols);
        dbMap.put(tableName, t);
    }

    //insert data
    private static void insertRecord(String tableName, String data) {

        //if the table doesn't exist in DB
        if(!dbMap.containsKey(tableName)){
            System.out.println("No such table found!");
        }else{
            Table t = dbMap.get(tableName);
            List<Boolean> isNullable = new ArrayList<>();
            List<Column> colsInTable;
            colsInTable = t.getColumns();
            for(int i = 0; i < colsInTable.size(); i++){
                isNullable.add(colsInTable.get(i).isNullable());
            }
            rows = t.getRows();
            List<Cell> cells = new ArrayList<>();

            String[] dataValues = data.split(",");
            if(dataValues.length != colsInTable.size()){
                System.out.println("Insufficient values supplied");
                System.exit(0);
            }
            Row r = new Row();
            for(int i = 0; i < dataValues.length; i++){
                if(dataValues[i].equalsIgnoreCase("null")){
                    if(isNullable.get(i) == false){
                        System.out.println("Column is non nullable");
                        System.exit(0);
                    }
                }
                Cell c = new Cell();
                c.setValue(dataValues[i]);
                cells.add(c);
                r.setCells(cells);

            }
            rows.add(r);
            t.setRows(rows);
            dbMap.put(tableName, t);
        }
    }

    //select query
    private static void selectRecords(String tableName){
        if(!dbMap.containsKey(tableName)){
            System.out.println("No such table!");
            System.exit(0);
        }else{
            Table t = dbMap.get(tableName);
            List<Row> rows = t.getRows();
            System.out.println("Data:");
            for(int i = 0; i < rows.size(); i++){
                System.out.println();
                List<Cell> cells =rows.get(i).getCells();
                for(int j = 0; j < cells.size(); j++){
                    System.out.print( cells.get(j).getValue() + ",");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        String tableName = "test_tbl";

        List<String> cols = new ArrayList<>();
        cols.add("txn_id int false");
        cols.add("amt int false");
        cols.add("date string false");
        cols.add("bill_address string true");

        createTable(tableName, cols);
//        createTable(tableName, cols);

//        String nonExistentTable = "bermuda_tbl";

        String data = "123,1000,16022022,blr";
        insertRecord(tableName, data);
//        insertRecord(nonExistentTable, data);

        selectRecords(tableName);
    }
}
