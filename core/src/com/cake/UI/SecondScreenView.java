package com.cake.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * Created by Gerika on 16.04.2016.
 */
public class SecondScreenView {

    SpriteBatch batch;
    BitmapFont font;
    Skin skin;
    public Stage stage;

    public Label mainLabel;

    public Label nameLabel;
    public TextField nameField;

    public Label phoneLabel;
    public TextField phoneField;

    public Label organizationLabel;
    public TextField organizationField;

    public Label emailLabel;
    public TextField emailField;

    public Label adressOfDeliveryLabel;
    public TextField adressOfDeliveryField;

    public Label priceLabel;

    public Label timeOfDeliveryLabel;
    public TextField timeOfDeliveryField;

    public Label commentsLabel;
    public TextArea commentsArea;


    public CheckBox needDeliveryCheckBox;

    public TextButton previousScreenButton;
    public TextButton endOrderButton;



    public SecondScreenView(){

        batch = new SpriteBatch();
        // Use LibGDX's default Arial font.
        font = new BitmapFont();
        //this.setScreen(new MainMenuScreen(this));


        stage = new Stage();



//This all is UI initialization
        skin = new Skin();

        //add new Ninepatch.

        //It isjust small transparent image, used when we don't want any ninepatch,but Libgdx want it

        skin.add("default", new NinePatch(new Texture(Gdx.files.internal("empty.png")), 10, 0, 0, 0));

        skin.add("white", new NinePatch(new Texture(Gdx.files.internal("w.png")), 10,10, 10, 10));
        //these images for SelectBox
        skin.add("dbutton", new NinePatch(new Texture(Gdx.files.internal("UI/but002.png")), 10, 10, 0, 0));
        skin.add("lbutton", new NinePatch(new Texture(Gdx.files.internal("UI/but001.png")), 10, 10, 0, 0));

        //for checkbox
        skin.add("unchecked",new NinePatch(new Texture(Gdx.files.internal("UI/check1.png")), 10, 0, 0, 0));
        skin.add("checked",new NinePatch(new Texture(Gdx.files.internal("UI/check2.png")), 10, 0, 0, 0));


        //default LabelStyle.No images,just text
        skin.add("default", new Label.LabelStyle(font, Color.BROWN));

        //default TextButtonStyle.No images
        skin.add("default", new TextButton.TextButtonStyle(skin.getDrawable("dbutton"), skin.getDrawable("lbutton"), skin.getDrawable("dbutton"), font));
        //default CheckBoxStyle
        skin.add("default", new CheckBox.CheckBoxStyle(skin.getDrawable("unchecked"), skin.getDrawable("checked"), font, Color.BROWN));

        skin.add("default",new TextField.TextFieldStyle(font,Color.WHITE,skin.getDrawable("default"),skin.getDrawable("default"),skin.getDrawable("white")));



        mainLabel = new Label("Please,add your contact data!",skin);
        mainLabel.setBounds(100,400,300,80);

        nameLabel = new Label("Name*: ",skin);
        nameLabel.setBounds(100,340,100,20);
        nameField = new TextField("",skin);
       // nameField.setColor(Color.WHITE);
        nameField.setBounds(100,300,100,20);

        phoneLabel = new Label("Phone*:",skin);
        phoneLabel.setBounds(100,280,100,20);
        phoneField= new TextField("",skin);
        phoneField.setBounds(100,260,100,20);

        organizationLabel = new Label("Organization:",skin);
        organizationLabel.setBounds(100,240,100,20);
        organizationField= new TextField("",skin);
        organizationField.setBounds(100,220,100,20);

        emailLabel = new Label("E-mail:",skin);
        emailLabel.setBounds(100,200,100,20);
        emailField= new TextField("",skin);
        emailField.setBounds(100,180,100,20);

        adressOfDeliveryLabel = new Label("Adress of delivery: ",skin);
        adressOfDeliveryLabel.setBounds(100,160,100,20);

        adressOfDeliveryField= new TextField("",skin);
        adressOfDeliveryField.setBounds(100,140,100,20);

        priceLabel = new Label("Price: ",skin);
        priceLabel.setBounds(300,340,100,20);

        timeOfDeliveryLabel = new Label("Time Of delivery",skin);

        timeOfDeliveryField= new TextField("",skin);

        commentsLabel = new Label("Would you like to add some comments",skin);
        commentsLabel.setBounds(300,280,100,20);
        commentsArea = new TextArea("",skin);
        commentsArea.setBounds(300,160,100,100);


        needDeliveryCheckBox = new CheckBox("delivery",skin);
        //needDeliveryCheckBox.setBounds();

        previousScreenButton = new TextButton("Return to Designer",skin);
        previousScreenButton.setBounds(40,40,120,40);

        endOrderButton = new TextButton("Send order ",skin);
        endOrderButton.setBounds(500,40,120,40);



        stage.addActor(mainLabel);

        stage.addActor(nameLabel);
        stage.addActor(nameField);

        stage.addActor(phoneLabel);
        stage.addActor(phoneField);

        stage.addActor(organizationLabel);
        stage.addActor(organizationField);

        stage.addActor(emailLabel);
        stage.addActor(emailField);

        stage.addActor(adressOfDeliveryLabel);
        stage.addActor(adressOfDeliveryField);

        stage.addActor(priceLabel);

        //stage.addActor(timeOfDeliveryLabel);
        //stage.addActor(timeOfDeliveryField);

        stage.addActor(commentsLabel);
        stage.addActor(commentsArea);

        //stage.addActor(needDeliveryCheckBox);

        stage.addActor(previousScreenButton);

        stage.addActor(endOrderButton);




    }







}
