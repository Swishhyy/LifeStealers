# LifeStealers
## Currently listed below is the PLANNED stuff, as these things are NOT implemented
 A lifesteal Plugin for 1.21+, this plugin is primarily developed for Epic Labaratory MC but it is a public resource.

 This plugin features the Lifesteal SMP features,
 The Ability to manufacture Heart Pieces into Hearts, This allows users to gain hearts easily
 Aswell as the ability to make a beyond default hearts via "Golden Hearts" this takes 9 Hearts in a crafting table to combine into one Golden Heart as this are harder to get thats why they seem more broken


 All features can be disabled in config and editted in config
 For now recipes cannot be editted

 Commands for Admins:
 /LifeStealers grant %player% <heart/goldenheart> %amount% // grants heart(s)/golden heart(s) to any user
 /LifeStealers remove %player% <heart/goldenheart> %amount% // removes heart(s)/golden hearts(s) from any user
 /LifeStealers reload // reloads config files 
 /LifeStealers hearts %player% // this shows any players current hearts
 
 Placeholders:
%Lifestealerskillamount% shows how many kills the player has
%LifestealersDeathamount% shows how many deaths the player has
%LifestealersHeartamount% shows the players current heart count


Default Config
```
# Enable/Disable any plugin functionality
GoldenHeart: true # Enables Golden Heart Functionality
HeartCrafting: true # Allows hearts to be crafted
HeartDropAsAItem: true # Drops a heart as an item instead of directly giving it to the player
HeartStealOnKill: true # Enables stealing hearts from players upon killing them
TeamSystem: true # Enables the Team System

# LifeSteal Configuration
BanLength: 1d # Duration of ban when a player runs out of hearts
MaxHearts: 20 # Maximum number of hearts a player can have
MinHearts: 0 # Minimum number of hearts a player can have before being banned
HeartDropChance: 100 # Chance (in %) for a heart to drop on player death

# Crafting Configuration
GoldenHeartRecipe: true # Enables custom crafting recipe for golden hearts
HeartCraftingRecipes:
  Heart:
    enabled: true
    pattern:
      - "NNN"
      - "NSN"
      - "NNN"
    ingredients:
      N: NETHERITE_INGOT
      S: NETHER_STAR
    result:
      item: HEART_ITEM
      amount: 1
  GoldenHeart:
    enabled: true
    pattern:
      - "HHH"
      - "HHH"
      - "HHH"
    ingredients:
      H: HEART_ITEM
    result:
      item: GOLDEN_HEART
      amount: 1

# PVP Options
AllowHeartStealInPVE: false # Allows stealing hearts from mobs in PVE
TeamKillHeartSteal: false # Enables stealing hearts from teammates

# Heart Recovery Options
HeartRecoveryCooldown: 1h # Cooldown before a player can recover a lost heart
HeartRecoveryCommandEnabled: true # Enables a command to recover hearts
HeartRecoveryCost: 5 # Cost in diamonds or custom items to recover one heart

# Logging & Messages
EnableLogging: true # Logs events like kills and heart transfers to the console
KillMessage: "{killer} stole a heart from {victim}!" # Customizable kill message
BanMessage: "You are banned for running out of hearts. See you in {time}!" # Customizable ban message

# Admin Commands
AdminBypass: false # Allows admins to bypass heart-related restrictions
AdminNotification: true # Notifies admins when a player runs out of hearts

# Other Configurations
HeartTradeEnabled: true # Allows players to trade hearts with others
HeartTradeCooldown: 10m # Cooldown for heart trading
HeartStealLimitPerDay: 5 # Maximum number of hearts a player can steal in one day
CustomHeartItemName: "&cStolen Heart" # Custom display name for heart items
CustomHeartItemLore:
  - "&7This heart was stolen in combat."
  - "&6Use it wisely."
```
