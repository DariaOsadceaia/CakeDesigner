package com.cake.DataBaseWorker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.cake.components.Extra;
import com.cake.grafics.VExtra;

import java.sql.*;

/**
 * Created by Gerika on 20.03.2016.
 */
public class ExtrasTableEditor {

    public static void createExtrasTable(Connection conn,Statement stat){

        try {

            stat.executeUpdate("drop table if exists extras;");

            stat.executeUpdate("create table extras (id,name, image,price,image2,image3);");
            //add new values,4 columns:id,name, image,price
            PreparedStatement prep = conn.prepareStatement(
                    "insert into extras values (?, ?, ?, ?, ?, ?);");

            prep.setInt(1, 1);
            prep.setString(2, "Cherry");
            prep.setString(3, "sprite/e001.png");
            prep.setDouble(4, 7.00);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();

            prep.setInt(1, 2);
            prep.setString(2, "Strawberry");
            prep.setString(3, "sprite/e002.png");
            prep.setDouble(4, 7.00);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();

            prep.setInt(1,3);
            prep.setString(2,"None");
            prep.setString(3,"sprite/e000.png");
            prep.setDouble(4,0.00);
            prep.setString(5, "none");
            prep.setString(6, "none");
            prep.addBatch();



            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            //take results in rs
            ResultSet rs = stat.executeQuery("select * from extras;");
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


    public static com.badlogic.gdx.utils.Array readExtrasTable(Connection conn, Statement stat) {

        ResultSet rs = null;
        com.badlogic.gdx.utils.Array<Extra> extras = new com.badlogic.gdx.utils.Array<Extra>();
        try {
            //
            rs = stat.executeQuery("select * from extras;");


            while (rs.next()) {
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
                extras.add(new Extra(rs.getInt(1), rs.getString(2), new VExtra(ar), rs.getFloat(4)));

            }
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extras;

    }


}
