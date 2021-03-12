package com.example.weather_cuongtrinh;

public class Item {
    private int id;
    private String DateTime;
    private String IconPhrase;
    private Temperature Temperature;
    private int WeatherIcon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public com.example.weather_cuongtrinh.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.weather_cuongtrinh.Temperature temperature) {
        Temperature = temperature;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }
}
