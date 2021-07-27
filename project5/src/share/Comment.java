package share;
/**
 * 用于存储Comment的信息
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Henry Emmert
 * @version July 19, 2021
 */

public class Comment implements Data<Comment>{
	private boolean delete=false;
    private User author; //author of post
    private String content; //content of post
    private long timestamp=0; //timestamp of post
    private int temporaryID;
    public Comment(User author, String content) {
        this.author = author;
        this.content = content;
    }

    /**
     * gets the author of the comment
     *
     * @return comment author
     */
    @Override
    public User getAuthor() {
        return delete?null:author;
    }

    /**
     * gets the content of the comment
     *
     * @return comment content
     */
    @Override
    public String getContent() {
        return delete?null: content;
    }

	@Override
	public void updateTimestamp() {
		timestamp=System.currentTimeMillis();
	}

    /**
     * gets the timestamp of the comment
     *
     * @return comment timestamp
     */
    @Override
	public long getTimestamp() {
		return delete?-1:timestamp;
	}


	@Override
	public void delete() {
		delete=true;
	}
	@Override
	public boolean isDelete() {
		return delete;
	}

	@Override
	public int getTemporaryID() {
		return temporaryID;
	}

	@Override
	public void setTemporaryID(int temporaryID) {
		this.temporaryID=temporaryID;
	}
	
}

