package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {

    private long cityId;
    private WeatherResponse response;
    @Given("city id is: {int}")
    public void set_city_id(int cityId) {
        this.cityId = cityId;

    }
    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }
    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        Assertions.assertEquals(params.get("latitude"), response.getLat(), "Wrong Lat!");
        Assertions.assertEquals(params.get("longitude"), response.getLon(), "Wrong Lon!");
    }
    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {
        Assertions.assertEquals(params.get("timezone"), response.getTimezone(), "Wrong Timezone!");
        Assertions.assertEquals(params.get("timezoneOffset"), response.getTimezoneOffset(), "Wrong Timezone Offset!");

    }
    @Then("current data is:")
    public void check_current(Map<String, String> params) {
        Assertions.assertEquals(params.get("currentTime"), response.getCurrent().getDt(), "Wrong Day Time!");
        Assertions.assertEquals(params.get("sunrise"), response.getCurrent().getSunrise(), "Wrong Sunrise!");
        Assertions.assertEquals(params.get("sunset"), response.getCurrent().getSunset(), "Wrong Sunset!");
        Assertions.assertEquals(params.get("temperature"), response.getCurrent().getTemp(), "Wrong Temperature!");
        Assertions.assertEquals(params.get("feelsLike"), response.getCurrent().getFeelsLike(), "Wrong Feels like!");
        Assertions.assertEquals(params.get("pressure"), response.getCurrent().getPressure(), "Wrong Pressure!");
        Assertions.assertEquals(params.get("humidity"), response.getCurrent().getHumidity(), "Wrong Humidity!");
        Assertions.assertEquals(params.get("dewPoint"), response.getCurrent().getDewPoint(), "Wrong Dew Point!");
        Assertions.assertEquals(params.get("uvi"), response.getCurrent().getUvi(), "Wrong Uvi!");
        Assertions.assertEquals(params.get("clouds"), response.getCurrent().getClouds(), "Wrong Clouds!");
        Assertions.assertEquals(params.get("visibility"), response.getCurrent().getVisibility(), "Wrong Visibility!");
        Assertions.assertEquals(params.get("windSpeed"), response.getCurrent().getWindSpeed(), "Wrong Wind Speed!");
        Assertions.assertEquals(params.get("windDeg"), response.getCurrent().getWindDeg(), "Wrong Wind Deg!");
        Assertions.assertEquals(params.get("windGust"), response.getCurrent().getWindGust(), "Wrong Wind Gust!");

    }
    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), response.getCurrent().getWeather().get(0).getId(), "Wrong Id!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeather().get(0).getMain(), "Wrong Main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeather().get(0).getDescription(), "Wrong Description!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeather().get(0).getIcon(), "Wrong Icon!");

    }
    @Then("minutely data is:")
    public void check_minutely(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getMinutely().get(0).getDt(), "Wrong Dt!");
        Assertions.assertEquals(params.get("precipitation"), response.getMinutely().get(0).getPrecipitation(), "Wrong Precipitation!");

    }
    @Then("hourly data is:")
    public void check_hourly(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getHourly().get(0).getDt(), "Wrong Dt!");
        Assertions.assertEquals(params.get("temp"), response.getHourly().get(0).getTemp(), "Wrong Temp!");
        Assertions.assertEquals(params.get("feelsLike"), response.getHourly().get(0).getFeelsLike(), "Wrong Feels like!");
        Assertions.assertEquals(params.get("pressure"), response.getHourly().get(0).getPressure(), "Wrong Pressure!");
        Assertions.assertEquals(params.get("humidity"), response.getHourly().get(0).getHumidity(), "Wrong Humidity!");
        Assertions.assertEquals(params.get("dewPoint"), response.getHourly().get(0).getDewPoint(), "Wrong Dew Point!");
        Assertions.assertEquals(params.get("uvi"), response.getHourly().get(0).getUvi(), "Wrong Uvi!");
        Assertions.assertEquals(params.get("clouds"), response.getHourly().get(0).getClouds(), "Wrong Clouds!");
        Assertions.assertEquals(params.get("visibility"), response.getHourly().get(0).getVisibility(), "Wrong Visibility!");
        Assertions.assertEquals(params.get("windSpeed"), response.getHourly().get(0).getWindSpeed(), "Wrong Wind Speed!");
        Assertions.assertEquals(params.get("windDeg"), response.getHourly().get(0).getWindDeg(), "Wrong Wind Deg!");
        Assertions.assertEquals(params.get("windGust"), response.getHourly().get(0).getWindGust(), "Wrong Wind Gust!");
        Assertions.assertEquals(params.get("pop"), response.getHourly().get(0).getWindGust(), "Wrong Wind Gust!");

    }
    @Then("hourly weather data is:")
    public void check_hourly_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), response.getHourly().get(0).getWeather().get(0).getId(), "Wrong Id!");
        Assertions.assertEquals(params.get("main"), response.getHourly().get(0).getWeather().get(0).getMain(), "Wrong Main!");
        Assertions.assertEquals(params.get("description"), response.getHourly().get(0).getWeather().get(0).getDescription(), "Wrong Description!");
        Assertions.assertEquals(params.get("icon"), response.getHourly().get(0).getWeather().get(0).getIcon(), "Wrong Icon!");
    }
    @Then("daily data is:")
    public void check_daily(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getDaily().get(0).getDt(), "Wrong Day Time!");
        Assertions.assertEquals(params.get("sunrise"), response.getDaily().get(0).getSunrise(), "Wrong Sunrise!");
        Assertions.assertEquals(params.get("sunset"), response.getDaily().get(0).getSunset(), "Wrong Sunset!");
        Assertions.assertEquals(params.get("moonRise"), response.getDaily().get(0).getMoonrise(), "Wrong Moonrise!");
        Assertions.assertEquals(params.get("moonSet"), response.getDaily().get(0).getMoonset(), "Wrong Moonset!");
        Assertions.assertEquals(params.get("moonPhase"), response.getDaily().get(0).getMoonPhase(), "Wrong Moon Phase!");
        Assertions.assertEquals(params.get("temperature"), response.getDaily().get(0).getTemp(), "Wrong Temperature!");

    }
    @Then("daily temp data is:")
    public void check_daily_temp(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getDaily().get(0).getTemp().getDay(), "Wrong Day Temp!");
        Assertions.assertEquals(params.get("min"), response.getDaily().get(0).getTemp().getMin(), "Wrong Minimum Temp!");
        Assertions.assertEquals(params.get("max"), response.getDaily().get(0).getTemp().getMax(), "Wrong Maximum Temp!");
        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getTemp().getNight(), "Wrong Night Temp!");
        Assertions.assertEquals(params.get("eve"), response.getDaily().get(0).getTemp().getEve(), "Wrong Evening Temp!");
        Assertions.assertEquals(params.get("morn"), response.getDaily().get(0).getTemp().getMorn(), "Wrong Morning Temp!");
    }
    @Then("daily feels like data is:")
    public void check_daily_feels_like(Map<String, String> params) {
        Assertions.assertEquals(params.get("dt"), response.getDaily().get(0).getFeelsLike().getDay(), "Wrong Day Temp!");
        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getFeelsLike().getNight(), "Wrong Night Temp!");
        Assertions.assertEquals(params.get("eve"), response.getDaily().get(0).getFeelsLike().getEve(), "Wrong Evening Temp!");
        Assertions.assertEquals(params.get("morn"), response.getDaily().get(0).getFeelsLike().getMorn(), "Wrong Morning Temp!");
    }
    @Then("daily weather data is:")
    public void check_daily_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), response.getDaily().get(0).getWeather().get(0).getId(), "Wrong Id!");
        Assertions.assertEquals(params.get("main"), response.getDaily().get(0).getWeather().get(0).getMain(), "Wrong Main!");
        Assertions.assertEquals(params.get("description"), response.getDaily().get(0).getWeather().get(0).getDescription(), "Wrong Description!");
        Assertions.assertEquals(params.get("icon"), response.getDaily().get(0).getWeather().get(0).getIcon(), "Wrong Icon!");
    }

    @Then("following alert recieved:")
    public void check_alert(Map<String, String> params) {
        Assertions.assertEquals(params.get("senderName"), response.getAlerts().get(0).getSenderName(), "Wrong Sender Name!");
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent(), "Wrong Event!");
        Assertions.assertEquals(params.get("start"), response.getAlerts().get(0).getStart(), "Wrong Start!");
        Assertions.assertEquals(params.get("end"), response.getAlerts().get(0).getEnd(), "Wrong End!");
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(0).getDescription(), "Wrong Description!");
    }
    @Then("tags for an alert are:")
    public  void check_tags(List<String> tags) {

    }
}
