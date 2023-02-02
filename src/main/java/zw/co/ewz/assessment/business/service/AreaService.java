package zw.co.ewz.assessment.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.ewz.assessment.business.dao.AreaRepository;
import zw.co.ewz.assessment.business.dto.request.AreaRequest;
import zw.co.ewz.assessment.business.dto.response.AreaResponse;
import zw.co.ewz.assessment.business.model.AreaLocation;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaResponse addLocation(AreaRequest areaRequest) {

        AreaLocation areaLocation = AreaLocation.builder()
                .location(areaRequest.location())
                .isActive(true)
                .build();

        areaRepository.save(areaLocation);

        return new AreaResponse(areaLocation.getLocation());
    }

    public AreaLocation getLocation(String location) {

        Optional<AreaLocation> area = areaRepository.findAreaByLocation(location);

        if (area.isEmpty()) throw new EntityNotFoundException("Area in location: " + area.get().getLocation() + " not found");

        return area.get();
    }


    public List<AreaResponse> getAllLocations() {

        List<AreaLocation> areaLocations = areaRepository.findAll();

        if (areaLocations.isEmpty()) throw new EntityNotFoundException("Areas in location: not found");

        return areaLocations.stream().map(a -> new AreaResponse(a.getLocation())).toList();
    }
}
