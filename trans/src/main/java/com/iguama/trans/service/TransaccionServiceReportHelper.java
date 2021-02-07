package com.iguama.trans.service;

import com.iguama.trans.model.Transaccion;
import com.iguama.trans.repository.TransaccionRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransaccionServiceReportHelper {

	public TransaccionRepository transaccionRepository;

	@Autowired
	private TransaccionServiceReportHelper(TransaccionRepository transaccionRepository) {
		this.transaccionRepository = transaccionRepository;
	}
	
	public void runReports() {
		
		List<Transaccion> dbtrans = this.transaccionRepository.findAll();
		
		ArrayList<Transaccion> repo1 = new ArrayList<Transaccion>();
		ArrayList<Transaccion> repo2 = new ArrayList<Transaccion>();
		
		Float tasaHoy = 0.0013f;
		Float tasaManana = 0.0010f;

		BigDecimal th = new BigDecimal(tasaHoy, new MathContext(5, RoundingMode.HALF_EVEN));
		BigDecimal tm = new BigDecimal(tasaManana, new MathContext(5, RoundingMode.HALF_EVEN));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		
		//LocalDateTime now = LocalDateTime.now();
		LocalDateTime now = LocalDateTime.parse("2021-02-08 17:00:00", dtf);
		
		System.out.println("Fecha/Hora Limite para distribuir reportes : "+now);
		
		for (Iterator<Transaccion> iterator = dbtrans.iterator(); iterator.hasNext();) {

			Transaccion trans = iterator.next();
			
			LocalDateTime tranDate = trans.getFechaCreacion().toLocalDateTime();
			
			if (tranDate.isAfter(now)) {
				
				trans.setTipoCambio(tasaManana);
				
				BigDecimal millas = trans.getMontoTotal().divide(tm, 0, RoundingMode.HALF_DOWN);
				
				trans.setMillasGastadas(millas);
				
				repo2.add(trans);
				
			} else {
				
				trans.setTipoCambio(tasaHoy);
				
				BigDecimal millas = trans.getMontoTotal().divide(th, 0, RoundingMode.HALF_DOWN);
				
				trans.setMillasGastadas(millas);
					
				repo1.add(trans);
			}
		}
		
		if ( repo1.size() > 0 ) printReport(repo1,1);
        
		if ( repo2.size() > 0 ) printReport(repo2,2);	
		
	}
		
	private void printReport(ArrayList<Transaccion> repo, int numrep) {
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		System.out.println("***************************Inicia Reporte "+numrep+"*************************************");		
		System.out.println("");
		
		for (Iterator<Transaccion> iterator = repo.iterator(); iterator.hasNext();) {
			
			Transaccion trans = iterator.next();
			
			StringBuffer sb = new StringBuffer("");
			
			sb.append(trans.getIdOrden()).append("|");
			sb.append(trans.getFechaCreacion()).append("|");
			sb.append(trans.getIdCliente()).append("|");
		    sb.append(trans.getNombreProducto()).append("|$");
		    sb.append(df.format(trans.getMontoTotal())).append("|Millas ");
		    sb.append(df.format(trans.getMillasGastadas())).append("|");
		    sb.append(trans.getTipoCambio());
			
	        System.out.println(sb);
	        
		}
		
		System.out.println("");
		System.out.println("***************************Termina Reporte "+numrep+"*************************************");
	        
	}
	
}
