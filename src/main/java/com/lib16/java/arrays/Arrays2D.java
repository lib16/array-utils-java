package com.lib16.java.arrays;

import java.util.Random;

public final class Arrays2D
{
	private Arrays2D() {}

	public static <T> void swap(T[][] array, int x1, int y1, int x2, int y2)
	{
		T object = array[y1][x1];
		array[y1][x1] = array[y2][x2];
		array[y2][x2] = object;
	}

	public static <T> void reverseX(T[][] array)
	{
		reverseX(array, 0, 0, array[0].length, array.length);
	}

	public static <T> void reverseX(T[][] array, int startX, int startY, int stopX, int stopY)
	{
		int last = stopX - 1;
		int stop = (stopX - startX) / 2 + startX;
		for (int y = startY; y < stopY; y++) {
			for (int x1 = startX, x2 = last; x1 < stop; x1++, x2--) {
				swap(array, x1, y, x2, y);
			}
		}
	}

	public static <T> void reverseY(T[][] array)
	{
		reverseY(array, 0, 0, array[0].length, array.length);
	}

	public static <T> void reverseY(T[][] array, int startX, int startY, int stopX, int stopY)
	{
		int last = stopY - 1;
		int stop = (stopY - startY) / 2 + startY;
		for (int x = startX; x < stopX; x++) {
			for (int y1 = startY, y2 = last; y1 < stop; y1++, y2--) {
				swap(array, x, y1, x, y2);
			}
		}
	}

	/**
	 * Array items rotate left if distance is greater than 0.
	 */
	public static <T> void rotateX(T[][] array, int distance)
	{
		rotateX(array, distance, 0, 0, array[0].length, array.length);
	}

	/**
	 * Array items rotate left if distance is greater than 0.
	 */
	public static <T> void rotateX(T[][] array, int distance,
			int startX, int startY, int stopX, int stopY)
	{
		boolean rotateLeft = distance > 0;
		distance = Math.abs(distance) % (stopX - startX);
		int x = rotateLeft ? startX + distance : stopX - distance;
		reverseX(array, startX, startY, x, stopY);
		reverseX(array, x, startY, stopX, stopY);
		reverseX(array, startX, startY, stopX, stopY);
	}

	/**
	 * Array items rotate up if distance is greater than 0.
	 */
	public static <T> void rotateY(T[][] array, int distance)
	{
		rotateY(array, distance, 0, 0, array[0].length, array.length);
	}

	/**
	 * Array items rotate up if distance is greater than 0.
	 */
	public static <T> void rotateY(T[][] array, int distance,
			int startX, int startY, int stopX, int stopY)
	{
		boolean rotateUp = distance > 0;
		distance = Math.abs(distance) % (stopY - startY);
		int y = rotateUp ? startY + distance : stopY - distance;
		reverseY(array, startX, startY, stopY, y);
		reverseY(array, startX, y, stopX, stopY);
		reverseY(array, startX, startY, stopX, stopY);
	}

	public static <T> void shuffle(T[][] array, Random random)
	{
		shuffle(array, random, 0, array[0].length, 0, array.length);
	}

	public static <T> void shuffle(T[][] array, Random random,
			int startX, int startY, int stopX, int stopY)
	{
		int countX = stopX - startX;
		int countY = stopY - startY;
		for (int y = startY; y < stopY; y++) {
			for (int x = startX; x < stopX; x++) {
				swap(array, x, y,
						random.nextInt(countX) + startX,
						random.nextInt(countY) + startY);
			}
		}
	}

	public static <T> void copy(T[][] src, T[][] dst)
	{
		copy(src, dst, 0, 0, src[0].length, src.length);
	}

	public static <T> void copy(T[][] src, T[][] dst, int startX, int startY, int stopX, int stopY)
	{
		int count = stopX - startX;
		for (int y = startY; y < stopY; y++) {
			System.arraycopy(src[y], startX, dst[y], startX, count);
		}
	}
}
