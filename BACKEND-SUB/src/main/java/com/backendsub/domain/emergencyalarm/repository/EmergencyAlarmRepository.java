package com.backendsub.domain.emergencyalarm.repository;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyAlarmRepository extends JpaRepository<EmergencyAlarm, Long>, EmergencyAlarmRepositoryCustom {

}
