package org.nsu.oop.task4.controller;

import org.nsu.oop.task4.factory.Factory;
import org.nsu.oop.task4.factory.parts.Accessory;
import org.nsu.oop.task4.factory.parts.Body;
import org.nsu.oop.task4.factory.parts.Engine;
import org.nsu.oop.task4.pubSub.Publisher;
import org.nsu.oop.task4.pubSub.Subscriber;
import org.nsu.oop.task4.ui.Menu;

public class Controller implements Subscriber<FactoryEvent>, Publisher<FactoryEvent> {
    Factory factory;
    Menu menu;

    private static Controller instance = null;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    private Controller() {}

    public Controller addFactory(Factory factory) {
        this.factory = factory;
        return this;
    }

    public Controller addMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    @Override
    public void publish(FactoryEvent event) {
        if (menu == null) {
            throw new RuntimeException("menu not attached to controller");
        }

        menu.onEvent((StockChangeEvent) event);
    }

    @Override
    public void onEvent(FactoryEvent event) {
        if (event instanceof SpeedChangeEvent) {
            handleSpeedChange((SpeedChangeEvent) event);
        } else if (event instanceof StockChangeEvent) {
            handleStockChange((StockChangeEvent) event);
        }
    }

    private void handleStockChange(StockChangeEvent event) {
        this.publish(event);
    }

    private void handleSpeedChange(SpeedChangeEvent event) {
        if (factory == null) {
            throw new RuntimeException("factory not attached to controller");
        }

        Class<?> partClass = event.getPartClass();
        int speed = event.getSpeed();

        if (partClass == Body.class) {
            factory.setBodySpeed(speed);
        } else if (partClass == Engine.class) {
            factory.setEngineSpeed(speed);
        } else if (partClass == Accessory.class) {
            factory.setAccessorySpeed(speed);
        }
    }
}
