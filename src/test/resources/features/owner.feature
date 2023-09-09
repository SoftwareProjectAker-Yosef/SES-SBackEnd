Feature:ownerUI

  Scenario: Owner signs in with the right credentials and tries to get all ads

    When the client after auth "GET" "/residence/getResidencesForAdsUser"

    Then the client receives status code of 200



  Scenario: Owner signs in with the right credentials and tries to get a specific residence

    When the client after auth "GET" "/residence/test?id=3"

    Then the client receives status code of 200




  Scenario: Owner signs in with the right credentials and tries to get a specific residence

    When the client after auth "GET" "/residence/test?id=3"

    Then the client receives status code of 200


  Scenario: Owner signs in with the right credentials and tries to get all his residences

    When the client after auth "GET" "/residence/getOwnerHouses?ownerEmail=mohammadaker6@gmail.com"

    Then the client receives status code of 200


  Scenario: Owner signs in with the right credentials and tries to request for an ad

    When the client after auth "PUT" "/residence/requestAd?id=3"

    Then the client receives status code of 200



  Scenario: Owner signs in with the right credentials and tries to get reservations made on his residences

    When the client after auth "GET" "/rent/getOwnerReservations?email=mohammadaker6@gmail.com"

    Then the client receives status code of 200


  Scenario: Adding a Residence to the Database
    When the client calls "/residence/saveResidence" with the request body:
    """
    {
      "ownerEmail": "owner@example.com",
      "price": 200000,
      "location": "123 Main St",
      "country": "United States",
      "city": "New York",
      "area": 1233,
      "adminApproval": 2,
      "description": "Modern apartment with city view",
      "floorCount": 10,
      "bedrooms": 2,
      "bathrooms": 2,
      "services": ["gym", "pool", "security"],
      "images": ["image1.jpg", "image2.jpg"]
    }
    """
    Then the client receives status code of 202