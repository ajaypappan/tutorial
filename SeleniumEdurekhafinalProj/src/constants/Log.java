package constants;

import org.apache.log4j.Logger;

public class Log {

	public static Logger Log = Logger.getLogger(Log.class.getName());
	
	
	public static void startlogging(String sTestCaseName){
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++++++++++++" + sTestCaseName +" ++++++++++++");
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public static void Endlogging(String sTestcaseName){
		Log.info("======================= END ==================");
	}
	
	public static void info(String Message){
		Log.info(Message);
	}
	
	public static void error(String Message){
		Log.error(Message);
	}
	
	public static void Warning(String Message){
		Log.warn(Message);
	}
	
	public static void debug(String Message){
		Log.debug(Message);
	}
}
