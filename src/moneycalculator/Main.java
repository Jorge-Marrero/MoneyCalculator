package moneycalculator;

import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.rest.RestExchangeRateLoader;
import moneycalculator.persistence.files.FilesCurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.control.CalculateCommand;

public class Main {
    public static void main(String[] args){
        CurrencyListLoader currencyLoader = new FilesCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }
}
