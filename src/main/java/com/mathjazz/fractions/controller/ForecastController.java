package com.mathjazz.fractions.controller;

import com.mathjazz.fractions.model.Forecast;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class ForecastController {

    String mycity="warszawa";

    private Forecast getForecast(String city) {

        RestTemplate restTemplate = new RestTemplate();
        try {
            Forecast forecast = restTemplate.getForObject("https://danepubliczne.imgw.pl/api/data/synop/station/{city}",
                    Forecast.class,
                    city);
            return forecast;
        }
        catch (RestClientException ex) {
            return restTemplate.getForObject("https://danepubliczne.imgw.pl/api/data/synop/station/warszawa",
                    Forecast.class);
        }
    }

    @GetMapping("/forecast")
    public String get(Model model) {
        model.addAttribute("newCity", new Forecast());
        model.addAttribute("mycity", mycity);
        model.addAttribute("forecast", getForecast(mycity));

        return "forecastView";
    }

    @PostMapping("/add-city")
    public String addCity(@ModelAttribute Forecast forecast) {
        mycity=forecast.getStacja().toLowerCase();

        return "redirect:/forecast";
    }

}
