import java.util.Scanner; 
import java.util.Random;

class happyValentines {
  public static void main(String[] args) {
   
    Scanner reader = new Scanner(System.in);
    Random nosayer = new Random();
    boolean rightResponse, rightResponse2;
    
    String[] noResponses = {
      "Are you sure about that????????",
      "Are you absolutely positively certain??",
      "You're gonna break my heart.",
      "I know you want to say yes, just admit it.",
      "Don't do this I'll cry.",
      "Pretty please?",
      "I will break into your house.",
      "How dare you?",
      "There is no point resisting", };
    
    String[] startResponses = {
    " Can I ask you a question, gorgeous?",
    " Let me ask you something please, Can I?",
    " Can I please ask you a question?",,
    " Let ask you something"};
    
    String[] askResponses = {
    " Will you be my valentine?",
    " Will you please be my valentine?",
    " Wont you let me be your valentine?",
    " Can you take me as your valentine?",
    " Let me be your valentine",
    " Be my valentine"
    };
      
    
    do{
    
    System.out.print(startResponses[nosayer.nextInt(startResponses.length)]);
    String decision = reader.nextLine();
    
    String[] rightDecision = {"yes","yeah","YES","Yes","Yeah","Absolutely","okay","ok",","Ofcourse!","YEAH","OFCOURSE","yes you can","Yes you can","ofcourse"};
    String wrongDecision = "no";
   
    rightResponse = false;
    for(String response : rightDecision){
    if (decision.equals(response)) {
       rightResponse = true;
      break;}
    }
    
    if (rightResponse) {
       System.out.println(" YYAYYY");
      do{
       System.out.println(askResponses[nosayer.nextInt(askResponses.length)]);
       String secondDecision = reader.nextLine();
       
        rightResponse2 = false;
        for(String response : rightDecision){
        if (secondDecision.equals(response)) {
        rightResponse2 = true;
        break;}
    }
         if (rightResponse2){
           System.out.println(":DDDD"); 
           String surprise = reader.nextLine();
                {System.out.println("    ***   ***");
                System.out.println("  **   **   **");
                System.out.println(" **     *     **");
                System.out.println(" **           **");
                System.out.println("  **          **");
                System.out.println("    **     **");
                System.out.println("      ** **");
                System.out.println("        *"); }
         }
         else if (secondDecision.equals(wrongDecision)){
           System.out.println("BZZZZP, INVALID ANSWER!! "+ noResponses[nosayer.nextInt(noResponses.length)]);
         }
         else{
           System.out.print("I'm sorry I dont understand you, could you please say that again");
         }
      }while (!rightResponse2);
    }


    else if (decision.equals(wrongDecision)) {
      System.out.print(noResponses[nosayer.nextInt(noResponses.length)]);
    }
    
    else{
      System.out.print(" I'm sorry my stupid code doesnt get you. Could you please repeat with a different response?");
    }
    
     }while (!rightResponse);
   
     reader.close();
  }
}
