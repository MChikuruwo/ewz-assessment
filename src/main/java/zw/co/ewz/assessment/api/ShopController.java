package zw.co.ewz.assessment.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zw.co.ewz.assessment.business.dto.request.ShopRequest;
import zw.co.ewz.assessment.business.dto.response.ApiResponse;
import zw.co.ewz.assessment.business.service.ShopService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop")
public class ShopController {

    private final ShopService service;


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse addShop(@RequestBody ShopRequest shopRequest) throws Exception {

        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), service.addShop(shopRequest));
    }

    @GetMapping(value = "/name/get", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getShopByShopName(@RequestParam("shop-name") String shopName) {
        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), service.getShopByName(shopName));
    }

    @GetMapping(value = "/all/get", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getAllShops() {
        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), service.getAllShops());
    }

    @GetMapping(value = "/location/get", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getAllShopsInArea(@RequestParam("area")String areaLocation) {
        return new ApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), service.getShopsByArea(areaLocation));
    }

}
