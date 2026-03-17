package com.yunusemin.edgemod;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.bus.api.IEventBus;

@Mod("edgemod")
public class EdgeMod {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems("edgemod");
    
    // Bot Kumandası Kaydı
    public static final net.neoforged.neoforge.registries.DeferredItem<Item> REMOTE = ITEMS.register("bot_remote", 
        () -> new Item(new Item.Properties().stacksTo(1)));

    public EdgeMod(IEventBus bus) {
        ITEMS.register(bus);
        bus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(REMOTE);
        }
    }
}
