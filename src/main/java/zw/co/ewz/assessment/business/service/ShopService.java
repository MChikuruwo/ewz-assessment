package zw.co.ewz.assessment.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.ewz.assessment.business.dao.ShopRepository;
import zw.co.ewz.assessment.business.dto.request.ShopRequest;
import zw.co.ewz.assessment.business.dto.response.ShopResponse;
import zw.co.ewz.assessment.business.model.AreaLocation;
import zw.co.ewz.assessment.business.model.Shop;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    private final AreaService areaService;

    public ShopResponse addShop(ShopRequest shopRequest) throws Exception {

        AreaLocation areaLocation = areaService.getLocation(shopRequest.location());

        Shop shop = Shop.builder()
                .shopName(shopRequest.shopName())
                .areaLocation(areaLocation)
                .isActive(true)
                .build();

        if (!shop.getShopName().matches("^[A-Z\s]+$"))  throw new Exception("shop name must be uppercase!");

        shopRepository.save(shop);

        return new ShopResponse(shop.getShopName(), shop.getAreaLocation());
    }

    public ShopResponse getShopByName(String shopName) {

        Optional<Shop> shop = shopRepository.findShopByShopName(shopName);

        if (shop.isEmpty()) throw new EntityNotFoundException("Shop with name: " + shop.get().getShopName() + " not found.");

        return new ShopResponse(shop.get().getShopName(), shop.get().getAreaLocation());
    }

    public List<ShopResponse> getShopsByArea(String areaLocation) {

        AreaLocation location = areaService.getLocation(areaLocation);

        if (location==null) throw new EntityNotFoundException("Location"+ areaLocation+ " not found!");

        List<Shop> shops = shopRepository.findShopsByAreaLocation(location);

        if (shops.isEmpty()) throw new EntityNotFoundException("Shops not found.");

        return shops.stream().map(a -> new ShopResponse(a.getShopName(), a.getAreaLocation())).toList();
    }


    public List<ShopResponse> getAllShops() {

        List<Shop> shops = shopRepository.findAll();

        if (shops.isEmpty()) throw new EntityNotFoundException("Shops not found.");

        return shops.stream().map(a -> new ShopResponse(a.getShopName(), a.getAreaLocation())).toList();
    }
}
