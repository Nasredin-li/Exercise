package massive;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) {

		java.io.PrintWriter outputStream = null;
		try {
			outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\Maze.htm"));
			
			int a = 20;
			int b = 20;
			Mass mass = new Mass(a, b);
			int[][] maze = mass.getRealMazeSorted();
			outputStream.println("<!DOCTYPE HTML>");
			outputStream.println("<html><head>" 
					+"<meta charset=\"UTF-8\">"
					+"<title>Labirint</title>"
			+ "</head>" + "<body>" + "<table style=" + "\""
					+ "border: 2px solid rgb(221, 221, 221); display: table;\">");
			for (int i = 0; i < a * b; ) {
				for (int y = 0; y < a; y++) {
					outputStream.println("<tr>");
					for (int x = 0; x < b; x++) {
						outputStream.print(
								"<td style=\"border: 2px solid rgb(221, 221, 221); width: 30px;height: 30px;");
						
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

						outputStream.println("\">&nbsp;</td>");
						i++;
					}
					outputStream.println("</tr>");
				}
			}

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
