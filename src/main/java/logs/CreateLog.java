package logs;

import org.apache.log4j.Logger;

public class CreateLog {

	public void writeLog(String name,String result) {
		Logger log;
		log=Logger.getLogger("devpinoyLogger");
		log.info("====================================================================================");
		log.info("----------------------------------"+name+"------------------------------------------");
		log.info("====================================================================================");
		log.info("Result : "+result);
		
		
	}
}
