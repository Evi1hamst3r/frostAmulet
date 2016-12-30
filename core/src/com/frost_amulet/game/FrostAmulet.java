package com.frost_amulet.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.GdxFileSystem;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.frost_amulet.game.screens.MenuScreen;
import com.sun.glass.ui.Menu;

public class FrostAmulet extends Game {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont fontAnglosax50;
    private float w,h;
    MenuScreen menuScreen;

    @Override
    public void create () {

        this.setScreen(menuScreen = new MenuScreen(this));

        Handler.start();

        w = Handler.getGameWidth(); // width of screen
        h = Handler.getGameHeight(); // height of screen

        camera = new OrthographicCamera(); // 2D camera
        camera.setToOrtho(false, w, h); // y increases upwards, viewport = window
        batch = new SpriteBatch(); // batch drawing

        Handler.setBatch(batch);
        Handler.setGame(this);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/AnglosaxOblique.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        parameter.color = Color.BLACK;
        fontAnglosax50 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!

        Handler.setFont(fontAnglosax50);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 0, 1); // Clear color is yellow
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear buffer with Clear color
        batch.setProjectionMatrix(camera.combined); // Set Projection Matrix
        menuScreen.render(1.0f);


        //batch.begin(); // begin drawing
        //fontAnglosax50.draw(batch, "Hello World", w/2-180, h/2+50); // Draw the Hello World text
       // batch.end(); // end drawing
    }

    @Override
    public void dispose() {
        batch.dispose(); // remove batch when app ending
        fontAnglosax50.dispose(); // remove font when app ending
    }
}