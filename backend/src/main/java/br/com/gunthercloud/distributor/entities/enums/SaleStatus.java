package br.com.gunthercloud.distributor.entities.enums;

public enum SaleStatus {
	DONE(1),
	WAITING(2),
	CANCELED(3);
	
	private int code;
	
	private SaleStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	public static SaleStatus valueOf(int code) {
		for(SaleStatus v : SaleStatus.values()) {
			if(v.getCode() == code) {
				return v;
			}
		}
		throw new IllegalArgumentException("Status Sale Does Not Exists!");
	}
}
