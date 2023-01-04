package controller;

import java.util.ArrayList;
import java.util.List;

import model.GameModel;
import model.IronSword;
import model.Nokia3310Armor;
import model.PaperboardArmor;
import model.Player;
import model.SteelArmor;
import model.WaterBottlePotion;
import model.WoodenSword;
import model.AppleJuicePotion;
import model.Armor;
import model.Boss;
import model.Sword;
import model.CorkscrewSword;
import model.Fight;
import view.Action;
import view.GameScreen;
import view.PossibleAction;

public class GameLogic {

	private GameModel gameModel;
	private GameScreen screen;

	private Player player;
	private boolean bossKilled;

	public GameLogic(GameModel theRootModel, GameScreen theRootView) {
		gameModel = theRootModel;
		screen = theRootView;
		player = gameModel.getPlayer();
	}

	public void start() {
		screen.welcomeMessage();

		while (!endOfTheGame()) {
			if(!player.getInventory().isOpen()) {
				screen.describeCurrentRoom(player.getCurrentLocation());
			}

			if(player.getCurrentLocation().getTrap() != null) {
				player.getCurrentLocation().getTrap().triggerOn(player);
			}

			if(player.isFighting()) {

				Fight fight = new Fight(player, player.getCurrentLocation().getEnemy());
				screen.showFight(fight);

				while(player.isFighting()) {

					screen.showRound(fight.getTurn());
					screen.showHp(player);
					screen.showHp(player.getCurrentLocation().getEnemy());

					List<Action> contextualPossibleActions = getContextualActions();

					screen.proposeAvailableActions(contextualPossibleActions);

					PossibleAction actionToDo = screen.readActionToDo(contextualPossibleActions);

					doAnAction(actionToDo);

					fight.checkFight();
					if(!player.isFighting()) {
						screen.fightEnding(fight);
						if(player.isAlive()) {
							if(player.getCurrentLocation().getEnemy().getItem() != null) {
								player.getCurrentLocation().getEnemy().dropItem(player);
								screen.receiveItem(player.getCurrentLocation().getEnemy().getItem());
							}
							if(player.getCurrentLocation().getEnemy() instanceof Boss) {
								setBossKilled(true);
							}
							player.getCurrentLocation().setEnemy(null);
						}
					}
					fight.addTurn();
				}
			}
			else {

				List<Action> contextualPossibleActions = getContextualActions();

				screen.proposeAvailableActions(contextualPossibleActions);

				PossibleAction actionToDo = screen.readActionToDo(contextualPossibleActions);

				doAnAction(actionToDo);
			}
		}
		if (player.isAlive()) {
			screen.goodEnding();
		} else {
			screen.badEnding();
		}
	}

