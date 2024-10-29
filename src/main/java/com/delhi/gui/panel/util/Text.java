package com.delhi.gui.panel.util;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Optional;

public class Text {

    public static Optional<LocalDate> getDate(JTextField field) {
        Optional<LocalDate> ret;
        try {
            ret = Optional.of(LocalDate.parse(field.getText()));
        } catch (Exception e) {
            ret = Optional.empty();
        }
        return ret;
    }

    public static Optional<Double> getDouble(JTextField field) {
        Optional<Double> ret;
        try {
            ret = Optional.of(Double.parseDouble(field.getText()));
        } catch (Exception e) {
            ret = Optional.empty();
        }
        return ret;
    }
}
