package com.dragonslayerelf.crafting.crafting;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenMenu implements Listener {

    private ArrayList<InventoryMenu> invMens = new ArrayList<>();
    public ArrayList<InventoryMenu> getInvMens() {
        return invMens;
    }
    public OpenMenu() {
        ItemStack[] items = {new ItemStack(Material.BLUE_WOOL, 1), new ItemStack(Material.BLACK_WOOL, 1), new ItemStack(Material.RED_WOOL, 1)};
        String[] names = {"Give Diamond", "Give Coal", "Give Redstone"};
        ArrayList<List<String>> lores = new ArrayList<>();
        lores.add(Arrays.asList("Gives you a diamond!"));
        lores.add(Arrays.asList("Gives you coal!", "Without mining!"));
        lores.add(Arrays.asList("Gives you redstone!"));
        invMens.add(new InventoryMenu("Give Menu", 9, items, names, lores));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        if(e.getWhoClicked() instanceof Player)
        {
            Player ply = (Player) e.getWhoClicked();
            if(e.getInventory().equals(invMens.get(0).getInv())) {
                e.setCancelled(true);
                if(e.getCurrentItem().equals(invMens.get(0).getItems().get(0))) {
                    ply.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
                }
                else if(e.getCurrentItem().equals(invMens.get(0).getItems().get(1)))
                {
                    ply.getInventory().addItem(new ItemStack(Material.COAL, 1));
                }
                else if (e.getCurrentItem().equals(invMens.get(0).getItems().get(2)))
                {
                    ply.getInventory().addItem(new ItemStack(Material.REDSTONE, 3));
                }
            }
        }
    }
}
