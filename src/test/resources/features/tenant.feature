Feature: tenantUI

  Scenario: Tenant signs in with the right credentials and tries to get all ads

    When the client after auth "GET" "/residence/getResidencesForAdsUser"

    Then the client receives status code of 200





  Scenario: Tenant signs in with the right credentials and tries to get all residences

    When the client after auth "GET" "/residence/getAll"

    Then the client receives status code of 200
