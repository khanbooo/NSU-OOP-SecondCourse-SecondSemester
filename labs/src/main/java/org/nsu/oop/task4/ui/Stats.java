package org.nsu.oop.task4.ui;

import javax.swing.*;
import java.awt.*;

public class Stats extends JPanel {
    private final PartInfo body_panel;
    private final PartInfo engine_panel;
    private final PartInfo accessory_panel;
    private final PartInfo car_panel;

    public Stats() {
        super(new GridLayout(1, 4));

        body_panel = new PartInfo("Bodies");
        engine_panel = new PartInfo("Engines");
        accessory_panel = new PartInfo("Accessories");
        car_panel = new PartInfo("Cars");

        add(body_panel);
        add(engine_panel);
        add(accessory_panel);
        add(car_panel);
    }

    public void setBodyAmount(int current_amount, int total_amount) {
        body_panel.setAmounts(current_amount, total_amount);
    }

    public void setEngineAmount(int current_amount, int total_amount) {
        engine_panel.setAmounts(current_amount, total_amount);
    }

    public void setAccessoryAmount(int current_amount, int total_amount) {
        accessory_panel.setAmounts(current_amount, total_amount);
    }

    public void setCarAmount(int current_amount, int total_amount) {
        car_panel.setAmounts(current_amount, total_amount);
    }
}
