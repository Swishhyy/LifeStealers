package me.swishhyy.lifeStealers.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class CraftingManager {
    private final JavaPlugin plugin;

    public CraftingManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerRecipes() {
        ConfigurationSection recipesSection = plugin.getConfig().getConfigurationSection("CraftingRecipes");
        if (recipesSection == null) {
            plugin.getLogger().warning("No crafting recipes found in the config!");
            return;
        }

        for (String recipeName : recipesSection.getKeys(false)) {
            ConfigurationSection recipeSection = recipesSection.getConfigurationSection(recipeName);

            if (recipeSection == null || !recipeSection.getBoolean("enabled", true)) {
                continue;
            }

            String[] pattern = recipeSection.getStringList("pattern").toArray(new String[0]);
            Map<String, Object> ingredients = recipeSection.getConfigurationSection("ingredients").getValues(false);

            ItemStack result = createResultItem(recipeSection.getConfigurationSection("result"));
            if (result == null) {
                plugin.getLogger().warning("Failed to create result item for recipe: " + recipeName);
                continue;
            }

            registerRecipe(recipeName, pattern, ingredients, result);
        }
    }

    private ItemStack createResultItem(ConfigurationSection resultSection) {
        if (resultSection == null) return null;

        String materialName = resultSection.getString("item");
        Material material = Material.matchMaterial(materialName);
        if (material == null) {
            plugin.getLogger().warning("Invalid material: " + materialName);
            return null;
        }

        int amount = resultSection.getInt("amount", 1);
        return new ItemStack(material, amount);
    }

    private void registerRecipe(String recipeName, String[] pattern, Map<String, Object> ingredients, ItemStack result) {
        NamespacedKey key = new NamespacedKey(plugin, recipeName.toLowerCase());
        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape(pattern);

        for (Map.Entry<String, Object> entry : ingredients.entrySet()) {
            String keyChar = entry.getKey();
            Material material = Material.matchMaterial(entry.getValue().toString());
            if (material == null) {
                plugin.getLogger().warning("Invalid material for ingredient: " + entry.getValue());
                continue;
            }
            recipe.setIngredient(keyChar.charAt(0), material);
        }

        Bukkit.addRecipe(recipe);
        plugin.getLogger().info("Registered recipe: " + recipeName);
    }
}
