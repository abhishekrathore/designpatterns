import java.io.IOException;

interface CommandExecutor {

	public void runCommand(String cmd) throws Exception;
}


class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws IOException {
                //some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}


class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pwd){
		if("abhishek".equals(user) && "youstart".equals(pwd)) isAdmin=true;
		executor = new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		if(isAdmin){
			executor.runCommand(cmd);
		}else{
			if(cmd.trim().startsWith("rm")){
				throw new Exception("rm command is not allowed for non-admin users.");
			}else{
				executor.runCommand(cmd);
			}
		}
	}

}

public class ProxyTest {

	public static void main(String[] args){
		CommandExecutor executor = new CommandExecutorProxy(args[0], args[1]);
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand("rm -r demo.txt");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
		
    }
}