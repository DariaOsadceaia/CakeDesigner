package com.cake.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Array;
import com.cake.components.CakeBase;
import com.cake.components.CakeCream;
import com.cake.components.Extra;

/**
 * Created by Gerika on 10.04.2016.
 */
public class FirstScreenView {

    public SpriteBatch batch;
    public BitmapFont font;
    public Skin skin;
    public Stage stage;

    public TextButton nextScreenButton;


    public Label baseLabel;
    public Label formLabel;
    public Label checkTierapartLabel;
    public Label countTiersLabel;
    public Label weightLabel;

    public Label forWeightSliderLabel;
    public Label forTierSliderLabel;
    public Label forCakeSliderLabel;



    public Label creamLabel;
    public Label extraLabel;
    public Label countOfCakesLabel;
    public Label priceLabel;

    public SelectBox creamSelectBox;
    public SelectBox extrasSelectBox;


    public final SelectBox languageSelectBox;
    public final SelectBox baseSelectBox;
    public final SelectBox formSelectBox;
    public final CheckBox tiersApartCheckBox;
    public final Slider weightSlider;
    public final Slider countOfTiers;
    public Slider countOfCakesSlider;

    public Image baseImage;
    
    public Image creamImage;
    public Image extraImage;


    public FirstScreenView(Array<CakeBase> b,Array<CakeCream> c,Array<Extra> e) {

        batch = new SpriteBatch();
        // Use LibGDX's default Arial font.
        font = new BitmapFont();
        //this.setScreen(new MainMenuScreen(this));


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);


//This all is UI initialization
        skin = new Skin();

        //add new Ninepatch.

        //It isjust small transparent image, used when we don't want any ninepatch,but Libgdx want it

        skin.add("default", new NinePatch(new Texture(Gdx.files.internal("empty.png")), 10, 0, 0, 0));
        //these images for SelectBox
        skin.add("dbutton", new NinePatch(new Texture(Gdx.files.internal("UI/but002.png")), 10, 0, 0, 0));
        skin.add("lbutton", new NinePatch(new Texture(Gdx.files.internal("UI/but001.png")), 10, 0, 0, 0));
        //images for sliders
        skin.add("sliderLine",new NinePatch(new Texture(Gdx.files.internal("UI/slid001.png")), 10, 0, 0, 0));
        skin.add("sliderKnob",new NinePatch(new Texture(Gdx.files.internal("UI/round001.png")), 10, 0, 0, 0));
        //for checkbox
        skin.add("unchecked",new NinePatch(new Texture(Gdx.files.internal("UI/check1.png")), 10, 0, 0, 0));
        skin.add("checked",new NinePatch(new Texture(Gdx.files.internal("UI/check2.png")), 10, 0, 0, 0));


        //load pictures for cake
        for(int i=0;i<b.size;i++) {
            for (int k=0;k<b.get(i).getViewer().getImage().size;k++)
            skin.add("base" + b.get(i).getId()+"_"+k, new NinePatch(b.get(i).getViewer().getImage().get(k), 0, 0, 0, 0));
        }


            for (int i = 0; i < c.size; i++) {
                for (int k=0;k<c.get(i).getViewer().getImage().size;k++)
                skin.add("cream" + c.get(i).getId()+"_"+k, new NinePatch(c.get(i).getViewer().getImage().get(k), 0, 0, 0, 0));

            }

        for(int i=0;i<e.size;i++) {
            for (int k=0;k<e.get(i).getViewer().getImage().size;k++)
            skin.add("extra"+e.get(i).getId()+"_"+k,new NinePatch(e.get(i).getViewer().getImage().get(k), 0, 0, 0, 0));

        }

            //default SelectboxStyle.No images
        SelectBox.SelectBoxStyle selectBoxStyle = new SelectBox.SelectBoxStyle();
        selectBoxStyle.font = font;
        selectBoxStyle.background = skin.getDrawable("dbutton");
        selectBoxStyle.backgroundDisabled = skin.getDrawable("dbutton");
        selectBoxStyle.backgroundOpen = skin.getDrawable("lbutton");
        selectBoxStyle.backgroundOver = skin.getDrawable("dbutton");
        selectBoxStyle.listStyle = new List.ListStyle(font, Color.CORAL, Color.WHITE, skin.getDrawable("dbutton"));
        selectBoxStyle.scrollStyle = new ScrollPane.ScrollPaneStyle(skin.getDrawable("dbutton"), skin.getDrawable("dbutton"), skin.getDrawable("dbutton"), skin.getDrawable("dbutton"), skin.getDrawable("dbutton"));
        selectBoxStyle.disabledFontColor = Color.BLUE;
        selectBoxStyle.fontColor = Color.WHITE;

        skin.add("default", selectBoxStyle);


            //default LabelStyle.No images,just text
        skin.add("default", new Label.LabelStyle(font, Color.BROWN));

