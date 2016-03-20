package com.cake.DataBaseWorker;

import java.sql.*;

/**
 * Created by Gerika on 19.03.2016.
 */
public class CreamsTableEditor {

    static void createCreamTable(Connection conn,Statement stat){

        try {

            stat.executeUpdate("drop table if exists creams;");

            stat.executeUpdate("create table creams (id,name, image,price);");
            //add new values,4 columns:id,name, image,price
            PreparedStatement prep = conn.prepareStatement(
                    "insert into creams values (?, ?, ?, ?);");

            prep.setInt(1, 1);
            prep.setString(2, "Milk");
            prep.setString(3,"milkcream.png");
            prep.setDouble(4, 10.00);
            prep.addBatch();

            prep.setInt(1, 2);
            prep.setString(2, "Nuts");
            prep.setString(3,"nutscream.png");
            prep.setDouble(4, 10.00);
            prep.addBatch();

            prep.setInt(1, 3);
            prep.setString(2, "Choko with nuts");
            prep.setString(3,"chokocream.png");
            prep.setDouble(4, 15.00);
            prep.addBatch();

            prep.setInt(1, 4);
            prep.setString(2, "Pistachio");
            prep.setString(3,"fis.png");
            prep.setDouble(4, 17.0f);
            prep.addBatch();

            prep.setInt(1, 4);
            prep.setString(2,"Strawberry Cream");
            prep.setString(3,"mal.png");
            prep.setDouble(4,15.0f);
            prep.addBatch();

            prep.setInt(1,5);
            prep.setString(2,"None");
            prep.setString(3,"zero.png");
            prep.setDouble(4,0);
            prep.addBatch();

            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            //take results in rs
            ResultSet rs = stat.executeQuery("select * from creams;");
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




    }


