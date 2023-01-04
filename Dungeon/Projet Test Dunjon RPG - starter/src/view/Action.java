package view;

public class Action {
  private char charToRead;
  private String message;
  private PossibleAction actionToDo;

  //Cosntructor
  public Action(char charToRead, String message, PossibleAction action) {
    super();
    this.charToRead = charToRead;
    this.message = message;
    this.actionToDo = action;
  }
  
  public Action(int intToRead, String message, PossibleAction action) {
	    super();
	    this.charToRead = Integer.toString(intToRead).toCharArray()[0];
	    this.message = message;
	    this.actionToDo = action;
	  }

  //Getters & Setters
  public char getCharToRead() {
    return charToRead;
  }

  public String getMessage() {
    return message;
  }

  public PossibleAction getAction() {
    return actionToDo;
  }

}
