package massive;

/**
 * Class Mass is an exercise of java coding in theme Massive. Class Mass has
 * massive "realMaze" in which is data for creating the Maze.
 * 
 * @author Serge P.
 *
 */
public class Mass {

	private int[][] realMaze;
	private int[][] realMazeSorted;

	/**
	 * Maze data stock. realMaze[][0] - "x" coordinate, realMaze[][1] - "y"
	 * coordinate, realMaze[][2] - "left" wall, 0 = standing wall, 1 = breaking
	 * wall. realMaze[][0] - "right" wall, 0 = standing wall, 1 = breaking wall.
	 * realMaze[][0] - "bottom" wall, 0 = standing wall, 1 = breaking wall.
	 * realMaze[][0] - "top" wall, 0 = standing wall, 1 = breaking wall.
	 * 
	 * @return Maze data stock.
	 */
	public int[][] getRealMaze() {
		return realMaze;
	}

	public int[][] getRealMazeSorted() {
		return realMazeSorted;
	}

	
	
	
	public Mass(int a,int b){
		init(a,b);
	}
	private void init(int a, int b) {
		int length = a * b;

		/**
		 * maze - helping massive, it stocks maze cell data running routine. It
		 * has cells that it is running repeatedly without new data. Massive
		 * length is biggest that realMaze(x*y) length.
		 */
		int[][] maze = new int[length * 15 - 1][6];
		fullMaze(maze);

		int[] newCell = firstCell(a, b);
		maze[0][0] = newCell[0];
		maze[0][1] = newCell[1];
		int direction = findDirection(newCell[0], newCell[1], a, b, maze);
		maze[0][direction + 1] = 1;
		int g = 1;
		int h = 2;
		while (g < maze.length) {

			System.out.println("direction=" + direction + ", h = " + h);
			if (direction == 0) {

				System.out.println("direction " + direction);

				newCell[0] = maze[g - h][0];
				newCell[1] = maze[g - h][1];
				if (h < g) {
					h = h + 2;
				}
			}
			newCell = nextCell(newCell[0], newCell[1], direction);
			System.out.println(newCell[0]);
			System.out.println(newCell[1]);
			
				maze[g][0] = newCell[0];
				maze[g][1] = newCell[1];
			
			
			int backWall = removeBackWall(direction);
			if (backWall != 1) {
				maze[g][backWall] = 1;
			}
			direction = findDirection(newCell[0], newCell[1], a, b, maze);
			if (direction != 0) {
				maze[g][direction + 1] = 1;
				h = 2;
			}
			System.out.println("g" + g);
			g++;
			
		}
		int w = 0;
		while (w < maze.length) {
			System.out.print(maze[w][0] + ", ");
			System.out.print(maze[w][1] + ", ");
			System.out.print(maze[w][2] + ", ");
			System.out.print(maze[w][3] + ", ");
			System.out.print(maze[w][4] + ", ");
			System.out.println(maze[w][5]);
			w++;
		}
		realMaze = realMaze(realMaze, maze, length);
		realMazeSorted = realMazeSorted(realMazeSorted, maze, length, a, b);
		int m = 0;
		while (m < realMaze.length) {
			System.out.print("RealMaze " + realMaze[m][0] + ", ");
			System.out.print(realMaze[m][1] + ", ");
			System.out.print(realMaze[m][2] + ", ");
			System.out.print(realMaze[m][3] + ", ");
			System.out.print(realMaze[m][4] + ", ");
			System.out.println(realMaze[m][5] + ", -" + (m + 1));
			m++;
		}
		int k = 0;
		while (k < realMazeSorted.length) {
			System.out.print("RealMazeSorted ");
			for (int go = 0; go < 6; go++) {
				System.out.print(realMazeSorted[k][go] + ", ");
			}
			System.out.println(", -- " + (k + 1));
			k++;
		}
		
	}

	public static void main(String[] args) {
		//Mass mass = new Mass(5, 5);

	}

	private static int[][] realMazeSorted(int[][] realMazeSorted, int[][] maze, int length, int a, int b) {
		realMazeSorted = new int[length][6];
		fullRealMazeSorted(realMazeSorted, a, b);
		for (int i = 0; i < length; i++) {
			for (int e = 0; e < maze.length; e++) {
				if (realMazeSorted[i][0] == maze[e][0] && realMazeSorted[i][1] == maze[e][1]) {
					for (int r = 2; r < 6; r++) {
						if (maze[e][r] == 1) {
							realMazeSorted[i][r] = maze[e][r];
						}
					}
				}

			}
		}
		return realMazeSorted;
	}

	private static void fullRealMazeSorted(int[][] realMazeSorted, int a, int b) {
		int i = 0;
		while (i < a * b) {
			for (int c = 0; c < a; c++) {
				for (int f = 0; f < b; f++) {
					realMazeSorted[i][0] = c;
					realMazeSorted[i][1] = f;
					i++;
				}
			}
			
		}

	}

	private static int[][] realMaze(int[][] realMaze, int[][] maze, int length) {
		realMaze = new int[length][6];
		int p = 0;
		int i = 0;
		while (p < length && i < maze.length) {
			int r = 5;
			int u = 0;// this cell has the data, some of walls != 0.
			while (r > 1) {
				if (maze[i][r] > 0) {
					u++;
				}
				r--;
			}
			if (u > 0) {
				int q = 0;
				boolean write = cheking(p, q, realMaze, maze, i);
				if (write == false) {
					while (q < 6) {
						realMaze[p][q] = maze[i][q];
						q++;

					}
					p++;
				}
			}
			i++;

		}
		return realMaze;
	}

