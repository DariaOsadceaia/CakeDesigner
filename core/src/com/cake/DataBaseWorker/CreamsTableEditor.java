package com.cake.DataBaseWorker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.cake.components.CakeCream;
import com.cake.grafics.VCakeCream;

import java.sql.*;

/**
 * Created by Gerika on 19.03.2016.
 */
public class CreamsTableEditor {

    static void createCreamTable(Connection conn,Statement stat){

        try {

            stat.executeUpdate("drop table if exists creams;");

            stat.executeUpdate("create table creams (id,name, image,price,image2,image3);");
            //add new values,4 columns:id,name, image,price
            PreparedStatement prep = conn.prepareStatement(
                    "insert into creams values (?, ?, ?, ?, ?, ?);");

            prep.setInt(1, 1);
            prep.setString(2, "Milk");
            prep.setString(3, "sprite/c001.png");
            prep.setDouble(4, 10.00);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();


            prep.setInt(1, 2);
            prep.setString(2, "Choko");
            prep.setString(3, "sprite/c002.png");
            prep.setDouble(4, 15.00);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();

            prep.setInt(1, 3);
            prep.setString(2, "Pistachio");
            prep.setString(3, "sprite/c004.png");
            prep.setDouble(4, 17.0f);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();

            prep.setInt(1, 4);
            prep.setString(2, "Strawberry Cream");
            prep.setString(3, "sprite/c003.png");
            prep.setDouble(4, 15.0f);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();

            prep.setInt(1,5);
            prep.setString(2,"None");
            prep.setString(3,"zero.png");
            prep.setDouble(4,0);
            prep.setString(5, "none");
            prep.setString(6, "none");
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


    public static com.badlogic.gdx.utils.Array readCreamsTable(Connection conn, Statement stat) {

        ResultSet rs = null;
        com.badlogic.gdx.utils.Array<CakeCream> creams = new com.badlogic.gdx.utils.Array<CakeCream>();
        try {
            //
            rs = stat.executeQuery("select * from creams;");


            while (rs.next()) {
                //get new values
                //first - id
                //second - name
                //third - image
                //forth - price
                //get new values
                //first - id
                //second - name
                //third - image
                //forth - price
                com.badlogic.gdx.utils.Array<Texture> ar = new com.badlogic.gdx.utils.Array<Texture>();

                Texture t1 = new Texture(Gdx.files.internal(rs.getString(3)));
                ar.add(t1);
                if(!rs.getString(5).equals("none")&&!rs.getString(5).isEmpty()){
                    Texture t2 = new Texture(Gdx.files.internal(rs.getString(5)));
                    ar.add(t2);
                }

                if(!rs.getString(6).equals("none")&&!rs.getString(6).isEmpty()){
                    Texture t3 = new Texture(Gdx.files.internal(rs.getString(6)));
                    ar.add(t3);
                }


                creams.add(new CakeCream(rs.getInt(1), rs.getString(2), new VCakeCream(ar), rs.getFloat(4)));

            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creams;

    }




    }


