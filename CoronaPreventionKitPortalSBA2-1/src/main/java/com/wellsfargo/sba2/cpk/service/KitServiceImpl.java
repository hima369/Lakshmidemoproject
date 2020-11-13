package com.wellsfargo.sba2.cpk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba2.cpk.dao.KitRepository;
import com.wellsfargo.sba2.cpk.entity.kit;
import com.wellsfargo.sba2.cpk.exception.cpkException;


@Service
public class KitServiceImpl implements KitService {

	@Autowired
	private KitRepository kitrepo;
		
	@Override
	@Transactional
	public kit add(kit kit) throws cpkException {
		if(kit!=null) {
			if(kitrepo.existsById(kit.getKitID())) {
				throw new cpkException("Kit id is already used");
			}
			kitrepo.save(kit);
		}
		return kit;
	}

	@Override
	@Transactional
	public kit save(kit kit) throws cpkException {
		if(kit!=null) {
			if(!kitrepo.existsById(kit.getKitID())) {
				throw new cpkException("Kit id not found");
			}
			kitrepo.save(kit);
		}
		return kit;
	}

	@Override
	@Transactional
	public boolean deleteKit(int kitID) throws cpkException {
		if(!kitrepo.existsById(kitID)) {
			throw new cpkException("Kit id not found");
		}
		kitrepo.deleteById(kitID);
		return true;
	}

	@Override
	public kit getKitById(int kitID) throws cpkException {
		return kitrepo.findById(kitID).orElse(null);
		
	}

	@Override
	public List<kit> getAllKits() throws cpkException {		
		return kitrepo.findAll();
		
	}

}
