package com.example.timur.myenglish.api.api.GetWords;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alex on 07.03.2017.
 */

public class RespBody {

    @SerializedName("num")
    @Expose
    private String num;
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
    private String synid;
    @SerializedName("oppid")
    @Expose
    private String oppid;
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
    private String unit;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
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

    public String getSynid() {
        return synid;
    }

    public void setSynid(String synid) {
        this.synid = synid;
    }

    public String getOppid() {
        return oppid;
    }

    public void setOppid(String oppid) {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
