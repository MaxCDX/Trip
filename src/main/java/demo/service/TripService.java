package demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TripService {

    private final String apiKey = "put your own api key here ";//不要用我的，我怕她受我钱

    public byte[] getStaticMap(String origin) {
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/staticmap")
        .queryParam("center", origin)
        .queryParam("zoom", "12")
        .queryParam("size", "600x300")
        .queryParam("maptype", "roadmap")
        .queryParam("markers", "color:blue|label:S|" + origin)
        .queryParam("key", apiKey)
        .toUriString();
    
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, byte[].class);
    }

    public String getDirections(String origin, String destination) {
        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/directions/json")
                .queryParam("origin", origin)
                .queryParam("destination", destination)
                .queryParam("key", apiKey)
                .toUriString();
    
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
    
}
