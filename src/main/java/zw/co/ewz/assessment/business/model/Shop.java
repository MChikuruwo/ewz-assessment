package zw.co.ewz.assessment.business.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize
@ToString
public class Shop {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(unique = true)
    @Pattern(regexp = "^[A-Z\s]+$", message = "shop name must be uppercase!")
    private String shopName;

    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AreaLocation areaLocation;
}
