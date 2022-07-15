package phoenixclient.cosmetics.cape;

import net.minecraft.util.ResourceLocation;

public enum Capes {
	
	NONE("None", new ResourceLocation(""));
	
	
	String name;
    ResourceLocation location;
    boolean owned;

    Capes(String name, ResourceLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public ResourceLocation getResourceLocation() {
        return location;
    }
}
