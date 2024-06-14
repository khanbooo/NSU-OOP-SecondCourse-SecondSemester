package org.nsu.oop.task4.ui;

import org.nsu.oop.task4.controller.StockChangeEvent;
import org.nsu.oop.task4.factory.parts.Accessory;
import org.nsu.oop.task4.factory.parts.Body;
import org.nsu.oop.task4.factory.parts.Car;
import org.nsu.oop.task4.factory.parts.Engine;
import org.nsu.oop.task4.pubSub.Subscriber;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame implements Subscriber<StockChangeEvent> {
    private static final int height = 720;
    private static final int width = 1024;
    private final Stats stats;


    public Menu(){
        super();

        this.setTitle("Car Factory");
        this.setMinimumSize(new Dimension(width, height));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();

        stats = new Stats();
        container.add(stats, BorderLayout.NORTH);

        Settings settings = new Settings();
        container.add(settings, BorderLayout.CENTER);

        this.pack();
    }

    public void display() {
        this.setVisible(true);
    }

    @Override
    public void onEvent(StockChangeEvent event) {
        Class<?> partClass = event.getPartClass();
        int current = event.getCurrent_amount();
        int total = event.getTotal_amount();

        if (partClass == Body.class) {
            stats.setBodyAmount(current, total);
        } else if (partClass == Engine.class) {
            stats.setEngineAmount(current, total);
        } else if (partClass == Accessory.class) {
            stats.setAccessoryAmount(current, total);
        } else if (partClass == Car.class) {
            stats.setCarAmount(current, total);
        }
    }
}
