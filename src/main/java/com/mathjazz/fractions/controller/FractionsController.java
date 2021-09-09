package com.mathjazz.fractions.controller;

import com.mathjazz.fractions.component.AsideComponent;
import com.mathjazz.fractions.model.CalculatorForm;
import com.mathjazz.fractions.model.City;
import com.mathjazz.fractions.model.Forecast;
import com.mathjazz.fractions.model.FractionsForm;
import com.mathjazz.fractions.service.CalculatorService;
import com.mathjazz.fractions.service.FractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
    public class FractionsController {
        
        @Autowired
        private CalculatorService calculatorService;
        @Autowired
        private FractionsService fractionsService;
//        @Autowired
//        private AsideComponent asideComponent;
//        @Autowired
//        private Forecast forecast;
//        @Autowired
//        private City city;
//
//        @ModelAttribute
//        public void addTrivia (Model model){
//            String trivia;
//            trivia = asideComponent.getTriviaAboutNumber();
//            model.addAttribute("trivia", trivia);
//        }
//
//        String myCity;
//
//        @ModelAttribute
//        private void addForecast (Model model){
//            model.addAttribute("city", city);
//            model.addAttribute("newCity", new City());
//            model.addAttribute("forecast", asideComponent.getForecast(myCity));
//        }
//
//        @PostMapping("/add-city")
//        public String rateHandler(HttpServletRequest request ) {
//            myCity = request.getParameter("myCity");
//            String referer = request.getHeader("Referer");
//            return "redirect:"+ referer;
//        }

        @RequestMapping("/")
        public String home() {
            return "home";
        }

        @RequestMapping("/calculator")
        public String calculator() { return "calculators/calculator"; }
        
        @RequestMapping("/advanced")
        public String advancedHome() {
            return "calculators/advanced-calculator";
        }
        
        @RequestMapping("/fractions")
        public String fractions() {
            return "calculators/fractions-calculator";
        }
        
        @RequestMapping("/contact")
        public String contact() {
            return "contact";
        }
        
        @RequestMapping("/logging")
        public String logging() {
            return "logging";
        }    
        
        @RequestMapping("/registration")
        public String registration() {
            return "registration";
        }

        @PostMapping("/calculator")
        public String doCalculation(Model model, CalculatorForm form, BindingResult binding) {
            if ((binding.hasErrors()) || ((form.getX()==null) || (form.getY()==null))) {
                return "calculators/calculator";
            }
            
            double result=0;
            switch(form.getOperation()) {
                case "+":
                    result=calculatorService.add(form.getX(), form.getY());
                    break;
                case "-":
                    result=calculatorService.subtract(form.getX(), form.getY());
                    break;
                case "*":
                    result=calculatorService.multiply(form.getX(), form.getY());
                    break;
                case "/":
                    if(form.getY()==0) {
                        return "calculators/calculator";
                    }
                    else
                    result=calculatorService.division(form.getX(), form.getY());
                    break;
            }
                      
            model.addAttribute("form", form);
            model.addAttribute("result", result);
            
            return "calculators/calculator";
        }
        
        @PostMapping("/advanced")
        public String doAdvancedCalculation(Model model, CalculatorForm form, BindingResult binding) {
            if (binding.hasErrors() || form.getX()==null) {
                return "calculators/advanced-calculator";
            }
            double result=0;
            switch(form.getOperation()) {
                case "sqrt":
                    result=calculatorService.sqrt2(form.getX());
                    break;
                case "^2":
                    result=calculatorService.secondPower(form.getX());
                    break;
                case "%":
                    result=calculatorService.percent(form.getX());
                    break;
                case "!":
                    result=(double)calculatorService.factorials(form.getX().intValue());
                    break;
                case "sin":
                    result=calculatorService.sine(form.getX());
                    break;
                case "cos":
                    result=calculatorService.cosine(form.getX());
                    break;
                case "tg":
                    result=calculatorService.tangent(form.getX());
                    break;
                case "ln":
                    result=calculatorService.logarithm(form.getX());
                    break;
                   
            }
            
            model.addAttribute("form", form);
            model.addAttribute("result", result);
            
            return "calculators/advanced-calculator";
        
        }
        
        @PostMapping("/fractions")
        public String doFractionsCalculation(Model model, FractionsForm form, BindingResult binding, String myError) {
            int resultWhoNum, resultNum, resultDen;
            myError=null;
            if (binding.hasErrors()) {
                return "calculators/fractions-calculator";
            }
            else {
                switch(form.getOperation()) {
                    case "+":
                        fractionsService.add(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                    case "-":
                        fractionsService.subtract(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                    case "*":
                        fractionsService.multiply(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                    case "/":
                        fractionsService.division(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                }
            }
            resultWhoNum=fractionsService.wholeNumber;
            resultNum=fractionsService.numerator;
            resultDen=fractionsService.denominator;
            myError=fractionsService.myError;
            
            model.addAttribute("form", form);
            model.addAttribute("resultWhoNum", resultWhoNum);
            model.addAttribute("resultNum", resultNum);
            model.addAttribute("resultDen", resultDen);
            model.addAttribute("myError", myError);
            
                        
            return "calculators/fractions-calculator";
        }    
        
        @GetMapping("/calculator")
        public String doCalculation(CalculatorForm form) {
            return "calculators/calculator";
        }

        @GetMapping("/advanced")
        public String doAdvancedCalculation(CalculatorForm form) {
            return "calculators/advanced-calculator";
        }
        
        @GetMapping("/fractions")
        public String doFractionsCalculation(FractionsForm form) {
            return "calculators/fractions-calculator";
        }

        @RequestMapping("/basics-list")
        public String showBasicsList() {
            return "fractions_basics/basics-list";
        }

        @RequestMapping("/operations-list")
        public String showOperationsList() {return "fractions_operations/operations-list";
        }

        @RequestMapping("/additions-list")
        public String showAdditionsList() {return "fractions_additions/additions-list";
        }

        @RequestMapping("/build")
        public String buildFraction() { return "fractions_basics/build";
        }

        @RequestMapping("/read")
        public String readFraction() {
            return "fractions_basics/read";
        }

        @RequestMapping("/quotient")
        public String showQuotient() {
            return "fractions_basics/quotient";
        }

        @RequestMapping("/types")
        public String showTypes() {
            return "fractions_basics/types";
        }

        @RequestMapping("/mixed-to-improper")
        public String changeToImproper() {
            return "fractions_basics/mixed-to-improper";
        }

        @RequestMapping("/improper-to-mixed")
        public String changeToMixed() {
            return "fractions_basics/improper-to-mixed";
        }

        @RequestMapping("/expanding")
        public String expandingFraction() {
            return "fractions_basics/expanding";
        }

        @RequestMapping("/reduce")
        public String reduceFraction() {
            return "fractions_basics/reduce";
        }

        @RequestMapping("/common-denominator")
        public String findCommonDenominator() {
            return "fractions_basics/common-denominator";
        }

        @RequestMapping("/compare")
        public String compareFractions() {
            return "fractions_basics/compare";
        }

        @RequestMapping("/addition-easy")
        public String addEasyFractions() {
            return "fractions_operations/addition-easy";
        }

        @RequestMapping("/addition")
        public String addFractions() {
            return "fractions_operations/addition";
        }

        @RequestMapping("/subtraction-easy")
        public String subtractEasyFractions() {
            return "fractions_operations/subtraction-easy";
        }

        @RequestMapping("/subtraction")
        public String subtractFractions() {
            return "fractions_operations/subtraction";
        }

        @RequestMapping("/subtraction-special")
        public String subtractSpecialFractions() {
            return "fractions_operations/subtraction-special";
        }

        @RequestMapping("/multiplication-by-number")
        public String multiplyFractionByNumber() {
            return "fractions_operations/multiplication-by-number";
        }

        @RequestMapping("/multiplication")
        public String multiplyFractions() {
            return "fractions_operations/multiplication";
        }

        @RequestMapping("/reciprocal")
        public String findReciprocal() {
            return "fractions_operations/reciprocal";
        }

        @RequestMapping("/division")
        public String divideFractions() {
            return "fractions_operations/division";
        }

        @RequestMapping("/fraction-of-number")
        public String calculateFractionOfNumber() {
            return "fractions_additions/fraction-of-number";
        }

        @RequestMapping("/fraction-to-decimal-easy")
        public String changeFractionToDecimalEasy() {
            return "fractions_additions/fraction-to-decimal-easy";
        }

        @RequestMapping("/fraction-to-decimal")
        public String changeFractionToDecimal() {
            return "fractions_additions/fraction-to-decimal";
        }

        @RequestMapping("/about-fractions")
        public String readAboutFractions() {
            return "fractions_additions/about-fractions";
        }


//        String trivia;
//
//        public void getTriviaAboutNumber() {
//            RestTemplate restTemplate = new RestTemplate();
//            JsonNode myTrivia = restTemplate.getForObject("http://numbersapi.com/random?json", JsonNode.class).get("text");
//            trivia = myTrivia.asText("moja ciekawostka");

//        }
//
//        @GetMapping("/trivia")
//        public String getTrivia(Model model) {
//            getTriviaAboutNumber();
//            model.addAttribute("trivia", trivia);
//            System.out.println(trivia);
//            return "trivia";
//        }
}