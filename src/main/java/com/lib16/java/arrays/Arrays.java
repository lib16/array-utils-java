package com.lib16.java.arrays;

import java.util.Random;

public final class Arrays
{
	private Arrays() {}

	public static <T> void swap(T[] array, int index1, int index2)
	{
		T object = array[index1];
		array[index1] = array[index2];
		array[index2] = object;
	}

	public static <T> void reverse(T[] array)
	{
		reverse(array, 0, array.length);
	}

	public static <T> void reverse(T[] array, int start, int stop)
	{
		int last = stop - 1;
		stop = (stop - start) / 2 + start;
		for (int i = start, k = last; i < stop; i++, k--) {
			swap(array, i, k);
		}
	}

	/**
	 * Array items rotate left if distance is greater than 0.
	 */
	public static <T> void rotate(T[] array, int distance)
	{
		rotate(array, distance, 0, array.length);
	}

	/**
	 * Array items rotate left if distance is greater than 0.
	 */
	public static <T> void rotate(T[] array, int distance, int start, int stop)
	{
		boolean rotateLeft = distance > 0;
		distance = Math.abs(distance) % (stop - start);
		int index = rotateLeft ? start + distance : stop - distance;
		reverse(array, start, index);
		reverse(array, index, stop);
		reverse(array, start, stop);
	}

	public static <T> void shuffle(T[] array, Random random)
	{
		shuffle(array, random, 0, array.length);
	}

	public static <T> void shuffle(T[] array, Random random, int start, int stop)
	{
		int count = stop - start;
		for (int i = start; i < stop; i++) {
			swap(array, i, random.nextInt(count) + start);
		}
	}
}
