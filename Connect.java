package client.manage;

import java.io.IOException;
import java.net.Socket;
/**
 * ����Э��GUI����
 *
 * ������Գ�ʼ����ˣ�����start�����󣬾Ϳ����ú�˿�ʼ����
 * ͬʱ����һ��UserOperate��
 * UserOperate�������ǣ����¼�����ʱ�ɵ�����Ӧ�ķ������������ӿɼ�{@link UserOperate}
 */
public final class Connect {
	private final Socket socket;
	/**
	 * 
	 * @param socket Ҫ���ӵķ�������Socket����������SoTimeout
	 * */
	public Connect(Socket socket) {
		this.socket=socket;
	}
	/**
	 * �ú�˿�ʼ����������÷�����GUI�����߳��ϵ��á�
	 * 
	 * */
	public UserOperate start() throws IOException {
		//TODO
		return null;
	}
	/**
	 * �������
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
