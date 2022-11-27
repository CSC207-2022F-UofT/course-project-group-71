# Project Description

The program allows event organizations to post their scheduled events and let participants join the events.
There are two different kinds of users, which are participants and organizations. They use separate databases and can choose to register or login separately by selecting radio buttons.
The participants can use the search bar through all available events and join the event, they can also delete the joined event. The participants can also choose to follow the organizers to be alerted by new coming events. After joining, they’ll get the notification before the event which sent by the organizations.
By signing in organizations’ accounts, they can see all events scheduled (published, unpublished, or past events), and number of followers. Organizations can also create events by filling in event’s title, place, description and time. The created event will be saved in the unpublished event page and they’ll need to “Publish” the event to make the event can be searched by the participants. They can also notify the participants who joined the event by clicking the “notify” button.
In participants’ accounts, they can see all events they have registered (past or future) and the organizations that they followed.

*Special Case to consider: We are using MySQL and DataGrip for data storage. Details will be explianed in the Database section.*
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
But from the concept perspective, we have *event*, *organization*, and *participant* to be responsible for the Enterprise Business Rules.

Only for demonstration purposes, each of those has the following attributes:

- Event
  - String organization: the username of the organization who launched the event.
  - String title: the title of the event.
  - *editable* String description: the description of the event.
  - *editable* String location: the location of the event.
  - *editable* ArrayList<Integer\> time: the time of the event, consists of year, month, day, hour, minute.
- Organization
  - String username: the username of the organization.
  - *editable* String password: the password of the organization.
  - *editable* ArrayList<String\> unpublishedEvents: the titles of events in the "draft box" of the organization. The organization can create new events. The organization can choose to change any information of existing events except for their title. The organization can also choose to delete the events here.
  - *editable* ArrayList<String\> upcomingEvents: the titles of events that are published by the organization from the "draft box". At this point, the organization cannot change any information about the events, but can choose to delete them.
  - ArrayList<String\> pastEvents: the titles of events which are published and whose time are in the past (comparing with system time by LocalDateTime).
  - ArrayList<String\> followers: the usernames of the organization's followers (all are participants).
- Participant 
  - String username: the username of the participant.
  - *editable* String password: the password of the participant.
  - *editable* ArrayList<String\> upcomingEvents: the titles of events that are published by the organization from the "draft box". At this point, the organization cannot change any information about the events, but can choose to delete them. 
  - ArrayList<String\> pastEvents: the titles of events which the participant joined and whose time are in the past (comparing with system time by LocalDateTime)
  - *editable* ArrayList<String\> followedOrganizations: the usernames of the participant's followed Organizations. The participant can choose to unfollow any of them.


*"*editable*" means the value of attribute can be changed by the user through means provided on UI.*


## Use Cases

All folders ending with use_case are the use cases of the project.
Each consists of 5 types of class/interface: InputBoundary, Interactor, OutputBoundary, RequestModel, ResponseModel (except for extract_information_use_case).
The use case

There are a few special use cases that are used in more than one place in the project:
- extract_information_use_case: This is designed to assist views to show information stored in the database for Clean Architecture purposes. It is not tied to any specific type of user or screen.
- upcoming_to_past_use_case: This is an auto-triggered use case that do not need the user to explicitly demand for it. It will convert the user's all relevant upcoming events whose time is in the past (comparing with system time by LocalDateTime) to past events.
- notify_event_use_case: This is used to notify the user about changes or updates of relevant events. It can be called in various places in the project as the function is so commonly used.

## Database
`src/main/java/database`

The database folder consists of 3 DsGateways and 3 FileUsers for event, organization, and participant. The FileUsers are directly connected to DataGrip. The guide for installing DataGrip and using the test database is at the end of this file.

Explain ALL tables in DataGrip, what does each of them do.