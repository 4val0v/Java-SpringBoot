



@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Date createdAt;
    private Date updatedAt;

    ///
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    ///
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "friend_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userFriends;
    ///

    // get a list of the user's friends
    public List<User> getFriends() {
        return friends;
    }
    // set a list of the user's friends
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
    public List<User> getUserFriends() {
        return userFriends;
    }
    public void setUserFriends(List<User> userFriends) {
        this.userFriends = userFriends;
    }
}

// Calling our getter methods to get list of friends

public void friends() {
    User user = userRepo.findOne(Long.valueOf(1));
    System.out.println(user.getFriends());
    
    // This will print out the first name of users 2 and 3. All the users that are user's friends
    for(User u : user.getFriends()) {
        System.out.println(u.getFirstName());
    }
    
    // This will only print out the first name of user 2.
    for(User u : user.getUserFriends()) {
        System.out.println(u.getFirstName());
    }
}