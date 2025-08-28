package br.com.gunthercloud.distributor.entity.enums;

import java.util.ArrayList;
import java.util.List;

public enum EmployeeStatus {
	ATIVO(0),
	FERIAS(1),
	SUSPENSO(2),
	DESLIGADO(3);
	
	private int code;
	
	private EmployeeStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static EmployeeStatus valueOf(int code) {
		for(EmployeeStatus e : EmployeeStatus.values()) {
			if(code == e.getCode()) {
				return e;
			}
		}
		throw new IllegalArgumentException("Invalid Status!");
	}
	public static List<EmployeeStatus> findAll() {
		List<EmployeeStatus> result = new ArrayList<>();
		for(EmployeeStatus e : EmployeeStatus.values()) {
			result.add(e);
		}
		return result;
	}
}
