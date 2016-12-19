package boku.codingtest.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Following class will provide utility methods related to File operations.
 * @author darshan
 *
 */
public class FileUtil {

  static AppLogger logger = AppLogger.getLogger(FileUtil.class);

  /**
 * Following method will return a list of all lines from provided file.
 * @param path File path where source file is located
 * @return List containing all lines from provided file
 */
  public static List<String> readFileLines(Path path) {

	List<String> listOfLines = null;

    try {
    	
      listOfLines = Files.readAllLines(path,Charset.defaultCharset());
      
    } catch (IOException ioe) {
      logger.error("Failed reading all lines from file : " + path.getFileName(), ioe);
    }
    
    return listOfLines;
  }


  /**
   * Following method will return list of all file path objects present in provided directory.
   * @param dirPath Path of directory which needs to be read
   * @return List of Path objects for all files present in provided directory
   */
  public static List<Path> getAllFilesFromDir(String dirPath) {
	  
	  List<Path> listOfFlies = new ArrayList<Path>();
	  
      try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirPath))) {
    	  
          for (Path path : directoryStream) {
        	  listOfFlies.add(path);
          }
          
      } catch (IOException ioe) {
    	  logger.error("Failed reading content of direcotry : " + dirPath, ioe);
      }
      
      return listOfFlies;
  }
	
	
}
