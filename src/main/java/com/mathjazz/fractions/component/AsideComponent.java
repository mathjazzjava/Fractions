package com.mathjazz.fractions.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.mathjazz.fractions.model.Forecast;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class AsideComponent {

    String trivia;
    String city;

    public String getTriviaAboutNumber() {
        String url = "http://numbersapi.com/random?json";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode myTrivia = restTemplate.getForObject(url, JsonNode.class).get("text");
        trivia = myTrivia.asText("Tutaj powinna być ciekawostka o losowej liczbie...");
        return trivia;
    }

    public Forecast getForecast(String city) {

        RestTemplate restTemplate = new RestTemplate();
            try {
                String url = "https://danepubliczne.imgw.pl/api/data/synop/station/{city}";
                Forecast forecast = restTemplate.getForObject(url, Forecast.class, city);
                return forecast;
            }
            catch (RestClientException ex) {
                return restTemplate.getForObject("https://danepubliczne.imgw.pl/api/data/synop/station/warszawa",
                        Forecast.class);
            }
    }


//    public Forecast getForecast() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        Forecast forecast = restTemplate.getForObject("https://danepubliczne.imgw.pl/api/data/synop/station/warszawa",
//                    Forecast.class);
//        return forecast;
//    }

//    @GetMapping("/forecast")
//    public String get(Model model) {
//        model.addAttribute("newCity", new Forecast());
//        model.addAttribute("mycity", mycity);
//        model.addAttribute("forecast", getForecast(mycity));
//
//        return "forecastView";
//    }
}
