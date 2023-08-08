Feature:adminUI



  Scenario: Admin signs in with the right credentials and tries to get all reservations

    When the client after auth "GET" "/rent/getAllRent"

    Then the client receives status code of 200





  Scenario: Admin signs in with the right credentials and tries to get all unaccepted residences

    When the client after auth "GET" "/residence/getAllUnAccepted"

    Then the client receives status code of 200


  Scenario: Admin signs in with the right credentials and tries to get all ad requests

    When the client after auth "GET" "/residence/getResidencesForAdsAdmin"

    Then the client receives status code of 200



  Scenario: Admin signs in with the right credentials and tries to get all furniture

    When the client after auth "GET" "/Fur/getFur"

    Then the client receives status code of 200











#  Scenario: admin sign in with right credentials and tries to get all orders
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/"
#    Then the client receives status code of [200,204]
#
#  Scenario: admin sign in with wrong credentials and tries to get all orders
#    Given 'amr'|'test12'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [401]
#    When the client after auth "GET" "/order/"
#    Then the client receives status code of [401]
#
#  Scenario: admin sign in with right credentials and tries to get orders with name
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/byName?name=carpet"
#    Then the client receives status code of [200,204]
#
#  Scenario: admin sign in with wrong credentials and tries to get orders with name
#    Given 'amr'|'test'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [401]
#    When the client after auth "GET" "/order/byName?name=carpet"
#    Then the client receives status code of [401]
#
#  Scenario: admin sign in with right credentials and tries to get orders with wrong name
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/byName?name=pencil"
#    Then the client receives status code of [204]
#
#
#  Scenario: admin sign in with right credentials and tries to get count of orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/countByDate?date=2023-02-21"
#    Then the client receives status code of [200]
#
#  Scenario: admin sign in with right credentials and tries to get count of unfinished orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/countUnfinished?date=2023-02-21"
#    Then the client receives status code of [200]
#
#  Scenario: admin sign in with right credentials and tries to get sum of unfinished orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/sumUnfinishedByDate?date=2023-02-21"
#    Then the client receives status code of [200]
#
#  Scenario: admin sign in with right credentials and tries to get sum of finished orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/sumFinishedByDate?date=2023-02-21"
#    Then the client receives status code of [200]
#
#
#  Scenario: admin sign in with right credentials and tries to update order status
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/updateStatus?id=1"
#    Then the client receives status code of [200]













#  Scenario: admin sign in with right credentials and tries to get all orders
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/"
#    Then the client receives status code of [200,204]
#
#  Scenario: admin sign in with wrong credentials and tries to get all orders
#    Given 'amr'|'test12'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [401]
#    When the client after auth "GET" "/order/"
#    Then the client receives status code of [401]
#
#  Scenario: admin sign in with right credentials and tries to get orders with name
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/byName?name=carpet"
#    Then the client receives status code of [200,204]
#
#  Scenario: admin sign in with wrong credentials and tries to get orders with name
#    Given 'amr'|'test'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [401]
#    When the client after auth "GET" "/order/byName?name=carpet"
#    Then the client receives status code of [401]
#
#  Scenario: admin sign in with right credentials and tries to get orders with wrong name
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/byName?name=pencil"
#    Then the client receives status code of [204]
#
#
#  Scenario: admin sign in with right credentials and tries to get count of orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/countByDate?date=2023-02-21"
#    Then the client receives status code of [200]
#
#  Scenario: admin sign in with right credentials and tries to get count of unfinished orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/countUnfinished?date=2023-02-21"
#    Then the client receives status code of [200]
#
#  Scenario: admin sign in with right credentials and tries to get sum of unfinished orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/sumUnfinishedByDate?date=2023-02-21"
#    Then the client receives status code of [200]
#
#  Scenario: admin sign in with right credentials and tries to get sum of finished orders before 2023-02-21
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/sumFinishedByDate?date=2023-02-21"
#    Then the client receives status code of [200]
#
#
#  Scenario: admin sign in with right credentials and tries to update order status
#    Given 'amr'|'test123'
#    When the client calls "/api/auth/signin"
#    Then the client receives status code of [200]
#    When the client after auth "GET" "/order/updateStatus?id=1"
#    Then the client receives status code of [200]
