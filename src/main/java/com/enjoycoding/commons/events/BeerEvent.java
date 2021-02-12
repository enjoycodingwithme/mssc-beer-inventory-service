package com.enjoycoding.commons.events;

import guru.sfg.beer.inventory.service.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {
    static final long serialVersionUID = -5669896652587499014L;
    private BeerDto beerDto;
}
