# Project Description

This is an event-ticketing platform that connects participants and organizations.
As an organization, user can create, edit, publish, new events; as a participant, user can search, join upcomin

## Starter File
`src/main/java/tutorial/HellowWord`

There are 3 static variables in the class:

- databaseUrl = "jdbc:mysql://localhost:3306/db2"
  - This is used for finding the database located in DataGrip.
- databaseUsername = "root"
  - This is the default username of your database, usually you will not need to change it.
- databasePassword = "vvks1309"
  - This is the password of your database, you need to set it when you are registering your account for your database.

The get methods of the above 3 static variables are used by `src/main/java/database`, these variables will be held fixed for all operations.

## Entities

We do not have the entities structure as we are using MySQL to store our data.
But from the concept perspective, we have *event*, *organization*, and *participant* to bear the Enterprise Business Rules.

## Use Cases

All folders ending with use_case are the use cases of the project.
Each consists of 5 types of class/interface: InputBoundary, Interactor, OutputBoundary, RequestModel, ResponseModel (except for extract_information_use_case).
The use case

There are a few special use cases:
- extract_information_use_case: This is designed to assist views to show information stored in the database. (Clean Architecture purposes)
- upcoming_to_past_use_case: This is an auto-triggered use case that do not need the user to explicitly demand

## Database
`src/main/java/database`

The database folder consists of 3 DsGateways and 3 FileUsers for event, organization, and participant. 