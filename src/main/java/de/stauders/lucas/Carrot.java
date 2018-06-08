package de.stauders.lucas;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Carrot extends Actor
{
    //TODO: Identifiziere Attribute, Methoden und Konstruktoren und markiere diese entsprechend durch Kommentare.
    private int weight = 5;
   
    
    public Carrot(){
        this(5);
    }
    
    public Carrot(int weight){
        this.weight = weight;
        getImage().drawString(String.valueOf(weight), 0, 10);
    }

    public int getWeight() {
        return weight;
    }    
}
