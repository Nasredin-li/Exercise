package output;

import java.io.BufferedReader;
import java.io.IOException;



public class OutputHTML {

	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		java.io.PrintWriter outputStream = null;
		try {
			

			outputStream = new java.io.PrintWriter(new java.io.FileWriter("d:\\Serge\\java\\HTM.htm"));
			outputStream.println("<p>Hello</p>");
		

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
