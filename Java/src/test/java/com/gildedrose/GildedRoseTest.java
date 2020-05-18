package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void sellInDecreasesDaily() {
        Item[] items = new Item[] { new Item("foo", 12, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
    }

    @Test
    void sellInDecreasesBelowZero() {
        Item[] items = new Item[] { new Item("foo", 0, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void qualityDecreasesDaily() {
        Item[] items = new Item[] { new Item("foo", 12, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void qualityDecreasesFasterAfterSellBy() {
        Item[] items = new Item[] { new Item("foo", 0, 17) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15, app.items[0].quality);
    }

    @Test
    void qualityDoesntDecreaseFromZero() {
        Item[] items = new Item[] { new Item("foo", 12, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityDoesntDecreaseBeyondZero() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void AgedBrieIncreasesQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 4, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void AgedBrieIncreasesQualityFasterAfterSellBy() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void QualityDoesntIncreaseFromFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void QualityDoesntIncreaseBeyondFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void SulfurasDoesntChangeValues() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    //  @Test
    //TODO void BackstagePassesLoseQualityAfterSellBy()

}
