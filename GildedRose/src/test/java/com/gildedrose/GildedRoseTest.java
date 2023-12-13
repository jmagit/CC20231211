package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class GildedRoseTest {
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
