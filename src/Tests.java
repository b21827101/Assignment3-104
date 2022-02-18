
public class Tests extends ExaminationDecorator{
	// we need a reference to obj we are decorating 
	AbstractExamination c;
	public Tests(AbstractExamination c) {
		this.c = c;
	}

	public int cost() {
		return 7+c.cost();
	}
	public String addOperation() { 
	    return c.addOperation() + "tests "; //appending admission and output
	}

}
