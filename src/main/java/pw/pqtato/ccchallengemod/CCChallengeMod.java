package pw.pqtato.ccchallengemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pw.pqtato.ccchallengemod.lists.BlockList;
import pw.pqtato.ccchallengemod.lists.ItemList;

@Mod("ccchallenge")
public class CCChallengeMod {
	public static CCChallengeMod instance;
	public static final String modid = "ccchallenge";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup ccchallenge = new CCChallengeItemGroup();
	
	public CCChallengeMod() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
					ItemList.gold_coin = new Item(new Item.Properties().group(ccchallenge)).setRegistryName(location("gold_coin")),
					ItemList.rainbow_coin = new Item(new Item.Properties().group(ccchallenge)).setRegistryName(location("rainbow_coin")),
					ItemList.icon = new Item(new Item.Properties()).setRegistryName(location("icon")),
					
					ItemList.lamp = new ItemBlock(BlockList.lamp, new Item.Properties().group(ccchallenge)).setRegistryName(BlockList.lamp.getRegistryName())
			);
			
			logger.info("Items registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					BlockList.lamp = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 3.0f).lightValue(10).sound(SoundType.WOOD)).setRegistryName(location("lamp"))
			);
			
			logger.info("Blocks registered");
		}
		
		private static ResourceLocation location(String name) {
			return new ResourceLocation(modid, name);
		}
	}
}
