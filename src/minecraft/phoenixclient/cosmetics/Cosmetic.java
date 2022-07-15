package phoenixclient.cosmetics;

import net.minecraft.util.ResourceLocation;

public class Cosmetic {
	
	public String name;
    public ResourceLocation location;
    public boolean wearing, owned;
    public String owner;

    public String getName() {
        return name;
    }
    
    public void setOwner(String owner) {
		this.owner = owner;
	}
    
    public String getOwner() {
		return owner;
	}


    public void setLocation(ResourceLocation location) {
        this.location = location;
    }


    public ResourceLocation getLocation() {
        return location;
    }

    public boolean isWearing() {
        return wearing;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setWearing(boolean wearing) {
        this.wearing = wearing;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
	

}
