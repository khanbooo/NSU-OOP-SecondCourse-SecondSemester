package org.nsu.oop.task4.ui;

import org.nsu.oop.task4.controller.Controller;
import org.nsu.oop.task4.controller.SpeedChangeEvent;
import org.nsu.oop.task4.factory.parts.Accessory;
import org.nsu.oop.task4.factory.parts.Body;
import org.nsu.oop.task4.factory.parts.Engine;
import org.nsu.oop.task4.pubSub.Publisher;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel implements Publisher<SpeedChangeEvent> {
    private final Controller controller = Controller.getInstance();
    private static final int min = 10;
    private static final int max = 100;
    private static final int num_of_labels = 9;

    public Settings() {
        super(new GridLayout(3, 1));

        addSlider("Body Production Speed", Body.class);
        addSlider("Engine Production Speed", Engine.class);
        addSlider("Accessory Production Speed", Accessory.class);
    }

    private void addSlider(String title, Class<?> partClass) {
        JSlider slider = new JSlider(Settings.min, Settings.max);

        slider.addChangeListener(e -> {
            JSlider slider1 = (JSlider) e.getSource();
            int speed = slider1.getValue();
            int period = 1000 / speed;
            publish(new SpeedChangeEvent(period, partClass));
        });

        slider.setLabelTable(slider.createStandardLabels(
                (Settings.max - Settings.min) / num_of_labels));

        slider.setPaintLabels(true);
        slider.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label = new JLabel(title);
        label.setAlignmentX(CENTER_ALIGNMENT);

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new GridLayout(2, 1));

        wrapper.add(label);
        wrapper.add(slider);

        add(wrapper);
    }
    @Override
    public void publish(SpeedChangeEvent event) {
        controller.onEvent(event);
    }
}
