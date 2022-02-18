import java.util.ArrayList;

public class AdmissionClass{
	public static String admissionID;
	public static String patientID;
	public static String outstring;//for addOperation
	public static String instring;//for addOperation
	public static int incost;//for totalcost
	public static int outcost;//for totalcost
	public static String outString;//for addOperation
	public static String inString;
	public int RemovedID;//RemovePatientID
	public static Object[] arr = new Object[1];//array of addpatient line
	public static ArrayList<String> listoutput = new ArrayList<String>();//arraylist for output.txt

	public void main() {
		Reading read2 = new Reading();
		PatientDao patient=new PatientDao();
		for(int i=0;read2.arrayinput.length>i;i++){
			if(read2.arrayinput[i][0].equals("AddPatient")) {
				arr=read2.arrayinput[i];
				patient.add();
				listoutput.add("Patient "+read2.arrayinput[i][1]+" "+read2.arrayinput[i][2]+" added");//Patient ID name added for output.txt
			}
			
			if(read2.arrayinput[i][0].equals("RemovePatient")) {
				RemovedID = Integer.parseInt(read2.arrayinput[i][1]);
				String RemovedsID= String.valueOf(RemovedID);//convert to String
				for(int j=0;read2.arraypatient.length>j;j++) {
        			 if(read2.arraypatient[j][0].equals(RemovedsID)) {
        				 
        				String[] words=read2.arraypatient[j][1].split(" ");//splitting name and surname
        				listoutput.add("Patient "+RemovedsID+" "+words[0]+" removed");//Patient RemovedsID name removed for output.txt
        				
        				patient.deleteByID(RemovedID);
        				AdmissionDao ex= new AdmissionDao();
        				ex.deleteByID(RemovedID);//removing line from admission.txt
        			 }	
        		 }				
			}
			if(read2.arrayinput[i][0].equals("CreateAdmission")){//writing admission created for output
				admissionID = read2.arrayinput[i][1];
				patientID = read2.arrayinput[i][2];
				listoutput.add("Admission "+admissionID+" created");
			}
			if(read2.arrayinput[i][0].equals("AddExamination")&& read2.arrayinput[i][1].equals(admissionID)) {
				String examinationType =read2.arrayinput[i][2];
				
				if(examinationType.equals("Outpatient")) {
					listoutput.add(examinationType+" examination added to admission "+admissionID);//appending information for outputtxt
					AbstractExamination out= new OutPatient();
					
					for(int j=3;read2.arrayinput[i].length>j;j++) {
						if(read2.arrayinput[i][j].equals("tests")) {
							out= new Tests(out);
							out.addOperation();
						}
						if(read2.arrayinput[i][j].equals("doctorvisit")) {
							out = new DoctorVisit(out);
							out.addOperation();
						}
						if(read2.arrayinput[i][j].equals("measurements")) {//using addOperation and cost
							out = new Measurement(out);		
							out.addOperation();
						}
						if(read2.arrayinput[i][j].equals("imagining")) {
							out = new Imaging(out);
							out.addOperation();
						}
					}
					outString=out.addOperation();
					outstring =outString.replace("\t"," ");//for replacing \t in output.txt
					outcost=out.cost();
				}
				if(examinationType.equals("Inpatient")) {
					AbstractExamination out= new InPatient();
					listoutput.add(examinationType+" examination added to admission "+admissionID);//appending information for outputtxt
					for(int j=3;read2.arrayinput[i].length>j;j++) {
						if(read2.arrayinput[i][j].equals("tests")) {
							out= new Tests(out);
							out.addOperation();
							}
						if(read2.arrayinput[i][j].equals("doctorvisit")) {
							out = new DoctorVisit(out);
							out.addOperation();
							}
						if(read2.arrayinput[i][j].equals("measurements")) {
							out = new Measurement(out);
							out.addOperation();
							}
						if(read2.arrayinput[i][j].equals("imagining")) {
							out = new Imaging(out);
							out.addOperation();
							}
					}
					incost=out.cost();
					inString=out.addOperation();
					instring=inString.replace("\t"," ");//for replacing \t in output.txt
				}
			}
		}
	}
}
