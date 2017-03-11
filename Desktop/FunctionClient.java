import java.io.ObjectOutputStream;
import java.net.Socket;

public class FunctionClient {

	public static void main(String[] args) throws Exception {
		String ip = "10.67.20.108";

		Socket socket = new Socket(ip, 9999);
		ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

		FunctionInterface functionInterface = a -> a + 5;

		os.writeObject(functionInterface);

		os.flush();
		os.close();
		socket.close();

		System.out.println(functionInterface.apply(5));

	}

}
