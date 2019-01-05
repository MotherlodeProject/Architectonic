package io.github.motherlodeproject.architectonic.registry;

import io.github.motherlodeproject.architectonic.Architectonic;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ArchitectonicItems {

	public static Item add(String name, Item item) {
		ArchitectonicRegistry.ITEMS.put(new Identifier(Architectonic.MOD_ID, name), item);
		return item;
	}

	public static void loadClass() {}
}
