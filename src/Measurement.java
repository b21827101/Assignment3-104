
public class Measurement extends ExaminationDecorator{
	// we need a reference to obj we are decorating 
	AbstractExamination c;
	public Measurement(AbstractExamination c) {
		this.c = c;
	}
	
	public int cost() {
		return 5 + c.cost();
	}
	
	public String addOperation() { 
        return c.addOperation() + "measurements "; //appending admission and output
	}
}
