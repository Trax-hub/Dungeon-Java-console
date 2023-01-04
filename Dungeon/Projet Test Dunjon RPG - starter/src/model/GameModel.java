package model;

public class GameModel {

  private Dungeon theDungeon;
  private Player thePlayer;

  //Constructor
  /**
   * This constructor creates a GamModel and set its Dungeon's startingRoom
   */
  public GameModel() {
    theDungeon = new Dungeon();
    thePlayer = new Player();
    thePlayer.setCurrentLocation(theDungeon.getStartingRoom());
  }

  //Getter
  public Player getPlayer() {
    return thePlayer;
  }

}
