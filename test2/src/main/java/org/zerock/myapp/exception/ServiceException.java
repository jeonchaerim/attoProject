package org.zerock.myapp.exception;


//영속성 계층의 모든 종류의 DAO구현에서 발생하는 예외 처리 
public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}//constructor 
	
	public ServiceException(Exception e) {
		super(e);
	}//constructor 

}//end class 
