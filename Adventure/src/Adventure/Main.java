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
			
		}	
		
	
	}
	
}
