package com.yunusemin.edgemod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod("edgemod")
public class EdgeMod {
    public static final String MODID = "edgemod";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);

    public static final DeferredHolder<Item, Item> BOT_REMOTE = ITEMS.register("bot_remote", 
        () -> new Item(new Item.Properties().stacksTo(1)) {
            @Override
            public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
                if (!level.isClientSide) {
                    player.sendSystemMessage(Component.literal("§6[Emildian Edge] §fBot Kumandasi Calisiyor!"));
                }
                return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
            }
        });

    public EdgeMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            // BURASI KRİTİK: .get() ekledik ki kutu açılsın
            event.accept(BOT_REMOTE.get());
        }
    }
}
