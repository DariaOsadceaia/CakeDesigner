package com.cake.DataBaseWorker;

import java.sql.*;

/**
 * Created by Gerika on 19.03.2016.
 */
public class BasesTableEditor {

    static void createBaseTable(Connection conn, Statement stat) {

        try {

            stat.executeUpdate("drop table if exists bases;");

            stat.executeUpdate("create table bases (id,name, image,price);");
            //add new values,4 columns:id,name, image,price
            PreparedStatement prep = conn.prepareStatement(
                    "insert into bases values (?, ?, ?, ?);");

            prep.setInt(1, 1);
            prep.setString(2, "Lemon");
            prep.setString(3, "limobase.png");
            prep.setDouble(4, 20.00);
            prep.addBatch();

            prep.setInt(1, 2);
            prep.setString(2, "Choko");
            prep.setString(3, "chokobase.png");
            prep.setDouble(4, 20.00);
            prep.addBatch();

            prep.setInt(1, 3);
            prep.setString(2, "Choko with nuts");
            prep.setString(3, "chokobase.png");
            prep.setDouble(4, 25.00);
            prep.addBatch();

            prep.setInt(1, 4);
            prep.setString(2, "Marcipan");
            prep.setString(3, "jel.png");
            prep.setDouble(4, 30.0f);
            prep.addBatch();

            prep.setInt(1, 4);
            prep.setString(2, "Orange fluid");
            prep.setString(3, "orange.png");
            prep.setDouble(4, 20.0f);
            prep.addBatch();

            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            //take results in rs
            ResultSet rs = stat.executeQuery("select * from bases;");
            while (rs.next()) {
                //just for watching results
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("price = " + rs.getDouble("price"));
            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    static void readBasesTable(Connection conn, Statement stat) {

        ResultSet rs = null;
        try {
            //
            rs = stat.executeQuery("select * from bases;");

            while (rs.next()) {


            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

