package com.loginregistration.loginregistration.services;

import com.loginregistration.loginregistration.models.Show;
import com.loginregistration.loginregistration.models.User;
import com.loginregistration.loginregistration.models.UserShow;
import com.loginregistration.loginregistration.repositories.ShowRepository;
import com.loginregistration.loginregistration.repositories.UserRepository;
import com.loginregistration.loginregistration.repositories.UserShowRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final UserShowRepository userShowRepository;

    public UserService(UserRepository userRepository, ShowRepository showRepository, UserShowRepository userShowRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.userShowRepository = userShowRepository;
    }

    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find user by id
    public User findUserById(Long id) {
        Optional<User> u = userRepository.findById(id);

        if (u.isPresent())
            return u.get();
        else
            return null;
    }

    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if (user == null)
            return false;
        else {
            // if the passwords match, return true, else, return false
            if (BCrypt.checkpw(password, user.getPassword()))
                return true;
            else
                return false;
        }
    }

    public List<Show> allShows() {
        return showRepository.findAll();
    }

    public Show createShow(Show show) {
        Show newShow = new Show(show.getTitle(), show.getNetwork(), show.getUser());
        return showRepository.save(newShow);
    }

    public Show findShowById(Long id) {
        Optional<Show> showToFind = showRepository.findById(id);

        if (showToFind.isPresent())
            return showToFind.get();
        else
            return null;
    }

    public Show updateShow(Show show) {
        Show showToUpdate =findShowById(show.getId());
        showToUpdate.setTitle(show.getTitle());
        showToUpdate.setNetwork(show.getNetwork());
        return showRepository.save(showToUpdate);
    }

    public UserShow createShow(UserShow rating) {
        return userShowRepository.save(rating);
    }


    public double ratingByShow(Show show) {
        List<UserShow>  ratingList = userShowRepository.findByShow(show);
        if (ratingList == null)
            return 0;
        double sum = 0;
        for (UserShow rating: ratingList) {
            sum += rating.getRating();
        }

        return sum/ratingList.size();
    }

    public Show findShowByTitle(String title) {
        return showRepository.findByTitle(title);
    }

    public double ratingByUser(User user) {
        UserShow userRating = userShowRepository.findByUser(user);
        if (userRating == null)
            return 0;
        return userRating.getRating();
    }

    public UserShow createRating(UserShow rating) {
        UserShow newRating = new UserShow(rating.getRating(), rating.getUser(), rating.getShow());
        return userShowRepository.save(newRating);
    }

    public void deleteShow(Long show_id){
        showRepository.deleteById(show_id);
    }

}
