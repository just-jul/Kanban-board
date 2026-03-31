package com.julia;

import java.awt.*;

public enum ColorEnum {
    VERY_LIGHT_GRAY(227, 226, 225), LIGHT_PURPLE(221, 182, 250), VERY_LIGHT_PURPLE(239, 225, 250), PURPLE(102,0,153), LIGHT_BLUE(147,220,230), BLUE(0,0,192), VERY_LIGHT_GREEN(220, 247, 226), LIGHT_GREEN(147,230,168), LIGHT_ORANGE(255,102,0);

    private int red;
    private int green;
    private int blue;

    private ColorEnum (int r, int g, int b)
    {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getRed()   { return red; }
    public int getGreen() { return green; }
    public int getBlue()  { return blue; }

    public Color toColor(){
        return new Color(red, green, blue);
    }

}

