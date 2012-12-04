package com.adventureteamllc.adventuregram;



//import com.adventureteamllc.adventuregram.Event;
//import com.adventureteamllc.adventuregram.Event;
import java.util.Scanner;
import java.util.Stack;


/**
 * // -------------------------------------------------------------------------
/**
 *  For testing purposes.
 *
 *  @author Brian Wright
 *  @version Nov 24, 2012
 */
public class Game
{
    public static void main(String [] args)
    {
        System.out.println("game startse");
        Game g = new Game();
        g.play();
    }



    //enables backtracking through story
    private Stack<Event> playerPath;
    private Story map;

    public Game()
    {
        playerPath = new Stack<Event>();
        map = new Story();
        Event ev0 = new Event("title", "start");
        Event ev1 = new Event("title2", "asfasdf");
        Event ev2 = new Event("title3", "end");
        Event ev5= new Event("title5", "other choice");
        ev2.setEnd();
        ev0.addCommand(new Command("go to ev1", "1"));
        ev0.addCommand(new Command("go to ev5 but don't cause it doesn't go to end", "3"));
        ev1.addCommand(new Command("got to ev2", "2"));

        map.addEvent(ev0);
        map.addEvent(ev1);
        map.addEvent(ev2);
        map.addEvent(ev5);

        playerPath.push(ev0);


    }

    public void movePlayer(int choice)
    {
       // playerPath.peek().getEvent(choice);
    }

    public void play()
    {
        Scanner in = new Scanner(System.in);

        String s = "";

        while(!s.startsWith("end") && !playerPath.peek().isEnd())
        {
            System.out.println(playerPath.peek().getDescription());
            int count = playerPath.peek().getNumConnections();
            for (int i = 0; i <  count; i++)
            {
                System.out.println(""+(i+1) + " : "+playerPath.peek().getCommand(i).getName());
            }

            s = in.nextLine();
            char ch = s.charAt(0);
            int offset = ch - '1';
            if (offset >= 0 && offset < count)
            {
                playerPath.push(map.getEvent(playerPath.peek().getCommand(offset).getTarget()));
            }

            //System.out.println(":"+ s);
        }
        if(playerPath.peek().isEnd())
        {
            System.out.println("yuou wind");
        }
    }





}
