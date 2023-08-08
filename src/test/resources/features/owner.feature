Feature:ownerUI

  Scenario: Owner signs in with the right credentials and tries to get all ads

    When the client after auth "GET" "/residence/getResidencesForAdsUser"

    Then the client receives status code of 200




