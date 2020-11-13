package com.wellsfargo.sba2.cpk.service;

import java.util.List;

import com.wellsfargo.sba2.cpk.entity.kit;
import com.wellsfargo.sba2.cpk.exception.cpkException;

public interface KitService {

	kit add(kit kit) throws cpkException;
	kit save(kit kit) throws cpkException;
	boolean deleteKit(int kitID) throws cpkException;
	kit getKitById(int kitID) throws cpkException;	
	List<kit> getAllKits() throws cpkException;
	
	
}
