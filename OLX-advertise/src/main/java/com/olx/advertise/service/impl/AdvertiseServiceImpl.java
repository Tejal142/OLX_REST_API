package com.olx.advertise.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.olx.advertise.dto.Advertise;
import com.olx.advertise.dto.AdvertiseResponse;
import com.olx.advertise.entity.AdvertiseEntity;
import com.olx.advertise.repo.AdvertiseRepo;
import com.olx.advertise.service.AdvertiseService;
import com.olx.advertise.utils.AdvertiseUtil;
import com.olx.advertise.utils.JwtUtils;

@Service
public class AdvertiseServiceImpl implements AdvertiseService{

	@Autowired
	private AdvertiseRepo advertiseRepo;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	RestTemplate restTemplate;
	
	static String category= "http://OLX-Masterdata/category/{id}";
	static String validateUser = "http://OLX-Login/token/validate";
	
	@Override
	public AdvertiseResponse createAdvertise(Advertise advertise, String authToken) {
		if(validateToken(authToken)) {
			String userName = jwtUtils.extractUsername(authToken.split(" ")[1]);
			advertise.setUsername(userName);
			AdvertiseEntity advertiseDocument = AdvertiseUtil.convertToDocument(advertise);
			advertiseDocument.setCreatedDate(new Date());
			advertiseDocument = advertiseRepo.save(advertiseDocument);
			AdvertiseResponse response = AdvertiseUtil.convertToAdvertise(advertiseDocument, getCategory(advertiseDocument.getCategory()), userName);
			return response;
		}
		return null;
		
	}

	@Override
	public List<AdvertiseResponse> searchAdvertiseByText() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCategory(Long id) {
		Map<String, Long> params = new HashMap<>();
        params.put("id", id);
		String categoryName = restTemplate.getForObject(category, String.class, params);
		return categoryName;
	}


	@Override
	public AdvertiseResponse getAdvertiseByPostId(Long postId, String authToken) {
		Optional<AdvertiseEntity> advertiseDoc = advertiseRepo.findById(postId);
		if(advertiseDoc.isPresent()) {
			return AdvertiseUtil.convertToAdvertise(advertiseDoc.get(), getCategory(advertiseDoc.get().getCategory()), authToken);
		}
		return null;
	}

	
	public Boolean validateToken(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(validateUser, HttpMethod.GET, entity, Boolean.class).getBody();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public List<AdvertiseResponse> searchAdvertiseByFilterCriteria() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AdvertiseEntity> getAllAdvertise() {
		// TODO Auto-generated method stub
		 List<AdvertiseEntity> advertiseDoc = advertiseRepo.findAll();
		return advertiseDoc;
	}

}
