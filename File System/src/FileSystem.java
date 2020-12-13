
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileSystem {

	public static void main(String[] args) {

        System.out.println("********  Welcome to File Management System.   ************");
        System.out.println("********  DEVELOPER : ATUL NIBODH  *********");
        
       start();
        main(args);
	}

	private static void start() {
		
		System.out.println();
		System.out.println("***************************************************************************************************");
        showAllFiles();
        
        System.out.println("Enter Your Choice..");	
        System.out.println("1.Add Files");	
        System.out.println("2.Delete Files");	
        System.out.println("3.Search Files");	
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        
        switch (option) {
		case 1:
			addFile();
			break;
		case 2:
			deleteFile();
			break;
		case 3:
			searchFile();
			break;

		default:
			break;
		}
        start();
	}

	private static void showAllFiles() {
		
		System.out.println("\nFiles List: ");
		System.out.println("--------------------------------");
		try {
	        		String userDirectory = System.getProperty("user.dir");
	        		userDirectory = userDirectory + "/files/";
				File folder = new File(userDirectory);
		
				// list all the files
				File[] files = folder.listFiles();
				for(File file : files) {
					if(file.isFile()) {
						System.out.println(file);
				}
			}
			
			} catch (Exception e) {
				e.getStackTrace();
		}
	}

	private static void addFile() {
        System.out.println("Enter File Name");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine(); 
        String userDirectory = System.getProperty("user.dir");
		userDirectory = userDirectory + "/files/";
        
        try {  
            File file = new File(userDirectory + fileName);  // this line is used to create the file in the specified directory.
            if (file.createNewFile()) {  
                System.out.println("New File named "+ fileName +" is created!");  
            } else {                   
                if(file.exists())
                {
                    System.out.println("File already exists.");	
                    System.out.println("File path:" + file.getAbsolutePath());
                    System.out.println("File name:  " + file.getName());
                    System.out.println("File class:  " + file.getClass());
                    System.out.println("File parent:  " + file.getParent());
                    System.out.println("File space allocated:  " + file.getUsableSpace());
                    System.out.println("File length: " + file.length());

                }
                else
                {
                		System.out.println("File doesnot exists.");
                }

            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
	}

	private static void deleteFile() {

        System.out.println("Enter File Name to be deleted.");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine(); 
        String userDirectory = System.getProperty("user.dir");
		userDirectory = userDirectory + "/files/";
        
        File specifiedFile = new File(userDirectory+fileName); 
         if (specifiedFile.delete()) { 
           System.out.println("Deleted the file: " + specifiedFile.getName());
         } else {
           System.out.println("Failed to delete the file.");
           System.out.println("File does not exist in the Directory");
         }
        
	}

	private static void searchFile() {

        System.out.println("Enter File Name to be searched.");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine(); 
        
        try {
    		String userDirectory = System.getProperty("user.dir");
    		userDirectory = userDirectory + "/files/";
		File folder = new File(userDirectory);

		// list all the files
		File[] files = folder.listFiles();
		boolean isFound = false;
		
		for(File file : files) {
			if(file.getName().equals(fileName)) {
				System.out.println("File named "+fileName +" found successfully");
				isFound = true;
			}
			
		}
		
		if(!isFound)
			System.out.println("File named "+fileName +" not found.");
		
		
	
	} catch (Exception e) {
		e.getStackTrace();
}

	}

}
