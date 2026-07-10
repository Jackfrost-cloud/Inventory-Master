# Inventory Master - Build & Test Guide

## 🏗️ Building the Mod

### Step 1: Setup Development Environment

Make sure you have the following installed:
- Java JDK 21 or higher
- Gradle (or use the included `gradlew`)

**Check Java Version:**
```bash
java -version
```

Should output Java 21 or higher.

### Step 2: Generate Sources

Before building, generate source mappings:

```bash
cd c:\Users\adamo\Desktop\mod
./gradlew genSources
```

This may take 2-5 minutes on first run.

**Expected Output:**
```
BUILD SUCCESSFUL
```

### Step 3: Build the Mod

```bash
./gradlew build
```

This will compile all Java code and create the mod JAR.

**Build Time:** 1-3 minutes depending on your system

**Expected Output:**
```
BUILD SUCCESSFUL in XXXs
```

### Step 4: Verify Build

Check that the JAR was created:

```bash
dir build\libs\
```

Should show:
```
inventory-master-1.0.0.jar
inventory-master-1.0.0-sources.jar (optional)
```

---

## 🧪 Testing the Mod

### Option 1: Development Environment

Run the mod directly in Minecraft:

```bash
./gradlew runClient
```

This will:
1. Launch Minecraft with your mod loaded
2. Start in a test world
3. Allow you to test all features

**First Run:** May take 5-10 minutes to download dependencies and generate workspace

### Option 2: Manual Installation

1. Copy the JAR to your Mods folder:
```
cp build\libs\inventory-master-1.0.0.jar %APPDATA%\.minecraft\mods\
```

2. Launch Minecraft with Fabric Loader
3. Create or enter a world
4. Open any container (chest, barrel, hopper, etc.)
5. You should see the UI buttons

---

## ✅ Testing Checklist

### Core Features
- [ ] **Sort Button (Y)**
  - Open a chest with mixed items
  - Press Y or click Sort button
  - Items should reorganize by category
  - Verify stacks merge

- [ ] **Search (F)**
  - Open a chest
  - Press F or click Search
  - Type "diamond"
  - Verify diamond items are highlighted

- [ ] **Category Tabs**
  - Open a chest
  - Click different category tabs at bottom
  - Inventory display should change
  - Navigation with ← → keys should work

- [ ] **Favorite Slots (M)**
  - Click a slot
  - Press M to mark as favorite
  - Verify visual change (star icon)
  - Sort inventory - favorite item should stay in place

- [ ] **Smart Deposit (D)**
  - Register a chest for ores
  - Open another chest with ore items
  - Press D to deposit
  - Verify items moved to registered chest

### UI Elements
- [ ] **Buttons Render**
  - All buttons visible on screen
  - Buttons highlight on hover
  - Buttons clickable

- [ ] **Search Bar**
  - Appears when F pressed
  - Hides when ESC pressed
  - Can type text
  - Cursor visible

- [ ] **Category Tabs**
  - All 7 tabs visible
  - Current tab highlighted
  - Clicking changes active tab
  - Icon/text visible

### Configuration
- [ ] **ModConfig**
  - Config file created in `config/inventory-master/`
  - Contains all feature toggles
  - Features enable/disable based on config

### Translations
- [ ] **English Text**
  - All buttons have English labels
  - Messages appear in chat in English

- [ ] **Language Selection**
  - Change Minecraft language to Spanish
  - Reopen chest
  - UI should be in Spanish

---

## 🐛 Troubleshooting

### Build Fails - "Java version incompatible"
**Solution:** Install Java 21 or higher
```bash
java -version
# Should show java version 21 or higher
```

### Build Fails - "Task 'runClient' not found"
**Solution:** Make sure you're in the mod directory
```bash
cd c:\Users\adamo\Desktop\mod
./gradlew runClient
```

### Mod Doesn't Load
**Solution:** Check the log file
```
%APPDATA%\.minecraft\logs\latest.log
```

Look for errors starting with "Inventory Master"

### Buttons Don't Appear
**Cause:** Mixin not loaded

**Solution:** Verify fabric.mod.json has correct entrypoints
```json
"entrypoints": {
  "main": ["com.inventorymaster.InventoryMasterMod"],
  "client": ["com.inventorymaster.client.InventoryMasterClient"]
}
```

### Search Bar Doesn't Work
**Solution:** Verify ItemSearcher initialization
Check logs for: "Initializing Inventory Master Client!"

### Categories Not Switching
**Solution:** Verify VirtualBags is initialized
Check that CategoryTab buttons are clickable

---

## 📊 Performance Metrics

### Expected Performance
- **Load Time:** < 1 second
- **Sort Time:** < 500ms for full inventory
- **Search Time:** < 100ms for 1000 items
- **Render Time:** < 1ms per frame

### Optimization Tips
- Pre-load textures: `AssetManager.preloadAllButtonTextures()`
- Cache category lists
- Minimize mixin impact

---

## 🔍 Debug Mode

Enable debug logging:

1. Edit `InventoryMasterMod.java`
2. Add debug logs to key methods
3. Rebuild with `./gradlew build`
4. Run and check `latest.log`

Example:
```java
InventoryMasterMod.LOGGER.info("Sort button clicked!");
InventoryMasterMod.LOGGER.warn("No items found");
InventoryMasterMod.LOGGER.error("Search failed", exception);
```

---

## 📦 Distribution

### Creating Release JAR
The build already creates a distributable JAR:

```bash
./gradlew build
# Output: build/libs/inventory-master-1.0.0.jar
```

### Publishing to Modrinth
1. Create account on modrinth.com
2. Create new project
3. Upload JAR from `build/libs/`
4. Add screenshots and description
5. Publish

### Publishing to CurseForge
1. Create account on curseforge.com
2. Create new project for Fabric mods
3. Upload JAR
4. Configure version details
5. Publish

---

## 🚀 Release Checklist

Before releasing:
- [ ] All tests pass
- [ ] No compile warnings
- [ ] Documentation complete
- [ ] Version number set correctly (currently 1.0.0)
- [ ] Changelog written
- [ ] Screenshots taken
- [ ] Tested on clean Minecraft install

---

## 📝 Version Info

**Current Version:** 1.0.0

**Minecraft:** 1.21.1
**Fabric Loader:** 0.15.3
**Java:** 21+

To update version, edit `gradle.properties`:
```properties
mod_version=1.1.0
```

Then rebuild with `./gradlew build`

---

## 💡 Quick Commands

| Command | Purpose |
|---------|---------|
| `./gradlew build` | Build the mod JAR |
| `./gradlew runClient` | Run in development |
| `./gradlew genSources` | Generate source mappings |
| `./gradlew clean` | Clean build files |
| `./gradlew tasks` | List available tasks |

---

## 📞 Support Resources

- **Fabric Documentation:** https://fabricmc.net/
- **Minecraft Wiki:** https://minecraft.wiki/
- **Java Documentation:** https://docs.oracle.com/
- **Gradle Guide:** https://gradle.org/

---

**Ready to build! 🎉**

Run: `./gradlew build` to start.
