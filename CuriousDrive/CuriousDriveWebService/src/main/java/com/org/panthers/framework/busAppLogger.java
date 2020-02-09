package com.org.panthers.framework;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.org.panthers.business.busConstant;

public class busAppLogger {

	static private FileHandler fileTxt;
	static private SimpleFormatter formatterTxt;

	static private FileHandler fileHTML;
	static private Formatter formatterHTML;
	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	static public void setup() throws IOException {

		// suppress the logging output to the console
		Logger rootLogger = Logger.getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		if (handlers[0] instanceof ConsoleHandler) {
			rootLogger.removeHandler(handlers[0]);
		}

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdfDate.format(now);

		LOGGER.setLevel(Level.INFO);
		fileTxt = new FileHandler("./applogs/mylogs" + strDate + ".log");
		fileHTML = new FileHandler("./applogs/mylogs" + strDate + ".html");

		// create a TXT formatter
		formatterTxt = new SimpleFormatter();
		fileTxt.setFormatter(formatterTxt);
		LOGGER.addHandler(fileTxt);

		// create an HTML formatter
		formatterHTML = new busAppHTMLFormatter();
		fileHTML.setFormatter(formatterHTML);
		LOGGER.addHandler(fileHTML);
	}

	public void log(String astrMessage, String astrSeverity, String astrMethod) {

		if (LOGGER.getHandlers().length == 0) {
			try {

				busAppLogger.setup();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Problems with creating the log files");
			}
		}

		if (astrSeverity == busConstant.SeveritySevere) {
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe(astrMethod + " - " + astrMessage);
		}

		if (astrSeverity == busConstant.SeverityInfo) {
			LOGGER.setLevel(Level.INFO);
			LOGGER.severe(astrMethod + " - " + astrMessage);
		}
	}

	public static void main(String[] args) {

	}
}
