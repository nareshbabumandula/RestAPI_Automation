package com.crud.examples;

public class SplitIntegerIntoBoxes {
    public static void main(String[] args) {
        int input = 27;
        int[] boxes = splitIntoBoxes(input, 4);
        printBoxes(boxes);
        
        input = 40;
        boxes = splitIntoBoxes(input, 4);
        printBoxes(boxes);
    }

    public static int[] splitIntoBoxes(int num, int numBoxes) {
        int[] boxes = new int[numBoxes];
        int quotient = num / numBoxes;
        int remainder = num % numBoxes;

        for (int i = 0; i < numBoxes; i++) {
            if (i < remainder) {
                boxes[i] = quotient + 1;
            } else {
                boxes[i] = quotient;
            }
        }

        return boxes;
    }

    public static void printBoxes(int[] boxes) {
        for (int box : boxes) {
            System.out.print(box + " ");
        }
        System.out.println();
    }
}

