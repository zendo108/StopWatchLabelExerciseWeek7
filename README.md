# StopWatchLabelExerciseWeek7
Exercises
This is a graded exercise which should be posted to your learning journal.

The StopWatchLabel component from section 12.4.5 in the textbook displays the text "Timing..." 
when the stop watch is running. It would be nice if it displayed the elapsed time since the 
stop watch was started. For that, you need to create a Timer (see section 6.5.1 in the textbook.) 
Add a Timer to the original source code, StopWatchLabel.java in the code directory, to drive the 
display of the elapsed time in seconds. Create the timer in the mousePressed() routine when the 
stop watch is started. Stop the timer in the mousePressed() routine when the stop watch is 
stopped. The elapsed time won't be very accurate anyway, so just show the integral number of 
seconds. You only need to set the text a few times per second. For the Timer method, use a 
delay of 200 milliseconds for the timer. Here is an applet that tests one possible solution 
to this exercise: