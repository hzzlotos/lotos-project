package cn.newtouch.base.frequentlyUsedClasses.string;

import java.io.*;

public class Output4File {

	public void output(String str, String filePath) {

		String[] strs = null;
		
//		byte[] by = null;
		
		if ( null != str) {
			
			Input4File input4File = new Input4File();
			
			String strFormat = input4File.input(filePath).concat("====================\n");
			
//			by = str.getBytes();
			
			strs = strFormat.concat(str).split("\n");
			
		} else {
			
			System.out.println("No String!");
			
			return;
		}
		
		try {
			
			File f = new File(filePath);
			
			FileOutputStream os = new FileOutputStream(f);
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			
			BufferedWriter bf = new BufferedWriter(osw);
			
			for (int i = 0; i < strs.length; i++) {
				
				bf.write(strs[i]);
				
				if ( i < strs.length - 1) {
					
					bf.newLine();
				}
			}
			
			bf.close();
			
			//os.write(by);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
