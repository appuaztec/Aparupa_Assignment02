Feature: Booking a flight in Goibibo.com

  Background: Launch to GoIbibo

  @single
  Scenario Outline:  Single Trip Goibibo Booking
    Given User in GoIbibo page
    And choose type of travel "One way"
    And Select source "<Source>", "<Destination>" and "<Departure Date>"
    And Select the traveller details "<adult>", "<children>" and "<infants>"
    And Select travel classtype "<class>"
    And Click on Search
    And find the cheapest price and click on Book now button
    Then Verify the details on Review page
#
    Examples:
      | Source  | Destination | Departure Date | adult | children | infants | class   |
      | Kolkata | Bengaluru   | 28/Aug/2020    | 1     | 0        | 0       | Economy |


  @round
  Scenario Outline:  Round Trip Goibibo Booking
    Given User in GoIbibo page
    And choose type of travel "Round Trip"
    And Select source "<Source>", "<Destination>" and "<Departure Date>" , "<Arrival Time>"
    And Select the traveller details "<adult>", "<children>" and "<infants>"
    And Select travel classtype "<class>"
    And Click on Search
    And find the cheapest price for both flights and click on Book now button
    Then Verify the details for both flights on Review page
#
    Examples:
      | Source  | Destination | Departure Date | Arrival Time | adult | children | infants | class   |
      | Kolkata | Bengaluru   | 28/Aug/2020    | 01/Sep/2020  | 1     | 0        | 0       | Economy |


#  Scenario Outline: MULTI CITY Trip Goibibo Booking
#    Given User in GoIbibo page
#    And choose type of travel "Multi City"
#    And Select the traveller details "<adult>", "<children>" and "<infants>"
#    And Select travel classtype "<class>"
#    And Select source, destinations and departure date
#      | source | destination | departure date |
#      | place1 | place2      | dd             |
#      | place2 | place3      | dd             |
#    And Click on Search
#    And find the cheapest price and click on Book now button
#    Then Verify the details on Review page
#
#    Examples:
#      | adult | children | infants | class   |
#      | 1     | 0        | 0       | Economy |

