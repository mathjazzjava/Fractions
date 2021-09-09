package com.mathjazz.fractions.model;

import org.springframework.stereotype.Component;

@Component
public class City {

    private MyCity myCity;

    public MyCity getMyCity() {
        return myCity;
    }

    public void setCity(MyCity myCity) {
        this.myCity = myCity;
    }

    public static enum MyCity {
        bialystok("Białystok"), bielskobiala("Bielsko-Biała"), bydgoszcz("Bydgoszcz"),
        czestochowa("Częstochowa"), elblag("Elbląg"), gdansk("Gdańsk"), jeleniagora("Jelenia Góra"),
        kalisz("Kalisz"), katowice("Katowice"), kielce("Kielce"), koszalin("Koszalin"),
        krakow("Kraków"), krosno("Krosno"), legnica("Legnica"), leszno("Leszno"), lubin("Lublin"),
        lodz("Łódź"), nowysacz("Nowy Sącz"), olsztyn("Olsztyn"), opole("Opole"), ostroleka("Ostrołęka"),
        pila("Piła"), plock("Płock"), poznan("Poznań"), przymysl("Przemyśl"), rzeszow("Rzeszów"),
        siedlce("Siedlce"), suwalki("Suwałki"), szczecin("Szczecin"), tarnow("Tarnów"),
        torun("Toruń"), warszawa("Warszawa"), wroclaw("Wrocław"), zamosc("Zamość"), zielonagora("Zielona Góra");

        private final String cityName;

        MyCity(String cityName) {
            this.cityName = cityName;
        }

        public String getCityName() {
            return cityName;
        }

    }
}