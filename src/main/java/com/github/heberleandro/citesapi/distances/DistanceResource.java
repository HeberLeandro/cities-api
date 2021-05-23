package com.github.heberleandro.citesapi.distances;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

  private final DistanceService service;
  Logger log = LoggerFactory.getLogger(DistanceResource.class);

  public DistanceResource(DistanceService service) {
    this.service = service;
  }

//  @GetMapping("/by-points")
//  public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
//                         @RequestParam(name = "to") final Long city2) {
//    log.info("byPoints");
//    return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
//  }

  @GetMapping
  public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2, @RequestParam(name = "unit") final String unit) {
    log.info("byCube");
    Double result = service.distanceByCubeInMeters(city1, city2, unit);
    return (result != null) ? ResponseEntity.ok().body(result) :  ResponseEntity.notFound().build();
  }
}
