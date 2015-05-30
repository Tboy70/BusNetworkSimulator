package fr.utbm.info.gl52.Graphics;

import java.awt.Graphics;
import java.awt.Shape;


/**
 * 
 */
public interface IGraphic {

    /**
     * 
     */
    public void draw(Graphics g);
    public boolean intersect(Shape r);
}