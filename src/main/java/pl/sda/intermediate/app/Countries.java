package pl.sda.intermediate.app;

import lombok.Getter;

@Getter
public enum Countries {

    POLAND("Polska", "PL"),
    USA("USA", "US"),
    GERMANY("Niemcy","DE"),
    FRANCE("Francja", "FR");

    String countryName;
    String symbol;

    Countries(String countryName, String symbol){
        this.countryName = countryName;
        this.symbol = symbol;
    }
}
