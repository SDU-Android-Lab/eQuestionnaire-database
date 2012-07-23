/*
 * Util sdu.androidlab.isurvey.Database SqlError.java
 * 2012 2012-7-22 下午9:48:42
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;


/**
 * @author zhenzxie
 *
 */
public class SqlError {
	
	public String message;
	
	public Exception exception;

	public SqlError() {
	
	}
	
	public SqlError(String msg) {
	
		this.message = msg;
	}

	public SqlError(Exception exp) {
	
		this.exception = exp;
	}
	
	/**
	 * @param message
	 * @param exception
	 */
	public SqlError(String message, Exception exception) {
	
		this.message = message;
		this.exception = exception;
	}

}
