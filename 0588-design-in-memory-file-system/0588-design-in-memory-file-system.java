public class FileSystem {
    private FsNode root;
    
    public FileSystem() {
        root = new FsNode("");
    }
    
    public List<String> ls(String path) {
        return findNode(path).getList();
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }
    
    private FsNode findNode(String path){
        String[] files = path.split("/");
        FsNode cur = root;
        for(String file : files){
            if(file.length() == 0) continue;

            cur.children.putIfAbsent(file, new FsNode(file));
            cur = cur.children.get(file);

            if(cur.isFile()) break;
        }
        return cur;
    }
    
    private class FsNode{
        private TreeMap<String, FsNode> children;
        private StringBuilder fileContent;
        private String name;


        public FsNode(String name){
            children = new TreeMap<>();
            fileContent = new StringBuilder();
            this.name = name;
        }
        
        public String getContent(){
            return fileContent.toString();
        }

        public String getName(){
            return name;
        }

        public void addContent(String content){
            fileContent.append(content);
        }

        public boolean isFile(){
            return fileContent.length() > 0;
        }

        public List<String> getList(){
            List<String> list = new ArrayList<>();
            if(isFile()){
                list.add(getName());
            }else{
                list.addAll(children.keySet());
            }

            return list;
        }
    }
}


/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */