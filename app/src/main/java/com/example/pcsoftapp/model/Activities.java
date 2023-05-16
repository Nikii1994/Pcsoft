package com.example.pcsoftapp.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activities {

    @SerializedName("docsr")
    @Expose
    private Object docsr;
    @SerializedName("DOC_TYPE")
    @Expose
    private String docType;
    @SerializedName("DOC_NO")
    @Expose
    private String docNo;
    @SerializedName("DOC_DATE")
    @Expose
    private String docDate;
    @SerializedName("DOC_DATE1")
    @Expose
    private String docDate1;
    @SerializedName("RESOTYPE")
    @Expose
    private String resotype;
    @SerializedName("GRP_CD")
    @Expose
    private String grpCd;
    @SerializedName("PARTY_ST")
    @Expose
    private Object partySt;
    @SerializedName("PARTY_NO")
    @Expose
    private Object partyNo;
    @SerializedName("MC_GR")
    @Expose
    private String mcGr;
    @SerializedName("MC_CODE")
    @Expose
    private String mcCode;
    @SerializedName("ACT_DATE")
    @Expose
    private String actDate;
    @SerializedName("ACT_DATE1")
    @Expose
    private String actDate1;
    @SerializedName("PRODUCTV")
    @Expose
    private Integer productv;
    @SerializedName("PROJCT_NO")
    @Expose
    private String projctNo;
    @SerializedName("PRV_LVL")
    @Expose
    private Object prvLvl;
    @SerializedName("P_PLN_CD")
    @Expose
    private Object pPlnCd;
    @SerializedName("C_PLN_CD")
    @Expose
    private String cPlnCd;
    @SerializedName("IM_CODE")
    @Expose
    private String imCode;
    @SerializedName("S_IM_CODE")
    @Expose
    private String sImCode;
    @SerializedName("IN_TIME")
    @Expose
    private String inTime;
    @SerializedName("OUT_TIME")
    @Expose
    private String outTime;
    @SerializedName("ACTD_HRS")
    @Expose
    private Integer actdHrs;
    @SerializedName("ACTD_COST")
    @Expose
    private Integer actdCost;
    @SerializedName("ACC_AMT")
    @Expose
    private Integer accAmt;
    @SerializedName("IM_REF")
    @Expose
    private String imRef;
    @SerializedName("POST_FLAG")
    @Expose
    private Object postFlag;
    @SerializedName("USER_ID")
    @Expose
    private Object userId;
    @SerializedName("DATE_STMP")
    @Expose
    private String dateStmp;
    @SerializedName("TIME_STMP")
    @Expose
    private Object timeStmp;
    @SerializedName("ID_KEY")
    @Expose
    private Integer idKey;
    @SerializedName("ACT_DESCR")
    @Expose
    private String actDescr;
    @SerializedName("SOIM_DESCR")
    @Expose
    private String soimDescr;
    @SerializedName("FGIM_DESCR")
    @Expose
    private String fgimDescr;
    @SerializedName("longit")
    @Expose
    private String longit;
    @SerializedName("latit")
    @Expose
    private String latit;
    @SerializedName("in_addr")
    @Expose
    private String inAddr;
    @SerializedName("out_long")
    @Expose
    private String outLong;
    @SerializedName("out_latit")
    @Expose
    private String outLatit;
    @SerializedName("out_addr")
    @Expose
    private String outAddr;
    @SerializedName("rstart")
    @Expose
    private String rstart;
    @SerializedName("rend")
    @Expose
    private String rend;
    @SerializedName("rTot")
    @Expose
    private String rTot;
    @SerializedName("vcode")
    @Expose
    private Object vcode;
    @SerializedName("CO_CD")
    @Expose
    private String coCd;
    @SerializedName("plant_no")
    @Expose
    private String plantNo;

    public Object getDocsr() {
        return docsr;
    }

    public void setDocsr(Object docsr) {
        this.docsr = docsr;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocDate1() {
        return docDate1;
    }

    public void setDocDate1(String docDate1) {
        this.docDate1 = docDate1;
    }

    public String getResotype() {
        return resotype;
    }

    public void setResotype(String resotype) {
        this.resotype = resotype;
    }

    public String getGrpCd() {
        return grpCd;
    }

    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    public Object getPartySt() {
        return partySt;
    }

    public void setPartySt(Object partySt) {
        this.partySt = partySt;
    }

    public Object getPartyNo() {
        return partyNo;
    }

    public void setPartyNo(Object partyNo) {
        this.partyNo = partyNo;
    }

    public String getMcGr() {
        return mcGr;
    }

    public void setMcGr(String mcGr) {
        this.mcGr = mcGr;
    }

    public String getMcCode() {
        return mcCode;
    }

    public void setMcCode(String mcCode) {
        this.mcCode = mcCode;
    }

    public String getActDate() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate = actDate;
    }

    public String getActDate1() {
        return actDate1;
    }

    public void setActDate1(String actDate1) {
        this.actDate1 = actDate1;
    }

    public Integer getProductv() {
        return productv;
    }

    public void setProductv(Integer productv) {
        this.productv = productv;
    }

    public String getProjctNo() {
        return projctNo;
    }

    public void setProjctNo(String projctNo) {
        this.projctNo = projctNo;
    }

    public Object getPrvLvl() {
        return prvLvl;
    }

    public void setPrvLvl(Object prvLvl) {
        this.prvLvl = prvLvl;
    }

    public Object getPPlnCd() {
        return pPlnCd;
    }

    public void setPPlnCd(Object pPlnCd) {
        this.pPlnCd = pPlnCd;
    }

    public String getCPlnCd() {
        return cPlnCd;
    }

    public void setCPlnCd(String cPlnCd) {
        this.cPlnCd = cPlnCd;
    }

    public String getImCode() {
        return imCode;
    }

    public void setImCode(String imCode) {
        this.imCode = imCode;
    }

    public String getSImCode() {
        return sImCode;
    }

    public void setSImCode(String sImCode) {
        this.sImCode = sImCode;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getActdHrs() {
        return actdHrs;
    }

    public void setActdHrs(Integer actdHrs) {
        this.actdHrs = actdHrs;
    }

    public Integer getActdCost() {
        return actdCost;
    }

    public void setActdCost(Integer actdCost) {
        this.actdCost = actdCost;
    }

    public Integer getAccAmt() {
        return accAmt;
    }

    public void setAccAmt(Integer accAmt) {
        this.accAmt = accAmt;
    }

    public String getImRef() {
        return imRef;
    }

    public void setImRef(String imRef) {
        this.imRef = imRef;
    }

    public Object getPostFlag() {
        return postFlag;
    }

    public void setPostFlag(Object postFlag) {
        this.postFlag = postFlag;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getDateStmp() {
        return dateStmp;
    }

    public void setDateStmp(String dateStmp) {
        this.dateStmp = dateStmp;
    }

    public Object getTimeStmp() {
        return timeStmp;
    }

    public void setTimeStmp(Object timeStmp) {
        this.timeStmp = timeStmp;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public void setIdKey(Integer idKey) {
        this.idKey = idKey;
    }

    public String getActDescr() {
        return actDescr;
    }

    public void setActDescr(String actDescr) {
        this.actDescr = actDescr;
    }

    public String getSoimDescr() {
        return soimDescr;
    }

    public void setSoimDescr(String soimDescr) {
        this.soimDescr = soimDescr;
    }

    public String getFgimDescr() {
        return fgimDescr;
    }

    public void setFgimDescr(String fgimDescr) {
        this.fgimDescr = fgimDescr;
    }

    public String getLongit() {
        return longit;
    }

    public void setLongit(String longit) {
        this.longit = longit;
    }

    public String getLatit() {
        return latit;
    }

    public void setLatit(String latit) {
        this.latit = latit;
    }

    public String getInAddr() {
        return inAddr;
    }

    public void setInAddr(String inAddr) {
        this.inAddr = inAddr;
    }

    public String getOutLong() {
        return outLong;
    }

    public void setOutLong(String outLong) {
        this.outLong = outLong;
    }

    public String getOutLatit() {
        return outLatit;
    }

    public void setOutLatit(String outLatit) {
        this.outLatit = outLatit;
    }

    public String getOutAddr() {
        return outAddr;
    }

    public void setOutAddr(String outAddr) {
        this.outAddr = outAddr;
    }

    public String getRstart() {
        return rstart;
    }

    public void setRstart(String rstart) {
        this.rstart = rstart;
    }

    public String getRend() {
        return rend;
    }

    public void setRend(String rend) {
        this.rend = rend;
    }

    public String getrTot() {
        return rTot;
    }

    public void setrTot(String rTot) {
        this.rTot = rTot;
    }

    public Object getVcode() {
        return vcode;
    }

    public void setVcode(Object vcode) {
        this.vcode = vcode;
    }

    public String getCoCd() {
        return coCd;
    }

    public void setCoCd(String coCd) {
        this.coCd = coCd;
    }

    public String getPlantNo() {
        return plantNo;
    }

    public void setPlantNo(String plantNo) {
        this.plantNo = plantNo;
    }

}