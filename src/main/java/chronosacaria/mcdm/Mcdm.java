package chronosacaria.mcdm;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Mcdm implements ModInitializer {

    public static final String MOD_ID = "mcdm";

    public static final Identifier ID (String path){
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {

    }
}
