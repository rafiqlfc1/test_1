@all
Feature:

  @testcase_01
  Scenario Outline: Register to the app

    Given Register to the application using "<UserName>" and "<Password>"
    Given Login to the application using "<UserName>" and "<Password>"

    Examples:
      | UserName                | Password |
      | test1658486491@test.com | 123456   |


  @testcase_02
  Scenario: Check the products in each category
    Given Login to the application using "test165848649@test.com" and "123456"
    When Check the products in each category


  @testcase_03
  Scenario: Add random item to cart and remove it
    Given Login to the application using "test165848649@test.com" and "123456"
    Then Add specific Item to cart
    Then Go to Cart
    Then Remove the added Item from cart


  @testcase_04
  Scenario Outline: Complete successful checkout
    Given Login to the application using "test165848649@test.com" and "123456"
    Then Add specific Item to cart
    Then Go to Cart
    Then Purchase the Item and add "<Name>", "<Country>", "<City>", "<Card>", "<Month>" and "<Year>"

    Examples:
      | Name | Country | City | Card | Month | Year |
      | test | test    | test | test | test  | test |