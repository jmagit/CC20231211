package com.example.gildedrose;

public class Producto {
	private String name;
	private int sellIn;
	private int quality;
	
	public Producto(String name, int sellIn, int quality) {
		if(name == null)
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		this.name = name;
		this.sellIn = sellIn;
		setQuality(quality);
	}

	public String getName() {
		return name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		if(quality < 0)
			throw new IllegalArgumentException("La calidad no puede ser inferior a 0");
		this.quality = quality;
	}
	

}
