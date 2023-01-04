package view;

import java.util.List;

import model.Armor;
import model.Sword;
import model.Boss;
import model.Chest;
import model.Fight;
import model.Humanoid;
import model.Item;
import model.Player;
import model.Room;

public class GameScreen {

	public void welcomeMessage() {
		Console.displayln("Welcome in the Dungeon of the Death !");
		Console.displayln("You must find the Boss to save the princess in disguise");
	}

	public void badEnding() {
		Console.displayln("Busted ! You're dead :(");
		Console.displayln("The princess will stay here for a while");
	}

	public void goodEnding() {
		Console.displayln("Congrats ! You won ! The Princess is now free !");
	}

	public void describeCurrentRoom(Room currentRoom) {
		if(currentRoom.getEnemy() != null) {
			if(currentRoom.getEnemy() instanceof Boss) {
				Console.displayln("You are in "+currentRoom+" and a Boss is facing you");
			}
			else {
				Console.displayln("You are in "+currentRoom+" and an enemy is facing you");
			}
		}
		else {
			Console.displayln("You are in " + currentRoom+", there is nobody...");
		}
		if(currentRoom.getTrap() != null) {
			Console.displayln("You hear a click");
			Console.displayln("A trap triggered");
			Console.displayln(currentRoom.getTrap().getMessage());
			Console.displayln("The trap inflicts "+currentRoom.getTrap().getDamages()+" damages on you");
		}

	}

	public void showHp(Humanoid humanoid) {
		Console.displayln(humanoid+" HP : "+humanoid.getHp()+"/"+humanoid.getHpMax());
	}

	public void showRound(int turn) {
		Console.systemeInfo("Round "+turn);
	}

	public void showFight(Fight fight) {
		Console.displayln("A fight started between you and "+fight.getEnemy());
	}

	public void describeAttack(Player player, Humanoid enemy) {
		if(player.getLastAttack()) {
			Console.displayln("You just attacked "+enemy+" and inflict "+((player.getAttackStat() + (int) player.getAttackStat()*0.2) - (int) player.getAttackStat()*enemy.getDefenseStat())+" damages on him, critical attack !");
		}
		else {
			Console.displayln("You just attacked "+enemy+" and inflict "+(player.getAttackStat() - (int) player.getAttackStat()*enemy.getDefenseStat())+" damages on him");
		}
	}

	public void describeAttack(Humanoid enemy, Player player) {
		if(enemy.getLastAttack()) {
			Console.displayln("the "+enemy+" just attacked you and inflict "+((enemy.getAttackStat() + (int) enemy.getAttackStat()*0.2) - (int) enemy.getAttackStat()*player.getDefenseStat())+" damages on you, critical attack !");
		}
		else {
			Console.displayln("the "+enemy+" just attacked you and inflict "+(enemy.getAttackStat() - (int) enemy.getAttackStat()*player.getDefenseStat())+" damages on you");
		}
	}

	public void runAway(Humanoid enemy) {
		Console.displayln("You run away from the fight against "+enemy);
	}

	public void noItem() {
		Console.displayln("You don't have any items");
	}

	public void fightEnding(Fight fight) {
		if(fight.getPlayer().isAlive() && !fight.getEnemy().isAlive()) {
			Console.displayln("You won the battle against "+fight.getEnemy());
		}
		if(!fight.getPlayer().isAlive()){
			Console.displayln(fight.getEnemy()+" defeated you. You die on the battlefield");
		}
	}
	
	public void receiveItem(Item item) {
		Console.displayln("The enemy just dropped you a " + item.toString());
	}

	public void openChest(Chest chest) {
		Console.displayln("You opnened a chest and get a " + chest.getItem().toString());
	}

	public void drinkWaterBottlePotion(Player player) {
		Console.displayln("You drink some water, you have "+player.getHp()+"/"+player.getHpMax()+"HP");
	}

	public void drinkAppleJuicePotion(Player player) {
		Console.displayln("You drink some apple juice, you have "+player.getHp()+"/"+player.getHpMax()+"HP");
	}

	public void cantDrink() {
		Console.displayln("You can't drink you're already full");
	}

	public void equipArmor(Armor armor) {
		Console.displayln("You just equiped a " + armor.getName() + ", you have block now " + armor.getResistance() + "% of the damages");
	}

	public void equipSword(Sword sword) {
		Console.displayln("You just equiped a " + sword.getName() + ", you have inflict now " + sword.getDamage() + " damages more when you attack an enemy");
	}

	public void unequipArmor(Armor armor) {
		Console.displayln("You just removed your armor you are now as vulnerable as at the begining of your adventure");
	}

	public void unequipSword(Sword sword) {
		Console.displayln("You just removed your sword, you only have your fists now");
	}

	public void cantWear() {
		Console.displayln("You already wear an armor, remove it before wear another one !");
	}

	public void cantUse() {
		Console.displayln("You already armed a sword please remove it before use another one !");
	}

	public void proposeAvailableActions(List<Action> actions) {
		for (Action a : actions) {
			Console.displayln("(" + a.getCharToRead() + ") " + a.getMessage());
		}
	}

	public PossibleAction readActionToDo(List<Action> actions) {
		PossibleAction result = null;

		Interaction.resetKeys();
		for (Action a : actions) {
			Interaction.acceptKey(a.getCharToRead());
		}

		Console.systemeInfo("Your choice ?");
		char rep = Interaction.readAction();

		for (Action a : actions) {
			if (Character.toLowerCase(rep) == Character.toLowerCase(a.getCharToRead())) {
				result = a.getAction();
				break;
			}
		}

		return result;
	}

}
