# Inventory Master - Project Structure

## Directory Layout

```
inventory-master/
├── src/
│   ├── main/
│   │   ├── java/com/inventorymaster/
│   │   │   ├── InventoryMasterMod.java          # Main mod entry point
│   │   │   ├── client/
│   │   │   │   ├── InventoryMasterClient.java   # Client entry point
│   │   │   │   ├── InventoryManager.java        # Core sorting logic
│   │   │   │   ├── FavoriteSlots.java           # Favorite slots system
│   │   │   │   ├── ItemCategorizer.java         # Item categorization
│   │   │   │   ├── ItemSearcher.java            # Search functionality
│   │   │   │   ├── SmartDepositSystem.java      # Smart deposit logic
│   │   │   │   └── VirtualBags.java             # Virtual bags/tabs
│   │   │   ├── mixin/
│   │   │   │   ├── ScreenMixin.java             # Screen interaction hooks
│   │   │   │   └── ClientScreenMixin.java       # Client screen hooks
│   │   │   ├── config/
│   │   │   │   └── ModConfig.java               # Configuration management
│   │   │   └── ui/                              # (To be created)
│   │   │       ├── InventoryScreen.java         # Custom inventory UI
│   │   │       ├── SortButton.java              # Sort button widget
│   │   │       ├── SearchBar.java               # Search bar widget
│   │   │       ├── CategoryTabs.java            # Category tab widgets
│   │   │       └── SmartDepositButton.java      # Smart deposit button
│   │   └── resources/
│   │       ├── fabric.mod.json                  # Mod metadata
│   │       ├── inventory-master.mixins.json     # Mixin config
│   │       └── assets/inventory-master/
│   │           ├── icon.png                     # Mod icon
│   │           ├── lang/en_us.json              # English translations
│   │           └── textures/                    # Texture assets
│   └── test/                                     # (Optional) Test code
├── build.gradle                                  # Gradle build config
├── settings.gradle                               # Gradle settings
├── gradle.properties                             # Gradle properties
├── .gitignore                                    # Git ignore rules
└── README.md                                     # Project readme
```

## Core Components

### 1. **InventoryMasterMod.java**
   - Main mod entry point
   - Initializes all systems

### 2. **InventoryManager.java**
   - Handles automatic inventory sorting
   - Merges similar stacks
   - Arranges items by category

### 3. **FavoriteSlots.java**
   - Manages locked/favorite slots
   - Prevents favorite items from being moved

### 4. **ItemCategorizer.java**
   - Categorizes items into 7 categories
   - Sorts items by category priority

### 5. **ItemSearcher.java**
   - Provides search functionality
   - Supports fuzzy matching
   - Generates search suggestions

### 6. **SmartDepositSystem.java**
   - Registers storage chests
   - Automatically directs items to correct chests
   - Manages category-to-chest mappings

### 7. **VirtualBags.java**
   - Manages category-based tabs
   - Filters items by category
   - Provides category information for UI

### 8. **ModConfig.java**
   - Handles configuration storage
   - Manages user preferences
   - Saves/loads settings from disk

## Next Steps

1. **UI Implementation** (To be done)
   - Create custom screen widgets
   - Implement sort button
   - Add search bar
   - Create category tabs

2. **Event Handling** (To be done)
   - Hook into inventory open/close events
   - Handle key bindings
   - Listen to mouse clicks on buttons

3. **Testing** (To be done)
   - Test sorting functionality
   - Verify favorite slots work
   - Test category assignment
   - Validate search functionality

4. **Asset Creation** (To be done)
   - Create mod icon (16x16 pixels)
   - Create button textures
   - Add UI element textures

5. **Translations** (To be done)
   - Add English translations
   - Support other languages

## Building the Mod

```bash
# Generate sources
./gradlew genSources

# Build the mod
./gradlew build

# Run in dev environment
./gradlew runClient
```

## Dependencies

- Minecraft 1.21.1
- Fabric Loader 0.15.3
- Fabric API 0.102.0

All dependencies are automatically managed by Gradle.
