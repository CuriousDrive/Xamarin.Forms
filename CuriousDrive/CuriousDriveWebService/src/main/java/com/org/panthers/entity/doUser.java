package com.org.panthers.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.ws.rs.core.UriInfo;

import com.org.panthers.framework.busBaseDAOImpl;
import com.org.panthers.framework.doBase;

import java.util.Date;


/**
 * The persistent class for the SYS_USER database table.
 * 
 */
@Entity
@Table(name="SYS_USER")
@NamedQuery(name="doUser.findAll", query="SELECT d FROM doUser d")
public class doUser extends doBase implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	public int userId;

	@Column(name="ABOUT_ME")
	public String aboutMe;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	public Date birthDate;

	@Column(name="DISPLAY_NAME")
	public String displayName;

	@Column(name="EMAIL_ADDRESS")
	public String emailAddress;
	
	@Column(name="FIRST_NAME")
	public String firstName;

	@Column(name="GENDER_ID")
	public int genderId;

	@Column(name="GENDER_VALUE")
	public String genderValue;

	@Column(name="INTERESTS")
	public String interests;

	@Column(name="LAST_NAME")
	public String lastName;

	@Column(name="NETWORK_ID")
	public int networkId;

	@Column(name="NETWORK_USER_ID")
	public String networkUserId;

	@Column(name="NETWORK_VALUE")
	public String networkValue;

	@Column(name="OCCUPATION")
	public String occupation;

	@Column(name="SALT_VALUE")
	public String saltValue;
	
	@Column(name="PASSWORD")
	public String password;
	
	@Column(name="OTP")
	public String otp;
	
	@Column(name="IS_USER_VERIFIED")
	public String isUserVerified;

	@Column(name="IS_PASSWORD_FORGOTTEN")
	public String isPasswordForgotten;

	@Column(name="USER_STATUS_ID")
	public int userStatusId;
	
	@Column(name="USER_STATUS_VALUE")
	public String userStatusValue;

	@Column(name="PHONE_NUMBER")
	public String phoneNumber;

	@Column(name="PICTURE_URL")
	public String pictureUrl;

	@Column(name="TWITTER_URL")
	public String twitterUrl;

	@Column(name="WEBSITE_URL")
	public String websiteUrl;
	
	@Column(name="FACEBOOK_URL")
	public String facebookUrl;
	
	@Column(name="INSTAGRAM_URL")
	public String instagramUrl;
	
	@Column(name="MODIFIED_BY")
	public int modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	public Date modifiedDate;
	
	@Column(name="CREATED_BY")
	public int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE")
	public Date createdDate;

	@Column(name="UPDATE_SEQ")
	public int updateSeq;


	public doUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAboutMe() {
		return this.aboutMe;
	}
		
	public String getIsUserVerified() {
		return isUserVerified;
	}

	public void setIsUserVerified(String isUserVerified) {
		this.isUserVerified = isUserVerified;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFacebookUrl() {
		return this.facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGenderId() {
		return this.genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGenderValue() {
		return this.genderValue;
	}

	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}

	public String getInterests() {
		return this.interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}

	public String getNetworkUserId() {
		return this.networkUserId;
	}

	public void setNetworkUserId(String networkUserId) {
		this.networkUserId = networkUserId;
	}

	public String getNetworkValue() {
		return this.networkValue;
	}

	public void setNetworkValue(String networkValue) {
		this.networkValue = networkValue;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getTwitterUrl() {
		return this.twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public int getUpdateSeq() {
		return this.updateSeq;
	}

	public void setUpdateSeq(int updateSeq) {
		this.updateSeq = updateSeq;
	}

	public String getWebsiteUrl() {
		return this.websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
			
	public String getSaltValue() {
		return saltValue;
	}

	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getIsUserVerfied() {
		return isUserVerified;
	}

	public void setIsUserVerfied(String isUserVerfied) {
		this.isUserVerified = isUserVerfied;
	}

	public String getIsPasswordForgotten() {
		return isPasswordForgotten;
	}

	public void setIsPasswordForgotten(String isPasswordForgotten) {
		this.isPasswordForgotten = isPasswordForgotten;
	}

	public int getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(int userStatusId) {
		this.userStatusId = userStatusId;
	}

	public String getUserStatusValue() {
		return userStatusValue;
	}

	public void setUserStatusValue(String userStatusValue) {
		this.userStatusValue = userStatusValue;
	}

	@Override
	public int insert() {
		busBaseDAOImpl<doUser> baseDAOImpl = new busBaseDAOImpl<doUser>();
		this.loadCreatedByProperties();
		baseDAOImpl.insert(this);
		return this.getUserId();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUser> baseDAOImpl = new busBaseDAOImpl<doUser>();
		baseDAOImpl.delete(doUser.class, this.getUserId());
		return 1;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUser> baseDAOImpl = new busBaseDAOImpl<doUser>();
		this.loadModifiedByProperties();
		baseDAOImpl.update(this);
		return 1;
	}

	@Override
	public doUser get() {
		// TODO Auto-generated method stub
		busBaseDAOImpl<doUser> baseDAOImpl = new busBaseDAOImpl<doUser>();
		return baseDAOImpl.get(this.getUserId(), doUser.class);
	}
	
	@Override
	public void loadCreatedByProperties() {
		// TODO Auto-generated method stub
		this.setCreatedBy(this.iintUserId);
		this.setCreatedDate(new Date());
		this.setModifiedBy(this.iintUserId);		
		this.setModifiedDate(new Date());
	}

	@Override
	public void loadModifiedByProperties() {
		// TODO Auto-generated method stub
		this.setModifiedBy(this.iintUserId);		
		this.setModifiedDate(new Date());
	}

	
	public enum enmUser {
		userId,
		birthDate,
		createdBy,
		createdDate,
		displayName,
		emailAddress,
		firstName,	
		genderId,
		genderValue,
		lastName,
		modifiedBy,
		modifiedDate,
		networkId,
		networkUserId,
		networkValue,
		password,
		otp,
		isUserVerfied,
		isPasswordForgotten,
		userStatusId,
		userStatusValue,
		phoneNumber,
		pictureUrl,
		updateSeq,
		interests,
		occupation,
		twitterUrl,
		websiteUrl,
		facebookUrl,
		aboutMe
	}

}