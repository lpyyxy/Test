package client.manage;

import share.Comment;
import share.Data;
import share.Post;
import share.User;
/**
 * ���¼�����ʱ�ɵ�����Ӧ�ķ���
 *
 * ���磺
 * GUI����֮�󣬵�����¼���棬�û������˺����벢����˵�¼��ť
 * �����˰�ť����¼���Ȼ���ȼ���û������Ƿ�Ϊ�գ����Ϊ�գ�
 * ����������ʾ����Ϊ�գ������Ϊ�գ�����UserOperate�е�login����
 * login�����᷵��{@link User}�����Ϊnull����ô���Ƿ������ܾ���¼��һ�����������
 * �����Ϊnull���ǾͿ��Բ鿴�û���Ϣ��
 * Ȼ������������ˣ�����������֮��Ϳ��Ե���UserOperate�е�getPost����
 * getPost�᷵��GetData���󣬾�����ô�ÿ��Բο�{@link GetData}
 * ��GetData�Ϳ��Ի�ȡ{@link Post}�ˣ�����û�����һ��Post����ȡPost��temporaryID
 * Ȼ�����UserOperate�е�getComment�����Ϳ��Ի�ȡ��Post��Comment��
 */
public interface UserOperate {
	/**
	 * ��¼��������������ѵ�¼���ȵ���logout()���ٵ�¼
	 * 
	* @param name �û�����
	* @param password �û�����
	*/
	User login(String name,String password);
	/**
	 * �޸��Լ������ϣ�ע��name�����޸�
	 * 
	* @param user Ҫ�޸ĵ�����
	*/
	boolean editUser(User user);
	/**
	 * ɾ���û���ע����Ҫ�ٴ�ȷ��
	 * 
	* @param user Ҫɾ�����û�
	*/
	boolean deleteUser(User user);
	/**
	 * ע���˺�
	 * 
	*/
	void logout();
	/**
	 * �����û�����������
	 * 
	* @param name �û���
	*/
	GetData<Data> find(String name);
	/**
	 * ����Post��TemporaryID����Comment
	 * 
	* @param PostTemporaryID Ŀ��Post��TemporaryID
	*/
	GetData<Comment> getComment(int PostTemporaryID);
	/**
	 * ��ȡ���µ�Post
	 * 
	*/
	GetData<Post> getPost();
	/**
	 * �ύComment
	 * 
	 * @param PostTemporaryID Ŀ��Post��TemporaryID
	 * @param comment Ҫ�ύ��Comment 
	 * @return �Ƿ�ɹ��ύ
	*/
	boolean addComment(int PostTemporaryID,Comment comment);
	/**
	 * �ύPost
	 * 
	 * @param post Ҫ�ύ��Post
	 * @return �Ƿ�ɹ��ύ
	*/
	boolean addPost(Post post);
	/**
	 * �༭Comment
	 * 
	 * @param PostTemporaryID Ŀ��Comment��Post��TemporaryID
	 * @param CommentTemporaryID Ŀ��Comment��TemporaryID
	 * @param comment Ҫ�ύ��Comment 
	 * @return �Ƿ�ɹ��༭
	*/
	boolean editComment(int PostTemporaryID,int CommentTemporaryID,Comment comment);
	/**
	 * �༭Post
	 * 
	 * @param PostTemporaryID Ŀ��Post��TemporaryID
	 * @param post Ҫ�ύ��Post
	 * @return �Ƿ�ɹ��༭
	*/
	boolean editPost(int PostTemporaryID,Post post);
	/**
	 * ɾ��Comment
	 * 
	 * @param PostTemporaryID Ŀ��Comment��Post��TemporaryID
	 * @param CommentTemporaryID Ŀ��Comment��TemporaryID
	 * @return �Ƿ�ɹ�ɾ��
	*/
	boolean deleteComment(int PostTemporaryID,int CommentTemporaryID);
	/**
	 * ɾ��Post
	 * 
	 * @param PostTemporaryID Ŀ��Post��TemporaryID
	 * @return �Ƿ�ɹ�ɾ��
	*/
	boolean deletePost(int PostTemporaryID);
}
