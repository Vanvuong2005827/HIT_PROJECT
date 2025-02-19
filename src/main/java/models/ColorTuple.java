package models;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class ColorTuple {
    private Color color1;
    private Color color2;
    private Color color3;
    private Color color4;

    public ColorTuple(Color color1, Color color2, Color color3, Color color4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }
}
