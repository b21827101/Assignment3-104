import java.util.ArrayList;

public class AdmissionDao implements PatientInterface{
	
	Reading read2= new Reading();
	AdmissionClass a = new AdmissionClass();
	public static ArrayList<String> newlist1 = new ArrayList<String>();
	PatientDao patient = new PatientDao();
	
	public void add() {	
		a.listoutput.add("TotalCost for admission "+ a.admissionID);
		read2.list2.add(Integer.parseInt(a.admissionID)+"\t"+Integer.parseInt(a.patientID));
		
		if(a.instring != null&& a.outstring != null) {//I made if else status to avoid any errors
			read2.list2.add(a.inString);
			read2.list2.add(a.outString);
			a.listoutput.add("	"+a.instring+" "+a.incost+"$");
			a.listoutput.add("	"+a.outstring+" "+a.outcost+"$");
		}	
		else if(a.instring != null&& a.outstring == null) {
			read2.list2.add(a.inString);
			a.listoutput.add("	"+a.instring+" "+a.incost+"$");
		}
		else if(a.instring == null && a.outstring != null) {
			read2.list2.add(a.outString);
			a.listoutput.add("	"+a.outstring+" "+a.outcost+"$");
		}
		a.listoutput.add("	Total: "+(a.incost+a.outcost)+"$");//Totalcost for output
		
		
		
		ArrayList<Integer> newlist = new ArrayList<Integer>();
		String add1 = "";
		for(int i=0;read2.list2.size()>i;i++) {//I separated the arraylist from int to remove
			if (Character.isDigit(read2.list2.get(i).charAt(0)) ) {
				newlist.add(i);
			}
		}
		for(int i=1;read2.list2.size()>i;i++) {//each admisssion has one index in newlist1
			if(newlist.contains(i)){
				newlist1.add(add1);
				add1 = "";
				add1 +=read2.list2.get(i)+"\n" ;		
			}
			if(newlist.contains(i)== false){
				add1 +=  read2.list2.get(i)+"\n" ;
			}
			if(i == read2.list2.size() - 1){
				newlist1.add(add1);
			}
		}
		String ek = read2.list2.get(0);
		String ek1 =newlist1.get(0);
		ek = ek+ "\n"+ek1;
		ek = ek.replace("null", "");
		newlist1.set(0,ek);		
	}

	
	public void deleteByID(int ID) {
		ArrayList<String> listremove = new ArrayList<String>();
		for (int i = 0; i < read2.list2.size(); i++) {
	       	 if(read2.list2.get(i).contains(String.valueOf(ID))) {
	       		 listremove.add(String.valueOf(i));//appending indexes to delete
	   	         for (int j = i+1; j < read2.list2.size(); j++) {
	   	        	 if(read2.list2.get(j).contains("Inpatient")|| read2.list2.get(j).contains("Outpatient")) {
	   	        		 listremove.add(String.valueOf(j));}//appending indexes to delete
	   	        	 else {
	   	        		 break;
	   	        	 }	 
	   	         }
	       	 }
		}  
	    for (int i = 0; i < listremove.size(); i++) {
	    	int y=Integer.valueOf(listremove.get(i));
	       	read2.list2.remove(y-i);// deleting the correct index by doing y-i
	    }
	}
}
