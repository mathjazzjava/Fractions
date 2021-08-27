package com.mathjazz.fractions;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class AsideComponent {

    String trivia;

    public String getTriviaAboutNumber() {
        String url = "http://numbersapi.com/random?json";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode myTrivia = restTemplate.getForObject(url, JsonNode.class).get("text");
        trivia = myTrivia.asText("Tutaj powinna być ciekawostka o losowej liczbie...");
        return trivia;
    }

//    @GetMapping("/trivia")
//    public String getTrivia(Model model) {
//        getTriviaAboutNumber();
//        model.addAttribute("trivia", trivia);
//        return "trivia";
//    }
}
