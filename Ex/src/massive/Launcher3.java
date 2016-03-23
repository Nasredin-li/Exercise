package massive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Launcher3 {

	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		java.io.PrintWriter outputStream = null;
		try {
			int a = 20;
			int b = 20;
			int[] gift = new int[a / 3];
			for (int f = 0; f < gift.length; f++) {
				gift[f] = ((int) (Math.random() * a * b));
			}
			Mass3 mass = new Mass3(a, b);
			int[][] maze = mass.getRealMazeSorted();
			inputStream = new BufferedReader(
					new FileReader("d:\\Serge\\java\\Ded-Moroz.js"));
			ArrayList<String> javascript = new ArrayList<String>();
			String c;
			while ((c = inputStream.readLine()) != null) {
				if(c.startsWith("var data")==false){
					javascript.add(c);	
				}
				
			
			}
			outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\Ded-Moroz.js"));
			outputStream.println("var data=[");
			for (int i = 0; i < a * b;i++) {
				
				outputStream.println( "[" + maze[i][2] + ", " + maze[i][3] + ", " + maze[i][4]
						+ ", " + maze[i][5] + "], ");
			}
			outputStream.println("];");
			for (String e : javascript) {
				outputStream.println(e);
			}
			
			if (outputStream != null) {
				outputStream.close();
			}
			

			outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\Maze3.htm"));

			outputStream.println("<!DOCTYPE HTML>");
			outputStream.println("<html><head>" + "<meta charset=\"UTF-8\">" + "<title>Maze3</title>" + "</head>"
					+ "<body>"
					+"<h2>Labirint</h2p><p id=\"x\">"+a+"</p><p> x </p><p id=\"y\">"+b+"</p>"
					+ "<button type=\"button\" onclick=\"left()\">Left</button>"
					+ "<button type=\"button\" onclick=\"right()\">Right</button>"
					+ "<button type=\"button\" onclick=\"top()\">Top</button>"
					+ "<button type=\"button\" onclick=\"bottom()\">Bottom</button>" + "<table style=" + "\""
					+ "border: 2px solid rgb(221, 221, 221); display: table;\">");
			for (int i = 0; i < a * b;) {
				for (int y = 0; y < a; y++) {
					outputStream.println("<tr>");
					for (int x = 0; x < b; x++) {
						outputStream.print("<td id=\"" + i + "\""
								+ " style=\"border: 2px solid rgb(221, 221, 221); width: 30px;height: 30px;");

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
								outputStream.println("<IMG src=\"./new-year-composition9.gif\">");
								break;
							}
						}
						outputStream.println("</td>");

						i++;
					}
					outputStream.println("</tr>");
				}
			}
			outputStream.println("<script type=\"text/javascript\" src=\"./Ded-Moroz.js\"></script>");
			outputStream.println("</body></html>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
