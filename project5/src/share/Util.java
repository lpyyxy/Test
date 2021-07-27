package share;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * 一些实用类
 *
 */
public class Util {
	/**
	 * 用于把Post存储为CSV
	 *
	 */
	public static void postToCSV(ArrayList<Post> posts,File file) throws FileNotFoundException{
		PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (Post post:posts) {
                pw.printf("%s,%s,%s,%s\n", post.getTitle(), post.getAuthor(),post.getContent(), post.getTimestamp());
            }
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            pw.close();
        }
	}
	/**
	 * 用于把CSV导入
	 *
	 */
	public static ArrayList<Post> CSVToPost(User own,File file) throws IOException {
        ArrayList<Post> list = new ArrayList<>();
        BufferedReader bufferedReader=null;
        try {
        	bufferedReader=new BufferedReader(new FileReader(file));
        	bufferedReader.lines().forEach((line)->{
            	String[] datas = line.split(",");
            	if(datas.length==3){
            		list.add(new Post(datas[0],new User(datas[1]), datas[2]));
            	}
            });
        } catch (FileNotFoundException e) {
           throw e;
        }finally {
        	if(bufferedReader!=null) 
        		bufferedReader.close();
        }

        return list;
	}
	public static byte[] toByteArray (Object obj) {      
        byte[] bytes = null;      
        ByteArrayOutputStream bos = new ByteArrayOutputStream();      
        try {        
            ObjectOutputStream oos = new ObjectOutputStream(bos);         
            oos.writeObject(obj);        
            oos.flush();         
            bytes = bos.toByteArray ();      
            oos.close();         
            bos.close();        
        } catch (IOException ex) {        
            ex.printStackTrace();   
        }      
        return bytes;    
    }   
       
    public static Object toObject (byte[] bytes) {    
        Object obj = null;      
        try {        
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
            ObjectInputStream ois = new ObjectInputStream (bis);        
            obj = ois.readObject();      
            ois.close();   
            bis.close();   
        } catch (IOException ex) {        
            ex.printStackTrace();   
        } catch (ClassNotFoundException ex) {        
            ex.printStackTrace();   
        }      
        return obj;    
    }   
	public static int byteArrayToInt(byte[] data) {
		return byteArrayToInt(0,data);
	}
	public static int byteArrayToInt(int subscript,byte[] data) {
		return (data[subscript]&0xff)|((data[subscript+1]&0xff)<<8)|((data[2]&0xff)<<16)|((data[3]&0xff)<<24);
	}
	public static short byteArrayToShort(byte[] data) {
		return byteArrayToShort(0,data);
	}
	public static short byteArrayToShort(int subscript,byte[] data) {
		return (short) ((data[subscript]&0xff)|((data[subscript+1]&0xff)<<8));
	}
	public static byte[] intToByteArray(int data) {
		byte[] bytes=new byte[4];
		bytes[3]=(byte)(data>>24);
		bytes[2]=(byte)(data>>16);
		bytes[1]=(byte)(data>>8);
		bytes[0]=(byte)data;
		return bytes;
	}
	public static byte[] shortToByteArray(short data) {
		byte[] bytes=new byte[2];
		bytes[1]=(byte)(data>>8);
		bytes[0]=(byte)data;
		return bytes;
	}
	public static short intToShort(int data) {
		return (short)data;
	}
	public static int shortToInt(short data) {
		return ((int)data)&0x0000ffff;
	}
}
