Meta:

Narrative:
As a user
I want to access Music Youtube
So that I can login, search and use any feature on Music Youtube

Scenario: Make sure user can Sign in using Google Account on Music Youtube
Given I want login to Music Youtube
When I input valid username and password
Then I success login to Music Youtube using valid username and password google account

Scenario: User use search feature with condition login or without login first
Given I want search music on Music Youtube with condition login or without login first <condition>
When I input keyword <key> music on feature search
Then searching music success and valid with keyword <key>
Examples:
|condition  |key|
|login      |Restoe Boemi (feat. Virzha)|
|without    |Restoe Boemi (feat. Virzha)|

Scenario: User can find out New Releases, Charts, Mood & Genre of music on explore page with condition login or without login first
Given I want access explore page music on Music Youtube with condition login or without login first <condition>
When I access submenu <submenu> on explore page
Then I success access submennu <submenu> on explore page for find out New Releases, Charts, Mood & Genre of music with condition login or without login first
Examples:
|condition      |submenu|
|login          |New releases|
|login          |Charts|
|login          |Moods & genres|
|without        |New releases|
|without        |Charts|
|without        |Moods & genres|

Scenario: User can find out Music on his Library
Given I have logged in music youtube using a valid account
When I access menu library on Music Youtube
Then I success access menu library and find out his Playlist, Song, Album, Artis and Subscribtions

Scenario: User can't find out Music on his Library without having to sign in first
Given I have not sign in first on music youtube
When I access menu library on Music Youtube
Then System will directed to form payment for subscriptions Music Youtube

Scenario: Search and Subscribe a Channel Music Youtube
Given I have logged in music youtube using a valid account
When I search and subscribe a channel music youtube <channelname>
Then I success search and subscribe a channel music youtube
Examples:
|channelname|
|NOAH|

Scenario: Like or Dislike a Music Youtube
Given I have logged in music youtube using a valid account
When I search a channel music youtube for like or dislike <param>
Then I success like or dislike a channel music youtube <param>
Examples:
|param|
|Like|
|Dislike|

Scenario: User can sign out from Music Youtube
Given I have logged in music youtube using a valid account
When I access avatar logo and click sign out
Then I success sign out from Music Youtube