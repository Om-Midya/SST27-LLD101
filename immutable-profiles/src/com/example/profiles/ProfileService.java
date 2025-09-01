package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.UserProfileBuilder(id, email).build();
    }

    public void updateDisplayName(UserProfile p, String displayName) {
        UserProfile.UserProfileBuilder builder = new UserProfile.UserProfileBuilder(id, email);
        if (displayName != null && displayName.length() > 100) {
            displayName = displayName.substring(0, 100);
        }
        builder.withDisplayName(displayName);
        return builder.build();
    }
}
