package client.manage;

/**
 * ������ȡ����
 * 
 * ʾ��
 * {@code 
 * GetData<Post> data=userOperate.getPost();
 * Post post;
 * while((post=data.next())!=null){
 * 		//��ӵ�������
 * }
 * } 
 * ����һ��ֻ��ȡ����Data����ֹ�Է�������ɲ���Ҫ��ѹ����
 *
 */
public interface GetData <T>{
	/**
	 * ��ȡ����
	 * @return ��ȡ������
	 * */
	T next();
}
