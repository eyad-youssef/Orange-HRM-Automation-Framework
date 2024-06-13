Feature: Login

  @HRM
  Scenario Outline: Create New User By Admin And Login With The New User
    Given Admin login with "<adminUsername>" and "<adminPassword>" to OrangeHRM login page
    And Click on Admin
    And Count Users Records
    And Click on Add button
    And Select User Role with "<userRole>"
    And Enter employee name with "<employeeName>"
    And Select Status with "<status>"
    And Enter Username with"<username>"
    And Enter Password with"<password>"
    And Enter Confirmed Password with"<confirmedPassword>"
    Then Click on Save Button
    And Count Users Records after adding new user

    Examples:
      | adminUsername | adminPassword | userRole | employeeName | status  | username           | password           | confirmedPassword  |  |  |
      | Admin         | admin123      | ESS      | Orange Test  | Enabled | OrangeMahaTest8888 | OrangeMahaTest8888 | OrangeMahaTest8888 |  |  |



    Scenario Outline: Delete new User
      Given Admin login with "<adminUsername>" and "<adminPassword>" to OrangeHRM login page
      And Click on Admin
      And Enter Username with"<username>"
      And Click on Search Button
      And Click on delete icon
      Then Get new users count
      Examples:
        | adminUsername | adminPassword | username |
        | Admin         | admin123      | Username |

