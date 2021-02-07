package com.iguama.trans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransaccionService {
	
	private TransaccionServiceReportHelper transaccionServiceReportHelper;

	@Autowired
	public TransaccionService(TransaccionServiceReportHelper transaccionServiceReportHelper) {
		this.transaccionServiceReportHelper = transaccionServiceReportHelper;
	}

	public void runReports() {
		
		transaccionServiceReportHelper.runReports();
	
	}
	
}
