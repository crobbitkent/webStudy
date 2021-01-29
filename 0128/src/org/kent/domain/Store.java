package org.kent.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



// data tranfer object

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private Long storeCode; // sno
    private String name;
    private String menu;
    private double lat;
    private double lng;
    private Date regdate; // sql의 date
    private Date updatedate;
}
