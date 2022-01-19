public class Data {
    //temperature in degrees celsius
    private String temperature;
    //humidity in percents
    private String humidity;
    //pressure in hPa
    private String pressure;
    public Data(String temperature, String humidity, String pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

}
