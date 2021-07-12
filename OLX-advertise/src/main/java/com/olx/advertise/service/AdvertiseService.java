package com.olx.advertise.service;

import java.util.List;

import com.olx.advertise.dto.Advertise;
import com.olx.advertise.dto.AdvertiseResponse;
import com.olx.advertise.entity.AdvertiseEntity;

public interface AdvertiseService {

	public AdvertiseResponse createAdvertise(Advertise advertise, String authToken);
	public List<AdvertiseResponse> searchAdvertiseByText();
	public AdvertiseResponse getAdvertiseByPostId(Long postId, String authToken);
	public List<AdvertiseEntity> getAllAdvertise();
	public List<AdvertiseResponse> searchAdvertiseByFilterCriteria();
}
