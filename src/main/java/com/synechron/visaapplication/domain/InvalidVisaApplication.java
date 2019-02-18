package com.synechron.visaapplication.domain;

public class InvalidVisaApplication {
    VisaApplication visaApplication;

    public VisaApplication getVisaApplication() {
        return visaApplication;
    }

    public void setVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvalidVisaApplication that = (InvalidVisaApplication) o;

        return visaApplication != null ? visaApplication.equals(that.visaApplication) : that.visaApplication == null;
    }

    @Override
    public int hashCode() {
        return visaApplication != null ? visaApplication.hashCode() : 0;
    }

    public InvalidVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }
}
