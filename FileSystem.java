import java.util.*;

class Directory{
    HashMap<String, Directory> directories;
    HashMap<String, String> files;
    public Directory(){
        directories = new HashMap<>();
        files = new HashMap<>();
    }
}

public class FileSystem {

    Directory root;
    public FileSystem() {
        // Constructor for FileSystem
        this.root = new Directory();
    }

    public void mkdir(String command){
        String[] paths = command.split("/");
        Directory current = root;
        for (int i=1; i<paths.length;i++) {       // first is empty
            current.directories.putIfAbsent(paths[i],new Directory());
            current = current.directories.get(paths[i]);
        }
    }

    public void addContentToFile(String command, String content){
        String[] paths = command.split("/");
        Directory current = root;
        for (int i=1; i<paths.length-1;i++) {       // first is empty
            current.directories.putIfAbsent(paths[i],new Directory());
            current = current.directories.get(paths[i]);
        }
        String filename = paths[paths.length-1];
        if(current.files.containsKey(filename)){
            String newcont = current.files.get(filename) + content;
            current.files.put(filename, newcont);
        }
        else{
            current.files.put(filename, content);
        }
    }

    public String readContentFromFile(String command){
        String[] paths = command.split("/");
        Directory current = root;
        for (int i=1; i<paths.length-1;i++) {       // first is empty
            current.directories.putIfAbsent(paths[i],new Directory());
            current = current.directories.get(paths[i]);
        }
        String filename = paths[paths.length-1];
        return current.files.getOrDefault(filename,"");
    }

    public List<String> ls(String command){
        
        List<String> li = new ArrayList<>();
        
        if (command == "/"){
            Directory current = root;
            for(String filename : current.files.keySet()){
                li.add(filename);
            }
            for(String dirname : current.directories.keySet()){
                li.add(dirname);
            }

            Collections.sort(li);

            return li;
        }
        String[] path = command.split("/");
        Directory current = root;
        for(int i=1;i<path.length-1;i++){
            current = current.directories.get(path[i]);
        }
        String name = path[path.length-1];

        if(current.files.containsKey(name)){
            li.add(name);
        }
        else if(current.directories.containsKey(name)){
            current = current.directories.get(name);
            for(String filename : current.files.keySet()){
                li.add(filename);
            }
            for(String dirname : current.directories.keySet()){
                li.add(dirname);
            }

            Collections.sort(li);
        }

        return li;
    }
    
}

/*
Design a data structure that simulates an in-memory file system.

Implement the FileSystem class:

FileSystem() Initializes the object of the system.
List<String> ls(String path)
If path is a file path, returns a list that only contains this file's name.
If path is a directory path, returns the list of file and directory names in this directory.
The answer should in lexicographic order.
void mkdir(String path) Makes a new directory according to the given path. The given directory path does not exist. If the middle directories in the path do not exist, you should create them as well.
void addContentToFile(String filePath, String content)
If filePath does not exist, creates that file containing given content.
If filePath already exists, appends the given content to original content.
String readContentFromFile(String filePath) Returns the content in the file at filePath.

Constraints:

1 <= path.length, filePath.length <= 100
path and filePath are absolute paths which begin with '/' and do not end with '/' except that the path is just "/".
You can assume that all directory names and file names only contain lowercase letters, and the same names will not exist in the same directory.
You can assume that all operations will be passed valid parameters, and users will not attempt to retrieve file content or list a directory or file that does not exist.
1 <= content.length <= 50
At most 300 calls will be made to ls, mkdir, addContentToFile, and readContentFromFile.

*/ 
