package com.yunusemin.edgemod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

@Mod("edgemod")
public class EdgeMod {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "edgemod");

    // Hatalı olan yeri DeferredHolder yaparak düzelttik
    public static final DeferredHolder<Item, Item> BOT_REMOTE = ITEMS.register("bot_remote", 
        () -> new Item(new Item.Properties()));

    public EdgeMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
