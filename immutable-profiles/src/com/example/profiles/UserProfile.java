package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private String id;
    private String email;
    private String phone;
    private String displayName;
    private String address;
    private boolean marketingOptIn;
    private String twitter;
    private String github;

    private UserProfile(UserProfileBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.displayName = builder.displayName;
        this.address = builder.address;
        this.marketingOptIn = builder.marketingOptIn;
        this.twitter = builder.twitter;
        this.github = builder.github;
    }
    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    public static class UserProfileBuilder {
        private final String id;
        private final String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public UserProfileBuilder(String id, String email) {
            this.id = id;
            this.email = email;
        }

        public UserProfileBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserProfileBuilder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public UserProfileBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public UserProfileBuilder withMarketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public UserProfileBuilder withTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public UserProfileBuilder withGithub(String github)
        {
            this.github = github;
            return this;
        }

        public UserProfile build() {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);
            // Optionally validate other fields here
            return new UserProfile(this);
        }
    }
}
