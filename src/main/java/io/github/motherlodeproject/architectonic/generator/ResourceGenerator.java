package io.github.motherlodeproject.architectonic.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ResourceGenerator {
	public static final String CUBE_BLOCKSTATE = "{\n"
		+ "  \"variants\": {\n"
		+ "\t\"\": { \"model\": \"architectonic:block/$name\" }\n"
		+ "  }\n"
		+ "}\n";
	public static final String SLAB_BLOCKSTATE = "{\n"
		+ "    \"variants\": {\n"
		+ "        \"type=bottom\": { \"model\": \"architectonic:block/$name_slab\" },\n"
		+ "        \"type=top\": { \"model\": \"architectonic:block/$name_slab_top\" },\n"
		+ "        \"type=double\": { \"model\": \"architectonic:block/$name\" }\n"
		+ "    }\n"
		+ "}\n";
	public static final String WALL_BLOCKSTATE = "{\n"
		+ "    \"multipart\": [\n"
		+ "        {   \"when\": { \"up\": \"true\" },\n"
		+ "            \"apply\": { \"model\": \"architectonic:block/$name_wall_post\" }\n"
		+ "        },\n"
		+ "        {   \"when\": { \"north\": \"true\" },\n"
		+ "            \"apply\": { \"model\": \"architectonic:block/$name_wall_side\", \"uvlock\": true }\n"
		+ "        },\n"
		+ "        {   \"when\": { \"east\": \"true\" },\n"
		+ "            \"apply\": { \"model\": \"architectonic:block/$name_wall_side\", \"y\": 90, \"uvlock\": true }\n"
		+ "        },\n"
		+ "        {   \"when\": { \"south\": \"true\" },\n"
		+ "            \"apply\": { \"model\": \"architectonic:block/$name_wall_side\", \"y\": 180, \"uvlock\": true }\n"
		+ "        },\n"
		+ "        {   \"when\": { \"west\": \"true\" },\n"
		+ "            \"apply\": { \"model\": \"architectonic:block/$name_wall_side\", \"y\": 270, \"uvlock\": true }\n"
		+ "        }\n"
		+ "    ]\n"
		+ "}\n";
	public static final String PILLAR_BLOCKSTATE = "{\n"
		+ "    \"variants\": {\n"
		+ "        \"axis=y\":  { \"model\": \"architectonic:block/$name\" },\n"
		+ "        \"axis=z\":   { \"model\": \"architectonic:block/$name\", \"x\": 90 },\n"
		+ "        \"axis=x\":   { \"model\": \"architectonic:block/$name\", \"x\": 90, \"y\": 90 }\n"
		+ "    }\n"
		+ "}\n";
	public static final String STAIRS_BLOCKSTATE = "{\n"
		+ "    \"variants\": {\n"
		+ "        \"facing=east,half=bottom,shape=straight\":  { \"model\": \"architectonic:block/$name_stairs\" },\n"
		+ "        \"facing=west,half=bottom,shape=straight\":  { \"model\": \"architectonic:block/$name_stairs\", \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=south,half=bottom,shape=straight\": { \"model\": \"architectonic:block/$name_stairs\", \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=north,half=bottom,shape=straight\": { \"model\": \"architectonic:block/$name_stairs\", \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=east,half=bottom,shape=outer_right\":  { \"model\": \"architectonic:block/$name_stairs_outer\" },\n"
		+ "        \"facing=west,half=bottom,shape=outer_right\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=south,half=bottom,shape=outer_right\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=north,half=bottom,shape=outer_right\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=east,half=bottom,shape=outer_left\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=west,half=bottom,shape=outer_left\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=south,half=bottom,shape=outer_left\": { \"model\": \"architectonic:block/$name_stairs_outer\" },\n"
		+ "        \"facing=north,half=bottom,shape=outer_left\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=east,half=bottom,shape=inner_right\":  { \"model\": \"architectonic:block/$name_stairs_inner\" },\n"
		+ "        \"facing=west,half=bottom,shape=inner_right\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=south,half=bottom,shape=inner_right\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=north,half=bottom,shape=inner_right\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=east,half=bottom,shape=inner_left\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=west,half=bottom,shape=inner_left\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=south,half=bottom,shape=inner_left\": { \"model\": \"architectonic:block/$name_stairs_inner\" },\n"
		+ "        \"facing=north,half=bottom,shape=inner_left\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=east,half=top,shape=straight\":  { \"model\": \"architectonic:block/$name_stairs\", \"x\": 180, \"uvlock\": true },\n"
		+ "        \"facing=west,half=top,shape=straight\":  { \"model\": \"architectonic:block/$name_stairs\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=south,half=top,shape=straight\": { \"model\": \"architectonic:block/$name_stairs\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=north,half=top,shape=straight\": { \"model\": \"architectonic:block/$name_stairs\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=east,half=top,shape=outer_right\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=west,half=top,shape=outer_right\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=south,half=top,shape=outer_right\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=north,half=top,shape=outer_right\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"uvlock\": true },\n"
		+ "        \"facing=east,half=top,shape=outer_left\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"uvlock\": true },\n"
		+ "        \"facing=west,half=top,shape=outer_left\":  { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=south,half=top,shape=outer_left\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=north,half=top,shape=outer_left\": { \"model\": \"architectonic:block/$name_stairs_outer\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=east,half=top,shape=inner_right\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=west,half=top,shape=inner_right\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"y\": 270, \"uvlock\": true },\n"
		+ "        \"facing=south,half=top,shape=inner_right\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=north,half=top,shape=inner_right\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"uvlock\": true },\n"
		+ "        \"facing=east,half=top,shape=inner_left\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"uvlock\": true },\n"
		+ "        \"facing=west,half=top,shape=inner_left\":  { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"y\": 180, \"uvlock\": true },\n"
		+ "        \"facing=south,half=top,shape=inner_left\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"y\": 90, \"uvlock\": true },\n"
		+ "        \"facing=north,half=top,shape=inner_left\": { \"model\": \"architectonic:block/$name_stairs_inner\", \"x\": 180, \"y\": 270, \"uvlock\": true }\n"
		+ "    }\n"
		+ "}\n";
	public static final String CUBE_MODEL = "{\n"
		+ "  \"parent\": \"block/cube_all\",\n"
		+ "  \"textures\": {\n"
		+ "\t\"all\": \"architectonic:block/$name\"\n"
		+ "  }\n"
		+ "}\n";
	public static final String STAIRS_MODEL = "{\n"
		+ "    \"parent\": \"block/stairs\",\n"
		+ "    \"textures\": {\n"
		+ "        \"bottom\": \"architectonic:block/$name\",\n"
		+ "        \"top\": \"architectonic:block/$name\",\n"
		+ "        \"side\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String STAIRS_INNER_MODEL = "{\n"
		+ "    \"parent\": \"block/inner_stairs\",\n"
		+ "    \"textures\": {\n"
		+ "        \"bottom\": \"architectonic:block/$name\",\n"
		+ "        \"top\": \"architectonic:block/$name\",\n"
		+ "        \"side\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String STAIRS_OUTER_MODEL = "{\n"
		+ "    \"parent\": \"block/outer_stairs\",\n"
		+ "    \"textures\": {\n"
		+ "        \"bottom\": \"architectonic:block/$name\",\n"
		+ "        \"top\": \"architectonic:block/$name\",\n"
		+ "        \"side\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String SLAB_MODEL = "{\n"
		+ "    \"parent\": \"block/slab\",\n"
		+ "    \"textures\": {\n"
		+ "        \"bottom\": \"architectonic:block/$name\",\n"
		+ "        \"top\": \"architectonic:block/$name\",\n"
		+ "        \"side\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String SLAB_TOP_MODEL = "{\n"
		+ "    \"parent\": \"block/slab_top\",\n"
		+ "    \"textures\": {\n"
		+ "        \"bottom\": \"architectonic:block/$name\",\n"
		+ "        \"top\": \"architectonic:block/$name\",\n"
		+ "        \"side\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String PILLAR_MODEL = "{\n"
		+ "    \"parent\": \"block/cube_column\",\n"
		+ "    \"textures\": {\n"
		+ "        \"end\": \"architectonic:block/$name_top\",\n"
		+ "        \"side\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String WALL_POST_MODEL = "{\n"
		+ "    \"parent\": \"block/template_wall_post\",\n"
		+ "    \"textures\": {\n"
		+ "        \"wall\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String WALL_SIDE_MODEL = "{\n"
		+ "    \"parent\": \"block/template_wall_side\",\n"
		+ "    \"textures\": {\n"
		+ "        \"wall\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String WALL_INVENTORY_MODEL = "{\n"
		+ "    \"parent\": \"block/wall_inventory\",\n"
		+ "    \"textures\": {\n"
		+ "        \"wall\": \"architectonic:block/$name\"\n"
		+ "    }\n"
		+ "}\n";
	public static final String ITEM_MODEL = "{\n"
		+ "  \"parent\": \"architectonic:block/$name\"\n"
		+ "}\n";

	public static final List<String> CUBES = new ArrayList<>();
	public static final List<String> STAIRS = new ArrayList<>();
	public static final List<String> SLABS = new ArrayList<>();
	public static final List<String> WALLS = new ArrayList<>();
	public static final List<String> PILLARS = new ArrayList<>();

	static {

	}

	public static void addWithStairsAndSlab(String name) {
		CUBES.add(name);
		SLABS.add(name);
		STAIRS.add(name);
	}

	public static void addWithStairsSlabAndWall(String name) {
		CUBES.add(name);
		SLABS.add(name);
		STAIRS.add(name);
		WALLS.add(name);
	}

	public static void addCube(String name) {
		CUBES.add(name);
	}

	public static void main(String... args) {
		JsonParser parser = new JsonParser();
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		for (String name : CUBES) {
			String blockstate = CUBE_BLOCKSTATE.replace("$name", name);
			String blockModel = CUBE_MODEL.replace("$name", name);
			String itemModel = ITEM_MODEL.replace("$name", name);
			try (Writer writer = new FileWriter("run/out/blockstates/" + name + ".json")) {
				gson.toJson(parser.parse(blockstate).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + ".json")) {
				gson.toJson(parser.parse(blockModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/item/" + name + ".json")) {
				gson.toJson(parser.parse(itemModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String name : PILLARS) {
			String blockstate = PILLAR_BLOCKSTATE.replace("$name", name);
			String blockModel = PILLAR_MODEL.replace("$name", name);
			String itemModel = ITEM_MODEL.replace("$name", name);
			try (Writer writer = new FileWriter("run/out/blockstates/" + name + ".json")) {
				gson.toJson(parser.parse(blockstate).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + ".json")) {
				gson.toJson(parser.parse(blockModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/item/" + name + ".json")) {
				gson.toJson(parser.parse(itemModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String name : STAIRS) {
			String blockstate = STAIRS_BLOCKSTATE.replace("$name", name);
			String straightModel = STAIRS_MODEL.replace("$name", name);
			String innerModle = STAIRS_INNER_MODEL.replace("$name", name);
			String outerModel = STAIRS_OUTER_MODEL.replace("$name", name);
			String itemModel = ITEM_MODEL.replace("$name", name + "_stairs");
			try (Writer writer = new FileWriter("run/out/blockstates/" + name + "_stairs.json")) {
				gson.toJson(parser.parse(blockstate).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_stairs.json")) {
				gson.toJson(parser.parse(straightModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_stairs_outer.json")) {
				gson.toJson(parser.parse(outerModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_stairs_inner.json")) {
				gson.toJson(parser.parse(innerModle).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/item/" + name + "_stairs.json")) {
				gson.toJson(parser.parse(itemModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String name : SLABS) {
			String blockstate = SLAB_BLOCKSTATE.replace("$name", name);
			String slabModel = SLAB_MODEL.replace("$name", name);
			String topSlabModel = SLAB_TOP_MODEL.replace("$name", name);
			String itemModel = ITEM_MODEL.replace("$name", name + "_slab");
			try (Writer writer = new FileWriter("run/out/blockstates/" + name + "_slab.json")) {
				gson.toJson(parser.parse(blockstate).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_slab.json")) {
				gson.toJson(parser.parse(slabModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_slab_top.json")) {
				gson.toJson(parser.parse(topSlabModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/item/" + name + "_slab.json")) {
				gson.toJson(parser.parse(itemModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String name : WALLS) {
			String blockstate = WALL_BLOCKSTATE.replace("$name", name);
			String wallSide = WALL_SIDE_MODEL.replace("$name", name);
			String wallPost = WALL_POST_MODEL.replace("$name", name);
			String wallInventory = WALL_INVENTORY_MODEL.replace("$name", name);
			String itemModel = ITEM_MODEL.replace("$name", name + "_wall_inventory");
			try (Writer writer = new FileWriter("run/out/blockstates/" + name + "_wall.json")) {
				gson.toJson(parser.parse(blockstate).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_wall_post.json")) {
				gson.toJson(parser.parse(wallPost).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_wall_side.json")) {
				gson.toJson(parser.parse(wallSide).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/block/" + name + "_wall_inventory.json")) {
				gson.toJson(parser.parse(wallInventory).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (Writer writer = new FileWriter("run/out/models/item/" + name + "_wall.json")) {
				gson.toJson(parser.parse(itemModel).getAsJsonObject(), writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
