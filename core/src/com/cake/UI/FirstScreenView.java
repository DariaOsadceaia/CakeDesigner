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
import com.cake.others.Disposition;

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

        //add new Ninepatch.Itisjust small transparent image, used when we don't want any ninepatch,but Libgdx want it
        skin.add("default", new NinePatch(new Texture(Gdx.files.internal("empty.png")), 10, 0, 0, 0));
        skin.add("slider_knob_light", new NinePatch(new Texture(Gdx.files.internal("r02.png")), 10, 0, 0, 0));
        skin.add("slider_knob_dark", new NinePatch(new Texture(Gdx.files.internal("r01.png")), 10, 0, 0, 0));
        skin.add("light_rect", new NinePatch(new Texture(Gdx.files.internal("s1.png")), 10, 0, 0, 0));
        skin.add("dark_button", new NinePatch(new Texture(Gdx.files.internal("but3.png")), 10, 0, 0, 0));


        //load pictures for cake
        for(int i=0;i<b.size;i++) {
            skin.add("base" + b.get(i).getId(), new NinePatch(b.get(i).getViewer().getImage(), 10, 0, 0, 0));
        }


            for (int i = 0; i < c.size; i++) {
                skin.add("cream" + c.get(i).getId(), new NinePatch(c.get(i).getViewer().getImage(), 10, 0, 0, 0));

            }

        for(int i=0;i<e.size;i++) {
            skin.add("extra"+e.get(i).getId(),new NinePatch(e.get(i).getViewer().getImage(), 10, 0, 0, 0));

        }

            //default SelectboxStyle.No images
            SelectBox.SelectBoxStyle selectBoxStyle = new SelectBox.SelectBoxStyle();
            selectBoxStyle.font = font;
            selectBoxStyle.background = skin.getDrawable("default");
            selectBoxStyle.backgroundDisabled = skin.getDrawable("default");
            selectBoxStyle.backgroundOpen = skin.getDrawable("default");
            selectBoxStyle.backgroundOver = skin.getDrawable("default");
            selectBoxStyle.listStyle = new List.ListStyle(font, Color.CORAL, Color.DARK_GRAY, skin.getDrawable("default"));
            selectBoxStyle.scrollStyle = new ScrollPane.ScrollPaneStyle(skin.getDrawable("default"), skin.getDrawable("default"), skin.getDrawable("default"), skin.getDrawable("default"), skin.getDrawable("default"));
            selectBoxStyle.disabledFontColor = Color.BLUE;
            selectBoxStyle.fontColor = Color.BROWN;

            skin.add("default", selectBoxStyle);


            //default LabelStyle.No images,just text
            skin.add("default", new Label.LabelStyle(font, Color.BLACK));

            //default TextButtonStyle.No images
            skin.add("default", new TextButton.TextButtonStyle(skin.getDrawable("default"), skin.getDrawable("default"), skin.getDrawable("default"), font));
            //default CheckBoxStyle
            skin.add("default", new CheckBox.CheckBoxStyle(skin.getDrawable("default"), skin.getDrawable("default"), font, Color.BLACK));
            //default SliderStyle
            //skin.add("default", new Slider.SliderStyle(skin.getDrawable("default"), skin.getDrawable("default")));
            skin.add("default-horizontal", new Slider.SliderStyle(skin.getDrawable("light_rect"), skin.getDrawable("slider_knob_light")));


            //create all items for menu
            languageSelectBox = new SelectBox(skin);
            languageSelectBox.setItems(new String[]{"english", "russian", "romanian"});
            languageSelectBox.setBounds(550, 450, 100, 25);

            baseSelectBox = new SelectBox(skin);
            baseSelectBox.setBounds(550, 400, 100, 25);

            formSelectBox = new SelectBox(skin);
            formSelectBox.setItems(new String[]{"round", "cube"});
            formSelectBox.setBounds(550, 350, 100, 25);

            creamSelectBox = new SelectBox(skin);
            creamSelectBox.setBounds(550, 300, 100, 25);

            extrasSelectBox = new SelectBox(skin);
            extrasSelectBox.setBounds(550, 250, 100, 25);


            priceLabel = new Label("Price", skin);
            priceLabel.setBounds(550, 50, 100, 25);

            baseLabel = new Label("Base", skin);
            baseLabel.setBounds(550, 425, 100, 25);

            formLabel = new Label("Form", skin);
            formLabel.setBounds(550, 375, 100, 25);

            checkTierapartLabel = new Label("Is Tiers Apart", skin);
            checkTierapartLabel.setBounds(500, 300, 100, 25);

            countTiersLabel = new Label("Count of Tiers", skin);
            countTiersLabel.setBounds(0, 450, 100, 25);

            weightLabel = new Label("Weight", skin);
            weightLabel.setBounds(0, 410, 100, 25);

            tiersApartCheckBox = new CheckBox("Is Tiers Apart?", skin);
            tiersApartCheckBox.setBounds(500, 275, 100, 100);

            weightSlider = new Slider(0.5f, 10f, 0.5f, false, skin);
            weightSlider.setBounds(0, 400, 100, 25);

            countOfTiers = new Slider(10f, 40f, 10f, false, skin);
            countOfTiers.setBounds(0, 300, 100, 25);


            //this code fragment displays Cake

            baseImage = new Image(skin.getDrawable("base"+b.get(0).getId()));
            baseImage.setAlign(Disposition.SCREEN_WIDTH / 2);
            creamImage = new Image(skin.getDrawable("cream"+c.get(0).getId()));
            extraImage = new Image(skin.getDrawable("extra"+b.get(0).getId()));


            stage.addActor(languageSelectBox);

            stage.addActor(baseLabel);
            stage.addActor(baseSelectBox);

            stage.addActor(creamSelectBox);

            stage.addActor(extrasSelectBox);

            stage.addActor(formLabel);
            stage.addActor(formSelectBox);

            //stage.addActor(checkTierapartLabel);
            // stage.addActor(tiersApartCheckBox);

            stage.addActor(countTiersLabel);

            stage.addActor(weightLabel);
            stage.addActor(weightSlider);
            stage.addActor(countOfTiers);

            stage.addActor(baseImage);
            stage.addActor(creamImage);
            stage.addActor(extraImage);


//this is Cake Drawing


        }




}