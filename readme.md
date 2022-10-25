# Twitter Mapper

Search for tweets based on keywords and see the results displayed on a world map.

### Usage

1. To get going, first fork this repository.
2. Create a Twitter account if you don't already have one.
3. Apply for a [developer](https://apps.twitter.com/) account. Fill out the questionnaire and await approval. This could take a couple of days.
4. Once granted, create a new app from the Twitter console, then set up user authentication from within it.
5. Pass the Twitter OAuth key, token and secrets to [`initializeTwitterStream`](https://github.com/Isoaxe/twitter-mapper/blob/main/src/twitter/LiveTwitterSource.java#L47-L50).
6. Then download [IntelliJ Idea](https://www.jetbrains.com/idea/) or similar IDE for running the program.
7. After installation, click the `open` button from the IntelliJ window and select the project directory.
8. `ctrl-click` the `Application` file in the `ui` package and select `Run 'main'`.
9. The graphics canvas will open and display a world map. A user can then enter search terms via the UI to display relevant tweets with the tweet origin being shown on the map.

### Coursework

This is the final project from the [Software Construction: Object-Oriented Design](https://www.edx.org/course/software-construction-object-oriented-design) course from [UBC](https://www.ubc.ca/). The course is the fourth of six that form the [Software Development MicroMasters](https://www.edx.org/micromasters/ubcx-software-development) Program on edX.

![Twitter Mapper](./data/twitter_mapper.png?raw=true)