package br.com.gunthercloud.distributor.entity.enums;

public enum PaymentStatus {
	WAITING_PAYMENT(1),
	CANCELED(2),
	PAID(3);
	
	private int code;
	
	private PaymentStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	public static PaymentStatus valueOf(int code) {
		for(PaymentStatus v : PaymentStatus.values()) {
			if(v.getCode() == code) {
				return v;
			}
		}
		throw new IllegalArgumentException("Status Payment Does Not Exists!");
	}
}
