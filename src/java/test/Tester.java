package test;

import db.dbFacade;
import entity.Country;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        dbFacade facade = new dbFacade();
        
        List<Country> countries = facade.getCountries();
        
        for (Country country : countries) {
            System.out.println(country.getName());
        }
    }
}
