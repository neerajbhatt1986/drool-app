package com.synechron.visaapplication.domain;

public class InvalidPassport {
    Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvalidPassport that = (InvalidPassport) o;

        return passport != null ? passport.equals(that.passport) : that.passport == null;
    }

    @Override
    public int hashCode() {
        return passport != null ? passport.hashCode() : 0;
    }

    public InvalidPassport(Passport passport) {
        this.passport = passport;
    }
}
