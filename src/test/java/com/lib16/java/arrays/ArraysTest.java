package com.lib16.java.arrays;

import java.util.List;
import java.util.Random;

import org.paukov.combinatorics3.Generator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArraysTest
{
	@DataProvider(name = "reverseProvider")
	public static Object[][] reverseProvider()
	{
		return new Object[][] {
			{
				new Integer[] {1, 2, 3, 4, 5},
				1, 5,
				new Integer[] {1, 5, 4, 3, 2}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				1, 4,
				new Integer[] {1, 4, 3, 2, 5}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				1, 3,
				new Integer[] {1, 3, 2, 4, 5}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				1, 2,
				new Integer[] {1, 2, 3, 4, 5}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				0, 3,
				new Integer[] {3, 2, 1, 4, 5}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				0, 0,
				new Integer[] {5, 4, 3, 2, 1}
			},
			{
				new Integer[] {1, 2, 3, 4},
				1, 4,
				new Integer[] {1, 4, 3, 2}
			},
			{
				new Integer[] {1, 2, 3, 4},
				1, 3,
				new Integer[] {1, 3, 2, 4}
			},
		};
	}

	@Test(dataProvider = "reverseProvider")
	public void testReverse(Integer[] array, int start, int stop, Integer[] expectedArray)
	{
		if (stop == 0) {
			Arrays.reverse(array);
		}
		else {
			Arrays.reverse(array, start, stop);
		}
		Assert.assertEquals(array, expectedArray);
	}

	@DataProvider(name = "rotateProvider")
	public static Object[][] rotateProvider()
	{
		return new Object[][] {
			{
				new Integer[] {1, 2, 3, 4, 5},
				2, 1, 5,
				new Integer[] {1, 4, 5, 2, 3}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				5, 1, 4,
				new Integer[] {1, 4, 2, 3, 5}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				-1, 1, 5,
				new Integer[] {1, 5, 2, 3, 4}
			},
			{
				new Integer[] {1, 2, 3, 4, 5},
				-4, 1, 4,
				new Integer[] {1, 4, 2, 3, 5}
			},
			{
				new Integer[] {1, 2, 3, 4, 5, 6, 7},
				4, 0, 0,
				new Integer[] {5, 6, 7, 1, 2, 3, 4}
			},
			{
				new Integer[] {1, 2, 3, 4, 5, 6, 7},
				-3, 0, 0,
				new Integer[] {5, 6, 7, 1, 2, 3, 4}
			},
			{
				new Integer[] {1, 2, 3, 4, 5, 6, 7},
				-10, 0, 0,
				new Integer[] {5, 6, 7, 1, 2, 3, 4}
			},
		};
	}

	@Test(dataProvider = "rotateProvider")
	public void testRotate(Integer[] array, int distance,
			int start, int stop, Integer[] expectedArray)
	{
		if (stop == 0) {
			Arrays.rotate(array, distance);
		}
		else {
			Arrays.rotate(array, distance, start, stop);
		}
		Assert.assertEquals(array, expectedArray);
	}

	@DataProvider(name = "shuffleProvider")
	public static Object[][] shuffleProvider()
	{
		return new Object[][] {
			{1, 3},
			{0, 4},
			{0, 0}
		};
	}

	@Test(dataProvider = "shuffleProvider")
	public void testShuffle(int start, int stop)
	{
		Random random = new Random();
		Integer[] array = new Integer[] {0, 1, 2, 3, 4, 5};
		Object[] permutations = Generator.permutation(array).simple().stream().toArray();
		if (stop == 0) {
			Arrays.shuffle(array, random);
		}
		else {
			Arrays.shuffle(array, random, start, stop);
		}
		Assert.assertTrue(isPermutation(array, permutations));
		Assert.assertTrue(correctAreaShuffled(array, start, stop));
	}

	static boolean isPermutation(Integer[] array, Object[] permutations)
	{
		List<Integer> list = java.util.Arrays.asList(array);
		for (Object permutation: permutations) {
			if (list.equals(permutation)) {
				return true;
			}
		}
		return false;
	}

	static boolean correctAreaShuffled(Integer[] array, int start, int stop)
	{
		if (stop == 0) return true;
		if (start > 0) {
			for (int i = 0; i < start; i++) {
				if (i != array[i].intValue()) {
					return false;
				}
			}
		}
		if (stop < array.length) {
			for (int i = stop; i < array.length; i++) {
				if (i != array[i].intValue()) {
					return false;
				}
			}
		}
		return true;
	}
}
