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
	@ParameterizedTest(name = "Producto normal {index}: ({0},{1}) => ({2},{3}")
	@CsvSource({"2,3,1,2", "-1,10,-2,8", "2,0,1,0", "-1,1,-2,0" })
    void normal(int sellIn, int quality, int sellInOut, int qualityOut) {
    	String producto = "Un producto";
        Item[] items = new Item[] { new Item(producto, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, items.length);
        assertAll("Producto Actual", 
        		() -> assertEquals(producto, app.items[0].name),
        		() -> assertEquals(sellInOut, app.items[0].sellIn),
        		() -> assertEquals(qualityOut, app.items[0].quality)
        		);
    }

}
