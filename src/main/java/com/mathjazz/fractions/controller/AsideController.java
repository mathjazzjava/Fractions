//package com.mathjazz.fractions.controller;
//
//import com.mathjazz.fractions.component.AsideComponent;
//import com.mathjazz.fractions.model.Forecast;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//
////@Controller
//public class AsideController {
//
//    @Autowired
//    private AsideComponent asideComponent;
//
//    @ModelAttribute
//    public void addTrivia (Model model){
//        String trivia;
//        trivia = asideComponent.getTriviaAboutNumber();
//        model.addAttribute("trivia", trivia);
//    }
//
//    @ModelAttribute
//    private void addForecast (Model model){
////       String myCity = "Warszawa";
////        myCity = asideComponent.getForecast("Warszawa");
////        model.addAttribute("newCity", new Forecast());
////        model.addAttribute("myCity", myCity);
//        model.addAttribute("forecast", asideComponent.getForecast());
//    }
//}
//
//
////    String mycity="warszawa";
////
////    private Forecast getForecast(String city) {
////
////        RestTemplate restTemplate = new RestTemplate();
////        try {
////            Forecast forecast = restTemplate.getForObject("https://danepubliczne.imgw.pl/api/data/synop/station/{city}",
////                    Forecast.class,
////                    city);
////            return forecast;
////        }
////        catch (RestClientException ex) {
////            return restTemplate.getForObject("https://danepubliczne.imgw.pl/api/data/synop/station/warszawa",
////                    Forecast.class);
////        }
////    }
////
////    @GetMapping("/forecast")
////    public String get(Model model) {
////        model.addAttribute("newCity", new Forecast());
////        model.addAttribute("mycity", mycity);
////        model.addAttribute("forecast", getForecast(mycity));
////
////        return "forecastView";
////    }
//
////    String mycity="warszawa";
////
////    @ModelAttribute
////    @PostMapping("/add-city")
////    public String addCity(@ModelAttribute Forecast forecast) {
////        mycity=forecast.getStacja().toLowerCase();
////
////        return "redirect:/forecast";
////    }
//
//
