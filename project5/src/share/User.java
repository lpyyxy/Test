package share;

import java.io.Serializable;
/**
 * 用于存储User的信息
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Henry Emmert
 * @version July 17, 2021
 */
public class User implements Operate,Serializable{
	private boolean delete=false;
	private String name;
    private short age;
    private GenderEnum gender;
    public User(String name,short age,GenderEnum gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
    public User(String data) throws IllegalArgumentException{
    	String[] datas = data.split("-");
    	if(datas.length==3) {
    		name=datas[0];
    		age=Integer.valueOf(datas[1]).shortValue();
    		gender=GenderEnum.valueOf(datas[2].toUpperCase());
    	}else {
    		throw new IllegalArgumentException();
    	}
    }
	public String getName() {
		return delete ?null:name;
	}
	public short getAge() {
		return delete?-1:age;
	}
	public GenderEnum getGender() {
		return delete?null:gender;
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
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return obj.hashCode()==hashCode();
	}
	@Override
	public String toString() {
		return new StringBuffer(name).append("-").append(age).append("-").append(gender.toString()).toString();
	} 
}
