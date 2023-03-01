Feature: Ticket reservation
  Scenario: Successful ticket reservation
    Given flight info:
      | destination | SVO    |
      | departure   | RIX    |
      | discount    | CFGCFG |
      | adults      | 2      |
      | kids        | 3      |
      | bags        | 2      |
      | flight_date | 14     |
      | seat        | 27     |


    And passenger info is:
      | first_name  | random     |
      | last_name   | Tester     |


    And home page opened

    When we are selecting airports
    Then selected airports appear on the next page

    When we are filling in passenger registration form

    And requesting price

    Then passenger name and airports appear
    And price is 1055 EUR

    When we are pressing book button
    And selecting seat

    Then correct seat number appears

    When we are booking selected ticket
    Then successful registration message appears

    When we are requesting reservation data
    Then current reservation is in the list
    And all reservation data is correct

