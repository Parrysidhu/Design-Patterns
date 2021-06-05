package assignment4.util;

import assignment4.driver.Driver;

public class Basic implements stateI {
	Context context;

	public Basic(Context newContext) {
		context = newContext;
	}

	@Override
	public void giveOutput(String item) {
		Boolean flag = false;
		for (Integer i = 0; i < Context.avalItems.length; i++) {
			if (Context.avalItems[i][0].equals("basic") && item.equals(Context.avalItems[i][1])) {
				flag = true;
			}
		}

		if (flag)
			Driver.builder.append("BASIC::" + item + "--YES\n");
		else
			Driver.builder.append("BASIC::" + item + "--NO\n");
	}

}
