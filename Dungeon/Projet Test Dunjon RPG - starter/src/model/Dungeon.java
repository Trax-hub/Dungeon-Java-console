package model;

public class Dungeon {

	private Room startingRoom;

	//Constructor
	/**
	 * This constructor create a Dungeon and call the method initRooms
	 */
	public Dungeon() {
		super();
		initRooms();
	}

	//Method
	/**
	 * This method creates Rooms, Enemies and Traps and linked them
	 */
	private void initRooms() {

		//Creation of the rooms
		startingRoom = new Room("Starting Room");
		Room roomB = new Room("Room B");
		Room roomC = new Room("Room C"); //salle des coffres
		Room roomD = new Room("Room D");
		Room roomE = new Room("Room E");
		Room roomF = new Room("Room F");
		Room roomG = new Room("Room G");
		Room roomH = new Room("Room H");
		Room roomI = new Room("Room I");
		Room roomJ = new Room("Room J");
		Room roomK = new Room("Room K");
		Room roomL = new Room("Room L");
		Room roomM = new Room("Room M");
		Room roomN = new Room("Room N");
		Room roomO = new Room("Room O");
		Room roomP = new Room("Room P");
		Room roomQ = new Room("Room Q");
		Room roomR = new Room("Room R");
		Room roomS = new Room("Room S");
		Room roomT = new Room("Room T");
		Room roomU = new Room("Room U");
		Room roomV = new Room("Room V");
		Room roomW = new Room("Room W");
		Room roomX = new Room("Room X");
		Room roomY = new Room("Room Y");
		Room roomZ = new Room("Room Z");
		Room roomAA = new Room("Room AA");
		Room roomAB = new Room("Room AB");
		Room roomAC = new Room("Room AC");
		Room roomAD = new Room("Room AD");
		Room roomAE = new Room("Room AE");
		Room roomAF = new Room("Room AF");
		Room roomAG = new Room("Room AG");
		Room roomAH = new Room("Room AH");
		Room roomAI = new Room("Room AI");
		Room roomAJ = new Room("Room AJ");
		Room finalRoom = new Room("Final Room");

		Zombie z1 = new Zombie(); //B
		Zombie z2 = new Zombie(); //P
		Zombie z3 = new Zombie(); //D
		Zombie z4 = new Zombie(); //K
		Zombie z5 = new Zombie(); //H
		Zombie z6 = new Zombie(); //M
		Zombie z7 = new Zombie(); //AI
		Zombie z8 = new Zombie(); //T
		Zombie z9 = new Zombie(); //X
		Zombie z10 = new Zombie(); //Z
		Zombie z11 = new Zombie(); //AA
		Zombie z12 = new Zombie(); //AC

		Skeleton s1 = new Skeleton(); //AE
		Skeleton s2 = new Skeleton(); //G
		Skeleton s3 = new Skeleton(); //L
		Skeleton s4 = new Skeleton(); //AB

		Psychopath p1 = new Psychopath(); //N
		Psychopath p2 = new Psychopath(); //AG

		Boss b1 = new Boss();

		Trap t1 = new Trap("an arrow trap", "It rains arrows", 15); //f
		Trap t2 = new Trap("an axes trap", "an ax falls from the sky", 10); //Q
		Trap t3 = new Trap("a wall trap", "a wall fall in front of you", 13); //U
		Trap t4 = new Trap("a spider trap", "some little spiders stings you", 5);//V
		Trap t5 = new Trap("an arrow trap", "It rains arrows", 15);//X
		Trap t6 = new Trap("a bomb trap","a bomb exploded on this room" , 30);//AB
		Trap t7 = new Trap("a new trap", "there are spikes on the ground of this room",20);//AG
		Trap t8 = new Trap("a shadow trap", "a dark force weakens you a lot", 40);//K

		WaterBottlePotion w1 = new WaterBottlePotion(); // z1 + roomB
		WaterBottlePotion w2 = new WaterBottlePotion(); //chest 5 + roomI
		WaterBottlePotion w3 = new WaterBottlePotion(); //chest6 + roomS
		WaterBottlePotion w4 = new WaterBottlePotion(); // z5 + roomH
		WaterBottlePotion w5 = new WaterBottlePotion(); //s3 + roomL


		AppleJuicePotion a1 = new AppleJuicePotion(); //chest8 + roomY
		AppleJuicePotion a2 = new AppleJuicePotion(); //s1 + roomAE
		AppleJuicePotion a3 = new AppleJuicePotion(); //s4 + roomAB
		AppleJuicePotion a4 = new AppleJuicePotion(); //p1 + roomN
		AppleJuicePotion a5 = new AppleJuicePotion(); //p2 + roomAG


		IronSword i1 = new IronSword(); //chest4 + roomAJ


		WoodenSword wd1 = new WoodenSword(); //z12 + roomAC


		CorkscrewSword c1 = new CorkscrewSword(); //chest3 + roomC

		Nokia3310Armor n1 = new Nokia3310Armor(); //chest1 + roomAH


		SteelArmor sa1 = new SteelArmor(); //chest7 +roomO

		PaperboardArmor pa1 = new PaperboardArmor(); //chest2 + roomAD

		Chest ch1 = new Chest(); //roomAH
		Chest ch2 = new Chest(); //roomAD
		Chest ch3 = new Chest(); //roomC
		Chest ch4 = new Chest(); //roomAJ
		Chest ch5 = new Chest(); //roomI
		Chest ch6 = new Chest(); //roomS
		Chest ch7 = new Chest(); //roomO
		Chest ch8 = new Chest(); //roomY



		//set chests
		ch1.setItem(n1);   
		ch2.setItem(pa1);
		ch3.setItem(c1);
		ch4.setItem(i1);
		ch5.setItem(w2);
		ch6.setItem(w3);
		ch7.setItem(sa1);
		ch8.setItem(a1);

		//set mobs loots
		//zombies
		z1.setItem(w1);
		z5.setItem(w4);
		z6.setItem(w5);
		z12.setItem(wd1);

		//skeletons
		s1.setItem(a2);
		s3.setItem(w5);
		s4.setItem(a3);

		// Psychopath 
		p1.setItem(a4);
		p2.setItem(a5);



		//Links between the rooms
		startingRoom.setNorthRoom(roomB);

		roomB.setSouthRoom(startingRoom);
		roomB.setWestRoom(roomC);
		roomB.setEastRoom(roomP);
		roomB.setEnemy(z1);


		roomC.setWestRoom(roomD);
		roomC.setEastRoom(roomB);
		roomC.setChest(ch3);

		roomD.setWestRoom(roomE);
		roomD.setEastRoom(roomC);
		roomD.setEnemy(z3);

		roomE.setNorthRoom(roomF);
		roomE.setEastRoom(roomD);


		roomF.setSouthRoom(roomE);
		roomF.setEastRoom(roomI);
		roomF.setNorthRoom(roomG);
		roomF.setTrap(t1);

		roomG.setSouthRoom(roomF);
		roomG.setNorthRoom(roomH);
		roomG.setEnemy(s2);

		roomH.setNorthRoom(roomAG);
		roomH.setSouthRoom(roomG);
		roomH.setEnemy(z5);

		roomI.setWestRoom(roomF);
		roomI.setNorthRoom(roomJ);
		roomI.setChest(ch5);

		roomJ.setNorthRoom(roomK);
		roomJ.setSouthRoom(roomI);

		roomK.setEastRoom(roomL);
		roomK.setSouthRoom(roomJ);
		roomK.setEnemy(z4);
		roomK.setTrap(t8);

		roomL.setEastRoom(roomM);
		roomL.setWestRoom(roomK);
		roomL.setEnemy(s3);

		roomM.setWestRoom(roomL);
		roomM.setSouthRoom(roomN);
		roomM.setEnemy(z6);

		roomN.setNorthRoom(roomM);
		roomN.setSouthRoom(roomO);
		roomN.setEnemy(p1);

		roomO.setNorthRoom(roomN);
		roomO.setChest(ch7);

		roomP.setWestRoom(roomB);
		roomP.setEastRoom(roomR);
		roomP.setSouthRoom(roomQ);
		roomP.setEnemy(z2);

		roomQ.setNorthRoom(roomP);
		roomQ.setEastRoom(roomS);
		roomQ.setTrap(t2);

		roomR.setWestRoom(roomP);
		roomR.setNorthRoom(roomV);
		roomR.setEastRoom(roomT);


		roomS.setWestRoom(roomQ);
		roomS.setChest(ch6);

		roomT.setWestRoom(roomR);
		roomT.setSouthRoom(roomU);
		roomT.setEnemy(z8);

		roomU.setNorthRoom(roomT);
		roomU.setTrap(t3);

		roomV.setNorthRoom(roomW);
		roomV.setSouthRoom(roomR);
		roomV.setTrap(t4);

		roomW.setEastRoom(roomY);
		roomW.setSouthRoom(roomV);
		roomW.setWestRoom(roomX);
		roomW.setNorthRoom(roomAA);

		roomX.setNorthRoom(roomZ);
		roomX.setEastRoom(roomW);
		roomX.setEnemy(z9);
		roomX.setTrap(t5);

		roomY.setWestRoom(roomW);
		roomY.setChest(ch8);

		roomZ.setSouthRoom(roomX);
		roomZ.setEnemy(z10);

		roomAA.setNorthRoom(roomAB);
		roomAA.setSouthRoom(roomW);
		roomAA.setEnemy(z11);

		roomAB.setSouthRoom(roomAA);
		roomAB.setWestRoom(roomAC);
		roomAB.setNorthRoom(roomAJ);
		roomAB.setEnemy(s4);
		roomAB.setTrap(t6);

		roomAC.setWestRoom(roomAD);
		roomAC.setEastRoom(roomAB);
		roomAC.setEnemy(z12);

		roomAD.setWestRoom(roomAE);
		roomAD.setEastRoom(roomAC);
		roomAD.setChest(ch2);

		roomAE.setWestRoom(roomAF);
		roomAE.setNorthRoom(roomAI);
		roomAE.setEastRoom(roomAD);
		roomAE.setEnemy(s1);


		roomAF.setWestRoom(roomAG);
		roomAF.setEastRoom(roomAE);

		roomAG.setNorthRoom(roomAH);
		roomAG.setSouthRoom(roomH);
		roomAG.setEastRoom(roomAF);
		roomAG.setEnemy(p2);
		roomAG.setTrap(t7);

		roomAH.setSouthRoom(roomAG);
		roomAH.setChest(ch1);

		roomAI.setSouthRoom(roomAE);
		roomAI.setEnemy(z7);

		roomAJ.setSouthRoom(roomAB);
		roomAJ.setEastRoom(finalRoom);
		roomAJ.setChest(ch4);

		finalRoom.setEnemy(b1);

	}

	public Room getStartingRoom() {
		return startingRoom;
	}

}
