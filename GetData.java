package client.manage;

/**
 * 用来获取数据
 * 
 * 示例
 * {@code 
 * GetData<Post> data=userOperate.getPost();
 * Post post;
 * while((post=data.next())!=null){
 * 		//添加到界面上
 * }
 * } 
 * 建议一次只读取几个Data，防止对服务器造成不必要的压力。
 *
 */
public interface GetData <T>{
	/**
	 * 获取数据
	 * @return 获取的数据
	 * */
	T next();
}
