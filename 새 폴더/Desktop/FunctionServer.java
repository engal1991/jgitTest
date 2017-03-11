import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FunctionServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9999);

		while (true) {
			Socket socket = ss.accept();

			ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
			FunctionInterface f = (FunctionInterface) is.readObject();

			int result = f.apply(10);

			System.out.println(result + " >> result");

			is.close();
			socket.close();
		}

	}
}
