package com.example.btsApplication.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.btsApplication.service.TripService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/tripReport")
public class TripResultReportController {

	private final TripService tripService;

	public TripResultReportController(TripService tripService) {
        this.tripService = tripService;
    }
	
	@GetMapping("/pdfTrip/{startStationId}/{endStationId}")
    public ResponseEntity<byte[]> generateTripPdf( @PathVariable Long startStationId,@PathVariable Long endStationId) throws FileNotFoundException, JRException {

    JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
		tripService.getTripsByStartAndEndStationId(startStationId,endStationId));
    JasperReport compileReport = JasperCompileManager
            .compileReport(new FileInputStream("src/main/resources/report/tripResult.jrxml"));
    HashMap<String, Object> map = new HashMap<>();
    
    JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
    
    byte[] data = JasperExportManager.exportReportToPdf(report);

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=tripResult.pdf");
    
    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
}
}
