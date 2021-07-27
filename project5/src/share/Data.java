package share;

import java.io.Serializable;

public interface Data <T> extends Operate,Serializable{
	User getAuthor();
	String getContent();
	void updateTimestamp();
	long getTimestamp();
	void setTemporaryID(int temporaryID);
	int getTemporaryID();
}
