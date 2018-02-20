## Project: REBUY
## EPIC: https://www14.v1host.com/Macyscom/Default.aspx?menu=EpicsPortfolioPlanningPage&feat-nav=m1
## Date updated: 9th May 2017

Feature: Verify the functionality of rebuy button for eligible products in order history page and order details page

  @scenario1 @domain_customer_management @use_wip
  Scenario: Verify "buy again" button visible on Order Details page for each eligible line item.
    Given I visit the web site as a registered user
    And I associate "rebuy-eligible-delivered" order in db
    When I navigate to order details page as a "signed in" user
    Then I should see "buy again" button
    Then I should see repurchase dialog box opens

  @scenario2 @domain_customer_management @use_wip
  Scenario: Verify "buy again" button is not visible on Order Details page for non-eligible line items.
    Given I visit the web site as a registered user
    And I associate "processing" order in db
    When I navigate to order details page as a "signed in" user
    Then I should not see "buy again" button

  @scenario3 @domain_customer_management @use_wip
  Scenario: Verify "buy again" button visible on Order details page for each line item on lower right corner.
    Given I visit the web site as a registered user
    And I associate "rebuy-eligible-delivered" order in db
    When I navigate to order details page as a "signed in" user
    Then I should see "buy again" button on lower right corner of line item for eligible line items.

  @scenario4 @domain_customer_management @use_wip
  Scenario: Verify "buy again" button visible on Order details page as a guest user
    Given I visit order history page as a guest user
    When I select "rebuy-eligible-delivered" order as a "guest" user
    And I lookup with order number and emailaddress in OH page
    Then I should see "buy again" button
    When I click on "buy again" button
    Then I should see repurchase dialog box opens

  @scenario5 @domain_customer_management @use_wip
  Scenario: Verify "buy again" button visible on Order History page as a guest user with zipcode lookup on order history page
    Given I visit order history page as a guest user
    When I select "intransit" order as a "guest" user
    And I lookup with order number and zipcode in OH page
    Then I should see "buy again" button
    When I click on "buy again" button
    Then I should see repurchase dialog box opens