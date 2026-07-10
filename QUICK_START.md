# Inventory Master - Quick Start Guide

## 📦 What's Been Implemented

### ✅ Complete
1. **Core Sorting System** - InventoryManager with stack merging and categorization
2. **Favorite Slots** - Lock specific inventory slots
3. **Item Categorizer** - 7 category classification system
4. **Search System** - ItemSearcher with fuzzy matching
5. **Smart Deposit** - Remember and auto-organize chests
6. **Virtual Bags** - Browse inventory by categories
7. **Configuration** - ModConfig with settings persistence
8. **Key Bindings** (NEW) - 6 customizable key bindings
9. **Translations** (NEW) - English, Spanish, French, German
10. **Asset Manager** (NEW) - Texture loading system

---

## 🚀 Building & Testing

### Prerequisites
- Java 21 or higher
- Gradle installed (or use `./gradlew`)

### Build Commands
```bash
# Navigate to project directory
cd c:\Users\adamo\Desktop\mod

# Download dependencies and generate sources
./gradlew genSources

# Build the mod
./gradlew build

# Run in development environment
./gradlew runClient
```

### Build Output
The compiled mod JAR will be at:
```
build/libs/inventory-master-1.0.0.jar
```

### Installation
1. Go to Minecraft Mods folder: `%APPDATA%\.minecraft\mods`
2. Copy the JAR file
3. Launch Minecraft with Fabric

---

## ⌨️ Default Key Bindings

| Function | Key |
|----------|-----|
| Sort Inventory | **Y** |
| Search | **F** |
| Next Category | **→** |
| Previous Category | **←** |
| Smart Deposit | **D** |
| Toggle Favorite | **M** |

All can be customized in Controls settings.

---

## 🌍 Languages Supported

- 🇺🇸 English (en_us)
- 🇪🇸 Spanish (es_es)
- 🇫🇷 French (fr_fr)
- 🇩🇪 German (de_de)

The game automatically loads the appropriate language file.

---

## 📁 Project Structure

```
inventory-master/
├── src/main/java/com/inventorymaster/
│   ├── InventoryMasterMod.java              # Main mod entry
│   ├── client/
│   │   ├── InventoryMasterClient.java       # Client init
│   │   ├── InventoryManager.java            # Sorting
│   │   ├── FavoriteSlots.java               # Favorites
│   │   ├── ItemCategorizer.java             # Categories
│   │   ├── ItemSearcher.java                # Search
│   │   ├── SmartDepositSystem.java          # Deposit
│   │   ├── VirtualBags.java                 # Tabs
│   │   ├── KeyBindings.java                 # Keys ✨
│   │   └── InputHandler.java                # Input ✨
│   ├── config/
│   │   └── ModConfig.java                   # Config
│   ├── assets/
│   │   └── AssetManager.java                # Assets ✨
│   └── mixin/
│       ├── ScreenMixin.java                 # Screen hooks
│       └── ClientScreenMixin.java           # Client hooks
├── src/main/resources/
│   ├── fabric.mod.json                      # Metadata
│   ├── inventory-master.mixins.json         # Mixins
│   └── assets/inventory-master/
│       ├── icon.png                         # Mod icon
│       ├── lang/
│       │   ├── en_us.json                   # English ✨
│       │   ├── es_es.json                   # Spanish ✨
│       │   ├── fr_fr.json                   # French ✨
│       │   └── de_de.json                   # German ✨
│       └── textures/gui/
│           ├── sort_button.png
│           ├── search_button.png
│           └── ...
├── build.gradle                             # Build config
├── gradle.properties                        # Properties
└── README.md                                # Overview
```

---

## 🔄 How Features Work

### 1. Sorting (Y)
Organizes inventory by category and merges item stacks:
```
Before: Random items scattered
After:  Blocks | Ores | Food | Tools | Armor | Misc
```

### 2. Favorite Slots (M)
Lock items to specific inventory positions so they never move during sorting.

### 3. Search (F)
Find items with fuzzy matching:
```
Input: "diam" → Results: Diamond, Diamond Block, Diamond Pickaxe
```

### 4. Smart Deposit (D)
Register chests and auto-deposit items:
```
Chest A → Ores
Chest B → Food
Chest C → Blocks
```

### 5. Virtual Bags (← →)
Browse inventory by category:
- 📦 Blocks
- ⛏️ Ores
- 💎 Valuables
- 🍖 Food
- 🔧 Tools
- ⚔️ Armor
- 📋 Misc

### 6. Categories
Items auto-sorted into 7 categories with priority ordering.

### 7. Configuration
Enable/disable any feature in config file.

---

## 🎨 Asset Placement

Create textures in:
```
src/main/resources/assets/inventory-master/textures/gui/
├── sort_button.png
├── search_button.png
├── favorite_button.png
├── deposit_button.png
└── tabs/
    ├── blocks_tab.png
    ├── ores_tab.png
    ├── valuables_tab.png
    ├── food_tab.png
    ├── tools_tab.png
    ├── armor_tab.png
    └── misc_tab.png
```

All textures should be PNG with transparency, 20-24 pixels.

See [ASSET_GUIDE.md](ASSET_GUIDE.md) for detailed instructions.

---

## 📚 Documentation Files

- **README.md** - Project overview
- **PROJECT_STRUCTURE.md** - Architecture details
- **KEYBINDINGS_AND_TRANSLATIONS.md** - Key bindings and language support
- **ASSET_GUIDE.md** - How to create textures
- **QUICK_START.md** - This file!

---

## 🔧 Next Steps

To complete the mod, implement:

1. **UI Screens** - Custom inventory screen with buttons
2. **Mouse Events** - Click handlers for buttons
3. **Chest Registration** - UI for marking storage chests
4. **Testing** - Verify all features work in-game

---

## 📞 Common Issues

### Build Fails
```
Error: Java version not compatible
→ Solution: Install Java 21+
```

### Mod Doesn't Load
```
Error: Missing dependencies
→ Solution: Run ./gradlew genSources first
```

### Keys Not Working
```
Error: Key bindings don't respond
→ Solution: Make sure InventoryMasterClient is initialized
```

---

## 💡 Tips

- Use `./gradlew runClient` to test while developing
- Check the log file at `.minecraft/logs/latest.log` for errors
- Press F3+S to see debug info in-game
- Test new features in Creative mode first

---

**Ready to build! 🚀**

Run: `./gradlew build`
