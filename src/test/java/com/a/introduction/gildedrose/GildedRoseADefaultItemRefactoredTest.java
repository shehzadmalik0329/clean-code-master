package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemRefactoredTest {

	private static final int SELLIN_BETWEEN_0_AND_5 = 4;
	private static final int SELLIN_BETWEEN_5_AND_10 = 7;
	private static final int SELLIN_GREATER_THAN_10 = 15;
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final int EXPIRED_SELLIN = -1;
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	private static final int DEFAULT_QUALITY = 3;
	private static final int NOT_EXPIRED_SELLIN = 15;
	private static final int MAX_QUALITY = 50;

	@Test
	public void upexpiredDefaultItem_qualityDecreasesBy1() {
		
		GildedRose app = createGildedRoseWithDefaultItem(DEFAULT_ITEM,
						 NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(DEFAULT_ITEM,
						NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 1);
		
		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		
		GildedRose app = createGildedRoseWithDefaultItem(DEFAULT_ITEM,
				EXPIRED_SELLIN, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(DEFAULT_ITEM, 
				EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);
	}
	
	@Test
	public void unexpiredAgedBrieItem_qualityIncreasesBy1() {
		
		GildedRose app = createGildedRoseWithDefaultItem(AGED_BRIE,
				NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 1);
		
		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredAgedBrieItem_qualityIncreasesBy2() {
		
		GildedRose app = createGildedRoseWithDefaultItem(AGED_BRIE,
				EXPIRED_SELLIN, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(AGED_BRIE, EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 2);
		
		assertItem(expected, app.items[0]);
	}

	@Test
	public void unexpiredAgedBrieItem_qualityDoesNotGoBeyondMaximum() {
		
		GildedRose app = createGildedRoseWithDefaultItem(AGED_BRIE,
				NOT_EXPIRED_SELLIN, MAX_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELLIN - 1, MAX_QUALITY);
		
		assertItem(expected, app.items[0]);

	}
	
	@Test
	public void backstageItemSellingGreaterThan10_qualityDecreasesBy1() {
		
		GildedRose app = createGildedRoseWithDefaultItem(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT,
				SELLIN_GREATER_THAN_10, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT,
				SELLIN_GREATER_THAN_10 - 1, DEFAULT_QUALITY + 1);
		
		assertItem(expected, app.items[0]);
	}

	@Test
	public void backstageItemSellingBetween5And10_qualityDecreasesBy2() {
		
		GildedRose app = createGildedRoseWithDefaultItem(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT,
				SELLIN_BETWEEN_5_AND_10, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT,
				SELLIN_BETWEEN_5_AND_10 - 1, DEFAULT_QUALITY + 2);
		
		assertItem(expected, app.items[0]);
	}

	@Test
	public void backstageItemSellingBetween0And5_qualityDecreasesBy3() {
		
		GildedRose app = createGildedRoseWithDefaultItem(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT,
				SELLIN_BETWEEN_0_AND_5, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT,
				SELLIN_BETWEEN_0_AND_5 - 1, DEFAULT_QUALITY + 3);
		
		assertItem(expected, app.items[0]);
	}
	
	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithDefaultItem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[] { item };
		return new GildedRose(items);
	}
}