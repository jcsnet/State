
public class Booter {
	
	public static void main(String[] args) {
	
	//State	1
	XmlReader textReader = new XmlTextReader(); 
	textReader.getParsedElements().print();
	
	//State 2
	XmlReader numberReader = new XmlNumberReader(); 
	numberReader.getParsedElements().print();
	}
}
