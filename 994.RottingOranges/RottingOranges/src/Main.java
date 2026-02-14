import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static int orangesRotting(int[][] grid) {
        Deque<Node> queue = new LinkedList<Node>();
        // initialize the queue with all the rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.addLast(new Node(i, j));
                }
            }
        }
        int countMinute = 0;
        while (!queue.isEmpty()) {
            // for every item in the rotten queue, we kick it off first and pick all of its unrotten adjacent to the rotten queue
            Deque<Node> currentRound = new LinkedList<Node>(queue);
            queue.clear();
            int nonNullRound = 0;
            while (!currentRound.isEmpty()) {
                Node firstItem = currentRound.getFirst();
                if (firstItem.y - 1 >= 0 && grid[firstItem.x][firstItem.y - 1] == 1) {
                    grid[firstItem.x][firstItem.y - 1] = 2;
                    queue.addLast(new Node(firstItem.x, firstItem.y - 1));
                    nonNullRound = 1;
                }

                if (firstItem.x - 1 >= 0 && grid[firstItem.x - 1][firstItem.y] == 1) {
                    grid[firstItem.x - 1][firstItem.y] = 2;
                    queue.addLast(new Node(firstItem.x - 1, firstItem.y));
                    nonNullRound = 1;
                }

                if (firstItem.x + 1 < grid.length && grid[firstItem.x + 1][firstItem.y] == 1) {
                    grid[firstItem.x + 1][firstItem.y] = 2;
                    queue.addLast(new Node(firstItem.x + 1, firstItem.y));
                    nonNullRound = 1;
                }

                if (firstItem.y + 1 < grid[0].length && grid[firstItem.x][firstItem.y + 1] == 1) {
                    grid[firstItem.x][firstItem.y + 1] = 2;
                    queue.addLast(new Node(firstItem.x, firstItem.y + 1));
                    nonNullRound = 1;
                }
                currentRound.removeFirst();
            }
            if (nonNullRound == 1) {
                countMinute++;
            }
        }

        // check if there is still unrotten orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return countMinute;
    }

    public static void main(String[] args) {

        int[][] grid = new int[10][10];
//        grid[0] = new int[]{2, 1, 1};
//        grid[1] = new int[]{1, 1, 0};
//        grid[2] = new int[]{0, 1, 1};
        grid[0] = new int[]{2, 0, 1};


        System.out.println("result:" + orangesRotting(grid));
    }
}