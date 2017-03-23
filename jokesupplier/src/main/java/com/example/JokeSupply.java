package com.example;

public class JokeSupply {

    private static int jokeCount = -1;
    private static final String newLine = System.getProperty("line.separator");

    private static final String[] jokes = {
            "Q: How many IT guys does it take to screw in a light bulb?" + newLine +
            "A: None, that's a Facilities problem.",

            "How is a computer like an air conditioner?" + newLine +
            "When you open Windows it won't work!",

            "Q: Why did the man throw the clock out the window?" + newLine +
            "A: He wanted to see time fly. ",

            "A lawyer, an engineer and a mathematician were called in for a test." + newLine +
                    "The engineer went in first and was asked, 'What is 2+2?' The engineer thought awhile and finally answered, '4.'" + newLine +
                    "Then the mathemetician was called in and was asked the same question. With little thought he replied, '4.0'" + newLine +
                    "Then the lawyer was called in, and was asked the same question. The lawyer answered even quicker than the mathematician, 'What do you want it to be?'",

            "Guy 1: Hey! Why do you smoke cigarettes even though there is a warning on the pack that says it's bad for your health?" + newLine +
                    "Guy 2: I am a software professional. I don't bother about warnings -- I am concerned only about the 'Alerts.'"};

    public static String getJokes() {
        ++jokeCount;
        if (jokeCount >= jokes.length) {
            jokeCount = 0;
        }

        return jokes[jokeCount];
    }

}
