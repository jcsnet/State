import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class XmlTextReader implements XmlReader{

	private SAXBuilder builder;
	private File xmlFile;
	private List<Element> elementList = new ArrayList<>();

	public XmlTextReader() {
		init();
	}

	@Override
	public XmlReader getParsedElements() {
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			elementList = rootNode.getChildren("number");
			
			return this;
			
		} catch (IOException io) {
			return null;
		} catch (JDOMException jdomex) {
			return null;
		}
	}

	@Override
	public XmlReader print() {
		if(elementList != null){
			for (Element element : elementList) {
				System.out.println("Number description : " + element.getChildText("name"));
			}
		}
		return this;
	}

	private void init() {
		builder = new SAXBuilder();
		xmlFile = new File("c:\\myXML.xml");
	}
}
