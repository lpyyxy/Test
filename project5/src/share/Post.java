package share;

/**
 * 用于存储Post的信息
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Henry Emmert
 * @version July 17, 2021
 */

public class Post implements Data<Post>{
	private boolean delete=false;
    private String title; //title of post
    private User author; //author of post
    private String content; //content of post
    private long timestamp; //timestamp of post
    private int temporaryID;
    public Post(String title,User author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    /**
     * gets the title of the post
     *
     * @return post title
     */
    public String getTitle() {
        return delete?null:title;
    }

    /**
     * gets the author of the post
     *
     * @return post author
     */
    @Override
    public User getAuthor() {
        return delete?null: author;
    }

    /**
     * gets the content of the post
     *
     * @return post content
     */
    @Override
    public String getContent() {
        return delete?null: content ;
    }


	@Override
	public void updateTimestamp() {
		timestamp=System.currentTimeMillis();
	}

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
