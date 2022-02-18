import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reading {
	protected static String[][] arrayinput;
	public static String[][] arrayadmission;
	public static String[][] arraypatient;
	public static ArrayList<String> list1 = new ArrayList<String>();
	public static ArrayList<String> list2 = new ArrayList<String>();
	public static ArrayList<String> listpatient = new ArrayList<String>();
	
	public static String[] readFile(String path, ArrayList<String> list) {
		try {
		int i=0;
		int length = Files.readAllLines(Paths.get(path)).size();
		String[] results = new String[length];
			for (String line : Files.readAllLines(Paths.get(path))) {
				results[i++] = line ;
				list.add(line);
				
			}
		return results;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Main getmain=new Main();//call the main class
		String[] lines = readFile(getmain.argument1,list1);//getmain.argument1 "input.txt"
		arrayinput = new String[lines.length][];//adjusting the length of the arrayinput
		int z=0;
		for (String line:lines) {
			String[] pieces = line.split(" ");//separation from tab
			arrayinput[z]=new String[pieces.length];//adjusting the length of the each row
			for(int i=0;pieces.length>i;i++) {
				arrayinput[z][i]=(String)pieces[i];			
			}	
			z+=1;
		}
		
		String[] lines1 = readFile("admission.txt",list2);//reading admission.txt 
		arrayadmission = new String[lines1.length][];//adjusting the length of the arrayadmission
		int x=0;
		for (String line1:lines1) {
			String[] pieces1 = line1.split("\t");//separation from tab
			arrayadmission[x]=new String[pieces1.length];//adjusting the length of the each row
			for(int j=0;pieces1.length>j;j++) {
				arrayadmission[x][j]=(String)pieces1[j];			
			}	
			x+=1;
		}
		
		String[] lines2 = readFile("patient.txt",listpatient);//reading patient.txt
		arraypatient = new String[lines2.length][];//adjusting the length of the arraypatient
		int y=0;
		for (String line2:lines2) {
			String[] pieces2 = line2.split("\t");//separation from tab
			arraypatient[y]=new String[pieces2.length];//adjusting the length of the each row
			for(int j=0;pieces2.length>j;j++) {
				arraypatient[y][j]=(String)pieces2[j];
			}	
			y+=1;
		}
	}		
}

