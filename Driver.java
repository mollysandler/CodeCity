public class Driver {

    public static void main(String[] args){
        GitClone gitClone = new GitClone("git@github.com:aayushjoshi16/CS-Projects.git");
        gitClone.clone_repo();
    }
}
