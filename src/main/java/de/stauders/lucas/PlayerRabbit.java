package de.stauders.lucas;
import greenfoot.*;

public class PlayerRabbit extends Rabbit {
    
    //Attribute    
    private Carrot[] inventory = new Carrot[8];
    
    private InventoryDisplayAdapter displayAdapter;
    
    
    
    //Konstruktoren    
    
    //Methoden
    /**
     * Wird einmal pro Zeiteinheit aufgerufen
     */
    public void act() {
        performMovement();    

        if (Greenfoot.isKeyDown("E")) {
            pick();
        }
        
        if (Greenfoot.isKeyDown("R")) {
            put();
        }
        
      
        displayAdapter.update(inventory);  //Inventar aktualisieren
        
    }
	
	public void addedToWorld(World world){    
        displayAdapter = new InventoryDisplayAdapter(inventory.length);
        world.addObject(displayAdapter, 0, world.getHeight()-1);
    }
    
    
    public void pick(){
        Carrot[] objs = getRabbitWorld().getObjectArrayAt(getX(), getY(), Carrot.class);
        
        if(objs.length>0){       
            for(int i=0;i<inventory.length;i++){
                if(inventory[i]==null){
                    inventory[i]=objs[0];
                    getRabbitWorld().removeObject(objs[0]);
                    return;  //beendet die gesamte Methode
                }
            }   
        }
    }
    
    public void put(){       
        for(int i=0;i<inventory.length;i++){
            if(inventory[i]!=null){                
                getRabbitWorld().addObject(inventory[i], getX(), getY());
                inventory[i]=null;
                return; //beendet die gesamte Methode
            }
        }        
    }


    //TODO: Steuerung �ber die Tasten W - A - S - D realisieren
    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            move(1);
        }  
        if (Greenfoot.isKeyDown("S")) {
            move(-1);
        } 
        if (Greenfoot.isKeyDown("A")) {
            turnLeft();
        } 
        if (Greenfoot.isKeyDown("D")) {
            turnRight();
        } 
    }
    
    

}
