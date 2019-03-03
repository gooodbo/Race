package com.belochka.race.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public abstract class GameObject {

    public Polygon bounds;
    public Sprite object;

    public GameObject(TextureRegion textureRegion, float x, float y, float width, float hight) {

        bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, hight, 0f, hight});
        bounds.setOrigin(width / 2, hight / 2); //центр поворота машины
        bounds.setPosition(x, y);

        object = new Sprite(textureRegion);
        object.setSize(width, hight);
        object.setOrigin(width / 2f, hight / 2f);
        object.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        object.setPosition(bounds.getX(), bounds.getY());
        object.setRotation(bounds.getRotation());
        object.draw(batch);
    }

    public Polygon getBounds() {
        return bounds;
    }
}
