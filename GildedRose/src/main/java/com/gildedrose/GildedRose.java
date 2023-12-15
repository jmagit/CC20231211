package com.gildedrose;

class GildedRose {
	public static final int CALIDAD_MAXIMA = 50;
	public static final int DEGRADACION_ESTANDAR = 1;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

	/**
	 * Actualiza la calidad de la lista de productos previamente introducida.
	 */
	public void updateQuality() {
		for (int productIndex = 0; productIndex < items.length; productIndex++) {
			if (esSulfuras(productIndex))
				continue; // con sulfuras no se hace nada
			quitaUnDia(productIndex);
			if (esQueso(productIndex)) {
				updateQuesoQuality(productIndex);
			} else if (esEntrada(productIndex)) {
				updateEntradaQuality(productIndex);
			} else if (esConjurado(productIndex)) {
				updateConjuradoQuality(productIndex);
			} else {
				updateProductosQuality(productIndex);
			}
		}
	}

	private void updateQuesoQuality(int productIndex) {
		incrementaCalidad(productIndex, haCaducado(productIndex) ? 2 : 1);
	}

	private void updateEntradaQuality(int productIndex) {
		if (haCaducado(productIndex)) {
			ponACeroCalidad(productIndex);
		} else if (quedan5DiasOMenos(productIndex)) {
			incrementaCalidad(productIndex, 3);
		} else if (quedan10diasOMenos(productIndex)) {
			incrementaCalidad(productIndex, 2);
		} else {
			incrementaCalidad(productIndex, 1);
		}
	}

	private void updateConjuradoQuality(int productIndex) {
		if (haCaducado(productIndex)) {
			// caducado degrada al doble de velocidad
			quitaCalidad(productIndex, 4 * DEGRADACION_ESTANDAR);
		} else {
			quitaCalidad(productIndex, 2 * DEGRADACION_ESTANDAR);
		}
	}

	private void updateProductosQuality(int productIndex) {
		if (haCaducado(productIndex)) {
			quitaCalidad(productIndex, 2 * DEGRADACION_ESTANDAR);
		} else {
			quitaCalidad(productIndex, DEGRADACION_ESTANDAR);
		}
	}

	private boolean esSulfuras(int productIndex) {
		return items[productIndex].name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean esEntrada(int productIndex) {
		return items[productIndex].name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean esQueso(int productIndex) {
		return items[productIndex].name.equals("Aged Brie");
	}

	private boolean esConjurado(int productIndex) {
		return items[productIndex].name.equals("Conjured Mana Cake");
	}

	private boolean quedan5DiasOMenos(int productIndex) {
		return items[productIndex].sellIn < 5;
	}

	private boolean quedan10diasOMenos(int productIndex) {
		return items[productIndex].sellIn < 10;
	}

	private boolean haCaducado(int productIndex) {
		// los dias negativos son cuando esta caducado
		return items[productIndex].sellIn < 0;
	}

	private void quitaUnDia(int productIndex) {
		items[productIndex].sellIn = items[productIndex].sellIn - 1;
	}

	private void ponACeroCalidad(int productIndex) {
		quitaCalidad(productIndex, items[productIndex].quality);
	}

	private void quitaCalidad(int productIndex, int cantidad) {
//		int rslt = items[productIndex].quality - cantidad;
//		items[productIndex].quality = rslt < 0 ? 0 : rslt;
//
//		items[productIndex].quality = items[productIndex].quality - cantidad < 0 ?
//				0 : items[productIndex].quality - cantidad;

		if (items[productIndex].quality - cantidad < 0) {
			items[productIndex].quality = 0;
		} else {
			items[productIndex].quality = items[productIndex].quality - cantidad;
		}

//		items[productIndex].quality = items[productIndex].quality - 1;
//		if (items[productIndex].quality < 0) {
//			items[productIndex].quality = 0;
//		}
	}

	private void incrementaCalidad(int productIndex, int cantidad) {
		items[productIndex].quality = Math.min(items[productIndex].quality + cantidad, CALIDAD_MAXIMA);
	}

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                    	if(items[i].name.toLowerCase().contains("conjured") && items[i].quality > 1)
//                    		items[i].quality = items[i].quality - 1;
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                            	if(items[i].name.toLowerCase().contains("conjured"))
//                            		items[i].quality = items[i].quality - 1;
//                                items[i].quality = Math.max(0, items[i].quality - 1);
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }
}
