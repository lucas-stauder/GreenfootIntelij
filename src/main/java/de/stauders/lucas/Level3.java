package de.stauders.lucas;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends RabbitWorld
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level3()
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
        Bus bus = new Bus();
        addObject(bus,2,2);
        Tree tree = new Tree();
        addObject(tree,2,1);
        Rock rock = new Rock();
        addObject(rock,6,3);
        Carrot carrot = new Carrot();
        addObject(carrot,3,4);
        Carrot carrot2 = new Carrot(42);
        addObject(carrot2,6,5);
        Apple apple = new Apple();
        addObject(apple,2,6);
        Banana banana = new Banana();
        addObject(banana,5,1);
        Ball ball = new Ball();
        addObject(ball,1,3);
        Apple apple2 = new Apple();
        addObject(apple2,5,4);
        carrot.setLocation(1,6);
        PickAxe pickaxe = new PickAxe();
        addObject(pickaxe,6,4);
        removeObject(carrot2);
        PickAxe pickaxe2 = new PickAxe();
        addObject(pickaxe2,1,2);
    }
    
}
