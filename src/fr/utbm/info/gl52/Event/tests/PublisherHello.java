package fr.utbm.info.gl52.Event.tests;

import java.util.Scanner;

import fr.utbm.info.gl52.Event.EventService;
import fr.utbm.info.gl52.Event.IPublisher;

public class PublisherHello implements IPublisher {
	public PublisherHello()
	{

	}
	public void test()
	{
		/*
		EventService.getInstance().publish(new EventHello("test 1!"));
		EventService.getInstance().publish(new EventHello("test 2!"));
		EventService.getInstance().publish(new EventHello("test 3!"));
		EventService.getInstance().publish(new EventHello("test 4 : hello !"));*/
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Inscription à deux evenements EventHello avec deux Filtres:");
		System.out.println("Les chaînes contenant 'hello' (sensible à la casse) ne déclenchent pas d'evenement (FilterHello)");
		System.out.println("Les chaînes contenant 'bite' (non sensible à la casse) déclenche l'evenement (FilterBite) ");
		
		while(true)
		{
			System.out.println("In:");
			
			String str = sc.nextLine();
			if (!str.isEmpty())
			{
				System.out.println("Out:"+str);
				EventService.getInstance().publish(new EventHello(str));
			}
		}
	}
}
