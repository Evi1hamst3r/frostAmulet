package com.frost_amulet.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.frost_amulet.game.FrostAmulet;
import com.frost_amulet.game.Handler;

/**
 * Created by dev on 7/12/16.
 */
public class MenuScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Stage stage;

    private Texture texNewGame;
    private TextureRegion texRegNewGame;
    private TextureRegionDrawable texRegDrawNewGame;
    private ImageButton buttonNewGame;

    private Texture texLoadGame;
    private TextureRegion texRegLoadGame;
    private TextureRegionDrawable texRegDrawLoadGame;
    private ImageButton buttonLoadGame;


  //  private BitmapFont fontAnglosax50;
    private float w,h;

    private float menuButtonWidth;


    private int fontSize;
    MenuScreen menuScreen;


    public MenuScreen(FrostAmulet game){
        System.out.println("Menu Load");

        w = Handler.getGameWidth(); // width of screen
        h = Handler.getGameHeight(); // height of screen
        menuButtonWidth = Handler.getMenuButtonWidth();
        batch = Handler.getBatch(); // batch drawing
        System.out.print(menuButtonWidth);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui


        loadNewGameButton();
        loadLoadGameButton();

        Gdx.input.setInputProcessor(stage); //Start taking input from the ui











       // loadGraphics();




    }




    private void loadNewGameButton(){
        texNewGame = new Texture(Gdx.files.internal("menuButtons/buttonNewGameHover.png"));
        texRegNewGame = new TextureRegion(texNewGame);
        texRegDrawNewGame = new TextureRegionDrawable(texRegNewGame);
        buttonNewGame = new ImageButton(texRegDrawNewGame); //Set the button upz
        buttonNewGame.setBounds(w/2 - menuButtonWidth*Handler.getGlobalTextureScale()/2, 2*h/4 - menuButtonWidth*Handler.getGlobalTextureScale()/4, menuButtonWidth*Handler.getGlobalTextureScale(),menuButtonWidth*Handler.getGlobalTextureScale()/2);
        buttonNewGame.getImageCell().expand().fill(); //Resize the image in the screen

        stage.addActor(buttonNewGame); //Add the button to the stage to perform rendering and take input.

        buttonNewGame.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {

                if(buttonNewGame.isOver()) {

                } else {System.out.println("Shit");}

                return false;}
        });

    }

    private void loadLoadGameButton(){
        texLoadGame = new Texture(Gdx.files.internal("menuButtons/buttonResumeGameHover.png"));
        texRegLoadGame = new TextureRegion(texLoadGame);
        texRegDrawLoadGame = new TextureRegionDrawable(texRegLoadGame);
        buttonLoadGame = new ImageButton(texRegDrawLoadGame); //Set the button upz
        buttonLoadGame.setBounds(w/2 - menuButtonWidth*Handler.getGlobalTextureScale()/2, 3*h/4 - menuButtonWidth*Handler.getGlobalTextureScale()/4, menuButtonWidth*Handler.getGlobalTextureScale(),menuButtonWidth*Handler.getGlobalTextureScale()/2);
        buttonLoadGame.getImageCell().expand().fill(); //Resize the image in the screen

        stage.addActor(buttonLoadGame); //Add the button to the stage to perform rendering and take input.

        buttonLoadGame.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {

                if(buttonLoadGame.isOver()){
                    System.out.println("Die");
                }

                else {System.out.println("Fark");}

                return false;}
        });

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 0, 1); // Clear color is yellow
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear buffer with Clear color

        ///batch.setProjectionMatrix(camera.combined); // Set Projection Matrix

       // batch.begin(); // begin drawing



       // batch.end(); // end drawing

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
