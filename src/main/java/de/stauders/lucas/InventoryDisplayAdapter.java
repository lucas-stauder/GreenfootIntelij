package de.stauders.lucas;
import greenfoot.*;

public class InventoryDisplayAdapter extends Actor {

    private Actor[] items;
    private Actor[] itemImages;
    //private static InventoryDisplayAdapter adapter = null;
    private GreenfootImage emtpySlot = new GreenfootImage(".\\images\\EmptySlot.png");

    public InventoryDisplayAdapter(int size) {
        getImage().setTransparency(0);
        items = new Actor[size];
        itemImages = new Actor[size]; 
         
    }
    
    protected void addedToWorld(World world){    
        for (int i = 0; i<itemImages.length; i++ ){  
            itemImages[i] = createDummyImageActor(i);
        }
    }
    
    
    /**
     * Updates all inventory Slots at the bottom of the screen with the content of the given inventory Array
     */ 
    public void update(Actor[] inventory) { 
		int length = Math.max(inventory.length, items.length);
        for (int i = 0; i < length; i++) {
            if (inventory[i] != items[i]) {
                items[i] = inventory[i];
                itemImages[i] = null;
                Actor dummyImageActor = createDummyImageActor(i);
                if(inventory[i] != null){
                    itemImages[i] = dummyImageActor;
                    dummyImageActor.getImage().drawImage(new GreenfootImage(inventory[i].getImage()), 5, 5);
                }
            }
        }

    }

    /**
     * Updates all inventory Slots at the bottom of the screen with the content of the given Actor
     */ 
    public void update(Actor inventory) {
        Actor inventorySlots[] = { inventory };
        update(inventorySlots);

    }

    private Actor createDummyImageActor(int i) {        
        Actor actor = new Actor() {
        };
        getWorld().addObject(actor, i, getY());
        itemImages[i] = actor;
        actor.setImage(new GreenfootImage(emtpySlot));
        
        return itemImages[i];

    }

}
