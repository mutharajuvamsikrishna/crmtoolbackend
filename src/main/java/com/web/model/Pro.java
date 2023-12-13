package com.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pro")
public class Pro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-increment
	private Long id;
	private String bdmname;
	private String firstres;
	private String lastres;
	private String currentstate;
	private String cmpname;
	private String lfstatus;
	private String pocstatus;
	private String domain;
	private String intrestserv;
	private String moredetail;
	private String infoshared;
	private String detailask;

	private Date followup;

	private String website;

	private String linkprof;
	private String region;
	private String coun;
	private String time;
	private String cusbefore;
	private String timezone;
	private String maincontact;
	private String mainlinkprof;
	private String mainemail;
	private String mainmob;
	private String secondcontact;
	private String secondlinkprof;
	private String secondemail;
	private String secondmob;
	private String emdate;
	private String emname;
	private String emtoname;
	private String emstate;
	private String emsummary;
	private String emdate1;
	private String emname1;
	private String emtoname1;
	private String emstate1;
	private String emsummary1;
	private String emdate2;
	private String emname2;
	private String emtoname2;
	private String emstate2;
	private String emsummary2;
	private String cuscalldate;
	private String isttime;
	private String fromname;
	private String callstatus;
	private String callsummery;
	private String cuscalldate1;
	private String isttime1;
	private String fromname1;
	private String callstatus1;
	private String callsummery1;
	private String cuscalldate2;
	private String isttime2;
	private String fromname2;
	private String callstatus2;
	private String callsummery2;
	private String email;

	public Pro() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBdmname() {
		return bdmname;
	}

	public void setBdmname(String bdmname) {
		this.bdmname = bdmname;
	}

	public String getFirstres() {
		return firstres;
	}

	public void setFirstres(String firstres) {
		this.firstres = firstres;
	}

	public String getLastres() {
		return lastres;
	}

	public void setLastres(String lastres) {
		this.lastres = lastres;
	}

	public String getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(String currentstate) {
		this.currentstate = currentstate;
	}

	public String getCmpname() {
		return cmpname;
	}

	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}

	public String getLfstatus() {
		return lfstatus;
	}

	public void setLfstatus(String lfstatus) {
		this.lfstatus = lfstatus;
	}

	public String getPocstatus() {
		return pocstatus;
	}

	public void setPocstatus(String pocstatus) {
		this.pocstatus = pocstatus;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIntrestserv() {
		return intrestserv;
	}

	public void setIntrestserv(String intrestserv) {
		this.intrestserv = intrestserv;
	}

	public String getMoredetail() {
		return moredetail;
	}

	public void setMoredetail(String moredetail) {
		this.moredetail = moredetail;
	}

	public String getInfoshared() {
		return infoshared;
	}

	public void setInfoshared(String infoshared) {
		this.infoshared = infoshared;
	}

	public String getDetailask() {
		return detailask;
	}

	public void setDetailask(String detailask) {
		this.detailask = detailask;
	}

	public Date getFollowup() {
		return followup;
	}

	public void setFollowup(Date followup) {
		this.followup = followup;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLinkprof() {
		return linkprof;
	}

	public void setLinkprof(String linkprof) {
		this.linkprof = linkprof;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCoun() {
		return coun;
	}

	public void setCoun(String coun) {
		this.coun = coun;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCusbefore() {
		return cusbefore;
	}

	public void setCusbefore(String cusbefore) {
		this.cusbefore = cusbefore;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getMaincontact() {
		return maincontact;
	}

	public void setMaincontact(String maincontact) {
		this.maincontact = maincontact;
	}

	public String getMainlinkprof() {
		return mainlinkprof;
	}

	public void setMainlinkprof(String mainlinkprof) {
		this.mainlinkprof = mainlinkprof;
	}

	public String getMainemail() {
		return mainemail;
	}

	public void setMainemail(String mainemail) {
		this.mainemail = mainemail;
	}

	public String getMainmob() {
		return mainmob;
	}

	public void setMainmob(String mainmob) {
		this.mainmob = mainmob;
	}

	public String getSecondcontact() {
		return secondcontact;
	}

	public void setSecondcontact(String secondcontact) {
		this.secondcontact = secondcontact;
	}

	public String getSecondlinkprof() {
		return secondlinkprof;
	}

	public void setSecondlinkprof(String secondlinkprof) {
		this.secondlinkprof = secondlinkprof;
	}

	public String getSecondemail() {
		return secondemail;
	}

	public void setSecondemail(String secondemail) {
		this.secondemail = secondemail;
	}

	public String getSecondmob() {
		return secondmob;
	}

	public void setSecondmob(String secondmob) {
		this.secondmob = secondmob;
	}

	public String getEmdate() {
		return emdate;
	}

	public void setEmdate(String emdate) {
		this.emdate = emdate;
	}

	public String getEmname() {
		return emname;
	}

	public void setEmname(String emname) {
		this.emname = emname;
	}

	public String getEmtoname() {
		return emtoname;
	}

	public void setEmtoname(String emtoname) {
		this.emtoname = emtoname;
	}

	public String getEmstate() {
		return emstate;
	}

	public void setEmstate(String emstate) {
		this.emstate = emstate;
	}

	public String getEmsummary() {
		return emsummary;
	}

	public void setEmsummary(String emsummary) {
		this.emsummary = emsummary;
	}

	public String getEmdate1() {
		return emdate1;
	}

	public void setEmdate1(String emdate1) {
		this.emdate1 = emdate1;
	}

	public String getEmname1() {
		return emname1;
	}

	public void setEmname1(String emname1) {
		this.emname1 = emname1;
	}

	public String getEmtoname1() {
		return emtoname1;
	}

	public void setEmtoname1(String emtoname1) {
		this.emtoname1 = emtoname1;
	}

	public String getEmstate1() {
		return emstate1;
	}

	public void setEmstate1(String emstate1) {
		this.emstate1 = emstate1;
	}

	public String getEmsummary1() {
		return emsummary1;
	}

	public void setEmsummary1(String emsummary1) {
		this.emsummary1 = emsummary1;
	}

	public String getEmdate2() {
		return emdate2;
	}

	public void setEmdate2(String emdate2) {
		this.emdate2 = emdate2;
	}

	public String getEmname2() {
		return emname2;
	}

	public void setEmname2(String emname2) {
		this.emname2 = emname2;
	}

	public String getEmtoname2() {
		return emtoname2;
	}

	public void setEmtoname2(String emtoname2) {
		this.emtoname2 = emtoname2;
	}

	public String getEmstate2() {
		return emstate2;
	}

	public void setEmstate2(String emstate2) {
		this.emstate2 = emstate2;
	}

	public String getEmsummary2() {
		return emsummary2;
	}

	public void setEmsummary2(String emsummary2) {
		this.emsummary2 = emsummary2;
	}

	public String getCuscalldate() {
		return cuscalldate;
	}

	public void setCuscalldate(String cuscalldate) {
		this.cuscalldate = cuscalldate;
	}

	public String getIsttime() {
		return isttime;
	}

	public void setIsttime(String isttime) {
		this.isttime = isttime;
	}

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}

	public String getCallstatus() {
		return callstatus;
	}

	public void setCallstatus(String callstatus) {
		this.callstatus = callstatus;
	}

	public String getCallsummery() {
		return callsummery;
	}

	public void setCallsummery(String callsummery) {
		this.callsummery = callsummery;
	}

	public String getCuscalldate1() {
		return cuscalldate1;
	}

	public void setCuscalldate1(String cuscalldate1) {
		this.cuscalldate1 = cuscalldate1;
	}

	public String getIsttime1() {
		return isttime1;
	}

	public void setIsttime1(String isttime1) {
		this.isttime1 = isttime1;
	}

	public String getFromname1() {
		return fromname1;
	}

	public void setFromname1(String fromname1) {
		this.fromname1 = fromname1;
	}

	public String getCallstatus1() {
		return callstatus1;
	}

	public void setCallstatus1(String callstatus1) {
		this.callstatus1 = callstatus1;
	}

	public String getCallsummery1() {
		return callsummery1;
	}

	public void setCallsummery1(String callsummery1) {
		this.callsummery1 = callsummery1;
	}

	public String getCuscalldate2() {
		return cuscalldate2;
	}

	public void setCuscalldate2(String cuscalldate2) {
		this.cuscalldate2 = cuscalldate2;
	}

	public String getIsttime2() {
		return isttime2;
	}

	public void setIsttime2(String isttime2) {
		this.isttime2 = isttime2;
	}

	public String getFromname2() {
		return fromname2;
	}

	public void setFromname2(String fromname2) {
		this.fromname2 = fromname2;
	}

	public String getCallstatus2() {
		return callstatus2;
	}

	public void setCallstatus2(String callstatus2) {
		this.callstatus2 = callstatus2;
	}

	public String getCallsummery2() {
		return callsummery2;
	}

	public void setCallsummery2(String callsummery2) {
		this.callsummery2 = callsummery2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pro [id=" + id + ", bdmname=" + bdmname + ", firstres=" + firstres + ", lastres=" + lastres
				+ ", currentstate=" + currentstate + ", cmpname=" + cmpname + ", lfstatus=" + lfstatus + ", pocstatus="
				+ pocstatus + ", domain=" + domain + ", intrestserv=" + intrestserv + ", moredetail=" + moredetail
				+ ", infoshared=" + infoshared + ", detailask=" + detailask + ", followup=" + followup + ", website="
				+ website + ", linkprof=" + linkprof + ", region=" + region + ", coun=" + coun + ", time=" + time
				+ ", cusbefore=" + cusbefore + ", timezone=" + timezone + ", maincontact=" + maincontact
				+ ", mainlinkprof=" + mainlinkprof + ", mainemail=" + mainemail + ", mainmob=" + mainmob
				+ ", secondcontact=" + secondcontact + ", secondlinkprof=" + secondlinkprof + ", secondemail="
				+ secondemail + ", secondmob=" + secondmob + ", emdate=" + emdate + ", emname=" + emname + ", emtoname="
				+ emtoname + ", emstate=" + emstate + ", emsummary=" + emsummary + ", emdate1=" + emdate1 + ", emname1="
				+ emname1 + ", emtoname1=" + emtoname1 + ", emstate1=" + emstate1 + ", emsummary1=" + emsummary1
				+ ", emdate2=" + emdate2 + ", emname2=" + emname2 + ", emtoname2=" + emtoname2 + ", emstate2="
				+ emstate2 + ", emsummary2=" + emsummary2 + ", cuscalldate=" + cuscalldate + ", isttime=" + isttime
				+ ", fromname=" + fromname + ", callstatus=" + callstatus + ", callsummery=" + callsummery
				+ ", cuscalldate1=" + cuscalldate1 + ", isttime1=" + isttime1 + ", fromname1=" + fromname1
				+ ", callstatus1=" + callstatus1 + ", callsummery1=" + callsummery1 + ", cuscalldate2=" + cuscalldate2
				+ ", isttime2=" + isttime2 + ", fromname2=" + fromname2 + ", callstatus2=" + callstatus2
				+ ", callsummery2=" + callsummery2 + ", email=" + email + ", getId()=" + getId() + ", getBdmname()="
				+ getBdmname() + ", getFirstres()=" + getFirstres() + ", getLastres()=" + getLastres()
				+ ", getCurrentstate()=" + getCurrentstate() + ", getCmpname()=" + getCmpname() + ", getLfstatus()="
				+ getLfstatus() + ", getPocstatus()=" + getPocstatus() + ", getDomain()=" + getDomain()
				+ ", getIntrestserv()=" + getIntrestserv() + ", getMoredetail()=" + getMoredetail()
				+ ", getInfoshared()=" + getInfoshared() + ", getDetailask()=" + getDetailask() + ", getFollowup()="
				+ getFollowup() + ", getWebsite()=" + getWebsite() + ", getLinkprof()=" + getLinkprof()
				+ ", getRegion()=" + getRegion() + ", getCoun()=" + getCoun() + ", getTime()=" + getTime()
				+ ", getCusbefore()=" + getCusbefore() + ", getTimezone()=" + getTimezone() + ", getMaincontact()="
				+ getMaincontact() + ", getMainlinkprof()=" + getMainlinkprof() + ", getMainemail()=" + getMainemail()
				+ ", getMainmob()=" + getMainmob() + ", getSecondcontact()=" + getSecondcontact()
				+ ", getSecondlinkprof()=" + getSecondlinkprof() + ", getSecondemail()=" + getSecondemail()
				+ ", getSecondmob()=" + getSecondmob() + ", getEmdate()=" + getEmdate() + ", getEmname()=" + getEmname()
				+ ", getEmtoname()=" + getEmtoname() + ", getEmstate()=" + getEmstate() + ", getEmsummary()="
				+ getEmsummary() + ", getEmdate1()=" + getEmdate1() + ", getEmname1()=" + getEmname1()
				+ ", getEmtoname1()=" + getEmtoname1() + ", getEmstate1()=" + getEmstate1() + ", getEmsummary1()="
				+ getEmsummary1() + ", getEmdate2()=" + getEmdate2() + ", getEmname2()=" + getEmname2()
				+ ", getEmtoname2()=" + getEmtoname2() + ", getEmstate2()=" + getEmstate2() + ", getEmsummary2()="
				+ getEmsummary2() + ", getCuscalldate()=" + getCuscalldate() + ", getIsttime()=" + getIsttime()
				+ ", getFromname()=" + getFromname() + ", getCallstatus()=" + getCallstatus() + ", getCallsummery()="
				+ getCallsummery() + ", getCuscalldate1()=" + getCuscalldate1() + ", getIsttime1()=" + getIsttime1()
				+ ", getFromname1()=" + getFromname1() + ", getCallstatus1()=" + getCallstatus1()
				+ ", getCallsummery1()=" + getCallsummery1() + ", getCuscalldate2()=" + getCuscalldate2()
				+ ", getIsttime2()=" + getIsttime2() + ", getFromname2()=" + getFromname2() + ", getCallstatus2()="
				+ getCallstatus2() + ", getCallsummery2()=" + getCallsummery2() + ", getEmail()=" + getEmail() + "]";
	}

}
