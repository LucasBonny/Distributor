package br.com.gunthercloud.distributor.services.exceptions;

public class DatabaseExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DatabaseExecption(String msg) {
		super(msg);
	}
}
