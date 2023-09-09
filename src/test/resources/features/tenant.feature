Feature: tenantUI

  Scenario: Tenant signs in with the right credentials and tries to get all ads

    When the client after auth "GET" "/residence/getResidencesForAdsUser"

    Then the client receives status code of 200





  Scenario: Tenant signs in with the right credentials and tries to get all residences

    When the client after auth "GET" "/residence/getAll"

    Then the client receives status code of 200


  Scenario: Tenant signs in with the right credentials and tries to rent

    When the client after auth "GET" "/rent/getAllRentDates"

    Then the client receives status code of 200




  Scenario: Tenant signs in with the right credentials and tries to get rent dates of a residence

    When the client after auth "GET" "/rent/dates?number=3"

    Then the client receives status code of 200




  Scenario: Tenant signs in with the right credentials and tries to get reservation made by him

    When the client after auth "GET" "/rent/getTenantReservations?email=mohammadaker6"

    Then the client receives status code of 200


  Scenario: Tenant signs in with the right credentials and tries to get a specific furniture piece

    When the client after auth "GET" "/Fur/test?id=2"
    Then the client receives status code of 200




  Scenario: Tenant signs in with the right credentials and tries to get furniture pieces from a specific type

    When the client after auth "GET" "/Fur/getFurtype?type=chair"
    Then the client receives status code of 200



  Scenario: Tenant signs in with the right credentials and tries to rent a residence

    When the client calls "/Fur/saveFur" with the request body:
    """
    {
      "email": "testEmail@gmail.com",
      "type": "Table",
      "description": "Wooden table",
      "price": 100,
      "phone": "+123456789",
      "number": 5,
      "images": ["image1.jpg", "image2.jpg"]
    }
    """
    Then the client receives status code of 202

  Scenario: Adding a Rent to the Database
    When the client calls "/rent/saveRent" with the request body:
    """
    {
      "email": "tenant@example.com",
      "ownerEmail": "owner@example.com",
      "date": "2023-08-10",
      "number": 123
    }
    """
    Then the client receives status code of 202