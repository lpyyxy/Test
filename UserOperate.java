package client.manage;

import share.Comment;
import share.Data;
import share.Post;
import share.User;
/**
 * 当事件发生时可调用相应的方法
 *
 * 例如：
 * GUI启动之后，弹出登录界面，用户输入账号密码并点击了登录按钮
 * 触发了按钮点击事件，然后先检查用户输入是否为空，如果为空，
 * 弹出窗口提示输入为空，如果不为空，调用UserOperate中的login方法
 * login方法会返回{@link User}，如果为null，那么就是服务器拒绝登录，一般是密码错了
 * 如果不为null，那就可以查看用户信息了
 * 然后出来主界面了，出来主界面之后就可以调用UserOperate中的getPost方法
 * getPost会返回GetData对象，具体怎么用可以参考{@link GetData}
 * 用GetData就可以获取{@link Post}了，如果用户进入一个Post，获取Post的temporaryID
 * 然后调用UserOperate中的getComment方法就可以获取打开Post的Comment了
 */
public interface UserOperate {
	/**
	 * 登录到服务器，如果已登录，先调用logout()，再登录
	 * 
	* @param name 用户名称
	* @param password 用户密码
	*/
	User login(String name,String password);
	/**
	 * 修改自己的资料，注意name不可修改
	 * 
	* @param user 要修改的内容
	*/
	boolean editUser(User user);
	/**
	 * 删除用户，注意需要再次确认
	 * 
	* @param user 要删除的用户
	*/
	boolean deleteUser(User user);
	/**
	 * 注销账号
	 * 
	*/
	void logout();
	/**
	 * 根据用户名查找内容
	 * 
	* @param name 用户名
	*/
	GetData<Data> find(String name);
	/**
	 * 根据Post的TemporaryID查找Comment
	 * 
	* @param PostTemporaryID 目标Post的TemporaryID
	*/
	GetData<Comment> getComment(int PostTemporaryID);
	/**
	 * 获取最新的Post
	 * 
	*/
	GetData<Post> getPost();
	/**
	 * 提交Comment
	 * 
	 * @param PostTemporaryID 目标Post的TemporaryID
	 * @param comment 要提交的Comment 
	 * @return 是否成功提交
	*/
	boolean addComment(int PostTemporaryID,Comment comment);
	/**
	 * 提交Post
	 * 
	 * @param post 要提交的Post
	 * @return 是否成功提交
	*/
	boolean addPost(Post post);
	/**
	 * 编辑Comment
	 * 
	 * @param PostTemporaryID 目标Comment的Post的TemporaryID
	 * @param CommentTemporaryID 目标Comment的TemporaryID
	 * @param comment 要提交的Comment 
	 * @return 是否成功编辑
	*/
	boolean editComment(int PostTemporaryID,int CommentTemporaryID,Comment comment);
	/**
	 * 编辑Post
	 * 
	 * @param PostTemporaryID 目标Post的TemporaryID
	 * @param post 要提交的Post
	 * @return 是否成功编辑
	*/
	boolean editPost(int PostTemporaryID,Post post);
	/**
	 * 删除Comment
	 * 
	 * @param PostTemporaryID 目标Comment的Post的TemporaryID
	 * @param CommentTemporaryID 目标Comment的TemporaryID
	 * @return 是否成功删除
	*/
	boolean deleteComment(int PostTemporaryID,int CommentTemporaryID);
	/**
	 * 删除Post
	 * 
	 * @param PostTemporaryID 目标Post的TemporaryID
	 * @return 是否成功删除
	*/
	boolean deletePost(int PostTemporaryID);
}
