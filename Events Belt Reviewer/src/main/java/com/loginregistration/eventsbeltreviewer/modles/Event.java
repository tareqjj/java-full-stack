package com.loginregistration.eventsbeltreviewer.modles;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotNull(message = "Date must not be null")
    @Future(message = "Date must be a future date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @NotBlank(message = "Location must not be blank")
    private String location;
    @NotNull
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userPlanner;
    @OneToMany(mappedBy = "event", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> eventMessages;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersAttendingEvents;

    public Event() {
    }

    public Event(String name, Date date, String location, String state, User userPlanner) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.state = state;
        this.userPlanner = userPlanner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public String getStringDate() {
        SimpleDateFormat fm = new SimpleDateFormat("MMMM dd, yyyy");
        return fm.format(this.date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUserPlanner() {
        return userPlanner;
    }

    public void setUserPlanner(User userPlanner) {
        this.userPlanner = userPlanner;
    }

    public List<Message> getEventMessages() {
        return eventMessages;
    }

    public void setEventMessages(List<Message> eventMessages) {
        this.eventMessages = eventMessages;
    }

    public List<User> getUsersAttendingEvents() {
        return usersAttendingEvents;
    }

    public void setUsersAttendingEvents(List<User> usersAttendingEvents) {
        this.usersAttendingEvents = usersAttendingEvents;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
