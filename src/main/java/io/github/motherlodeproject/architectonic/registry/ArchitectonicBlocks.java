package io.github.motherlodeproject.architectonic.registry;

import io.github.motherlodeproject.architectonic.Architectonic;
import io.github.prospector.silk.block.SilkPaneBlock;
import io.github.prospector.silk.block.SilkStairsBlock;
import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;

public class ArchitectonicBlocks {

	static {
		add("prismarine_bricks_wall", new WallBlock(FabricBlockSettings.copy(Blocks.PRISMARINE_BRICKS).build()), ItemGroup.BUILDING_BLOCKS);
		add("dark_prismarine_wall", new WallBlock(FabricBlockSettings.copy(Blocks.DARK_PRISMARINE).build()), ItemGroup.BUILDING_BLOCKS);

		addWithStairsAndSlab("polished_stone", FabricBlockSettings.copy(Blocks.POLISHED_GRANITE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("stone_tiles", FabricBlockSettings.copy(Blocks.POLISHED_GRANITE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_stone_tiles", FabricBlockSettings.copy(Blocks.POLISHED_GRANITE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_stone_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_mossy_stone_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		add("stone_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE_BRICKS).build()), ItemGroup.BUILDING_BLOCKS);

		addWithStairsSlabAndWall("granite_cobblestone", FabricBlockSettings.copy(Blocks.COBBLESTONE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("granite_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_granite_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		add("granite_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE_BRICKS).build()), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("diorite_cobblestone", FabricBlockSettings.copy(Blocks.COBBLESTONE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("diorite_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_diorite_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		add("diorite_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE_BRICKS).build()), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("andesite_cobblestone", FabricBlockSettings.copy(Blocks.COBBLESTONE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("andesite_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_andesite_bricks", FabricBlockSettings.copy(Blocks.STONE_BRICKS).build(), ItemGroup.BUILDING_BLOCKS);
		add("andesite_pillar", new PillarBlock(FabricBlockSettings.copy(Blocks.STONE_BRICKS).build()), ItemGroup.BUILDING_BLOCKS);

		addWithStairsSlabAndWall("sandstone_bricks", FabricBlockSettings.copy(Blocks.SANDSTONE).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("small_sandstone_bricks", FabricBlockSettings.copy(Blocks.SANDSTONE).build(), ItemGroup.BUILDING_BLOCKS);

		add("dry_dirt", new Block(FabricBlockSettings.copy(Blocks.DIRT).build()), ItemGroup.BUILDING_BLOCKS);
		addWithStairsSlabAndWall("mud_bricks", FabricBlockSettings.copy(Blocks.BRICKS).build(), ItemGroup.BUILDING_BLOCKS);

		add("wicker", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).build()), ItemGroup.BUILDING_BLOCKS);
		add("wooden_bars", new SilkPaneBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).build()), ItemGroup.BUILDING_BLOCKS);
		add("thatch", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).build()), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("sugar_cane_block", FabricBlockSettings.copy(Blocks.OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("bamboo_block", FabricBlockSettings.copy(Blocks.OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("bamboo_planks", FabricBlockSettings.copy(Blocks.OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);

		addWithStairsAndSlab("oak_carved_wood", FabricBlockSettings.copy(Blocks.OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("wide_oak_planks", FabricBlockSettings.copy(Blocks.OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("spruce_carved_wood", FabricBlockSettings.copy(Blocks.SPRUCE_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("wide_spruce_planks", FabricBlockSettings.copy(Blocks.SPRUCE_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("birch_carved_wood", FabricBlockSettings.copy(Blocks.BIRCH_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("wide_birch_planks", FabricBlockSettings.copy(Blocks.BIRCH_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("jungle_carved_wood", FabricBlockSettings.copy(Blocks.JUNGLE_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("wide_jungle_planks", FabricBlockSettings.copy(Blocks.JUNGLE_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("acacia_carved_wood", FabricBlockSettings.copy(Blocks.ACACIA_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("wide_acacia_planks", FabricBlockSettings.copy(Blocks.ACACIA_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("dark_oak_carved_wood", FabricBlockSettings.copy(Blocks.DARK_OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);
		addWithStairsAndSlab("wide_dark_oak_planks", FabricBlockSettings.copy(Blocks.DARK_OAK_PLANKS).build(), ItemGroup.BUILDING_BLOCKS);

	}

	public static void addWithStairsAndSlab(String name, Block.Settings settings, ItemGroup tab) {
		Block baseBlock = add(name, new Block(settings), tab);
		add(name + "_slab", new SlabBlock(settings), tab);
		add(name + "_stairs", new SilkStairsBlock(baseBlock.getDefaultState(), settings), tab);
	}

	public static void addWithStairsSlabAndWall(String name, Block.Settings settings, ItemGroup tab) {
		Block baseBlock = add(name, new Block(settings), tab);
		add(name + "_slab", new SlabBlock(settings), tab);
		add(name + "_stairs", new SilkStairsBlock(baseBlock.getDefaultState(), settings), tab);
		add(name + "_wall", new WallBlock(settings), tab);
	}

	public static Block add(String name, Block block, ItemGroup tab) {
		return add(name, block, new BlockItem(block, new Item.Settings().itemGroup(tab)));
	}

	public static Block add(String name, Block block, BlockItem item) {
		ArchitectonicRegistry.BLOCKS.put(new Identifier(Architectonic.MOD_ID, name), block);
		if (item != null) {
			item.registerBlockItemMap(Item.BLOCK_ITEM_MAP, item);
			ArchitectonicItems.add(name, item);
		}
		return block;
	}

	public static void loadClass() {}
}
