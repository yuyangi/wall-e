package show.me.the.code.mem;

public class Matrix {

    private String id;

    private String[][] matrix;

    public Matrix(String[][] matrix) {
        this.matrix = matrix;
    }

    // 给定一个字符数组，从坐标(0,0)开始每个单词都向后移动一位，直到到达数组的末尾
    public String[] move(String[] words) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < words.length; i++) {
            if (col >= matrix[0].length) {
                row++;
                col = 0;
            }
            words[i] = matrix[row][col];
            col++;
        }
        return words;
    }

    class Node<T> {

        T data;
        int weight;
        Node<T> pre;
        Node<T> next;

    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
