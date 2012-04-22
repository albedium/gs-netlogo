package org.graphstream.netlogo.extension;

import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;
import org.nlogo.api.Syntax;

public class AddReceiver extends DefaultCommand {
	@Override
	public String getAgentClassString() {
		return "O";
	}

	@Override
	public Syntax getSyntax() {
		return Syntax.commandSyntax(new int[] { Syntax.TYPE_STRING,
				Syntax.TYPE_STRING, Syntax.TYPE_NUMBER });
	}

	@Override
	public void perform(Argument[] args, Context context)
			throws ExtensionException, LogoException {
		try {
			String receiverId = args[0].getString();
			String host = args[1].getString();
			int port = args[2].getIntValue();
			GSManager.addReceiver(receiverId, host, port);
		} catch (LogoException e) {
			throw new ExtensionException(e.getMessage());
		}
	}

}