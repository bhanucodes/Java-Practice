import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Chatroom {
    private String name;
    private Set<String> usernames;
    private List<String> messages;

    public Chatroom (String name){
        this.name = name;
        this.usernames = new HashSet<>();
        this.messages = new ArrayList<>();
    }
    
    //getters
    public String getName(){
        return name;
    }

    public Set<String> getUsernames(){
        return usernames;
    }

    public List<String> getMessages(){
        return messages;
    }

    
    public void addUser(String username){
        usernames.add(username);
    }

    public void removeUser(String username){
        usernames.remove(username);
    }

    public void addMessage(String message){
        messages.add(message);
    }
}

class User{
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    User(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}

public class Q7 {
    public static void main(String[] args) {
        
    }
}
