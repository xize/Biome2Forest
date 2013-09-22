package xize.biome2forest.Biome2Forest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Logger;

import net.minecraft.server.v1_6_R3.BiomeBase;
import net.minecraft.server.v1_6_R3.BiomeForest;

import org.bukkit.plugin.java.JavaPlugin;

public class biome2forest extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	@Override
	public void onEnable() {
		log.info("[Biome2Forest] has been enabled!");
		jungle();
		ocean();
	}
	
	@Override
	public void onDisable() {
		log.info("[Biome2Forest] has been disabled!");
	}

	public void jungle() {
        BiomeBase[] a = BiomeBase.biomes;
        BiomeForest nb1 = new BiomeForest(21);
        BiomeForest nb2 = new BiomeForest(22);
 
        try {
            Method m1 = BiomeBase.class.getMethod("b", int.class);
            m1.setAccessible(true);
 
            Method m2 = BiomeBase.class.getMethod("a", String.class);
            m2.setAccessible(true);
 
            Method m3 = BiomeBase.class.getMethod("a", int.class);
            m3.setAccessible(true);
 
            Method m4 = BiomeBase.class.getMethod("a", float.class, float.class);
            m4.setAccessible(true);
 
            m1.invoke(nb1, 353825);
            m2.invoke(nb1, "Jungle");
            m3.invoke(nb1, 5159473);
            m4.invoke(nb1, 0.7F, 0.8F);
 
            m1.invoke(nb2, 353825);
            m2.invoke(nb2, "JungleHills");
            m3.invoke(nb2, 5159473);
            m4.invoke(nb2, 0.7F, 0.8F);
 
            Field f1 = BiomeBase.class.getDeclaredField("JUNGLE");
            Field f2 = BiomeBase.class.getDeclaredField("JUNGLE_HILLS");
            this.setFinalStatic(f1, nb1);
            this.setFinalStatic(f2, nb2);
 
            a[21] = nb1;
            a[22] = nb2;
 
            Field f3 = BiomeBase.class.getDeclaredField("biomes");
            this.setFinalStatic(f3, a);
        } catch (Exception e) {}
    }
	
	public void ocean() {
        BiomeBase[] a = BiomeBase.biomes;
        BiomeForest nb1 = new BiomeForest(0);
 
        try {
            Method m1 = BiomeBase.class.getMethod("b", int.class);
            m1.setAccessible(true);
 
            Method m2 = BiomeBase.class.getMethod("a", String.class);
            m2.setAccessible(true);
 
            Method m3 = BiomeBase.class.getMethod("a", int.class);
            m3.setAccessible(true);
 
            Method m4 = BiomeBase.class.getMethod("a", float.class, float.class);
            m4.setAccessible(true);
 
            m1.invoke(nb1, 353825);
            m2.invoke(nb1, "Ocean");
            m3.invoke(nb1, 5159473);
            m4.invoke(nb1, 0.7F, 0.8F);
 
            Field f1 = BiomeBase.class.getDeclaredField("OCEAN");
            this.setFinalStatic(f1, nb1);
 
            a[0] = nb1;
 
            Field f3 = BiomeBase.class.getDeclaredField("biomes");
            this.setFinalStatic(f3, a);
        } catch (Exception e) {}
    }
	
    public void setFinalStatic(Field field, Object obj) throws Exception {
        field.setAccessible(true);
 
        Field mf = Field.class.getDeclaredField("modifiers");
        mf.setAccessible(true);
        mf.setInt(field, field.getModifiers() & ~Modifier.FINAL);
 
        field.set(null, obj);
    }

}