	public List<Action> getContextualActions() {

		List<Action> result = new ArrayList<>();

		if (player.getCurrentLocation().getWestRoom() != null && !player.isFighting() && !player.getInventory().isOpen()) {
			result.add(new Action('W', "Go West", PossibleAction.GOWEST));
		}
		if (player.getCurrentLocation().getEastRoom() != null && !player.isFighting() && !player.getInventory().isOpen()) {
			result.add(new Action('E', "Go East", PossibleAction.GOEAST));
		}
		if (player.getCurrentLocation().getNorthRoom() != null && !player.isFighting() && !player.getInventory().isOpen()) {
			result.add(new Action('N', "Go North", PossibleAction.GONORTH));
		}
		if (player.getCurrentLocation().getSouthRoom() != null && !player.isFighting() && !player.getInventory().isOpen()) {
			result.add(new Action('S', "Go South", PossibleAction.GOSOUTH));
		}

		if (player.isFighting() && !player.getInventory().isOpen()) {
			result.add(new Action('A', "Attack", PossibleAction.ATTACK));
			result.add(new Action('R', "Run away", PossibleAction.RUN));
		}

		if(!player.isFighting() && !player.getInventory().isOpen()) {
			result.add(new Action('I', "Open your Inventory", PossibleAction.INVENTORY));
		}
		
		if (!player.isFighting() && !player.getInventory().isOpen() && player.getCurrentLocation().getChest() != null) {
			result.add(new Action('T', "Open the chest", PossibleAction.OPEN));
		}

		if(player.getInventory().isOpen()) {
			int numero = 1;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof AppleJuicePotion && player.getInventory().getItemN(i).getQuantity() > 0) {
					result.add(new Action(numero, "Drink an apple juice", PossibleAction.DRINKJUICE));
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof WaterBottlePotion && player.getInventory().getItemN(i).getQuantity() > 0) { 
					result.add(new Action(numero, "Drink a bottle of water", PossibleAction.DRINKWATER));
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof PaperboardArmor  && player.getInventory().getItemN(i).getQuantity() > 0 ) {
					Armor armor = (Armor) player.getInventory().getItemN(i);
					if(player.getArmor() != armor) {
						result.add(new Action(numero, "Wear the paperboard armor", PossibleAction.WEARARMOR1));
					}
					else {
						result.add(new Action(numero, "Unwear the paperboard armor", PossibleAction.UNUSEARMOR1));
					}
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof SteelArmor  && player.getInventory().getItemN(i).getQuantity() > 0) {
					Armor armor = (Armor) player.getInventory().getItemN(i);
					if(player.getArmor() != armor) {
						result.add(new Action(numero, "Wear the steel armor", PossibleAction.WEARARMOR2));
					}
					else {
						result.add(new Action(numero, "Unwear the steel armor", PossibleAction.UNUSEARMOR2));
					}
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof Nokia3310Armor  && player.getInventory().getItemN(i).getQuantity() > 0) {
					Armor armor = (Armor) player.getInventory().getItemN(i);
					if(player.getArmor() != armor) {
						result.add(new Action(numero, "Wear the nokia 3310 armor", PossibleAction.WEARARMOR3));
					}
					else {
						result.add(new Action(numero, "Unwear the nokia 3310 armor", PossibleAction.UNUSEARMOR3));
					}
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof CorkscrewSword  && player.getInventory().getItemN(i).getQuantity() > 0) {
					Sword sword = (Sword) player.getInventory().getItemN(i);
					if(player.getSword() != sword) {
						result.add(new Action(numero, "Use the corkscrew sword", PossibleAction.USESWORD1));
					}
					else if(player.getSword() == sword){
						result.add(new Action(numero, "Unuse the corkscrew sword", PossibleAction.UNUSESWORD1));
					}
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof WoodenSword  && player.getInventory().getItemN(i).getQuantity() > 0) {
					Sword sword = (Sword) player.getInventory().getItemN(i);
					if(player.getSword() != sword) {
						result.add(new Action(numero, "Use the wooden sword", PossibleAction.USESWORD2));
					}
					else if(player.getSword() == sword){
						result.add(new Action(numero, "Unuse the wooden sword", PossibleAction.UNUSESWORD2));
					}
					numero++;
				}
				if(player.getInventory().getItemN(i) instanceof IronSword  && player.getInventory().getItemN(i).getQuantity() > 0) {
					Sword sword = (Sword) player.getInventory().getItemN(i);
					if(player.getSword() != sword) {
						result.add(new Action(numero, "Use the iron sword", PossibleAction.USESWORD3));
					}
					else if(player.getSword() == sword){
						result.add(new Action(numero, "Unuse the iron sword", PossibleAction.UNUSESWORD3));
					}
					numero++;
				}
			}
			result.add(new Action('C', "Close inventory", PossibleAction.CLOSE));
		}

		return result;
	}

	private void doAnAction(PossibleAction action) {
		switch (action) {
		case GOWEST:
			player.goWest();
			player.checkFight();
			break;
		case GOEAST:
			player.goEast();
			player.checkFight();
			break;
		case GONORTH:
			player.goNorth();
			player.checkFight();
			break;
		case GOSOUTH:
			player.goSouth();
			player.checkFight();
			break;
		case INVENTORY:
			if(player.getInventory().size() > 0) {
				player.openInventory();
			}
			else {
				screen.noItem();
			}
			break;
		case CLOSE:
			player.getInventory().setOpen(false);
			break;
		case ATTACK:
			player.attack(player.getCurrentLocation().getEnemy());
			screen.describeAttack(player, player.getCurrentLocation().getEnemy());
			if(player.getCurrentLocation().getEnemy().isAlive()) {
				player.getCurrentLocation().getEnemy().attack(player);
				screen.describeAttack(player.getCurrentLocation().getEnemy(), player);
			}
			break;
		case RUN:
			screen.runAway(player.getCurrentLocation().getEnemy());
			player.runAway();
			break;
		case DRINKWATER:
			if(player.getHp()+(player.getHp() * 0.05) < player.getHpMax()) {
				player.consumeWaterBottlePotion();
				screen.drinkAppleJuicePotion(player);
			}
			else {
				screen.cantDrink();
			}
			player.closeInventory();
			break;
		case DRINKJUICE:
			if(player.getHp()+(player.getHp() * 0.1) < player.getHpMax()) {
				player.consumeAppleJuicePotion();
				screen.drinkWaterBottlePotion(player);
			}
			else {
				screen.cantDrink();
			}
			player.closeInventory();
			break;
		case WEARARMOR1:
			boolean canwear1 = false;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof PaperboardArmor && player.getArmor() == null) {
					player.useArmor((Armor) player.getInventory().getItemN(i));
					screen.equipArmor((Armor) player.getInventory().getItemN(i));
					canwear1 = true;
					break;
				}
				else {
					canwear1 = false;
				}
			}
			if(!canwear1) {
				screen.cantWear();
			}
			player.closeInventory();
			break;
		case WEARARMOR2:
			boolean canwear2 = false;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof SteelArmor && player.getArmor() == null) {
					player.useArmor((Armor) player.getInventory().getItemN(i));
					screen.equipArmor((Armor) player.getInventory().getItemN(i));
					canwear2 = true;
					break;
				}
				else {
					canwear2 = false;
				}
			}
			if(!canwear2) {
				screen.cantWear();
			}
			player.closeInventory();
			break;
		case WEARARMOR3:
			boolean canwear3 = false;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof Nokia3310Armor && player.getArmor() == null) {
					player.useArmor((Armor) player.getInventory().getItemN(i));
					screen.equipArmor((Armor) player.getInventory().getItemN(i));
					canwear3 = true;
					break;
				}
				else {
					canwear3 = false;
				}
			}
			if(!canwear3) {
				screen.cantWear();
			}
			player.closeInventory();
			break;
		case USESWORD1:
			boolean canuse1 = false;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof CorkscrewSword && player.getSword() == null) {
					player.useSword((Sword) player.getInventory().getItemN(i));
					screen.equipSword((Sword) player.getInventory().getItemN(i));
					canuse1 = true;
					break;
				}
				else {
					canuse1 = false;
				}
			}
			if(!canuse1) {
				screen.cantUse();
			}
			player.closeInventory();
			break;
		case USESWORD2:
			boolean canuse2 = false;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof WoodenSword && player.getSword() == null) {
					player.useSword((Sword) player.getInventory().getItemN(i));
					screen.equipSword((Sword) player.getInventory().getItemN(i));
					canuse2 = true;
					break;
				}
				else {
					canuse2 = false;
				}
			}
			if(!canuse2) {
				screen.cantUse();
			}
			player.closeInventory();
			break;
		case USESWORD3:
			boolean canuse3 = false;
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof IronSword && player.getSword() == null) {
					player.useSword((Sword) player.getInventory().getItemN(i));
					screen.equipSword((Sword) player.getInventory().getItemN(i));
					canuse3 = true;
					break;
				}
				else {
					canuse3 = false;
				}
			}
			if(!canuse3) {
				screen.cantUse();
			}
			player.closeInventory();
			break;
		case UNUSESWORD1:
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof CorkscrewSword) {
					Sword sword = (Sword) player.getInventory().getItemN(i);
					player.unuseSword((Sword) player.getInventory().getItemN(i));
					screen.unequipSword((Sword) player.getInventory().getItemN(i));
					break;
				}
			}
			player.closeInventory();
			break;

		case UNUSESWORD2:
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof WoodenSword) {
					Sword sword = (Sword) player.getInventory().getItemN(i);
					player.unuseSword((Sword) player.getInventory().getItemN(i));
					screen.unequipSword((Sword) player.getInventory().getItemN(i));
					break;
				}
			}
			player.closeInventory();
			break;

		case UNUSESWORD3:
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof IronSword) {
					Sword sword = (Sword) player.getInventory().getItemN(i);
					player.unuseSword((Sword) player.getInventory().getItemN(i));
					screen.unequipSword((Sword) player.getInventory().getItemN(i));
					break;
				}
			}
			player.closeInventory();
			break;

		case UNUSEARMOR1:
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof PaperboardArmor) {
					Armor  armor = (Armor) player.getInventory().getItemN(i);
					player.unuseArmor((Armor) player.getInventory().getItemN(i));
					screen.unequipArmor((Armor) player.getInventory().getItemN(i));
					break;
				}
			}
			player.closeInventory();
			break;

		case UNUSEARMOR2:
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof SteelArmor) {
					Armor  armor = (Armor) player.getInventory().getItemN(i);
					player.unuseArmor((Armor) player.getInventory().getItemN(i));
					screen.unequipArmor((Armor) player.getInventory().getItemN(i));
					break;
				}
			}
			player.closeInventory();
			break;

		case UNUSEARMOR3:
			for(int i = 0; i < player.getInventory().getNbDifferentItems();i++) {
				if(player.getInventory().getItemN(i) instanceof Nokia3310Armor) {
					Armor  armor = (Armor) player.getInventory().getItemN(i);
					player.unuseArmor((Armor) player.getInventory().getItemN(i));
					screen.unequipArmor((Armor) player.getInventory().getItemN(i));
					break;
				}
			}
			player.closeInventory();
			break;
		case OPEN:
			player.openChest(player.getCurrentLocation().getChest());
			screen.openChest(player.getCurrentLocation().getChest());
			player.getCurrentLocation().setChest(null);
		}
	}
	
	private void setBossKilled(boolean killed) {
		this.bossKilled = true;
	}
	
	private boolean endOfTheGame() {
		if(player.isAlive() && bossKilled) {
			return true;
		}
		if(player.isAlive()) {
			return false;
		}
		else {
			return true;
		}
	}



}