	private static boolean cheking(int p, int q, int[][] realMaze, int[][] maze, int i) {
		for (int e = 0; e < p; e++) {
			if (realMaze[e][0] == maze[i][0] && realMaze[e][1] == maze[i][1]) {
				for (int t = 2; t < 6; t++) {
					if (maze[i][t] > 0) {
						realMaze[e][t] = maze[i][t];
					}
				}
				System.out.println("TRUE");
				return true;

			}
		}
		return false;

	}

	private static int removeBackWall(int direction) {
		int backWall = 0;
		if (direction == 1) {
			backWall = 2;
		}
		if (direction == 2) {
			backWall = 1;
		}
		if (direction == 3) {
			backWall = 4;
		}
		if (direction == 4) {
			backWall = 3;
		}
		return backWall + 1;
		// TODO Auto-generated method stub

	}

	/**
	 * Method places in first(x) & second(y) maze cells of second dimension -3.
	 * 
	 * @param maze
	 */
	private static void fullMaze(int[][] maze) {
		int i = 0;
		while (i < maze.length) {
			maze[i][0] = -3;
			maze[i][1] = -3;
			i++;
		}
	}

	/**
	 * to find free & permitted direction around this cell.
	 * 
	 * @param y
	 *            - coordinate "y".
	 * @param x
	 *            - coordinate "x".
	 * @param a
	 *            - realMaze dimension by "x".
	 * @param b
	 *            - realMaze dimension by "y".
	 * @param mazo
	 *            - helping massive of maze data cells.
	 * @return one decimal where 1=left, 2=right, 3=bottom, 4=top. 0= not exist
	 *         free & permitted cells around.
	 */
	private static int findDirection(int x, int y, int a, int b, int[][] maze) {
		boolean[] freeCell_ = findFreeCell(x, y, a, b, maze);
		int j = 0;
		int i = 0;
		while (i < 4) {
			if (freeCell_[i] == true) {
				j++;
			}
			i++;
		}

		if (j == 0) {
			System.out.println("XAHA!");
			return 0;
		}
		int direction = (int) (j * Math.random());
		int rightDirection = 0;
		int k = 0;
		while ((direction > -1) && k < 4) {
			if (freeCell_[k] == true) {
				direction--;

			}
			k++;
			rightDirection++;
		}
		System.out.println("rightDirection=" + rightDirection);
		return rightDirection;
		// TODO Auto-generated method stub

	}

	/**
	 * to ask is a free cell
	 * 
	 * @param y
	 *            - coordinate "y".
	 * @param x
	 *            - coordinate "x".
	 * @param maze
	 *            - helping massive of maze data cells.
	 * @return boolean "true" if cell is not visited, & "false" - if cell was
	 *         used.
	 */
	private static boolean isFree(int x, int y, int[][] maze) {
		int i = 0;
		while (i < maze.length) {
			if ((x == maze[i][0]) && (y == maze[i][1])) {
				return false;
			}
			i++;
		}
		return true;

	}

	/**
	 * to check is a cells around this in maze bound box(-1<x+-1<a & -1<y+-1<b),
	 * & check is a cell free.
	 * 
	 * @param y
	 *            - coordinate "y".
	 * @param x
	 *            - coordinate "x".
	 * @param a
	 *            - realMaze dimension by "x".
	 * @param b
	 *            - realMaze dimension by "y".
	 * @param maze
	 *            - helping massive of maze data cells.
	 * @return boolean massive, where [0]= left; [1] = right; [2]= bottom; [3]=
	 *         top.
	 */
	private static boolean[] findFreeCell(int x, int y, int a, int b, int[][] maze) {
		boolean[] chekBoundBox = new boolean[4];
		if (x > 0) {
			int x2 = x - 1;
			chekBoundBox[0] = isFree(x2, y, maze);

		}
		if (x + 1 < a) {
			int x3 = x + 1;
			chekBoundBox[1] = isFree(x3, y, maze);

		}
		if (y > 0) {
			int y2 = y - 1;
			chekBoundBox[2] = isFree(x, y2, maze);

		}
		if (y + 1 < b) {
			int y3 = y + 1;
			chekBoundBox[3] = isFree(x, y3, maze);
		}
		System.out.print(chekBoundBox[0] + ", ");
		System.out.print(chekBoundBox[1] + ", ");
		System.out.print(chekBoundBox[2] + ", ");
		System.out.println(chekBoundBox[3]);
		return chekBoundBox;
		// TODO Auto-generated method stub

	}

	/**
	 * to find random next cell from 0 to 4 free cells, return
	 * new cell.
	 * 
	 * @param b
	 * @param a
	 * @param direction
	 * @param newCell2
	 * @param newCell
	 */
	private static int[] nextCell(int x, int y, int direction) {

		if (direction == 1) {
			x = x - 1;

		}
		if (direction == 2) {
			x = x + 1;

		}
		if (direction == 3) {
			y = y - 1;

		}
		if (direction == 4) {
			y = y + 1;

		}
		int[] newCell = { x, y };

		return newCell;

	}

	/**
	 * to find random first cell.
	 * 
	 * @param b
	 *            - realMaze dimension by y.
	 * @param a
	 *            - realMaze dimension by x.
	 * @return decimal massive where first decimal is x of first cell, second
	 *         decimal - y.
	 */
	private static int[] firstCell(int a, int b) {
		int x = (int) (a * Math.random());
		int y = (int) (b * Math.random());
		int[] firstCell = { x, y };
		System.out.println(firstCell[0]);
		System.out.println(firstCell[1]);
		return firstCell;
		// TODO Auto-generated method stub

	}

}
