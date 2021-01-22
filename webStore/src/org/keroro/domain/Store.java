package org.keroro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private String storeCode;
    private String name;
    private String menu;
    private String x;
    private String y;
}
