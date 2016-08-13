package com.lib16.java.arrays;

import java.util.Random;

import org.paukov.combinatorics3.Generator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Arrays2DTest
{
	private static final Integer[][] ARRAY = new Integer[][] {
		{1, 2, 3, 4, 5},
		{6, 7, 8, 9, 10},
		{11, 12, 13, 14, 15},
		{16, 17, 18, 19, 20},
		{21, 22, 23, 24, 25}
	};

	@DataProvider(name = "reverseXProvider")
	public static Object[][] reverseXProvider()
	{
		return new Object[][] {
			{
				1, 1, 4, 4,
				new Integer[][] {
					{1, 2, 3, 4, 5},
					{6, 9, 8, 7, 10},
					{11, 14, 13, 12, 15},
					{16, 19, 18, 17, 20},
					{21, 22, 23, 24, 25}
				}
			},
			{
				0, 0, 0, 0,
				new Integer[][] {
					{5, 4, 3, 2, 1},
					{10, 9, 8, 7, 6},
					{15, 14, 13, 12, 11},
					{20, 19, 18, 17, 16},
					{25, 24, 23, 22, 21}
				}
			},
		};
	}

	@Test(dataProvider = "reverseXProvider")
	public void testReverseX(int startX, int startY, int stopX, int stopY, Integer[][] expected)
	{
		Integer[][] actual = new Integer[5][5];
		Arrays2D.copy(ARRAY, actual);
		if (stopY == 0) {
			Arrays2D.reverseX(actual);
		}
		else {
			Arrays2D.reverseX(actual, startX, startY, stopX, stopY);
		}
		assertEqualItems(actual, expected);
	}

	@DataProvider(name = "reverseYProvider")
	public static Object[][] reverseYProvider()
	{
		return new Object[][] {
			{
				1, 1, 4, 4,
				new Integer[][] {
					{1, 2, 3, 4, 5},
					{6, 17, 18, 19, 10},
					{11, 12, 13, 14, 15},
					{16, 7, 8, 9, 20},
					{21, 22, 23, 24, 25}
				}
			},
			{
				0, 0, 0, 0,
				new Integer[][] {
					{21, 22, 23, 24, 25},
					{16, 17, 18, 19, 20},
					{11, 12, 13, 14, 15},
					{6, 7, 8, 9, 10},
					{1, 2, 3, 4, 5}
				}
			},
		};
	}

	@Test(dataProvider = "reverseYProvider")
	public void testReverseY(int startX, int startY, int stopX, int stopY, Integer[][] expected)
	{
		Integer[][] actual = new Integer[5][5];
		Arrays2D.copy(ARRAY, actual);
		if (stopY == 0) {
			Arrays2D.reverseY(actual);
		}
		else {
			Arrays2D.reverseY(actual, startX, startY, stopX, stopY);
		}
		assertEqualItems(actual, expected);
	}

	@DataProvider(name = "rotateXProvider")
	public static Object[][] rotateXProvider()
	{
		return new Object[][] {
			{
				1, 1, 1, 4, 4,
				new Integer[][] {
					{1, 2, 3, 4, 5},
					{6, 8, 9, 7, 10},
					{11, 13, 14, 12, 15},
					{16, 18, 19, 17, 20},
					{21, 22, 23, 24, 25}
				}
			},
			{
				-2, 0, 0, 0, 0,
				new Integer[][] {
					{4, 5, 1, 2, 3},
					{9, 10, 6, 7, 8},
					{14, 15, 11, 12, 13},
					{19, 20, 16, 17, 18},
					{24, 25, 21, 22, 23}
				}
			},
		};
	}

	@Test(dataProvider = "rotateXProvider")
	public void testRotateX(int distance, int startX, int startY, int stopX, int stopY,
			Integer[][] expected)
	{
		Integer[][] actual = new Integer[5][5];
		Arrays2D.copy(ARRAY, actual);
		if (stopY == 0) {
			Arrays2D.rotateX(actual, distance);
		}
		else {
			Arrays2D.rotateX(actual, distance, startX, startY, stopX, stopY);
		}
		assertEqualItems(actual, expected);
	}

	@DataProvider(name = "rotateYProvider")
	public static Object[][] rotateYProvider()
	{
		return new Object[][] {
			{
				1, 1, 1, 4, 4,
				new Integer[][] {
					{1, 2, 3, 4, 5},
					{6, 12, 13, 14, 10},
					{11, 17, 18, 19, 15},
					{16, 7, 8, 9, 20},
					{21, 22, 23, 24, 25}
				}
			},
			{
				-2, 0, 0, 0, 0,
				new Integer[][] {
					{16, 17, 18, 19, 20},
					{21, 22, 23, 24, 25},
					{1, 2, 3, 4, 5},
					{6, 7, 8, 9, 10},
					{11, 12, 13, 14, 15}
				}
			},
		};
	}

	@Test(dataProvider = "rotateYProvider")
	public void testRotateY(int distance, int startX, int startY, int stopX, int stopY,
			Integer[][] expected)
	{
		Integer[][] actual = new Integer[5][5];
		Arrays2D.copy(ARRAY, actual);
		if (stopY == 0) {
			Arrays2D.rotateY(actual, distance);
		}
		else {
			Arrays2D.rotateY(actual, distance, startX, startY, stopX, stopY);
		}
		assertEqualItems(actual, expected);
	}

	@DataProvider(name = "shuffleProvider")
	public static Object[][] shuffleProvider()
	{
		return new Object[][] {
			{null, 0, 2, 5, 3},
			{null, 1, 2, 4, 3},
			{new Integer[][] {{1, 2, 3, 4, 5}}, 0, 0, 0, 0},
		};
	}

	@Test(dataProvider = "shuffleProvider")
	public void testShuffle(Integer[][] array, int startX, int startY, int stopX, int stopY)
	{
		Random random = new Random();
		if (array == null) {
			array = new Integer[5][5];
			Arrays2D.copy(ARRAY, array);
		}
		Object[] permutations = Generator.permutation(array[startY]).simple().stream().toArray();
		if (stopY == 0) {
			Arrays2D.shuffle(array, random);
		}
		else {
			Arrays2D.shuffle(array, random, startX, startY, stopX, stopY);
		}
		Assert.assertTrue(ArraysTest.isPermutation(array[startY], permutations));
		Assert.assertTrue(ArraysTest.correctAreaShuffled(array[startY], 0, array[startY].length));

	}

	private void assertEqualItems(Integer[][] actual, Integer[][] expected)
	{
		for (int y = 0; y < actual.length; y++) {
			for (int x = 0; x < actual[y].length; x++) {
				Assert.assertEquals(actual[y][x], expected[y][x]);
			}
		}
	}
}
