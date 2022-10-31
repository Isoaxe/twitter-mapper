# Twitter Mapper

Search for tweets based on keywords and see the results displayed on a world map.

### Usage

The app currently works using playback data. To use live data, it would have to be reconfigured to use the Twitter api v2 as v1.1 has been [retired completely](https://twittercommunity.com/t/deprecation-announcement-removing-compliance-messages-from-statuses-filter-and-retiring-statuses-sample-from-the-twitter-api-v1-1/170500) as of 31st October 2022. This is outside the scope of this course and has not been done.

#### Using Playback Data

This sets up the project to play back a cached Twitter feed. It is therefore not required to connect to the Twitter api as live data isn't being used.

1. To get going, first fork this repository.
2. Then download [IntelliJ Idea](https://www.jetbrains.com/idea/) or similar IDE for running the program.
3. After installation, click the `open` button from the IntelliJ window and select the project directory.
4. `ctrl-click` the `Application` file in the `ui` package and select `Run 'main'`.
5. The graphics canvas will open and display a world map. A user can then enter search terms via the UI to display relevant tweets with the tweet origin being shown on the map.

#### Using Live Data

To use live data in the app, the above steps need to be done followed by those below.

1. Reconfigure the code to implement Twitter api v2 as v1.1 has been depreciated.
2. Create a Twitter account if you don't already have one.
3. Apply for a [developer](https://apps.twitter.com/) account. Fill out the questionnaire and await approval. This could take a couple of days.
4. Once granted, create a new app from the Twitter console, then set up user authentication from within it.
5. Pass the Twitter OAuth key, token and secrets to [`initializeTwitterStream`](https://github.com/Isoaxe/twitter-mapper/blob/main/src/twitter/LiveTwitterSource.java#L47-L50).

### Coursework

This is the final project from the [Software Construction: Object-Oriented Design](https://www.edx.org/course/software-construction-object-oriented-design) course from [UBC](https://www.ubc.ca/). The course is the fourth of six that form the [Software Development MicroMasters](https://www.edx.org/micromasters/ubcx-software-development) Program on edX.

![Twitter Mapper](./data/twitter_mapper.png?raw=true)