package com.securin.cpeapi.repository;

import com.securin.cpeapi.model.CpeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CpeRepository
        extends JpaRepository<CpeEntity, Long>,
        JpaSpecificationExecutor<CpeEntity> {
}