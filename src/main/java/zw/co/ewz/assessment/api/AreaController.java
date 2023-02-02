package zw.co.ewz.assessment.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zw.co.ewz.assessment.business.dto.request.AreaRequest;
import zw.co.ewz.assessment.business.dto.request.ShopRequest;
import zw.co.ewz.assessment.business.dto.response.ApiResponse;
import zw.co.ewz.assessment.business.service.AreaService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/location")
public class AreaController {

    private final AreaService areaService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse addLocation(@RequestBody AreaRequest areaRequest)  {

        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), areaService.addLocation(areaRequest));
    }

    @GetMapping(value = "/name/get", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getLocationByName(@RequestParam("area-name") String areaName) {
        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), areaService.getLocation(areaName));
    }

    @GetMapping(value = "/all/get", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getAllALocations() {
        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), areaService.getAllLocations());
    }
}
