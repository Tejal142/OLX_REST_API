package com.olx.advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.olx.advertise.dto.Advertise;
import com.olx.advertise.dto.AdvertiseResponse;
import com.olx.advertise.entity.AdvertiseEntity;
import com.olx.advertise.service.AdvertiseService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(value = "*")
public class AdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;
	
	@ApiOperation(value = "Create Advertise", notes = "Create new Advertise")
	@PostMapping(value = "/advertise", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> createAdvertise(@RequestBody Advertise advertise, @RequestHeader("Authorization") String authToken) {
		AdvertiseResponse advertiseResponse = advertiseService.createAdvertise(advertise, authToken);
		return new ResponseEntity<AdvertiseResponse>(advertiseResponse, HttpStatus.CREATED);
	}


	@GetMapping(value = "/advertise/search", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> searchAdvertiseByText(){
		List<AdvertiseResponse> advertiseList = advertiseService.searchAdvertiseByText();
		return new ResponseEntity<>(advertiseList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/advertise/{postId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getAdvertiseByPostId(@PathVariable Long postId, @RequestHeader("token") String authToken){
		AdvertiseResponse advertiseResponse = advertiseService.getAdvertiseByPostId(postId, authToken);
		return new ResponseEntity<AdvertiseResponse>(advertiseResponse, HttpStatus.OK);
	}
	
	@GetMapping(value="/advertise", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AdvertiseEntity> getAllAdvertise() {
		return advertiseService.getAllAdvertise();
	}
	
	@ApiOperation(value = "Search Advertise by filter criteria", notes = "Search Advertise by filter Parameters")
	@GetMapping(value = "/advertise/search/filtercriteria", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> searchAdvertiseByFilterCriteria(){
		List<AdvertiseResponse> advertiseList = advertiseService.searchAdvertiseByFilterCriteria();
		return new ResponseEntity<>(advertiseList, HttpStatus.OK);
	}
	

}
