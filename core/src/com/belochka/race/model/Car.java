package com.belochka.race.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.belochka.race.control.CarController;

public class Car extends GameObject {
    public CarController carController;

    public Car(TextureRegion textureRegion, float x, float y, float width, float hight) {
        super(textureRegion, x, y, width, hight);
        carController = new CarController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        carController.handle();
    }
}
