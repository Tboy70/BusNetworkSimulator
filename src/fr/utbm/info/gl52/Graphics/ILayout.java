package fr.utbm.info.gl52.Graphics;


/**
 * 
 */
public interface ILayout {



    /**
     * @param int x 
     * @param int y
     */
    public void addComponent(int x, int y);

    /**
     * @param AbstractComponent c 
     * @param int x 
     * @param int y
     */
    public void moveComponent(AbstractComponent c, int x, int y);

    /**
     * @param AbstractComponent c
     */
    public void delete(AbstractComponent c);

}