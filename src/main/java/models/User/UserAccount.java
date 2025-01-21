package models.User;

import org.bson.types.ObjectId;

public class UserAccount {
    private ObjectId id; // ID của tài liệu
    private String username;
    private String password;

    private Role role;

    public UserAccount() {
        id = null; // ID mặc định là null cho tài liệu mới
        username = "";
        password = "";

        role = Role.USER;
    }

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;

        this.role = Role.USER;
    }

    public UserAccount(String username, String password, String fullName, Role role) {
        this.username = username;
        this.password = password;

        this.role = role;
    }

    // Getter và Setter cho ID
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }



    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setRole(Role role) {
        this.role = role;
    }
}
