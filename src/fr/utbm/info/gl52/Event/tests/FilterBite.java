package fr.utbm.info.gl52.Event.tests;

import fr.utbm.info.gl52.Event.IEvent;
import fr.utbm.info.gl52.Event.IFilter;

public class FilterBite implements IFilter {

	@Override
	public boolean apply(IEvent e) {
		if (IEvent.class.getClass() != EventHello.class.getClass())
			return false;
		else
			if (((EventHello)e).text.toLowerCase().contains("bite"))
				return true;
		return false;
	}

}
