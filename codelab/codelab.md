## Project Structure

This project :

 - Uses RxJava2 for the demos.
 - Follows the `MVP` architecture inspired by [repository](https://github.com/googlesamples/android-architecture).
 - Makes use of [`Dagger2`](https://google.github.io/dagger/)
 - Uses [Butterknife] (http://jakewharton.github.io/butterknife/)
 - Uses `TestScheduler` for writing tests.
 
## `CODE-LAB`
This is the code-lab I conducted at he GDG New Delhi January meetup. SpeakerDeck for this is available [here](https://speakerdeck.com/ragdroid/rxify-a-talk-to-remember-codelab).

### Pre-requisites : 
 - Android Studio IDE
 - `git`
 - Lots of excitement.
 
### Let's Get Started

 - Switch to branch `codelab`.
 - Checkout at the starting commit : SHA - `d5db64950f1616c308bb8174bb8dc01ab69971e8`.
 - List of all the commits is [here](https://github.com/ragdroid/rxify/commits/codelab).
 - Open `ChillActivity` and switch to the desired presenter.
 - Let's Get Started!! Following Presenters are implemented Click on any of the below sections to jump to the excercise :
 
 #### [Section 1 - Basic Spells] (basic.md) :
 	- [`EmptyPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/EmptyPresenter.java)
 	- [`ErrorPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/ErrorPresenter.java)
 	- [`FromPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/FromPresenter.java)
 	- [`IntervalPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/IntervalPresenter.java)
 	- [`IntervalRangePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/IntervalRangePresenter.java)
 	- [`JustPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/JustPresenter.java)
 	- [`NeverPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/NeverPresenter.java)
 	- [`RangePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/RangePresenter.java)
 	- [`TimePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/TimePresenter.java) 

 #### Section 2 - To-Do Section :
	- [`AssignmentPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/AssignmentPresenter.java)
	- [`BattleFlowPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/BattleFlowPresenter.java)
	- [`BattlePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/BattlePresenter.java)
	- [`DistinctPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/DistinctPresenter.java)
	- [`FilterPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/FilterPresenter.java)
	- [`FlatmapPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/FlatmapPresenter.java)
	- [`MapPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/MapPresenter.java)
	- [`ReducePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/ReducePresenter.java)
	- [`SkipPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/SkipPresenter.java)
	- [`TakePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/TakePresenter.java)
	- [`TakeUntilPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/TakeUntilPresenter.java)

 #### Section 3 - Threading :
	- [`ThreadingPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/ThreadingPresenter.java)

 #### Section 4 - Testing :
	- [`EmptyPresenter`](app/src/test/java/com/ragdroid/rxify/codelab/presenter/EmptyPresenterTest.java)
	- [`NeverPresenter`](app/src/test/java/com/ragdroid/rxify/codelab/presenter/NeverPresenterTest.java)
	- [`MagicalRemoteDataSourceTest`](app/src/test/java/com/ragdroid/rxify/logic/data/remote/MagicalRemoteDataSourceTest.java)
