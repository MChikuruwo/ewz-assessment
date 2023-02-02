package zw.co.ewz.assessment.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.ewz.assessment.business.model.AreaLocation;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<AreaLocation, Long> {
    Optional<AreaLocation> findAreaByLocation(String areaName);
}
