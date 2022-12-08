package Adventure;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		//enemy variables
		String[] enemies = {"Minion", "Dark Knight", "Coven Witch", "Scoundrel"};
		int maxEnemyHealth = 75;
		int enemyAttackDmg = 25;
		
		//player variables
		int hp = 100;
		int attackDmg = 50;
		int numHpPotions = 3;
		int potionHeal = 30;
		int potionChance = 50;
		
		boolean running = true;
		
		System.out.println("Welcome to the pit");
		
		GAME:
		while(running) {
			System.out.println("----------------------------------");
			//enemy spawn
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has come to fight! #\n");
			
			//fight sequence
			while(enemyHealth > 0){
				//User display and actions
				System.out.println("\tYour HP: " + hp);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tChoose Action");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink Potion");
				System.out.println("\t3. Run Away");
				
				String input = sc.nextLine();
				//outcomes from the user's input
				if(input.equals("1")) {//fight enemy
					int damageDealt = rand.nextInt(attackDmg);
					int damageTaken = rand.nextInt(enemyAttackDmg); 
				
					enemyHealth -= damageDealt;
					hp -= damageTaken;
					
					System.out.println("\t> You attacked " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You were damaged for " + damageTaken);
				
					if(hp < 1) {
						System.out.println("\t> You were slain in battle");
						break;
					}
					
				}
				else if(input.equals("2")) {//drink potion
					if(numHpPotions > 0) {
						hp += potionHeal;
						numHpPotions --;
						System.out.println("\t> You drink a potion and restore " + potionHeal + " HP.");
						System.out.println("\t Your total health is now " + hp + " HP.");
						System.out.println("\t You have " + numHpPotions + " remaining.\n");
					}
					else {
						System.out.println("\t> You have no more remaining potions. Fight more to find some.");
					}
				}
				else if(input.equals("3")) {//run away
					System.out.println("\tYou ran away from " + enemy);
					continue GAME;
				}
				else {
					System.out.println("\tInvalid Input ");
				}
			}
			
			if(hp < 1) {
				System.out.println("\t You are too weak to continue and pass out unknowing of what will happen next.");
				break;
			}
			
			System.out.println("----------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated # " );
			System.out.println("You have " + hp + " HP left. # ");
				
			if(rand.nextInt(100) < potionChance) {
				numHpPotions ++;
				System.out.println(" # The " + enemy + " dropped a Health Potion # ");
				System.out.println(" # You have " + numHpPotions + " Potions now. # ");
			}
				
			System.out.println("----------------------------------------------------");
			System.out.println("Continue fighting?" );
			System.out.println("1. Continue going");
			System.out.println("2. Leave the pit");
			
			String input = sc.nextLine();
				
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Input");
				input = sc.nextLine();
			}
				
			if(input.equals("1")) {
				System.out.println("You continue to fight.");
			}
			else if(input.equals("2")) {
				System.out.println("You leave the pit and stop fighting");
				break;	
			}
		}	
	}	
}