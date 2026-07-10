# Inventory Master - UI Implementation Guide

## Overview

The UI system for Inventory Master consists of several custom widgets and a main screen class that extends the vanilla container screen.

## UI Components

### 1. **InventoryMasterScreen** - Main Custom Screen
Location: `client/ui/InventoryMasterScreen.java`

The main screen that replaces the default container screen with Inventory Master features.

**Features:**
- Automatically replaces GenericContainerScreen
- Adds all UI buttons based on mod configuration
- Handles button clicks and interactions
- Manages category tab switching
- Processes search input

**Key Methods:**
- `handleSort()` - Sorts inventory when sort button clicked
- `handleSearch(String query)` - Filters items based on search query
- `handleSmartDeposit()` - Executes smart deposit
- `handleToggleFavorite()` - Toggles favorite on current slot
- `handleCategorySwitch(CategoryTab)` - Switches active category

### 2. **IMButton** - Custom Button Widget
Location: `client/ui/IMButton.java`

A styled button for Inventory Master features.

**Features:**
- Custom hover effects
- Styled borders
- Tooltip support
- Consistent theming

**Usage:**
```java
IMButton sortButton = new IMButton(x, y, width, height, Text.literal("S"), 
    button -> { /* on click */ }, "tooltip.key");
```

### 3. **SearchBar** - Search Input Widget
Location: `client/ui/SearchBar.java`

Text input field for searching items.

**Features:**
- Custom styling
- Placeholder text
- Cursor animation
- Fuzzy search integration

**Methods:**
- `setVisible(boolean)` - Show/hide search bar
- `clear()` - Clear search text
- `getText()` - Get current search query

### 4. **CategoryTab** - Category Tab Button
Location: `client/ui/CategoryTab.java`

Tab button for switching between item categories.

**Features:**
- Active/inactive visual states
- Hover effects
- Category management
- Smooth transitions

**Methods:**
- `setActive(boolean)` - Set tab active state
- `getCategory()` - Get associated category

### 5. **UIUtils** - Utility Functions
Location: `client/ui/UIUtils.java`

Common UI drawing and utility functions.

**Features:**
- Rect drawing with borders
- Text rendering
- Color constants
- Tooltip support

**Color Constants:**
```java
UIUtils.Colors.PRIMARY        // 0xFF4A90E2
UIUtils.Colors.PRIMARY_DARK   // 0xFF3A5BC7
UIUtils.Colors.SECONDARY      // 0xFF8B8B8B
UIUtils.Colors.TEXT_PRIMARY   // 0xFFFFFFFF
// ... and more
```

### 6. **TooltipManager** - Tooltip Display
Location: `client/ui/TooltipManager.java`

Manages tooltip display with delay.

**Features:**
- Configurable delay (300ms)
- Automatic translation
- Position tracking

### 7. **ScreenFactory** - Screen Creation
Location: `client/ui/ScreenFactory.java`

Factory for creating custom screens.

## UI Layout

```
┌─────────────────────────────────────────────────┐
│  Container Screen (Chest/Barrel/Hopper/etc)    │
├─────────────────────────────────────────────────┤
│  [S] Sort          ← Right side buttons         │
│  [Search bar]                                   │
│  [D] Smart Deposit                              │
│  [F] Favorite                                   │
│                                                 │
│  [Item Grid Display]                            │
│                                                 │
├─────────────────────────────────────────────────┤
│ [📦 Blocks] [⛏️ Ores] [💎 Val] ... [📋 Misc]   │
│  ← Category tabs at bottom                      │
└─────────────────────────────────────────────────┘
```

## Screen Injection Flow

```
1. Player opens container
   ↓
2. GenericContainerScreen.init() triggered
   ↓
3. ClientScreenOpenMixin intercepts
   ↓
4. InventoryMasterScreen created (if enabled)
   ↓
5. Buttons and tabs initialized
   ↓
6. Screen rendered with features
```

## Mixins

### ClientScreenOpenMixin
Intercepts screen opening to replace with InventoryMasterScreen.

**Location:** `mixin/ClientScreenOpenMixin.java`

**Method Injected:** `MinecraftClient.setScreen(Screen)`

**Purpose:** Replace GenericContainerScreen with InventoryMasterScreen

### ScreenMixin
Logs when UI is injected.

**Location:** `mixin/ScreenMixin.java`

**Method Injected:** `GenericContainerScreen.init()`

## Event Handling

### Mouse Events
- **Left Click** - Button activation
- **Scroll** - Tab navigation (configurable)
- **Hover** - Tooltip display

### Keyboard Events
- **ESC** - Close search bar
- **Bound Keys** - Trigger features via KeyBindings
- **Text Input** - Search query in search bar

## Configuration

UI features can be toggled in `ModConfig`:
```java
enableAutoSort        // Sort button
enableSearchBar       // Search bar
enableSmartDeposit    // Smart deposit button
enableFavoriteSlots   // Favorite button
enableVirtualBags     // Category tabs
```

## Styling Guide

### Colors
All colors are defined in `UIUtils.Colors`:
- Use `PRIMARY` for main UI elements
- Use `TEXT_PRIMARY` for visible text
- Use `ACCENT` for hover states

### Button Design
- Size: 20x20 pixels (standard)
- Label: Single character or icon
- Spacing: 5 pixels between buttons
- Positioning: Right side of screen

### Text
- Font: Minecraft default
- Shadow: Always enabled
- Color: Based on element type
- Size: Standard (8px)

## Advanced Features

### Search Integration
Search queries are processed by `ItemSearcher`:
```java
List<ItemStack> results = ItemSearcher.getInstance()
    .fuzzySearch(allItems, query);
```

### Category Filtering
Items displayed based on selected category:
```java
List<ItemStack> categoryItems = ItemCategorizer.getInstance()
    .getItemsByCategory(allItems, category);
```

### Smart Deposit
Deposits items to registered chests:
```java
BlockPos targetChest = SmartDepositSystem.getInstance()
    .getTargetChest(itemStack);
```

## Performance Considerations

1. **Texture Caching** - AssetManager pre-loads textures
2. **Lazy Initialization** - Buttons only created if enabled
3. **Efficient Rendering** - Draw calls minimized
4. **Event Throttling** - Input events processed once per tick

## Troubleshooting

### Screen Not Showing
- Check `ModConfig` - features might be disabled
- Verify mixins are compiled
- Check logs for initialization errors

### Buttons Not Responding
- Ensure `KeyBindings.register()` was called
- Check `InputHandler` is receiving events
- Verify button coordinates are correct

### Tooltips Not Displaying
- Check translation keys exist in language files
- Verify `TooltipManager` is initialized
- Check hover delay (300ms default)

## Future Enhancements

- [ ] Draggable buttons (customize layout)
- [ ] Theme selector (light/dark mode)
- [ ] Animation system (smooth transitions)
- [ ] Sound effects on button clicks
- [ ] Custom keybind UI
