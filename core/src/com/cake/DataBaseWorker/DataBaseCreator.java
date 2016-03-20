package com.cake.DataBaseWorker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static com.cake.DataBaseWorker.CreamsTableEditor.createCreamTable;
import static com.cake.DataBaseWorker.BasesTableEditor.createBaseTable;
import static com.cake.DataBaseWorker.ExtrasTableEditor.createExtrasTable;

/**
 * Created by Gerika on 19.03.2016.
 */
public class DataBaseCreator {

    public static void main(String[] args) throws Exception {
        //create sqlite db
        //create new connection with database
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stat = conn.createStatement();
        //create table "bases" in class BasesTableEditor
        //snd others
        //in different classes just because it's more comfortable
        createBaseTable(conn,stat);
        createCreamTable(conn, stat);
        createExtrasTable(conn,stat);

        //after all adds close connection
        conn.close();
    }
}



