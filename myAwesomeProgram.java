import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

public class myAwesomeProgram implements ActionListener{
   
   JButton yesButton; 
   JButton noButton;     
   JLabel text = new JLabel();
   int maxFrames = 100;
   JFrame[] frames = new JFrame[maxFrames];  // Array to hold all open frames
   int frameCount = 1;
   int textCount = 0;
   boolean sureReply = false;
   Random ranLoc = new Random();
  
   public static void main(String[] args) {
    
      myAwesomeProgram gui = new myAwesomeProgram();
      gui.go();
   }
  
   public void go() {  
    
      JFrame frame = new JFrame();
      frame.setResizable(false);
      text.setText("ARE YOU THE BEST TEACHER?");
    
      text.setFont(new Font("Arial", Font.BOLD, 25));
      text.setBounds(190,50,500,500);
      yesButton = new JButton("Yes");
      yesButton.setBounds(220,350,100,50);
      noButton = new JButton("No");
      noButton.setBounds(430,350,100,50);
       
      yesButton.addActionListener(this);
      noButton.addActionListener(this);
     
      noButton.addMouseListener(new MouseAdapter() {    //Randomizes the position of the button everytime the mouse enters the area of the button
        @Override
        public void mouseEntered(MouseEvent e) {
          
           noButton.setBounds(ranLoc.nextInt(700), ranLoc.nextInt(500),100,50);
        }
      });
    
      frame.getContentPane().setLayout(null);
      frame.getContentPane().setBackground(Color.white);
      frame.getContentPane().add(yesButton);
      frame.getContentPane().add(noButton);
      frame.getContentPane().add(text);
      frame.setLayout(null);
      frame.setSize(800,600);
      frame.setVisible(true);
     
      frame.setLocation( ranLoc.nextInt(800), ranLoc.nextInt(600) ); // Randomizes the frame location when closed
    
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  // Prevents the close button from working
     
     
      if (frameCount <= maxFrames){   // Checks if the number of open windows has reached the limit
        frames[frameCount++] = frame;
        frame.addWindowListener(new WindowAdapter() {  // Calls the method go() if the user attempts to close therefore
           @Override                                    // Opening another window
           public void windowClosing(WindowEvent e) {
              go();
           }
        });
      } else {
        text.setText("REALLY?");           //Stops opening new windows to prevent computer from blowing up
      }
    
      if (sureReply) {
        textCount = 3;        // Makes sure it goes to the "OK then" text when the user says they are unsure
      } else {
        textCount = (frameCount%3) + 1;    
      }
    
      if (textCount == 1) {
        text.setText("ARE YOU SURE YOU WANT TO DO THAT?");
        text.setBounds(135,50,600,500);
        yesButton.setText("No");             //Swapping the functions of the buttons
        yesButton.setBounds(420,350,100,50);
        noButton.setText("Yes");
        noButton.setBounds(220,350,100,50);
       
      } else if (textCount == 2) {
        text.setText("   ATTEMPTING TO EXIT IS FUTILE   ");
        yesButton.setVisible(false);
        noButton.setVisible(false);
     
      } else if (textCount == 3 && sureReply) {
        text.setText("OK then, ARE YOU THE BEST?");
        text.setBounds(190,50,600,500);
        sureReply = false;
      }
   }
  
   public void actionPerformed(ActionEvent event) {
    
      if ( event.getSource() == yesButton && textCount!=1 ) {
        for (int i = 0; i < frameCount; i++) {   // Disposes all of the frames before closing when yes is clicked
          if (frames[i] != null) {                // in the "Are you the best teacher" prompt
            frames[i].dispose();
          }
        }
        ending();                                      // Calls the ending screen after disposing 
       
      } else if ( event.getSource() == yesButton ) {  
        sureReply = true;                              // If textCount is 1 which is the "Are you sure" prompt 
        go();                                          // and the user presses No (they are not sure) 
      }                                                // it sets sureReply to true and instead opens another window
                                                       // prompting the question again not reaching the ending yet
      if ( event.getSource() == noButton ) {
        text.setText("            How            ");
      }
   }

   public void ending() {
      
      JFrame eframe = new JFrame();
      eframe.setResizable(false);
      JTextArea textarea = new JTextArea(
                   "                             * * * * * * * * * * * * *                                           \n" + 
                   "                        * * * * * * * * * * * * * * * * * *                                      \n" +      
                   "                     * * * * * * * *   * * * * * * * * * * * * *                                 \n" +                                 
                   "                   * * * *   * * * * * * * * * * * * * * * *  * *                                \n" + 
                   "                 * * * * *   * * * * *   * * *       * * * * * *   *                             \n" +   
                   "               * * *   * * * * *   * * *               * * * * * * *                             \n" +    
                   "               * * * * * * * * * * * *                   * * * * * *                             \n" +      
                   "             * * * *   * * *                               * * * *                               \n" +      
                   "                 * * * * *     * * *           * * * * *       * * *                             \n" +      
                   "               * *       = = = = = = = = = = = = = = = =       *  *         *                    \n" +    
                   "               * *     =             = =  = =          = =     *   *      *   *                  \n" +    
                   "               *        =      2       =   =     2       =      * *      *    *                  \n" +
                   "               *   *       = = = = =           = = =  =        *  *      *    *                  \n" +       
                   "               * * * *                 * * *                  * *        *      *                \n" +     
                   "                   * *             * * * * * * *          * * * *       *      *                 \n" +     
                   "                     *                  * * *             * * * *       *       * * * *          \n" +     
                   "                       *            *           *         * * *         *                 * *    \n" +     
                   "                         *           ** * * **          *  *          *                   *      \n" +      
                   "                           * *                         * * *           *                   *     \n" +     
                   "                               * * *   * *       * * * *               *                 * *     \n" +     
                   "                                  * * * * * * * *                     * *       * * * * *        \n" +    
                   "                                                                         * * * * *               \n" +
                   "                             Correct !!!"                                                        // Master potrait
                                        );
      if ( frameCount > 2 ) {
        textarea.append(" You can exit now ");
      }
     
      textarea.setEditable(false);
      textarea.setBounds(10,10,800,500);
      textarea.setFont(new Font("Monospaced", Font.PLAIN,14)); 
      eframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Allows to exit finally
     
      eframe.getContentPane().setLayout(null);
      eframe.getContentPane().setBackground(Color.white);
      eframe.getContentPane().add(textarea);
      eframe.setLayout(null);
      eframe.setSize(800,600);
      eframe.setVisible(true);  
   }
 }   
