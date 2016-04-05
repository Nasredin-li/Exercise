package massive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Launcher4 {

	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		java.io.PrintWriter outputStream = null;
		try {
			int a = 10;
			int b = 15;
			int[] gift = new int[a / 2];
			for (int f = 0; f < gift.length; f++) {
				gift[f] = ((int) (Math.random() * a * b));
			}
			Mass3 mass = new Mass3(a, b);
			int[][] maze = mass.getRealMazeSorted();

			outputStream = outputJS(a, b, gift, maze);

			//outputStream = outputHTM(a, b, gift, maze);

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

	private static java.io.PrintWriter outputHTM(int a, int b, int[] gift, int[][] maze) throws IOException {
		java.io.PrintWriter outputStream;
		outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\Maze3.htm"));

		outputStream.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		outputStream.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		outputStream.println("<head>");
		outputStream.println("<meta  http-equiv=\"Content-Type\" content=\"text/html; charset=\"UTF-8\">");
		outputStream.println("<title>Maze3</title>");
		outputStream.println("<link href=\"Training1.css\" rel=\"stylesheet\" type=\"text/css\" />");
		outputStream.println("</head>");
		outputStream.println("<body background=\"../Dis/11.jpg\" id=\"fon\" >");
		outputStream.println("<h2 id=\"h1\">Labirint</h2>");
		outputStream.println("<table id=\"tbl\" style=\"border: 2px solid rgb(30, 70, 240);\">");
		for (int i = 0; i < a * b;) {
			for (int y = 0; y < a; y++) {
				outputStream.println("<tr>");
				for (int x = 0; x < b; x++) {
					outputStream.print("<td id=\"" + i + "\""
							+ " style=\"border: 2px solid rgb(30, 70, 240); width: 35px;height: 35px;");

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
					outputStream.print("\">");
					String giftG=pasteGift(a, gift, outputStream, i);
					if(giftG==null){
						outputStream.print("&nbsp;");
					}else {
						outputStream.print(giftG);
					}
					outputStream.println("</td>");

					i++;
				}
				outputStream.println("</tr>");
			}
			outputStream.println("</table>");
		}
		outputStream.println(
				"<table width=\"500\" border=\"3\" align=\"center\" bordercolor=\"#FFFFFF\" id=\"more\"><tr><td width=\"200\" align=\"center\">"
						+ "<div><button type=\"button\" onclick=\"left()\"><IMG src=\"./StrelkaL.gif\" ></button>"
						+ "<button type=\"button\" onclick=\"top()\"><IMG src=\"./Strelka.gif\"></button>"
						+ "<button type=\"button\" onclick=\"right()\"><IMG src=\"./StrelkaR.gif\" ></button>"
						+ "<button type=\"button\" onclick=\"bottom()\"><IMG src=\"./StrelkaB.gif\" ></button></div></td>");
		for (int f = 0; f < gift.length; f++) {
			outputStream.print(
					"<td width=\"45\" align=\"center\" valign=\"middle\"><div id=\"oneGift" + f + "\"></div></td>");
		}
		
		outputStream.println("</tr></table>");
		outputStream.println("<p id=\"count\">—четчик шагов</p><p id=\"step\">0</p>");
		outputStream.println("<script type=\"text/javascript\" src=\"./Ded-Moroz2.js\"></script>");
		outputStream.println("<script type=\"text/javascript\" src=\"./Ded-Moroz3.js\"></script>");

		outputStream.println("</body></html>");
		return outputStream;
	}

	private static String pasteGift(int a, int[] gift, java.io.PrintWriter outputStream, int i) {
		for (int u = 0; u < a / 2; u++) {
			if (i == gift[u]) {
				return "<IMG src=\"./new-year-composition9.gif\">";
				
			}
		}
		return null;
	}

	private static java.io.PrintWriter outputJS(int a, int b, int[] gift, int[][] maze) throws IOException {
		java.io.PrintWriter outputStream;
		outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\Ded-Moroz2.js"));
		outputStream.println("var data=[");
		for (int i = 0; i < a * b; i++) {

			outputStream.println("[" + maze[i][2] + ", " + maze[i][3] + ", " + maze[i][4] + ", " + maze[i][5] + "], ");
		}
		outputStream.println("];");
		outputStream.println("var y=" + a);
		outputStream.println("var x=" + b);
		outputStream.print("var gift=[");
		for (int f = 0; f < gift.length; f++) {
			outputStream.print(gift[f]);
			if (f < gift.length - 1) {
				outputStream.print(",");
			}
		}
		outputStream.println("];");

		if (outputStream != null) {
			outputStream.close();
		}
		return outputStream;
	}

}
