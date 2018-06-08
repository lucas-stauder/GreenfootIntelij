package de.stauders.lucas;

import java.util.List;

// imports Actor, World, Greenfoot, GreenfootImage
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Greenfoot;

/**
 * 
 * @author Michael Kolling, changed by Thomas Karp
 * @version 1.0.2
 */
public class Rabbit extends Actor {
    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private int localRotation; // aktuelle Richtung
    
    private GreenfootImage rabitRight;
    private GreenfootImage rabitLeft;
    private GreenfootImage currentImage;
    

    /**
     * Erzeuge einen Hasen
     */
    public Rabbit() {
        rabitRight = new GreenfootImage(getImage());
        rabitLeft = new GreenfootImage(getImage());
        currentImage = rabitRight;
        rabitLeft.mirrorVertically();

        setImageRotation(RIGHT);
    }
    

    
    /**
     * �berpr�ft ob der Hase einen Schritt nach vorne laufen kann ohne auf ein Hindernis (Wand/Stein) zu treffen.
     */
    public boolean canMove(){
        return canMove(1);
    }

    /**
     * �berpr�ft, ob sich in distance Schritten vor dem Hasen kein Hindernis (Wand/Stein) befindet. 
     */
    public boolean canMove(int distance) {
        World myWorld = getWorld();
        int x = getNextX(distance);
        int y = getNextY(distance);

        if (x >= myWorld.getWidth() || y >= myWorld.getHeight() - 1) {
            return false;
        } else if (x < 0 || y < 0) {
            return false;
        }

        List<Rock> steine = myWorld.getObjectsAt(x, y, Rock.class);
        if (steine.isEmpty()) {
            return true;
        }

        return false;

    }

    /**
     * Returns the x coordinate of the next field, that lays <b>distance</b> steps in the current direction.
     */
    public int getNextX(int distance) {
        int x = getX();
        switch (localRotation) {
        case RIGHT:
            x = x + distance;
            break;
        case LEFT:
            x = x - distance;
            break;
        }
        return x;
    }

    
    /**
     * Returns the y coordinate of the next field, that lays <b>distance</b> steps in the current direction.
     */
    public int getNextY(int distance) {

        int y = getY();
        switch (localRotation) {
        case DOWN:
            y = y + distance;
            break;
        case UP:
            y = y - distance;
            break;
        }
        return y;
    }

    /**
     * Nach links drehen.
     */
    public void turnLeft() {
        switch (localRotation) {
        case DOWN:
            setImageRotation(RIGHT);
            break;
        case RIGHT:
            setImageRotation(UP);
            break;
        case UP:
            setImageRotation(LEFT);
            break;
        case LEFT:
            setImageRotation(DOWN);
            break;
        }
    }

    /**
     * Nach rechts drehen
     */
    public void turnRight() {
        switch (localRotation) {
        case DOWN:
            setImageRotation(LEFT);
            break;
        case RIGHT:
            setImageRotation(DOWN);
            break;
        case UP:
            setImageRotation(RIGHT);
            break;
        case LEFT:
            setImageRotation(UP);
            break;
        }
    }

    /**
     * Setze Richtung des Hasen.
     */
    public void setImageRotation(int richtung) {
        this.localRotation = richtung;
        switch (richtung) {
        case DOWN:
            setImage(rabitRight);
            setRotation(90);
            break;
        case RIGHT:
            setImage(rabitRight);
            setRotation(0);
            break;
        case UP:
            setImage(rabitLeft);
            setRotation(-90);
            break;
        case LEFT:
            setImage(rabitLeft);
            setRotation(180);
            break;
        default:
            break;
        }
    }

    /**
     * Tu, was ein Hase so tut
     */
    public void act() {
        super.act();
    }
    
     /**
     * Gibt den Text �ber dem Character aus.
     */
    public void say(boolean text){
        say(String.valueOf(text));
    }
    
     /**
     * Gibt den Text �ber dem Character aus.
     */
    public void say(int text){
        say(String.valueOf(text));
    }
    
     /**
     * Gibt den Text �ber dem Character aus.
     */
    public void say(double text){
        say(String.valueOf(text));
    }
    
    /**
     * Gibt den Text �ber dem Character aus.
     */
    public void say(String text){
        int y = getY() - 1;
        if (y < 0){
            y = 1;
        }
        getWorld().showText(text, getX(), y);
        System.out.println("a " + this.getClass().getName() + " says: " + text); 
        Greenfoot.delay(1);
    }
    
    /**
	* Liefert das Objekt vom Typ RabbitWorld in dem der Hase sich befindet.
	**/
    public RabbitWorld getRabbitWorld(){
        return getWorldOfType(RabbitWorld.class);
    }
    
    public void setImage(GreenfootImage image){
        currentImage = image;
        super.setImage(new GreenfootImage(currentImage));
    }
    
    
    /**
     * Zeichnet den �bergebenen Text auf das aktuelle Bild der Figur.
     */
    public void draw(String text){
        super.setImage(new GreenfootImage(currentImage));
        getImage().drawString(text, 0, 10);
    }
    
    /**
     * Zeichnet den Wert auf das aktuelle Bild der Figur.
     */
    public void draw(int value){        
        draw(String.valueOf(value));
    }
    
    public void move(int steps){
        if(canMove(steps)){
            super.move(steps);
        }
    }
    
}