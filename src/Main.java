import java.io.IOException;

public class Main {
	public static String argument1;
	public static void main(String[] args) throws IOException {
		Reading read1=new Reading();
		String argument2=args[0];//First argument input.txt
		argument1=argument2;
		read1.main(args);
		AdmissionDao e=new AdmissionDao();
		AdmissionClass a= new AdmissionClass();
		a.main();
		e.add();
		WritingFile write=new WritingFile();
		write.main(args);	
		write.writingTxtadmission();
		write.writingTxtpatient();
	}
}