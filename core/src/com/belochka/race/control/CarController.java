package com.belochka.race.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.belochka.race.view.GameScreen;

public class CarController {
    private Polygon carBounds;

    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }

    private float carSpeed = 0f, speedVelocity = 10f, speedMax = 10f;
    private float rotationSpeed = 50f;

    public void handle() {
        //вперёд и назад

        if (Gdx.input.isKeyPressed(Input.Keys.W))
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else
            downSpeed();

        carSpeed = sliceSpeed();

        //влево и вправо

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            carBounds.rotate(rotationSpeed * GameScreen.deltaCff * carSpeed);
        else if (Gdx.input.isKeyPressed(Input.Keys.D))
            carBounds.rotate(-rotationSpeed * GameScreen.deltaCff * carSpeed);


        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff,
                carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff);
    }

    private void downSpeed() {
        if (carSpeed > speedVelocity * GameScreen.deltaCff)
            carSpeed -= speedVelocity * GameScreen.deltaCff;
        else if (carSpeed < -speedVelocity * GameScreen.deltaCff)
            carSpeed += speedVelocity * GameScreen.deltaCff;
        else
            carSpeed = 0f;
    }

    private float sliceSpeed() {
        if (carSpeed > speedMax)
            return speedMax;
        if (carSpeed < -speedMax)
            return -speedMax;
        return carSpeed;
    }

}
