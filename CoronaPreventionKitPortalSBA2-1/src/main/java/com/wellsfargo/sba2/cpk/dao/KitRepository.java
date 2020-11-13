package com.wellsfargo.sba2.cpk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.sba2.cpk.entity.kit;

@Repository
public interface KitRepository extends JpaRepository <kit, Integer> {

}
