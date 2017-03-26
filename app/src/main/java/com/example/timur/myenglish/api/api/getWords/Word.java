package com.example.timur.myenglish.api.api.getWords;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 07.03.2017.
 */

public class Word {

    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("lang1")
    @Expose
    private String lang1;
    @SerializedName("def1")
    @Expose
    private String def1;
    @SerializedName("lang2")
    @Expose
    private String lang2;
    @SerializedName("def2")
    @Expose
    private String def2;
    @SerializedName("synid")
    @Expose
    private Integer synid;
    @SerializedName("oppid")
    @Expose
    private Integer oppid;
    @SerializedName("pos")
    @Expose
    private String pos;
    @SerializedName("sent1")
    @Expose
    private String sent1;
    @SerializedName("sent2")
    @Expose
    private String sent2;
    @SerializedName("unit")
    @Expose
    private Integer unit;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getLang1() {
        return lang1;
    }

    public void setLang1(String lang1) {
        this.lang1 = lang1;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getLang2() {
        return lang2;
    }

    public void setLang2(String lang2) {
        this.lang2 = lang2;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public Integer getSynid() {
        return synid;
    }

    public void setSynid(Integer synid) {
        this.synid = synid;
    }

    public Integer getOppid() {
        return oppid;
    }

    public void setOppid(Integer oppid) {
        this.oppid = oppid;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getSent1() {
        return sent1;
    }

    public void setSent1(String sent1) {
        this.sent1 = sent1;
    }

    public String getSent2() {
        return sent2;
    }

    public void setSent2(String sent2) {
        this.sent2 = sent2;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
