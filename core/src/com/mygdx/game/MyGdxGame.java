package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite head;
	Sprite body;
	Sprite tail;

	@Override
	public void create () {
		head = new Sprite(new Texture("head.png"), 32, 32);
		head.setX(256);
		body = new Sprite(new Texture("body.png"), 32, 32);
		body.setX(32);
		tail = new Sprite(new Texture("tail.png"), 32, 32);
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(new InputProcessor() {
			@Override
			public boolean keyDown(int keycode) {
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

			@Override
			public boolean scrolled(float amountX, float amountY) {
				return false;
			}
		});
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		head.draw(batch);
		body.draw(batch);
		batch.draw(new Texture("body.png"), 64, 0);
		batch.draw(new Texture("body.png"), 96, 0);
		batch.draw(new Texture("body.png"), 128, 0);
		batch.draw(new Texture("body1.png"), 160, 0);
		batch.draw(new Texture("body.png"), 192, 0);
		batch.draw(new Texture("body.png"), 224, 0);
		tail.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
