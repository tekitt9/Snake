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
	Texture img;
	Sprite sprite;
	int fallSpeed = 0;
	boolean isOnImg = false;

	@Override
	public void create () {
		img = new Texture("badlogic.jpg");
		batch = new SpriteBatch();
		sprite = new Sprite(img, 0, 0, 256, 256);;
		sprite.setPosition((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 2);
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
                isOnImg = screenX >= sprite.getX() && screenX <= sprite.getX() + sprite.getWidth()
                        && screenY <= Gdx.graphics.getHeight() - sprite.getY() && screenY >= Gdx.graphics.getHeight() - sprite.getY() - sprite.getHeight();
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
				System.out.printf("x:%d y:%d p:%d%n", screenX, screenY, pointer);
				System.out.printf("xT:%f yT:%f%n", sprite.getX(), sprite.getY());
				if (isOnImg) {
					sprite.setPosition(screenX - sprite.getWidth() / 2, Gdx.graphics.getHeight() - sprite.getHeight() / 2 - screenY);
				}
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
		if (sprite.getY() > 0) {
			sprite.translate(0, -fallSpeed);
		}
		if (sprite.getY() < 0) {
			sprite.setY(0);
		}
		if (sprite.getY() > Gdx.graphics.getHeight() - sprite.getHeight()) {
			sprite.setY(Gdx.graphics.getHeight() - sprite.getHeight());
		}
		if (sprite.getX() < 0) {
			sprite.setX(0);
		}
		if (sprite.getX() > Gdx.graphics.getWidth() - sprite.getWidth()) {
			sprite.setX(Gdx.graphics.getWidth() - sprite.getWidth());
		}
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
