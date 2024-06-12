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
   int frameCount = 0;
   Random ranLoc = new Random();
  
  public static void main(String[] args) {
    myAwesomeProgram gui = new myAwesomeProgram();
    gui.go();
  }
  
  public void go() {  
    
    JFrame frame = new JFrame();
    frame.setResizable(false);
    text.setText("ARE YOU A DONKEY???????");
    
    text.setFont(new Font("Arial", Font.BOLD, 25));
    text.setBounds(190,50,500,500);
    yesButton = new JButton("Yes");
    yesButton.setBounds(220,350,100,50);
    noButton = new JButton("No");
    noButton.setBounds(430,350,100,50);
    
    yesButton.addActionListener(this);
    noButton.addActionListener(this);
    
    noButton.addMouseListener(new MouseAdapter() {
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
    
    frame.setLocation( ranLoc.nextInt(800), ranLoc.nextInt(600) ); // Randomizes the frame location
    
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //Removes closing functionality
    
    
    if (frameCount <= maxFrames){   //Checks if the number of open windows has reached the limit
      frames[frameCount++] = frame;
      frame.addWindowListener(new WindowAdapter() {  //Calls the method go()
         @Override
         public void windowClosing(WindowEvent e) {
           go();
      }
      });
    }
    if(frameCount==2) {
    text.setText("ARE YOU SURE ABOUT THAT");
    }
    
    else {
      System.out.println("Really?");   //Stops opening new windows to prevent computer from exploding
    }
    
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getSource()==yesButton) {
      for(int i = 0; i < frameCount; i++) { //Disposes all of the frames before closing
        if(frames[i] != null) {
          frames[i].dispose();
       }
    } 
    ending();
    
    if(event.getSource()==noButton) {
      System.out.print("How");
    }
  }
}
  public void ending() {
      JFrame eframe = new JFrame();
      eframe.setResizable(false);
      JTextArea textarea = new JTextArea(
                   "                             * * * * * * * * * * * * *                                           \n" + 
                   "                        * * * * * * * * * * * * * * * * * *                                     \n" +      
                   "                     * * * * * * * *   * * * * * * * * * * * * *                                 \n" +                                 
                   "                   * * * *   * * * * * * * * * * * * * * * *  * *                                \n" + 
                   "                 * * * * *   * * * * *   * * *       * * * * * *   *                           \n" +   
                   "               * * *   * * * * *   * * *           *   * * * * * * *                           \n" +    
                   "               * * * * * * * * * * * *               * * * * * * * *                           \n" +      
                   "             * * * *   * * *                               * * * *                               \n" +      
                   "                 * * * * *     * * *           * * * * *       * * *                           \n" +      
                   "               * *       = = = = = = = = = = = = = = = =       *  *         *                 \n" +    
                   "               * *     =             = =  = =          = =     *   *      *   *           \n" +    
                   "               *        =      2       =   =     2       =      * *      *    *         \n" +
                   "               *   *       = = = = =           = = =  =        *  *      *    *          \n" +       
                   "               * * * *                 * * *                  * *        *      *               \n" +     
                   "                   * *             * * * * * * *          * * * *       *      *               \n" +     
                   "                     *                  * * *             * * * *       *       * * * *          \n" +     
                   "                       *            *           *         * * *         *                 * *     \n" +     
                   "                         *           ** * * **          *  *          *                   *    \n" +      
                   "                           * *                         * * *           *                   *     \n" +     
                   "                               * * *   * *       * * * *               *                 * *     \n" +     
                   "                                  * * * * * * * *                     * *       * * * * *        \n" +    
                   "                                                                         * * * * *               \n" +
                   "                             Correct !!!"                      
                                        );
      if(frameCount>1) textarea.append(" Can exit now :)");
      textarea.setEditable(false);
      textarea.setBounds(10,10,800,500);
      textarea.setFont(new Font("Monospaced", Font.PLAIN,14)); 
      eframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      eframe.getContentPane().setLayout(null);
      eframe.getContentPane().setBackground(Color.white);
      eframe.getContentPane().add(textarea);
      eframe.setLayout(null);
      eframe.setSize(800,600);
      eframe.setVisible(true);  
  }
}
    
    
    
