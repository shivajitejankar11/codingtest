package boku.codingtest.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

/**
 * Following class will provide utility methods related to File operations.
 * @author darshan
 *
 */
public class FileUtil {

	AppLogger logger = AppLogger.getLogger(FileUtil.class);
	
	/**
	 * Following method will return a list of all lines from provided file
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public List<String> readFileLines(String filePath, String fileName) {
		try {
			return Files.readAllLines(FileSystems.getDefault().getPath(filePath, fileName), Charset.defaultCharset());
		} catch (IOException ioe) {
			logger.error("Failed reading lines from file " + filePath + ":" + fileName, ioe);
		}
		return null;
	}
	
	
	
}
