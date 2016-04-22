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
 * Created by Gerika on 10.04.2016.
 */
public class FirstScreenView  {

    SpriteBatch batch;
    BitmapFont font;
    Skin skin;
    Stage stage;
    Table table;

    TextButton nextScreenButton;

    Label priceLabel;
    Label baseLabel;
    Label formLabel;
    Label checkTierapartLabel;
    Label countTiersLabel;
    Label weightLabel;

    SelectBox languageSelectBox;
    SelectBox baseSelectBox;
    SelectBox formSelectBox;
    CheckBox tiersApartCheckBox;
    Slider weightSlider;
    Slider CountOfTiers;



    public FirstScreenView(){


        batch = new SpriteBatch();
        // Use LibGDX's default Arial font.
        font = new BitmapFont();
        //this.setScreen(new MainMenuScreen(this));


        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        skin = new Skin();

        //add new Ninepatch.Itisjust small transparent image, used when we don't want any ninepatch,but Libgdx want it
        skin.add("default", new NinePatch(new Texture(Gdx.files.internal("empty.png")), 10, 0, 0, 0));

        //default SelectboxStyle.No images
        skin.add("default",new SelectBox.SelectBoxStyle(font, Color.CORAL,skin.getDrawable("default"),
                new ScrollPane.ScrollPaneStyle(skin.getDrawable("default"),skin.getDrawable("default"),skin.getDrawable("default"),skin.getDrawable("default"),skin.getDrawable("default")),
                new List.ListStyle(font, Color.CYAN,Color.BLACK,skin.getDrawable("default"))));


        //default LabelStyle.No images,just text
        skin.add("default",new Label.LabelStyle(font,Color.BLACK));

        //default TextButtonStyle.No images
        skin.add("default",new TextButton.TextButtonStyle(skin.getDrawable("default"),skin.getDrawable("default"),skin.getDrawable("default"),font));
        //default CheckBoxStyle
        skin.add("default",new CheckBox.CheckBoxStyle(skin.getDrawable("default"),skin.getDrawable("default"),font, Color.BLACK));
        //default SliderStyle
        skin.add("default",new Slider.SliderStyle(skin.getDrawable("default"),skin.getDrawable("default")));



        Table table = new Table();

        //create all items for menu
        languageSelectBox = new SelectBox(skin);
        baseSelectBox = new SelectBox(skin);
        formSelectBox = new SelectBox(skin);


        priceLabel = new Label("Price",skin);
        baseLabel = new Label("Base",skin);
        formLabel = new Label("Form",skin);
        checkTierapartLabel = new Label("Is Tiers Apart",skin);
        countTiersLabel = new Label("Count of Tiers",skin);
        weightLabel = new Label("Weight",skin);

        tiersApartCheckBox = new CheckBox("Is Tiers Apart",skin);

        weightSlider = new Slider(0.5f,10f,0.5f,false,skin);
        CountOfTiers = new Slider(1f,4f,1f,false,skin);


        table.add(languageSelectBox);

        table.add(baseLabel);
        table.add(baseSelectBox);

        table.add(formLabel);
        table.add(formSelectBox);

        table.add(countTiersLabel);



        stage.addActor(table);


    }










}
