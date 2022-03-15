import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class SpaceInvaders extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"SpaceInvaders"};
        SpaceInvaders spaceInvaders = new SpaceInvaders();
        PApplet.runSketch(processingArgs, spaceInvaders);
    }

    private final int PixelSizePerInvader = 50;
    private final int BorderSize = 25;
    private final int InvaderPixelAmount = 8;

    private final int Width = 1000;
    private final int Height = 1000;

    private final Color[] colors = new Color[6];

    public void settings() {
        size(Width, Height);
        noSmooth();
    }

    public void draw()
    {
        background(0);
        noStroke();

        generateRandomColors();
        int imagePixelSize = 2 * BorderSize + PixelSizePerInvader;

        for (int y = BorderSize; y < Height; y += imagePixelSize)
        {
            for (int x = BorderSize; x < Width; x += imagePixelSize)
            {
                image(GenerateInvader(), x, y, PixelSizePerInvader, PixelSizePerInvader);
            }
        }

        noLoop();
    }

    public void mouseClicked() {
        redraw();
    }

    private PImage GenerateInvader()
    {
        PImage img = createImage(InvaderPixelAmount, InvaderPixelAmount, ARGB);
        for (int y = 0; y < InvaderPixelAmount; y++)
        {
            for (int x = 0; x < InvaderPixelAmount / 2; x++)
            {
                int colorIndex = getRandomColorIndex();
                img.set(x, y, colors[colorIndex].getRGB());
                img.set(InvaderPixelAmount - 1 - x, y, colors[colorIndex].getRGB());
            }

            // center
            if (PixelSizePerInvader % 2 != 0)
            {
                img.set(InvaderPixelAmount / 2, y, colors[getRandomColorIndex()].getRGB());
            }
        }

        return img;
    }

    private int getRandomColorIndex() {
        return (int) random(0f, colors.length - 1f);
    }

    private void generateRandomColors() {
        for (int i = 0; i < colors.length; i++) {
            if(i < colors.length - 3) {
                colors[i] = new Color((int)random(0, 255), (int)random(0, 255), (int)random(0, 255), 255);
            }
            else {
                colors[i] = new Color(0, 0, 0, 0);
            }
        }
    }
}