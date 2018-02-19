//Alberto Vilches Prada
import java.io.IOException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {
		String fileInput = "";
		String fileOutput = "";
		int[] years = new int[200];
		String[] outputYears;
		int count= 0;
		Scanner cap = new Scanner(System.in);
		System.out.println("**Calculadora de Año Bisiesto / No Bisiesto mediante archivo de entrada / salida**");
		System.out.println(" ");
		System.out.println("Ruta COMPLETA del archivo a leer INCLUIDA la extension: ");
		fileInput = cap.nextLine();
		System.out.println("Indica ruta COMPLETA del archivo para los resultados INCLUIDA la extension: ");
		fileOutput = cap.nextLine();
		cap.close();
		count = Methods.readFile(fileInput, years);
		Methods.sortYears(years, count);
		outputYears = new String[count];
		Methods.leapYears(years, outputYears);
		Methods.writeFile(fileOutput, outputYears);
	}
}
