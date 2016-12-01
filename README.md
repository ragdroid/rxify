
# Rxify

Created a simple demo for the talk at [droidconIN 2016, Banglore](https://droidconin.talkfunnel.com/2016/94-rxify-a-simple-spell-for-complex-rxjava-operators).

 - For more information, checkout multi-part `Rxify` blog series on [medium](https://medium.com/@ragdroid/rxify-a-simple-spell-for-complex-rxjava-operators-part-1-4c31921583c4#.6hxqs39e6).
 - For the video of this talk click [here] (https://www.youtube.com/watch?v=UTyPMjfO1cA&list=PL279M8GbNsevRo-PUq-9UrfJgFAIK6ONd&index=4)
 - For the slides click [here] (https://speakerdeck.com/ragdroid/rxify-a-simple-spell-for-complex-rxjava-operators)

## Project Structure

This project :

 - Uses RxJava2 for the demos.
 - Follows the `MVP` architecture inspired by [repository](https://github.com/googlesamples/android-architecture).
 - Makes use of [`Dagger2`](https://google.github.io/dagger/)
 - Uses [Butterknife] (http://jakewharton.github.io/butterknife/)
 - Uses `TestScheduler` for writing tests.
 
## Zip-yosa ([`ZipActivity`](https://github.com/ragdroid/rxify/blob/master/app/src/main/java/com/ragdroid/rxify/zip/ZipActivity.java))

 - We are waiting for `FluxWeed` API call. 
 - We are also waiting for `Student` API call to get hair of Crab. 
 - Both the calls executing asynchronously. 
 - Problem : 
    - Initialise `PolyJuice` from the results of API calls. 
    - Hide the loader after both calls have completed.
    

## To-Do

 - Implement more demos.
