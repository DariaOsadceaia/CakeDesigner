package com.cake.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cake.model.CakeBase;

/**
 * Created by Gerika on 22.02.2016.
 */
public class CakeBaseRender {


    public OrthographicCamera cam;

    ShapeRenderer renderer = new ShapeRenderer();
    public static float CAMERA_WIDTH = 8f;

    public static  float CAMERA_HEIGHT = 5f;


    public int width;
    public int height;
    public float ppuX;    // �������� �� ����� ���� �� X
    public float ppuY;    // �������� �� ����� ���� �� Y
    public CakeBase cakeBase;


    public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float)width / CAMERA_WIDTH;
        ppuY = (float)height / CAMERA_HEIGHT;
    }

//��������� ������

    public void SetCamera(float x, float y){

        this.cam.position.set(x, y, 0);

        this.cam.update();

    }



    public CakeBaseRender(CakeBase cakeBase) {



        this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);

//������������� ������ �� ������

        SetCamera(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);

        cakeBase = new CakeBase();

    }



//�������� �����, ����� �� ������������ ��� ������� ����

    public void render() {
        drawCakeBase();



    }

    private void drawCakeBase(){
        //��� �������������...� ������ ������ � ��������
        renderer.setProjectionMatrix(cam.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(cakeBase.getColor());

        renderer.circle(cakeBase.getPosition().x, cakeBase.getPosition().y, cakeBase.getRadius());
        renderer.circle(cakeBase.getPosition().x,cakeBase.getPosition().y+cakeBase.getHight(),cakeBase.getRadius());


        renderer.end();



    }




}
