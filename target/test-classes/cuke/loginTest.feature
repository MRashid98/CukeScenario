Feature: loginTest
  Scenario Outline: Login into the demo website
    Given We can access the Demo Website
    When I access the Registration Page 
    And register using "<username>" as the username and "<password>" as the password
    Then I access the Login page
    And login with "<username>" and "<password>"

    Examples: 
      | username  | password | 
      | root 			|   root	 | 
      | MoRash 		|  QAPass  | 
			| userTest	| passTest |