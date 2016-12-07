package com.frost_amulet.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.GdxFileSystem;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FrostAmulet extends ApplicationAdapter {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private float w,h;

    @Override
    public void create () {

        Handler.Start();

        String localPath = Gdx.files.getLocalStoragePath() + "/core/assets/";
        System.out.println(localPath);

        w = Handler.getGameWidth(); // width of screen
        h = Handler.getGameHeight(); // height of screen

        camera = new OrthographicCamera(); // 2D camera
        camera.setToOrtho(false, w, h); // y increases upwards, viewport = window
        batch = new SpriteBatch(); // batch drawing

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.absolute(localPath + "fonts/AnglosaxOblique.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 0, 1); // Clear color is yellow
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear buffer with Clear color
        batch.setProjectionMatrix(camera.combined); // Set Projection Matrix
        batch.begin(); // begin drawing
        font.draw(batch, "Hello World", w/2-180, h/2+50); // Draw the Hello World text
        batch.end(); // end drawing
    }

    @Override
    public void dispose() {
        batch.dispose(); // remove batch when app ending
        font.dispose(); // remove font when app ending
    }
}