package massive;

import java.io.IOException;

public class Launcher3 {

	public static void main(String[] args) {

		java.io.PrintWriter outputStream = null;
		try {
			outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\Maze3.htm"));

			int a = 10;
			int b = 10;
			int[] gift = new int[a / 3];
			for (int f = 0; f < gift.length; f++) {
				gift[f] = ((int) (Math.random() * a * b));
			}

			Mass3 mass = new Mass3(a, b);
			int[][] maze = mass.getRealMazeSorted();
			outputStream.println("<!DOCTYPE HTML>");
			outputStream.println("<html><head>" + "<meta charset=\"UTF-8\">" + "<title>Maze3</title>" + "</head>"
					+ "<body>" + "<table style=" + "\"" + "border: 2px solid rgb(221, 221, 221); display: table;\">");
			for (int i = 0; i < a * b;) {
				for (int y = 0; y < a; y++) {
					outputStream.println("<tr>");
					for (int x = 0; x < b; x++) {
						outputStream
								.print("<td style=\"border: 2px solid rgb(221, 221, 221); width: 30px;height: 30px;");

						if (maze[i][2] != 0) {
							outputStream.print("border-top: none;");
						}
						if (maze[i][3] != 0) {
							outputStream.print("border-bottom: none;");
						}
						if (maze[i][4] != 0) {
							outputStream.print("border-left: none;");
						}
						if (maze[i][5] != 0) {
							outputStream.print("border-right: none;");
						}
						outputStream.println("\">");
						for (int u = 0; u < a / 3; u++) {
							if (i == gift[u]) {
								outputStream.println("<IMG src=\"./new-year-composition9.gif\"");
								break;
							}
						}
						outputStream.println("</td>");

						i++;
					}
					outputStream.println("</tr>");
				}
			}
			outputStream.println("</body></html>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
