package myapp.imp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import myapp.services.ILogger;

public class BeanFileLogger implements ILogger {
	
	private String filename = "tmp/myapp.log";
	private PrintWriter writer;
	
	@PostConstruct
	public void start() {
		if(filename == null) {
			throw new IllegalStateException("no filename");
		}
		try {
			OutputStream os = new FileOutputStream(filename, true);
			this.writer = new PrintWriter(os);
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("mauvais filename");
		}
		System.err.println("Start " + this);
	}
	
	@PreDestroy
	public void stop() {
		writer.close();
		System.err.println("Stop " + this);
	}
	
	@Override
	public void log(String message) {
		writer.printf("%tF %1$tR | %s\n", new Date(), message);
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
