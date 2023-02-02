package zw.co.ewz.assessment.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.ewz.assessment.business.model.AreaLocation;
import zw.co.ewz.assessment.business.model.Shop;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findShopByShopName(String shopName);

    List<Shop> findShopsByAreaLocation(AreaLocation location);
}
