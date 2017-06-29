/**
* This class responsible to write in XML file the keys
* (we havent finish it but you can change the keys to W,S,A,D in 'edit')
* @author Maayan & Eden
*/

package view;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;

public class KeysSetter {

	public void setKeysDef(OutputStream out) throws IOException {
		XMLEncoder xml=new XMLEncoder(out);
		XMLSaver(xml);
		xml.close();
	}

	public void  XMLSaver(XMLEncoder xml) {

		xml.writeObject("w");
		xml.writeObject("s");
		xml.writeObject("d");
		xml.writeObject("a");

	}

}
