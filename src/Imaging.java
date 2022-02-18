
public class Imaging extends ExaminationDecorator{
	
	AbstractExamination c;
	public Imaging(AbstractExamination c) {
		this.c = c;
	}
	public int cost() {
		return 10+c.cost();
	}
	public String addOperation() { 
        return c.addOperation() + "	imaging"; 
	}
}
