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

### Coursework

This is the final project from the [Software Construction: Object-Oriented Design](https://www.edx.org/course/software-construction-object-oriented-design) course from [UBC](https://www.ubc.ca/). The course is the fourth of six that form the [Software Development MicroMasters](https://www.edx.org/micromasters/ubcx-software-development) Program on edX.

![Twitter Mapper](./data/twitter_mapper.png?raw=true)