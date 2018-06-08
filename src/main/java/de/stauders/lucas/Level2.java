package de.stauders.lucas;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends RabbitWorld
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {
        PlayerRabbit rabbit = new PlayerRabbit();
        addObject(rabbit, 4, 4);

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Carrot carrot = new Carrot(2);
        addObject(carrot,6,4);
        Carrot carrot2 = new Carrot(5);
        addObject(carrot2,3,3);
        Carrot carrot3 = new Carrot(7);
        addObject(carrot3,2,5);
    }
}
