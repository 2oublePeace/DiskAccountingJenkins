package com.emiryanvl.reportservice

import com.emiryanvl.mainservice.dto.response.DiskResponse
import com.emiryanvl.mainservice.service.DiskService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ReportServiceApplication

fun main(args: Array<String>) {
	runApplication<ReportServiceApplication>(*args)
}
