# Rank Interactive Interview Test

Basic Casino Backend implementation

## Getting Started

### Dependencies

* Java 1.8
* Gradle 4+

### Installing

* execute ".\gradlew.bat build" from application directory to build required source files

### Executing program

* execute ".\gradlew.bat bootRun" from application directory to start webserver

### Requirements

* Dagacube

Method | Path               | Info
------ | -------------------|-----
GET    | /user/{id}/balance | view users current balance
POST   | /user/{id}/wager   | submit wager for user if promo code is recieved will update user freeGameCount value to reflect
POST   | /user/{id}/deposit | submit winnings to user profile

* Casino

Method | Path               | Info
------ | -------------------|-----
POST   | /user/transaction | View Last 10 transactions for user specified by the given userrname, expects securityKey

## Authors

Craig Atwood

## Version History

* 1.0
    * Initial Release

## License

This project is licensed under the [GNU GENERAL PUBLIC LICENSE] License - see the LICENSE file for details
