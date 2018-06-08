package de.bithackaton.rest;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bithackaton.model.NavigationMap;
import org.geojson.GeoJsonObject;
import org.geojson.MultiLineString;
import org.geojson.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NavigationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/navigate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public NavigationMap navigate(@RequestBody Point location) throws Exception {


        return new NavigationMap(counter.incrementAndGet(), geoData());
    }

    public String geoData() {
        return "HAHA";
    }
}