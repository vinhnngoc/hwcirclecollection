/*
 * Bài 5: Collection(List, Tree, Map, Set….), Mảng và lệnh lặp".
 * Tạo một Collection(tự lựa chọn List/Set/Map sao cho phù hợp bài toán)
 *  trong đó có 100 đối tượng tạo ra từ lớp "Circle". 
 *  "Circle" có một thuộc tính duy nhất là "radius"(số nguyên dương). 
 *  Giá trị của "radius" là ngẫu nhiên trong khoảng 1-100.
 *  
 * Sắp xếp Collection này theo chiều "radius" tăng dần
 * 
 * Viết chương trình cho phép nhập từ màn hình console một con số(số tự nhiên). 
 * Tìm và in ra vị trí(index) và diện tích của "Circle" có diện tích gần với con số nhập vào nhất.
 */

package com.vinh.radiuscollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
	public static final int NUMBER_OF_CIRCLE = 100;
	public static final int MAX_RADIUS = 200;

	public static void main(String[] args) {

		// Generate circle and give them random value of radius
		List<Circle> circleList = new ArrayList<Circle>();
		for (int i = 0; i < NUMBER_OF_CIRCLE; i++) {
			Circle circle = new Circle(MAX_RADIUS, i);
			circleList.add(circle);
		}

		// sorting list and print all array list
		sortingArrayList(circleList);
		printArrayList(circleList);

		// input a value of area and print the nearest area and index
		int inputNumber = inputNumberConsole();
		
		System.out.println("The element has the nearest area vlue is: ");
		areaToIndex(circleList, inputNumber);

	}// end main

	/*
	 * public static void printArrayList(List<Type> Name_of_List)
	 * 
	 * go from the first element of array to the last element and then print value
	 * of index, radius and area of each
	 */
	public static void printArrayList(List<Circle> list) {
		for (int i = 0; i < NUMBER_OF_CIRCLE; i++) {
			System.out.println(
					list.get(i).getIndex() + " Radius " + list.get(i).getRadius() + " Area " + list.get(i).getArea());
		}
	}

	/*
	 * public static void sortingArrayList(List<Type> Name_of_List)
	 * 
	 * using bubble sort to arrange the Array List with the increasing value of Area
	 * order
	 * 
	 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
	 * swapping the adjacent elements if they are in wrong order, in this case is
	 * the increasing value of area
	 */
	public static void sortingArrayList(List<Circle> list) {
		for (int i = 0; i < NUMBER_OF_CIRCLE - 1; i++) {
			for (int j = 0; j < NUMBER_OF_CIRCLE - 1; j++) {
				if (list.get(j).getRadius() > list.get(j + 1).getRadius()) {
					Circle tempCircle1 = list.get(j);
					Circle tempCircle2 = list.get(j + 1);
					list.remove(j);
					list.remove(j);
					list.add(j, tempCircle1);
					list.add(j, tempCircle2);
				}
			}
		}
	}

	/*
	 * public static int inputNumberConsole();
	 * 
	 * return an integer value which is input from the console and return this value
	 * if the input is not an integer, the return value is -1
	 */
	public static int inputNumberConsole() {
		try {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.printf("Enter Area Value:  ");
			int i = in.nextInt();
			return i;
		} catch (Exception e) {
			System.out.println("Input is not an integer ");
			return -1;
		}
	}

	/*
	 * public static void areaToIndex(List<Type> Name_of_List, int areaValue)
	 * 
	 * this function will find the nearest value of area to the given area. NOTICE:
	 * ONLY APPLY FOR THE SORTED AREA (INCREASING ORDER)
	 * 
	 * If the areaValue is -1, this function will print an error message
	 * 
	 * The basis of this function is to find the first element which has the area
	 * value larger the the given Area.
	 * 
	 * If this element is the first (index 0), print the first element list.get(0);
	 * 
	 * If the given Area value is larger than all the elements Area, return the last
	 * element area
	 * 
	 * If the first element has larger value than the given area is in the middle of
	 * the array list (index from 1 to 99), assume this element has index n, then
	 * compare the area value of element n and n-1 to find the nearest area value to
	 * the given Area value
	 */
	public static void areaToIndex(List<Circle> list, int areaValue) {
		if (areaValue == -1) {
			System.out.println("Input Error - Not Found");
		} else {
			for (int i = 0; i < NUMBER_OF_CIRCLE; i++) {
				if (areaValue <= list.get(i).getArea()) {
					if (i == 0)
						System.out.println("Index: " + list.get(i).getIndex() + " Area: " + list.get(i).getArea());
					else if (i > 0) {
						if ((areaValue - list.get(i - 1).getArea()) < (list.get(i).getArea() - areaValue))
							System.out.println(
									"Index: " + list.get(i - 1).getIndex() + " Area: " + list.get(i - 1).getArea());
						else
							System.out.println("Index: " + list.get(i).getIndex() + " Area: " + list.get(i).getArea());
					}
					break;
				} else {
					if (i == NUMBER_OF_CIRCLE - 1)
						System.out.println("Index: " + list.get(NUMBER_OF_CIRCLE - 1).getIndex() + " Area: "
								+ list.get(NUMBER_OF_CIRCLE - 1).getArea());
				}
			}
		}

	}

}// end class