            //default TextButtonStyle.No images
        skin.add("default", new TextButton.TextButtonStyle(skin.getDrawable("dbutton"), skin.getDrawable("lbutton"), skin.getDrawable("dbutton"), font));
            //default CheckBoxStyle
        skin.add("default", new CheckBox.CheckBoxStyle(skin.getDrawable("unchecked"), skin.getDrawable("checked"), font, Color.BROWN));
            //default SliderStyle
            //skin.add("default", new Slider.SliderStyle(skin.getDrawable("default"), skin.getDrawable("default")));
        skin.add("default-horizontal", new Slider.SliderStyle(skin.getDrawable("sliderLine"), skin.getDrawable("sliderKnob")));


            //create all items for menu
        languageSelectBox = new SelectBox(skin);
        languageSelectBox.setItems(new String[]{"english", "russian", "romanian"});
        languageSelectBox.setBounds(500, 440, 140, 40);



        baseLabel = new Label("Base", skin);
        baseLabel.setBounds(500, 400, 140, 40);

        baseSelectBox = new SelectBox(skin);
        baseSelectBox.setBounds(500, 360, 140, 40);


        creamLabel = new Label("Cream",skin);
        creamLabel.setBounds(500,320,140,40);

        creamSelectBox = new SelectBox(skin);
        creamSelectBox.setBounds(500,280,140,40);

        extraLabel = new Label("Extra",skin);
        extraLabel.setBounds(500,240,140,40);

        extrasSelectBox = new SelectBox(skin);
        extrasSelectBox.setBounds(500,200,140,40);


        priceLabel = new Label("Price: ", skin);
        priceLabel.setBounds(450, 80, 140, 30);

        nextScreenButton = new TextButton("Ready",skin);
        nextScreenButton.setBounds(450,40,140,40);
        //nextScreenButton.addListener();



        formLabel = new Label("Form", skin);
        formLabel.setBounds(0, 300, 130, 45);

        checkTierapartLabel = new Label("Is Tiers Apart", skin);
        checkTierapartLabel.setBounds(0, 200, 130, 30);

        countTiersLabel = new Label("Count of Tiers", skin);
        countTiersLabel.setBounds(0, 440, 200, 20);

        weightLabel = new Label("Weight", skin);
        weightLabel.setBounds(0, 380, 140, 25);

        tiersApartCheckBox = new CheckBox("Is Tiers Apart?", skin);
        tiersApartCheckBox.setBounds(0, 175, 130, 30);


        formSelectBox = new SelectBox(skin);
        formSelectBox.setItems(new String[]{"round", "cube"});
        formSelectBox.setBounds(0, 260, 130, 40);

        weightSlider = new Slider(0.5f, 10f, 0.5f, false, skin);
        weightSlider.setBounds(0, 360, 200, 25);
        weightSlider.setName("Weight");
        forWeightSliderLabel = new Label(" "+weightSlider.getValue()+"",skin);
        forWeightSliderLabel.setBounds(201, 360, 10, 25);


        countOfTiers = new Slider(1f, 4f, 1f, false, skin);
        countOfTiers.setBounds(0, 420, 200, 20);
        countOfTiers.setName("Count of tiers");
        forTierSliderLabel=new Label(" "+countOfTiers.getValue()+"",skin);
        forTierSliderLabel.setBounds(201, 420, 10, 25);

        countOfCakesLabel = new Label("Count of cakes",skin);
        countOfCakesLabel.setBounds(0,45,200,20);

        countOfCakesSlider = new Slider(1,15,1,false,skin);
        countOfCakesSlider.setBounds(0,25,200,20);

        forCakeSliderLabel = new Label(" "+countOfCakesSlider.getValue()+"",skin);
        forCakeSliderLabel.setBounds(201,25,10,25);


            //this code fragment displays Cake

        baseImage = new Image(skin.getDrawable("base"+b.get(0).getId()+"_"+0));
        baseImage.setBounds(180,100,300,200);
        creamImage = new Image(skin.getDrawable("cream"+c.get(0).getId()+"_"+0));
        creamImage.setBounds(180,100,300,200);
        extraImage = new Image(skin.getDrawable("extra"+b.get(0).getId()+"_"+0));
        extraImage.setBounds(180, 100, 300, 200);




        //just add this
        //it will not work until stage doesn't know about it
        stage.addActor(languageSelectBox);

        stage.addActor(baseLabel);
        stage.addActor(baseSelectBox);

        stage.addActor(creamLabel);
        stage.addActor(creamSelectBox);

        stage.addActor(extraLabel);
        stage.addActor(extrasSelectBox);

        stage.addActor(priceLabel);
        stage.addActor(nextScreenButton);

        stage.addActor(formLabel);
        stage.addActor(formSelectBox);

        stage.addActor(countOfCakesLabel);
        stage.addActor(countOfCakesSlider);
        stage.addActor(forCakeSliderLabel);

        stage.addActor(tiersApartCheckBox);

        stage.addActor(countTiersLabel);

        stage.addActor(weightLabel);
        stage.addActor(weightSlider);
        stage.addActor(forWeightSliderLabel);

        stage.addActor(countOfTiers);
        stage.addActor(forTierSliderLabel);

        stage.addActor(baseImage);
        stage.addActor(creamImage);
        stage.addActor(extraImage);




        }




}