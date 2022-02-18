import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WritingFile {
	
	Reading read1=new Reading();
	AdmissionDao e=new AdmissionDao();
	AdmissionClass a = new AdmissionClass();

	public void main(String[] args) throws IOException {//writing output
		PrintWriter out= new PrintWriter("output.txt");

		for(int i=0;a.listoutput.size()>i;i++) {
			out.println(a.listoutput.get(i));
		}
		java.util.Collections.sort(read1.listpatient, (String lineA, String lineB) -> {//sorting according to name
	        String wordA2 = lineA.split("\t")[1];
	        String wordB2 = lineB.split("\t")[1];
	        return wordA2.compareTo(wordB2);});
		out.println("Patient List:");
		for(int i=0;read1.listpatient.size()>i;i++) {
			String word1=read1.listpatient.get(i).replaceAll("\t"," ");
			out.println(word1);
		}
		out.close();
	}
	
	
	public void writingTxtadmission() {
		try {
			PrintWriter writer = new PrintWriter("admission.txt");
			Collections.sort(e.newlist1, (s1, s2) -> {//sorting according to id
	 		    Pattern pattern = Pattern.compile("^(\\d+)");
	 		    Matcher matcher1 = pattern.matcher(s1);
	 		    Matcher matcher2 = pattern.matcher(s2);
	 		    if (matcher1.find() && matcher2.find()) {
	 		        Integer i1 = Integer.valueOf(matcher1.group(1));
	 		        Integer i2 = Integer.valueOf(matcher2.group(1));
	 		        int compared = i1.compareTo(i2);
	 		        if (compared != 0) {
	 		            return compared;
	 		        }
	 		    }
	 		    return s1.compareTo(s2);
	 		});
			for(int i=0;e.newlist1.size()>i;i++) {//writing the admission.txx
				writer.write(e.newlist1.get(i));
			}
			writer.close();
			}
		catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}
	

	public void writingTxtpatient() {
		try { 
			Collections.sort(read1.listpatient, (s1, s2) -> {//sorting according to patientID
	     		Pattern pattern = Pattern.compile("^(\\d+)");
	     			Matcher matcher1 = pattern.matcher(s1);
	     			Matcher matcher2 = pattern.matcher(s2);
	     		    if (matcher1.find() && matcher2.find()) {
	     		        Integer i1 = Integer.valueOf(matcher1.group(1));
	     		        Integer i2 = Integer.valueOf(matcher2.group(1));
	     		        int compared = i1.compareTo(i2);
	     		        if (compared != 0) {
	     		            return compared;
	     		        }
	     		    }
	     		    return s1.compareTo(s2);
	     		});      
	    	PrintWriter writer = new PrintWriter("patient.txt");
	        for(int i=0;read1.listpatient.size()>i;i++) {//writing the txt
	        	writer.println(read1.listpatient.get(i));
	        }
	            writer.close(); 
	    } 
	    catch (IOException e) { 
	    	e.printStackTrace(); 
	    } 
	}
}
