# Inventory Master - Asset Guide

## Asset Files Required

### Mod Icon
- **File:** `src/main/resources/assets/inventory-master/icon.png`
- **Size:** 256x256 pixels (will be scaled down automatically)
- **Format:** PNG with transparency
- **Content:** Logo/icon representing inventory management

### Button Textures
Located in: `src/main/resources/assets/inventory-master/textures/gui/`

#### Sort Button
- **File:** `sort_button.png`
- **Size:** 20x20 pixels
- **Content:** ✓ (checkmark) or sorting arrows icon

#### Search Button
- **File:** `search_button.png`
- **Size:** 20x20 pixels
- **Content:** 🔍 (magnifying glass)

#### Favorite Button
- **File:** `favorite_button.png`
- **Size:** 20x20 pixels
- **Content:** ⭐ (star) filled and unfilled variants
- **States:**
  - `favorite_button.png` - Normal state
  - `favorite_button_active.png` - When slot is favorited

#### Smart Deposit Button
- **File:** `deposit_button.png`
- **Size:** 20x20 pixels
- **Content:** 📦 (package) or down arrow

#### Category Tab Icons
Located in: `src/main/resources/assets/inventory-master/textures/gui/tabs/`

- `blocks_tab.png` - 📦 Blocks
- `ores_tab.png` - ⛏️ Ores
- `valuables_tab.png` - 💎 Valuables
- `food_tab.png` - 🍖 Food
- `tools_tab.png` - 🔧 Tools
- `armor_tab.png` - ⚔️ Armor
- `misc_tab.png` - 📋 Miscellaneous

**Size:** 24x24 pixels each

### Search Bar Texture
- **File:** `src/main/resources/assets/inventory-master/textures/gui/search_bar.png`
- **Size:** 160x20 pixels
- **Content:** Text input field background

---

## How to Create Assets

### Using Image Editing Software
1. Open GIMP, Photoshop, or any image editor
2. Create a new image with the specified dimensions
3. Use transparency (alpha channel) for non-button areas
4. Save as PNG with transparency enabled

### Using Online Tools
- pixlr.com
- photopea.com
- gimp.org (free, open-source)

### Using Art Tools
- Aseprite (paid, great for pixel art)
- Krita (free, powerful)
- Paint.NET (free, simple)

---

## Asset Folder Structure

```
src/main/resources/assets/inventory-master/
├── icon.png
├── lang/
│   └── en_us.json
└── textures/
    └── gui/
        ├── sort_button.png
        ├── search_button.png
        ├── favorite_button.png
        ├── favorite_button_active.png
        ├── deposit_button.png
        ├── search_bar.png
        └── tabs/
            ├── blocks_tab.png
            ├── ores_tab.png
            ├── valuables_tab.png
            ├── food_tab.png
            ├── tools_tab.png
            ├── armor_tab.png
            └── misc_tab.png
```

---

## Loading Textures in Code

```java
// Example: Loading a texture
Identifier texture = new Identifier("inventory-master", "textures/gui/sort_button.png");
TextureManager textureManager = MinecraftClient.getInstance().getTextureManager();
textureManager.bindTexture(texture);
```

---

## Notes

- All textures should be power-of-two dimensions (16, 32, 64, 128, 256, etc.)
- Use PNG format for transparency support
- Keep textures simple and clear for small sizes
- Test textures in-game to ensure they look correct
