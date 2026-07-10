# Inventory Master - Key Bindings & Translations Reference

## 🎮 Key Bindings

All key bindings are customizable in Minecraft's control settings under "Inventory Master" category.

| Action | Default Key | Description |
|--------|------------|-------------|
| Sort Inventory | **Y** | Automatically sort and organize inventory |
| Toggle Search | **F** | Open/close the search bar |
| Next Category | **→** (Right Arrow) | Switch to the next item category |
| Previous Category | **←** (Left Arrow) | Switch to the previous item category |
| Smart Deposit | **D** | Deposit items into designated chests |
| Toggle Favorite | **M** | Mark/unmark the selected slot as favorite |

### How to Change Key Bindings

1. Open Minecraft
2. Go to **Options** → **Controls**
3. Scroll down to find "Inventory Master" section
4. Click on any binding to change it
5. Press the new key you want to assign

---

## 🌍 Supported Languages

The mod includes translations in the following languages:

### ✅ Implemented
- **English** (en_us) - Full
- **Spanish** (es_es) - Full
- **French** (fr_fr) - Full
- **German** (de_de) - Full

### 📋 Translation Coverage

Each language file includes translations for:
- Key binding names and descriptions
- Button labels
- Category names
- In-game messages
- Configuration options
- UI placeholders

### Adding More Languages

To add a new language:

1. Create a new file: `src/main/resources/assets/inventory-master/lang/[LANG_CODE].json`
2. Use the English (en_us.json) as a template
3. Translate all string values
4. Keep the JSON keys exactly the same

**Language Codes:**
- `en_us` - English (US)
- `es_es` - Spanish (Spain)
- `fr_fr` - French (France)
- `de_de` - German (Germany)
- `pt_br` - Portuguese (Brazil)
- `ja_jp` - Japanese
- `zh_cn` - Chinese (Simplified)

---

## 📝 Translation System

### File Location
```
src/main/resources/assets/inventory-master/lang/
├── en_us.json
├── es_es.json
├── fr_fr.json
└── de_de.json
```

### JSON Structure
```json
{
  "key.inventory-master.sort": "Sort Inventory",
  "inventorymaster.button.sort": "Sort",
  "inventorymaster.category.blocks": "Blocks"
}
```

### Naming Conventions

- `key.inventory-master.*` - Key binding translations
- `inventorymaster.button.*` - Button labels
- `inventorymaster.category.*` - Category names
- `inventorymaster.message.*` - In-game messages
- `inventorymaster.config.*` - Configuration option names

---

## 🔧 Configuration Strings

All feature toggle strings are translatable:

| Translation Key | Default (English) | Purpose |
|---|---|---|
| `enable_auto_sort` | Enable Auto Sort | Toggle automatic sorting |
| `enable_favorite_slots` | Enable Favorite Slots | Toggle favorite slots feature |
| `enable_categorization` | Enable Categorization | Toggle item categorization |
| `enable_smart_deposit` | Enable Smart Deposit | Toggle smart deposit system |
| `enable_search` | Enable Search | Toggle search functionality |
| `enable_virtual_bags` | Enable Virtual Bags | Toggle category tabs |

---

## 📢 In-Game Messages

Players will see these messages in their chat:

### Success Messages
- `"Inventory sorted!"` - After clicking sort
- `"Slot marked as favorite"` - When marking a slot
- `"Items deposited successfully"` - After smart deposit

### Info Messages
- `"Chest registered for category: [Category]"` - When setting up storage
- `"Slot unmarked as favorite"` - When unmarking
- `"Chest unregistered"` - When removing storage

### Search Messages
- `"No items found"` - When search has no results

---

## 🎯 Development Notes

### Adding a New Key Binding

In `KeyBindings.java`:
```java
PUBLIC_KEY_NAME = KeyBindingHelper.registerKeyBinding(
    new KeyBinding(
        "key.inventory-master.your_key_name",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_YOUR_KEY,
        CATEGORY
    )
);
```

Then add the translation in **all** language JSON files:
```json
"key.inventory-master.your_key_name": "Your Key Name"
```

### Adding a New Button

Create a translation key:
```json
"inventorymaster.button.your_button": "Button Label"
```

The mod will automatically load it from the current language file.

---

## 🐛 Troubleshooting

### Key Binding Not Working
1. Check the key isn't already bound to another action
2. Make sure the mod is installed correctly
3. Verify the key code is correct (GLFW_KEY_*)

### Translations Not Showing
1. Verify the language JSON file exists
2. Check JSON syntax is valid (use JSONLint)
3. Ensure the game is restarted after adding files

### Missing Translation String
The mod will display the English key if a translation is missing.

Example: If `es_es.json` doesn't have a string, it will show `key.inventory-master.sort`
