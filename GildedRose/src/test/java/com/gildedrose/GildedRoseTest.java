package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class GildedRoseTest {
/*
    @Test
    @DisplayName("Producto normal: con calidad y sin caducar")
    void normalConCalidadSinCaducar() {
    	String producto = "Un producto";
        Item[] items = new Item[] { new Item(producto, 2, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(1, app.items[0].sellIn),
        		() -> assertEquals(2, app.items[0].quality)
        		);
    }
    
    @Test
    @DisplayName("Producto normal: con calidad y caducado")
    void normalConCalidadCaducado() {
    	String producto = "Un producto";
        Item[] items = new Item[] { new Item(producto, -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(-2, app.items[0].sellIn),
        		() -> assertEquals(8, app.items[0].quality)
        		);
    }

    @Test
    @DisplayName("Producto normal: sin calidad y sin caducar")
    void normalSinCalidadSinCaducar() {
    	String producto = "Un producto";
        Item[] items = new Item[] { new Item(producto, 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(1, app.items[0].sellIn),
        		() -> assertEquals(0, app.items[0].quality)
        		);
    }
    
    @Test
    @DisplayName("Producto normal: sin calidad y caducado")
    void normalSinCalidadCaducado() {
    	String producto = "Un producto";
        Item[] items = new Item[] { new Item(producto, -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(-2, app.items[0].sellIn),
        		() -> assertEquals(0, app.items[0].quality)
        		);
    }
*/    
	@ParameterizedTest(name = "Producto normal {index}: ({0},{1}) => ({2},{3})")
	@CsvSource({
		"11, 10, 10, 9",
		"7, 1, 6, 0",
		"-1, 1, -2, 0",
		"0, 3, -1, 1",
		})
	void productNormalTest(int sellIn, int quality, int sellInOut, int qualityOut) {
    	String producto = "Normal Product";
        Item[] items = new Item[] { new Item(producto, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll(producto, 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(sellInOut, app.items[0].sellIn),
        		() -> assertEquals(qualityOut, app.items[0].quality)
        		);
    }
	
	@ParameterizedTest(name = "Aged Brie {index}: ({0},{1}) => ({2},{3})")
	@CsvSource({
		"2, 0, 1, 1",
		"-1, 48, -2, 50",
		"2, 50, 1, 50",
		"-2, 49, -3, 50",
		"1, 1, 0, 2",
		})
	void productAgedBrieTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Aged Brie";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	
	@ParameterizedTest(name = "Sulfuras {index}: ({0},{1}) => ({2},{3})")
	@CsvSource({
		"1, 0, 1, 0",
		"0, 1, 0, 1",
		"-1, 1, -1, 1",
		})
	void productSulfurasTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Sulfuras, Hand of Ragnaros";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	
	@ParameterizedTest(name = "Backstage passes {index}: ({0},{1}) => ({2},{3})")
	@CsvSource({
		"11, 0, 10, 1",
		"7, 1, 6, 3",
		"7, 49, 6, 50",
		"5, 49, 4, 50", // add
		"5, 3, 4, 6",
		"0, 3, -1, 0",
		"-1, 3, -2, 0",
		})
	void productBackstagePassesTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Backstage passes to a TAFKAL80ETC concert";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
/*	
	@ParameterizedTest(name = "Conjured {index}: ({0},{1}) => ({2},{3})")
	@CsvSource({
		"11, 10, 10, 8",
		"7, 1, 6, 0",
		"-5, 10, -6, 6",
		"0, 3, -1, 0",
		})
	void productConjuredTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Conjured Mana Cake";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
*/
    @Test
    @DisplayName("Producto Conjured: con calidad y sin caducar")
    void conjuredConCalidadSinCaducar() {
    	String producto = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(producto, 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(10, app.items[0].sellIn),
        		() -> assertEquals(8, app.items[0].quality)
        		);
    }
    
    @Test
    @DisplayName("Producto Conjured: con calidad y sin caducar (limite)")
    void conjuredConCalidadSinCaducarLimite() {
    	String producto = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(producto, 11, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(10, app.items[0].sellIn),
        		() -> assertEquals(0, app.items[0].quality)
        		);
    }
    
    @Test
    @DisplayName("Producto Conjured: con calidad y caducado")
    void conjuredConCalidadCaducado() {
    	String producto = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(producto, -1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(-2, app.items[0].sellIn),
        		() -> assertEquals(2, app.items[0].quality)
        		);
    }

    @Test
    @DisplayName("Producto Conjured: sin calidad y sin caducar")
    void conjuredSinCalidadSinCaducar() {
    	String producto = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(producto, 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(1, app.items[0].sellIn),
        		() -> assertEquals(0, app.items[0].quality)
        		);
    }
    
    @Test
    @DisplayName("Producto Conjured: sin calidad y caducado")
    void conjuredSinCalidadCaducado() {
    	String producto = "Conjured Mana Cake";
        Item[] items = new Item[] { new Item(producto, -3, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(-4, app.items[0].sellIn),
        		() -> assertEquals(0, app.items[0].quality)
        		);
    }
}
