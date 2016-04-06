package com.cake.DataBaseWorker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.cake.components.CakeBase;
import com.cake.grafics.VCakeBase;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Gerika on 19.03.2016.
 */
public class BasesTableEditor {

    public static void createBaseTable(Connection conn, Statement stat) {

        try {

            stat.executeUpdate("drop table if exists bases;");

            stat.executeUpdate("create table bases (id,name, image,price);");
            //add new values,4 columns:id,name, image,price
            //first - id
            //second - name
            //third - image
            //forth - price
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


    public static Array readBasesTable(Connection conn, Statement stat) {

        ResultSet rs = null;
        Array<CakeBase> bases = new Array<CakeBase>();
        try {
            //
            rs = stat.executeQuery("select * from bases;");


            while (rs.next()) {
                //get new values
                //first - id
                //second - name
                //third - image
                //forth - price
                bases.add(new CakeBase(rs.getInt(1),rs.getString(2),new VCakeBase(new Texture(Gdx.files.internal(rs.getString(3)))),rs.getFloat(4)));

            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bases;

    }

    public static void writeBasesTable(Connection conn, Statement stat,LinkedList a){

        //to add new rows without deleting table
        //first - id
        //second - name
        //third - image
        //forth - price

        PreparedStatement prep = null;
        CakeBase c;

        try {
            prep = conn.prepareStatement(
                    "insert into bases values (?, ?, ?, ?);");
        Iterator<CakeBase> iterator= a.iterator();
        while (iterator.hasNext()) {

            c = iterator.next();
            prep.setInt(1, c.getId());
            prep.setString(2,c.getName());
            prep.setString(3,c.getViewer().toString());
            prep.setDouble(4,c.getCost());
            prep.addBatch();
        }



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
}

