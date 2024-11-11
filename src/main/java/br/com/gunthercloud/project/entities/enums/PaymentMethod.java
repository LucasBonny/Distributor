package br.com.gunthercloud.project.entities.enums;

public enum PaymentMethod {
	CREDIT(1),
	DEBIT(2),
	PIX(3),
	CASH(4);
	
	private int code;
	
	private PaymentMethod(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	public static PaymentMethod valueOf(int code) {
		for(PaymentMethod v : PaymentMethod.values()) {
			if(code == v.getCode()) {
				return v;
			}
		}
		throw new IllegalArgumentException("Invalid Payment Method!");
	}
	
	

}
