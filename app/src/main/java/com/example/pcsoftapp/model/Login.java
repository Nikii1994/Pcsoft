package com.example.pcsoftapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Login {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("Error")
    @Expose
    private String error;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("dealer")
    @Expose
    private Boolean dealer;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("party_st")
    @Expose
    private String partySt;
    @SerializedName("b2bretven")
    @Expose
    private Boolean b2bretven;
    @SerializedName("SCHEMFREECMB")
    @Expose
    private Boolean schemfreecmb;
    @SerializedName("compflag")
    @Expose
    private String compflag;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("dealr_cat")
    @Expose
    private Object dealrCat;
    @SerializedName("loyltypts")
    @Expose
    private Object loyltypts;
    @SerializedName("TLEAD")
    @Expose
    private Boolean tlead;


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Boolean getDealer() {
        return dealer;
    }

    public void setDealer(Boolean dealer) {
        this.dealer = dealer;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getPartySt() {
        return partySt;
    }

    public void setPartySt(String partySt) {
        this.partySt = partySt;
    }

    public Boolean getB2bretven() {
        return b2bretven;
    }

    public void setB2bretven(Boolean b2bretven) {
        this.b2bretven = b2bretven;
    }

    public Boolean getSchemfreecmb() {
        return schemfreecmb;
    }

    public void setSchemfreecmb(Boolean schemfreecmb) {
        this.schemfreecmb = schemfreecmb;
    }

    public String getCompflag() {
        return compflag;
    }

    public void setCompflag(String compflag) {
        this.compflag = compflag;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Object getDealrCat() {
        return dealrCat;
    }

    public void setDealrCat(Object dealrCat) {
        this.dealrCat = dealrCat;
    }

    public Object getLoyltypts() {
        return loyltypts;
    }

    public void setLoyltypts(Object loyltypts) {
        this.loyltypts = loyltypts;
    }

    public Boolean getTlead() {
        return tlead;
    }

    public void setTlead(Boolean tlead) {
        this.tlead = tlead;
    }

}