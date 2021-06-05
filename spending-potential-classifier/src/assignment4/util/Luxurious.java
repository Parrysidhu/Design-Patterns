package assignment4.util;

import assignment4.driver.Driver;

public class Luxurious implements stateI {
	Context context;

	public Luxurious(Context newContext) {
		context = newContext;
	}

	@Override
	public void giveOutput(String item) {
		Boolean flag = false;
		for (Integer i = 0; i < Context.avalItems.length; i++) {
			if ((Context.avalItems[i][0].equals("basic") || Context.avalItems[i][0].equals("moderatelyExpensive"))
					&& item.equals(Context.avalItems[i][1])) {
				flag = true;
			}
		}

		if (flag)
			Driver.builder.append("LUXURIOUS::" + item + "--YES\n");
		else
			Driver.builder.append("LUXURIOUS::" + item + "--NO\n");
	}

}
