package assignment4.util;

import assignment4.driver.Driver;

public class Extravagant implements stateI {
	Context context;

	public Extravagant(Context newContext) {
		context = newContext;
	}

	@Override
	public void giveOutput(String item) {
		Boolean flag = false;
		for (Integer i = 0; i < Context.avalItems.length; i++) {
			if ((Context.avalItems[i][0].equals("basic") || Context.avalItems[i][0].equals("moderatelyExpensive")
					|| Context.avalItems[i][0].equals("superExpensive")) && item.equals(Context.avalItems[i][1])) {
				flag = true;
			}
		}

		if (flag)
			Driver.builder.append("EXTRAVAGANT::" + item + "--YES\n");
		else
			Driver.builder.append("EXTRAVAGANT::" + item + "--NO\n");
	}

}
