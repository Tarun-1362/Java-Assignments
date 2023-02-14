package Assignments;

import java.util.Iterator;
import java.util.Scanner;

class Guesser
{
	int guessnum;
	public int guess() 
	{
		Scanner sg=new Scanner(System.in);
		System.out.println("enter the guesser number between 1 to 10::");
		guessnum=sg.nextInt();
		if(guessnum>0 && guessnum<=10)
			return guessnum;
		else 
		{	
			return guess();
	    }
	}
}
class Players
{
	int player;
	int noOfPlayers;
	public int[] guessplayers() 
	{
		System.out.println("enter the number of players to be in the game");
		Scanner sc= new Scanner(System.in);
		noOfPlayers=sc.nextInt();
		int[] players=new int[noOfPlayers];
		for(int i=0;i<=noOfPlayers-1;i++)
		{
			System.out.println("enter number for " + (i+1) + " player between 1 to 10");
			players[i]=sc.nextInt();	
		}
		return players ;
		
	}
}
class Umpire 
{
	int numfromguesser;
	int[] optionsOfPlayers;
	
	void opguesser()
	{
		Guesser g=new Guesser();
		numfromguesser=g.guess();	
	}
	void opplayers() 
	{
		Players p = new Players();
		optionsOfPlayers=p.guessplayers();
	}
		
	void compare()
	{
		int count=0;
		int num=optionsOfPlayers.length;
		for (int i = 0; i <=num-1; i++) 
		{
			if(optionsOfPlayers[i]==numfromguesser) 
			{
				++count;
				System.out.println("Player "+ (i+1) + " won the game and the number is "+ optionsOfPlayers[i]);
			}
			
			else
				continue;
		}
		if(count==0)
			System.out.println("no one won the gam, Please restart");
		else if(count==optionsOfPlayers.length)
			System.out.println("All players won, Please restart");
	}
}
public class GuesserGame
{
	
	public static void main(String[] args) 
	{
		Umpire u=new Umpire();
		u.opguesser();
		u.opplayers();
		u.compare();
	}

}