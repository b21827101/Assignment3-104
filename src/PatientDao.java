import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class PatientDao implements PatientInterface{
	AdmissionClass a= new AdmissionClass();
	Reading read1= new Reading();

	public void deleteByID(int ID){//deleting the line to be removed
		 try{
			 BufferedReader file = new BufferedReader(new FileReader("patient.txt"));
	         String line;
	         String input = "";
	         int b=0;
	         String RemovedsID= String.valueOf(ID);//convert to String      	        		 
	         while ((line = file.readLine()) != null){
	        	 if (line.startsWith(RemovedsID= String.valueOf(ID))){//deleting the line to be removed
	        		 read1.listpatient.remove(line);
	        		 b+=1;
	             	 continue;
	              }
	        	 else if(b-1==read1.listpatient.size()){//removing blank line
	        		 input += line;
	        		 b+=1;
	        	 }
	        	 else {//if this is not removing line
	        		 input += line + '\n';
	        		 b+=1;
	             }
	         }       
	         FileOutputStream File = new FileOutputStream("patient.txt");
	         File.write(input.getBytes());
	         file.close();
	         File.close();
	        }
		catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public void add(){
    	String appending=a.arr[1]+"\t"+a.arr[2]+" "+a.arr[3]+"\t"+a.arr[4]+"\t"+"Address: ";
		for(int j=5;a.arr.length>j;j++) {
			appending+=a.arr[j]+" ";
		}
        read1.listpatient.add(appending); //appending new patient for output.txt and patient.txt
	}
}