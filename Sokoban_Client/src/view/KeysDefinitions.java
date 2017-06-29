/**
* This class responsible to get keys from XML and update the ways
* @author Maayan & Eden
*/

package view;

import java.beans.XMLDecoder;
import java.io.InputStream;
import java.util.HashMap;

public class KeysDefinitions {

	private HashMap<String, String> keys = new HashMap<String, String>();

	public KeysDefinitions(InputStream is) {
		XMLDecoder decoder = new XMLDecoder(is);
		keys.put(((String)decoder.readObject()),"up");
		keys.put(((String)decoder.readObject()),"down");
		keys.put(((String)decoder.readObject()),"right");
		keys.put(((String)decoder.readObject()),"left");
	}

	public String getCommandFromKey(String str) {
		return keys.get(str);
	}

}
