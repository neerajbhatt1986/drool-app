package com.synechron.visaapplication.domain;

public class ValidPassport
{
    Passport passport;

    public ValidPassport(Passport passport) {
        this.passport = passport;
    }

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

        ValidPassport that = (ValidPassport) o;

        return passport != null ? passport.equals(that.passport) : that.passport == null;
    }

    @Override
    public int hashCode() {
        return passport != null ? passport.hashCode() : 0;
    }
}
