import java.awt.event.*;
import javax.swing.*;
import java.util.Timer; 
import java.util.TimerTask;

/**
 * A custom component that acts as a simple stop-watch.  When the user clicks
 * on it, this componet starts timing.  When the user clicks again,
 * it displays the time between the two clicks.  Clicking a third time
 * starts another timer, etc.  While it is timing, the label just
 * displays the message "Timing....".
 * https://stackoverflow.com/questions/26523841/how-do-you-change-label-text-in-java-after-a-timer-ticks-a-second-passed/44626170
 */
public class StopWatchRunner extends JLabel implements MouseListener {
	private static Timer timer;
	private static TimerTask timerTask;
	protected static StopWatchRunner obj; 
	private int t;
   private long startTime;   // Start time of timer.
                             //   (Time is measured in milliseconds.)

   private boolean running;  // True when the timer is running.

   /**
    * Constructor sets initial text on the label to
    * "Click to start timer." and sets up a mouse listener
    * so the label can respond to clicks.
    */
   public StopWatchRunner() {
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }
   
   
   /**
    * Tells whether the timer is currently running.
    */
   public boolean isRunning() {
      return running;
   }

   
   /**
    * React when the user presses the mouse by starting
    * or stopping the timer and changing the text that
    * is shown on the label.
    */
   public void mousePressed(MouseEvent evt) {
	  
      if (running == false) {
    	 t = 1;
         running = true;
         startTime = evt.getWhen();  // Time when mouse was clicked.
         setText("Timing....");
         timer = new Timer();
         TimerTask task = new TimerTask() {
             @Override
             public void run() {
            	 setText(t++ +"secs");
             }
         };
         
         timer.scheduleAtFixedRate(task, 1000, 1000);
            
      }
      else {
    	  
            // Stop the timer.  Compute the elapsed time since the
            // timer was started and display it.
         running = false;
         long endTime = evt.getWhen();
         double seconds = (endTime - startTime) / 1000.0;
         setText("Time: " + seconds + " sec.");
         timer.cancel();
         timer.purge();
      }
   }

   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}
