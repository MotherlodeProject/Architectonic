package io.github.motherlodeproject.architectonic.registry;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArchitectonicRegistry implements ModInitializer {
	public static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
	public static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

	@Override
	public void onInitialize() {
		ArchitectonicItems.loadClass();
		ArchitectonicBlocks.loadClass();

		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
		for (Identifier id : BLOCKS.keySet()) {
			Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
		}
	}
}
