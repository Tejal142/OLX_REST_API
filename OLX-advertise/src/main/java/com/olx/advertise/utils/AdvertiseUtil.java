package com.olx.advertise.utils;

import com.olx.advertise.dto.Advertise;
import com.olx.advertise.dto.AdvertiseResponse;
import com.olx.advertise.entity.AdvertiseEntity;

public class AdvertiseUtil {

	public static AdvertiseEntity convertToDocument(Advertise advertise) {
		AdvertiseEntity advertiseDocument = new AdvertiseEntity(advertise.getId(), advertise.getTitle(), advertise.getCategoryId(), advertise.getPrice(), advertise.getDescription(), advertise.getUsername(), null, null, advertise.getStatusId());
		return advertiseDocument;
	}
	
	public static AdvertiseResponse convertToAdvertise(AdvertiseEntity advertiseDocument, String category, String status) {
		AdvertiseResponse advertiseResponse = new AdvertiseResponse();
		advertiseResponse.setCategory(category);
		advertiseResponse.setCreatedDate(advertiseDocument.getCreatedDate());
		advertiseResponse.setDescription(advertiseDocument.getDescription());
		advertiseResponse.setId(advertiseDocument.getId());
		advertiseResponse.setPrice(advertiseDocument.getPrice());
		advertiseResponse.setStatus(status);
		advertiseResponse.setTitle(advertiseDocument.getTitle());
		advertiseResponse.setUpdatedDate(advertiseDocument.getCreatedDate());
		advertiseResponse.setUsername(advertiseDocument.getUsername());
		return advertiseResponse;
	}
}
