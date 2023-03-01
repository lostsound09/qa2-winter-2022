package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.junit.jupiter.api.Assertions;
import tickets.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import requesters.TicketRequester;
import tickets.pages.ConfirmationPage;
import tickets.pages.HomePage;
import tickets.pages.PassengerInfoPage;
import tickets.pages.SelectSeatPage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class TicketStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; //null
    private PassengerInfoPage infoPage;
    private SelectSeatPage selectSeatPage;
    private ConfirmationPage confirmationPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi; //null
    private BaseFunc baseFunc = new BaseFunc();

    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    @Given("flight info:")
    public void set_flight_info(Map<String, String> params) {
        flightInfo = new FlightInfo(params.get("destination"), params.get("departure"), params.get("discount"), Integer.parseInt(params.get("adults")), Integer.parseInt(params.get("kids")), Integer.parseInt(params.get("bags")), params.get("flight_date"), Integer.parseInt(params.get(("seat"))));
    }
    @Given("passenger info is:")
            public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("first_name"), params.get("last_name"));
        flightInfo.setPassenger(passenger);
    }
    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }
    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        infoPage = new PassengerInfoPage(baseFunc);
    }
    @Then("selected airports appear on the next page")
    public void check_airports() {
        infoPage.assertFromAirportEquals(flightInfo.getDeparture());
        infoPage.assertToAirportEquals(flightInfo.getDestination());
    }

    @When("we are requesting reservation data")
    public void request_reservations() throws JsonProcessingException {
        TicketRequester requester = new TicketRequester();
        reservations = requester.getReservations();

    }
    @Then("current reservation is in the list")
    public void find_reservation() {
        for (Reservation r : reservations) {
            if (r.getName().equals(flightInfo.getPassenger().getFirstName())) {
                reservationFromApi = r;
                break;
            }
        }
        Assertions.assertNotNull(reservationFromApi, "Reservation is not found!");
    }

    @When("we are filling in passenger registration form")
    public void we_are_filling_in_passenger_registration_form() {
        infoPage.typeFirstName(flightInfo.getPassenger().getFirstName());
        infoPage.typeLastName(flightInfo.getPassenger().getLastName());
        infoPage.typeDiscountCode(flightInfo.getDiscount());
        infoPage.typeAdultCount(Integer.toString(flightInfo.getAdultCount()));
        infoPage.typeChildrenCount(Integer.toString(flightInfo.getChildCount()));
        infoPage.typeBagCount(Integer.toString(flightInfo.getBagsCount()));
        infoPage.selectFlightDay(flightInfo.getFlightDate());
    }
    @When("requesting price")
    public void requesting_price() {
        infoPage.clickGetPriceButton();
        selectSeatPage = new SelectSeatPage(baseFunc);
    }
    @Then("passenger name and airports appear")
    public void passenger_name_and_airports_appear() {
        selectSeatPage.assertFromAirportEquals(flightInfo.getDeparture());
        selectSeatPage.assertToAirportEquals(flightInfo.getDestination());
        selectSeatPage.assertFirstNameEquals(flightInfo.getPassenger().getFirstName());
    }
    @Then("price is {int} EUR")
    public void price_is_eur(Integer price) {
        selectSeatPage.assertPriceEquals(price);
    }
    @When("we are pressing book button")
    public void we_are_pressing_book_button() {
        selectSeatPage.clickBookButton();
    }
    @When("selecting seat")
    public void selecting_seat() {
        selectSeatPage.clickSeatButton(flightInfo.getSeatNr());
    }
    @Then("correct seat number appears")
    public void correct_seat_number_appears() {
        selectSeatPage.assertSeatEquals(flightInfo.getSeatNr());
    }
    @When("we are booking selected ticket")
    public void we_are_booking_selected_ticket() {
        selectSeatPage.clickBookConfirmationButton();
        confirmationPage = new ConfirmationPage(baseFunc);
    }
    @Then("successful registration message appears")
    public void successful_registration_message_appears() {
        confirmationPage.assertBookingSuccessful();
    }
    @Then("all reservation data is correct")
    public void check_reservation_data() {
        Assertions.assertEquals(flightInfo.getDeparture(), reservationFromApi.getAfrom());
        Assertions.assertEquals(flightInfo.getDestination(), reservationFromApi.getAto());
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), reservationFromApi.getName());
        Assertions.assertEquals(flightInfo.getPassenger().getLastName(), reservationFromApi.getSurname());
        Assertions.assertEquals(flightInfo.getBagsCount(), reservationFromApi.getBagCount());
        Assertions.assertEquals(flightInfo.getDiscount(), reservationFromApi.getDiscount());
        Assertions.assertEquals(Integer.toString(flightInfo.getChildCount()), reservationFromApi.getChildren());
        Assertions.assertEquals(flightInfo.getFlightDate(), reservationFromApi.getFlight());
        Assertions.assertEquals(Integer.toString(flightInfo.getAdultCount()), reservationFromApi.getAdults());
        Assertions.assertEquals(flightInfo.getSeatNr(), reservationFromApi.getSeat());
    }
}
