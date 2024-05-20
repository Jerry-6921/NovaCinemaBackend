package za.ac.cput.novacinemaapp.factory;

import za.ac.cput.novacinemaapp.domain.Cinema;
import za.ac.cput.novacinemaapp.domain.Review;
import za.ac.cput.novacinemaapp.domain.User;
import za.ac.cput.novacinemaapp.util.Helper;

import java.time.LocalDate;

/*  Showtime.java
 *   Factory class for Review
 *   Author: Musaddiq McWhite (219369151)
 *   17 May 2024
 * */

public class ReviewFactory {

    public static Review buildReview(Cinema cinema, User user, double rating, String comment, LocalDate timestamp) {
        if (Helper.isNullOrEmpty(cinema) || Helper.isNullOrEmpty(user)
                || Helper.isNullOrEmpty(rating) || Helper.isNullOrEmpty(comment)
                || Helper.isNullOrEmpty(timestamp))
            return null;

        String reviewId = Helper.generateId();

        return new Review.Builder().setReviewId(reviewId).setCinema(cinema)
                .setUser(user)
                .setRating(rating)
                .setComment(comment).setTimestamp(timestamp)
                .build();
    }

    public static Review buildReview(String reviewId, Cinema cinema, User user, double rating, String comment, LocalDate timestamp) {
        if (Helper.isNullOrEmpty(reviewId) || Helper.isNullOrEmpty(cinema) || Helper.isNullOrEmpty(user)
                || Helper.isNullOrEmpty(rating) || Helper.isNullOrEmpty(comment)
                || Helper.isNullOrEmpty(timestamp))
            return null;

        return new Review.Builder().setReviewId(reviewId).setCinema(cinema)
                .setUser(user)
                .setRating(rating)
                .setComment(comment).setTimestamp(timestamp)
                .build();
    }

    }






