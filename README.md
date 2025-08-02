# Automating Webpages using Selenium & TestNG
In this project, I have used Selenium & TestNG following the Page-Object-Model(POM) to automate features of the https://dailyfinance.roadtocareer.net/, read and store datas from .CSV

## Technologies Used
- Java
- Selenium-Java (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java implementation("org.seleniumhq.selenium:selenium-java:4.31.0"))
- TestNG (https://mvnrepository.com/artifact/org.testng/testng testImplementation group: 'org.testng', name: 'testng', version: '7.10.2')
- Java-Faker (https://mvnrepository.com/artifact/com.github.javafaker/javafaker implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2')
- Json-Simple (https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1')
- Apache-Commons (https://mvnrepository.com/artifact/org.apache.commons/commons-csv implementation group: 'org.apache.commons', name: 'commons-csv', version: '1.12.0')
- Allure-Testing (https://mvnrepository.com/artifact/io.qameta.allure/allure-testng implementation group: 'io.qameta.allure', name: 'allure-testng', version: '2.29.0')
## Prerequisites
- Selenium Webdriver
- TestNG Framework
- Java
- Gradle
- Intellij idea
- Allure
## Description:
1. Visit the site https://dailyfinance.roadtocareer.net/. Register a new user (e.g. gmailuser+randomdigit@gmail.com). Assert the congratulations email is received.
2. Now click on the reset password link. Write 2 negative test case and assert. 
3. Now Input valid gmail account you have registered and click on send reset link button
4. Now retrieve password reset mail from your gmail and set new password
5. Now login with the new password to ensure login successful
6. Add random 2 items (1 for all fields, another for only mandatory fields) and assert 2 items are showing on the item list
7. Now go to user profile and update user gmail with a new gmail
8. Now logout and login with the updated gmail account. Assert that using new email login is successful and using previous email login is failed.
9. Now logout again and login with the admin account. Admin credential must be sent from the terminal securely.
10. Search by the updated gmail and Assert that updated user email is showing on admin dashboard.
11. Now register more 3 users getting data from a CSV file
12. Now login as admin and get all the users from user table and write them in a text file.
## Test Cases:
https://docs.google.com/document/d/1xUMidhGszPaPEp92BsoBKQV8KgTZx-N_/edit
## Allure Reports
<img width="1912" height="802" alt="Screenshot_3" src="https://github.com/user-attachments/assets/c60afaad-3164-430a-b53d-7106070429f9" />

<img width="1059" height="947" alt="Screenshot_2" src="https://github.com/user-attachments/assets/2588a28d-d31a-4712-9fdd-6269f701ab2e" />

<img width="1056" height="723" alt="Screenshot_1" src="https://github.com/user-attachments/assets/6fb71672-db6f-47cd-b8dc-8544a28729db" />
## Output Vedio:


https://github.com/user-attachments/assets/423ec002-274a-4737-bef0-a611b7fcd022


