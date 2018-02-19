import java.io.*;
import java.util.regex.*;
public class Methods {
//Leer archivo
  public static int readFile(String fileInput, int[] years) throws FileNotFoundException, IOException {
	    String chain = "";
	    int count = 0;
	    int year = 0;
	    FileReader f = new FileReader(fileInput);
	    BufferedReader buffer = new BufferedReader(f);
	    Pattern p = Pattern.compile("[0-9]{4}");
	    
	    while ((chain = buffer.readLine()) != null) {
	      Matcher match = p.matcher(chain);
	      if (match.find()) {
	        year = Integer.parseInt(chain);
	        years[count] = year;
	        count++;
	      }
	    }
	    buffer.close();
	    return count;
	  }
  
//Ordenar los años
  public static void sortYears (int[] years, int count) {
    for(int i=0;i<(count-1);i++){
      for(int j=i+1;j<count;j++){
        if(years[i]>years[j]){
          int auxVar=years[i];
          years[i]=years[j];
          years[j]=auxVar;
         }
      }
    }
  }
  
 //Verificar si es bisiesto o no
  public static boolean isLeap (int year) {
	    boolean leap;
	    if (((year % 100 != 0) || (year % 400 == 0)) && (year % 4 == 0)) {
	    	leap = true;
	    	} else {
	    	leap = false;
	    	}
	    return leap;
	  }
  
  //Actuar dependiendo del tipo de año
  public static void leapYears (int[] years, String[] outputYears) {
    for (int i = 0; i < outputYears.length; i++) {
      if (isLeap(years[i])) {
    	  outputYears[i] = (years[i] + " => Es Bisiesto");
      } else {
    	  outputYears[i] = (years[i] + " => No Es Bisiesto");
      }
    }
  }
  
  //Escribir archivo de salida
  public static void writeFile (String destinationFile, String[] leapYears) throws IOException {
	    File file = new File(destinationFile);
	    BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
	    for (int i = 0; i < leapYears.length-1; i++) {
	       buffer.write(leapYears[i]);
	       buffer.newLine();
	    }
	    buffer.close();
	  }
}
