package client.manage;

import java.io.IOException;
import java.net.Socket;
/**
 * 用于协调GUI与后端
 *
 * 该类可以初始化后端，调用start方法后，就可以让后端开始工作
 * 同时返回一个UserOperate类
 * UserOperate的作用是：当事件发生时可调用相应的方法，具体例子可见{@link UserOperate}
 */
public final class Connect {
	private final Socket socket;
	/**
	 * 
	 * @param socket 要连接的服务器的Socket，建议设置SoTimeout
	 * */
	public Connect(Socket socket) {
		this.socket=socket;
	}
	/**
	 * 让后端开始工作，建议该方法在GUI启动线程上调用。
	 * 
	 * */
	public UserOperate start() throws IOException {
		//TODO
		return null;
	}
	/**
	 * 结束后端
	 * 
	 * */
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO
	}
}
