Feature:adminUI



  Scenario: Admin signs in with the right credentials

    When the client after auth "GET" "/user/checkUserExistence?email=mohammadaker6@gmail.com"

    Then the client receives status code of 200

    When the client after auth "POST" "/user/checkPassword?email=mohammadaker6@gmail.com&password=123"
    Then the client receives status code of 200


  Scenario: Admin tries to get user

    When the client after auth "GET" "/user/getUser?email=mohammadaker6"

    Then the client receives status code of 200






  Scenario: Admin signs in with the right credentials and tries to get all reservations

    When the client after auth "GET" "/rent/getAllRent"

    Then the client receives status code of 200


  Scenario: Admin signs in with the right credentials and tries to get all users

    When the client after auth "GET" "/user/"

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




  Scenario: Admin tries to accept an ad from owner

    When the client after auth "PUT" "/residence/acceptAd?id=3"

    Then the client receives status code of 200



  Scenario: Admin tries to decline an ad from owner

    When the client after auth "PUT" "/residence/declineAd?id=3"

    Then the client receives status code of 200



  Scenario: Adding a User to the Database
    When the client calls "/user/saveUser" with the request body:
    """
    {
      "email": "newuser@example.com",
      "password": "securepassword",
      "firstName": "John",
      "lastName": "Doe",
      "phoneNumber": "+123456789",
      "alternatePhoneNumber": "+987654321",
      "universityMajor": "Computer Science",
      "workPlace": "Tech Company",
      "age": 30,
      "userType": 1
    }
    """
    Then the client receives status code of 202


  Scenario: Admin tries to approve a residence

    When the client after auth "PUT" "/residence/admin-approval?id=3&adminApproval=0"

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
