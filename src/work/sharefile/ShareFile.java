package work.sharefile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

public class ShareFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getShareFile();
	}
	
	public static void getShareFile(){
		String ip = "192.168.1.103";
		String uname = "wonders";
		String unpw = "10.1.241.69";
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null,uname,unpw);
		String url = "smb://Administrator:aaaa11@10.1.241.69/FFOutput/";
		try{
		SmbFile file = new SmbFile(url);
		//file.connect();
		if(file.exists()){
			SmbFile[] files = file.listFiles();
			for(SmbFile f : files){
				System.out.println(f.getName());
				String localDir = "E:";
				InputStream in = new BufferedInputStream(new SmbFileInputStream(f));
				File localFile = new File(localDir + File.separator + f.getName());
				OutputStream out = new BufferedOutputStream(new FileOutputStream(localFile));
//				SmbFileInputStream fis = new SmbFileInputStream(f);
//				File localFile = new File(localDir + File.separator + f.getName());
//				OutputStream out = new FileOutputStream(localFile);
//				fis.
				System.out.println(f.getContentLength());
				byte[] buffer = new byte[1024*1024];
				System.out.println("111111111111111");
				while(in.read(buffer) != 1){
					System.out.println("222222222");
					out.write(buffer);
					System.out.println("333333333");
					buffer = new byte[1024*1024];
				}
				in.close();
				out.close();
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
