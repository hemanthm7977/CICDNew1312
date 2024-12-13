package Hemanth.dataNew;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReaderNew {

	/*public List<HashMap<String, String>> getJSONdataToMap() throws IOException {

		// read JSON to string
		String JSONcontent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "/src/test/java/Hemanth/dataNew/PurchaseOrderNew.json"),
				StandardCharsets.UTF_8);

		// String to Hashmap Jackson databind
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(JSONcontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}*/

}