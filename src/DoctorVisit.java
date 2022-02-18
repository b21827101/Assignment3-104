
public class DoctorVisit extends ExaminationDecorator{
	
	AbstractExamination c;
	public DoctorVisit(AbstractExamination c) {
		this.c = c;
	}

	public int cost() {
		return 15+c.cost();
	}
	public String addOperation() { 
        return c.addOperation() + "doctorvisit "; //appending admission and output
	}


}
